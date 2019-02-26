/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.axoom.drs.devices;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.joda.time.DateTime;
// [START iot_mqtt_includes]
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Java sample of connecting to Google Cloud IoT Core vice via MQTT, using JWT.
 *
 * <p>This example connects to Google Cloud IoT Core via MQTT, using a JWT for device
 * authentication. After connecting, by default the device publishes 100 messages to the device's
 * MQTT topic at a rate of one per second, and then exits. To set state instead of publishing
 * telemetry events, set the `-message_type` flag to `state.`
 *
 * <p>To run this example, first create your credentials and register your device as described in
 * the README located in the sample's parent folder.
 *
 * <p>After you have registered your device and generated your credentials, compile and run with the
 * corresponding algorithm flag, for example:
 *
 * <pre>
 *   $ mvn compile
 *   $ mvn exec:java -Dexec.mainClass="com.google.cloud.iot.examples.MqttExample" \
 *       -Dexec.args="-project_id=my-project-id \
 *       -registry_id=my-registry-id \
 *       -device_id=my-device-id \
 *       -private_key_file=/path/to/private_pkcs8 \
 *       -algorithm=RS256"
 * </pre>
 */
public class MqttExample {
  // [START iot_mqtt_jwt]
  /** Create a Cloud IoT Core JWT for the given project id, signed with the given RSA key. */
  private static String createJwtRsa(String projectId, String privateKeyFile) throws Exception {
    DateTime now = new DateTime();
    // Create a JWT to authenticate this device. The device will be disconnected after the token
    // expires, and will have to reconnect with a new token. The audience field should always be set
    // to the GCP project id.
    JwtBuilder jwtBuilder =
        Jwts.builder()
            .setIssuedAt(now.toDate())
            .setExpiration(now.plusMinutes(20).toDate())
            .setAudience(projectId);

    byte[] keyBytes = Files.readAllBytes(Paths.get(privateKeyFile));
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory kf = KeyFactory.getInstance("RSA");

    return jwtBuilder.signWith(SignatureAlgorithm.RS256, kf.generatePrivate(spec)).compact();
  }

  /** Create a Cloud IoT Core JWT for the given project id, signed with the given ES key. */
  private static String createJwtEs(String projectId, String privateKeyFile) throws Exception {
    DateTime now = new DateTime();
    // Create a JWT to authenticate this device. The device will be disconnected after the token
    // expires, and will have to reconnect with a new token. The audience field should always be set
    // to the GCP project id.
    JwtBuilder jwtBuilder =
        Jwts.builder()
            .setIssuedAt(now.toDate())
            .setExpiration(now.plusMinutes(20).toDate())
            .setAudience(projectId);

    byte[] keyBytes = Files.readAllBytes(Paths.get(privateKeyFile));
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory kf = KeyFactory.getInstance("EC");

    return jwtBuilder.signWith(SignatureAlgorithm.ES256, kf.generatePrivate(spec)).compact();
  }
  // [END iot_mqtt_jwt]

  // [START iot_mqtt_configcallback]
  static MqttCallback mCallback;

  /** Attaches the callback used when configuration changes occur. */
  public static void attachCallback(MqttClient client, String deviceId) throws MqttException {
    mCallback = new MqttCallback() {
      @Override
      public void connectionLost(Throwable cause) {
        // Do nothing...
      }

      @Override
      public void messageArrived(String topic, MqttMessage message) throws Exception {
        String payload = new String(message.getPayload());
        System.out.println("Payload : " + payload);
        // TODO: Insert your parsing / handling of the configuration message here.
      }

      @Override
      public void deliveryComplete(IMqttDeliveryToken token) {
        // Do nothing;
      }
    };

    String configTopic = String.format("/devices/%s/config", deviceId);
    client.subscribe(configTopic, 1);

    String commandTopic = String.format("/devices/%s/commands/#", deviceId);
    client.subscribe(commandTopic, 1);

    client.setCallback(mCallback);
  }
  // [END iot_mqtt_configcallback]

  /** Parse arguments, configure MQTT, and publish messages. */
  public static void main(String[] args) throws Exception {
    // [START iot_mqtt_configuremqtt]
    MqttExampleOptions options = MqttExampleOptions.fromFlags(args);
    if (options == null) {
      // Could not parse.
      System.exit(1);
    }

    // Build the connection string for Google's Cloud IoT Core MQTT server. Only SSL
    // connections are accepted. For server authentication, the JVM's root certificates
    // are used.
    final String mqttServerAddress =
        String.format("ssl://%s:%s", options.mqttBridgeHostname, options.mqttBridgePort);

    // Create our MQTT client. The mqttClientId is a unique string that identifies this device. For
    // Google Cloud IoT Core, it must be in the format below.
    final String mqttClientId =
        String.format(
            "projects/%s/locations/%s/registries/%s/devices/%s",
            options.projectId, options.cloudRegion, options.registryId, options.deviceId);

    MqttConnectOptions connectOptions = new MqttConnectOptions();
    // Note that the Google Cloud IoT Core only supports MQTT 3.1.1, and Paho requires that we
    // explictly set this. If you don't set MQTT version, the server will immediately close its
    // connection to your device.
    connectOptions.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);

    Properties sslProps = new Properties();
    sslProps.setProperty("com.ibm.ssl.protocol", "TLSv1.2");
    connectOptions.setSSLProperties(sslProps);

