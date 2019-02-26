package com.axoom.drs.utils;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class AxoomKafkaConsumer {  

  private static Consumer<Long, String> createConsumer(String topic, String serverAddress) {
    final Properties props = new Properties();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, serverAddress);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaConsumer");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

    // Create the consumer using props.
    final Consumer<Long, String> consumer = new KafkaConsumer<>(props);

    // Subscribe to the topic.
    consumer.subscribe(Collections.singletonList(topic));
    return consumer;
  }

  public static int runConsumer(String topic, String serverAddress) throws InterruptedException {
    final Consumer<Long, String> consumer = createConsumer(topic, serverAddress);
    int numOfRecords = 0;
    final int giveUp = 10;
    int noRecordsCount = 0;
    StopWatch watch = new StopWatch();
    watch.start();
    
    while (true) {
      final ConsumerRecords<Long, String> consumerRecords = consumer.poll(Duration.ofMillis(1000));      
      if (consumerRecords.count() == 0) {
        noRecordsCount++;
        if (noRecordsCount > giveUp)
          break;
        else
          continue;
      }

      numOfRecords = consumerRecords.count();
      consumerRecords.forEach(record -> {
        System.out.printf("Consumer Record:(%d, %s, %d, %d)\n", record.key(), record.value(),
            record.partition(), record.offset());
      });

      consumer.commitAsync();
    }
    consumer.close();
    watch.stop();
    System.out.println("DONE");    
    System.out.println("Time elapsed to consume " + numOfRecords + " events: " + watch.getTime(TimeUnit.SECONDS) + " seconds.");
    return numOfRecords;
  }
}
