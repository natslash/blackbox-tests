package com.axoom.drs.it;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItems;

import org.testng.annotations.Test;

public class RESTServiceTestIT {
	@Test
	public void givenUrl_whenJsonResponseHasArrayWithGivenValuesUnderKey_thenCorrect() {
		when().
			get("https://reqres.in/api/users").
		then().statusCode(200).
		assertThat().body("data.last_name",
				hasItems("Weaver"));
	}
}