    // With Google Cloud IoT Core, the username field is ignored, however it must be set for the
    // Paho client library to send the password field. The password field is used to transmit a JWT
    // to authorize the device.
    connectOptions.setUserName("unused");

    DateTime iat = new DateTime();
    if (options.algorithm.equals("RS256")) {
      connectOptions.setPassword(
          createJwtRsa(options.projectId, options.privateKeyFile).toCharArray());
    } else if (options.algorithm.equals("ES256")) {
      connectOptions.setPassword(
          createJwtEs(options.projectId, options.privateKeyFile).toCharArray());
    } else {
      throw new IllegalArgumentException(
          "Invalid algorithm " + options.algorithm + ". Should be one of 'RS256' or 'ES256'.");
    }
    // [END iot_mqtt_configuremqtt]

    // [START iot_mqtt_publish]
    // Create a client, and connect to the Google MQTT bridge.
    MqttClient client = new MqttClient(mqttServerAddress, mqttClientId, new MemoryPersistence());

    // Both connect and publish operations may fail. If they do, allow retries but with an
    // exponential backoff time period.
    long initialConnectIntervalMillis = 500L;
    long maxConnectIntervalMillis = 6000L;
    long maxConnectRetryTimeElapsedMillis = 900000L;
    float intervalMultiplier = 1.5f;

    long retryIntervalMs = initialConnectIntervalMillis;
    long totalRetryTimeMs = 0;

    if (!client.isConnected() && totalRetryTimeMs < maxConnectRetryTimeElapsedMillis) {
      try {
        client.connect(connectOptions);
      } catch (MqttException e) {
        int reason = e.getReasonCode();

        // If the connection is lost or if the server cannot be connected, allow retries, but with
        // exponential backoff.
        System.out.println("An error occurred: " + e.getMessage());
        if (reason == MqttException.REASON_CODE_CONNECTION_LOST
            || reason == MqttException.REASON_CODE_SERVER_CONNECT_ERROR) {
          System.out.println("Retrying in " + retryIntervalMs / 1000.0 + " seconds.");
          Thread.sleep(retryIntervalMs);
          totalRetryTimeMs += retryIntervalMs;
          retryIntervalMs *= intervalMultiplier;
          if (retryIntervalMs > maxConnectIntervalMillis) {
            retryIntervalMs = maxConnectIntervalMillis;
          }
        } else {
          throw e;
        }
      }
    }

    attachCallback(client, options.deviceId);
    
    StopWatch watch = new StopWatch();
    watch.start();    
    
    // Publish to the events or state topic based on the flag.
    String subTopic = options.messageType.equals("event") ? "events" : options.messageType;

    // The MQTT topic that this device will publish telemetry data to. The MQTT topic name is
    // required to be in the format below. Note that this is not the same as the device registry's
    // Cloud Pub/Sub topic.
    String mqttTopic = String.format("/devices/%s/%s", options.deviceId, subTopic);

    // Publish numMessages messages to the MQTT bridge, at a rate of 1 per second.
    for (int i = 1; i <= options.numMessages; ++i) {
      String dataText = options.registryId + "/" + options.deviceId + "-payload-" + System.currentTimeMillis() + "-" + i;
      String payload = "{\"data\":\"" + dataText + "\"}";
      System.out.format(
          "Publishing %s message %d/%d: '%s'\n",
          options.messageType, i, options.numMessages, payload);

      // Refresh the connection credentials before the JWT expires.
      // [START iot_mqtt_jwt_refresh]
      long secsSinceRefresh = ((new DateTime()).getMillis() - iat.getMillis()) / 1000;
      if (secsSinceRefresh > (options.tokenExpMins * 60)) {
        System.out.format("\tRefreshing token after: %d seconds\n", secsSinceRefresh);
        iat = new DateTime();
        if (options.algorithm.equals("RS256")) {
          connectOptions.setPassword(
              createJwtRsa(options.projectId, options.privateKeyFile).toCharArray());
        } else if (options.algorithm.equals("ES256")) {
          connectOptions.setPassword(
              createJwtEs(options.projectId, options.privateKeyFile).toCharArray());
        } else {
          throw new IllegalArgumentException(
              "Invalid algorithm " + options.algorithm
                  + ". Should be one of 'RS256' or 'ES256'.");
        }
        client.disconnect();
        client.connect();
        attachCallback(client, options.deviceId);
      }
      // [END iot_mqtt_jwt_refresh]

      // Publish "payload" to the MQTT topic. qos=1 means at least once delivery. Cloud IoT Core
      // also supports qos=0 for at most once delivery.
      MqttMessage message = new MqttMessage(payload.getBytes());
      message.setQos(1);
      client.publish(mqttTopic, message);

      if (options.messageType.equals("event")) {
        // Send telemetry events every second
        Thread.sleep(1000);
      } else {
        // Note: Update Device state less frequently than with telemetry events
        Thread.sleep(5000);
      }
    }

    // Wait for commands to arrive for about two minutes.
    for (int i = 1; i <= options.waitTime; ++i) {
      System.out.print(".");
      Thread.sleep(1000);
    }
    System.out.println("");


    // Disconnect the client if still connected, and finish the run.
    if (client.isConnected()) {
      client.disconnect();
    }
    watch.stop();
    System.out.println("Time consumed to publish events: " + watch.getTime(TimeUnit.SECONDS) + " seconds.");
    System.out.println("Finished loop successfully. Goodbye!");
    client.close();
    // [END iot_mqtt_publish]
  }
}
