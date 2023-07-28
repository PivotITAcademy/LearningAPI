package com.apiautomation.LearningAPI.tests;

import org.testng.annotations.Test;

import com.apiautomation.utils.Utils;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateIssueMetadataTest {

	@Test
	public void testApiCall() {
		Utils.print();
		//RestAssured.baseURI = "https://katep.atlassian.net";
		baseURI = "https://katep.atlassian.net";
		given().header("Authorization","Basic a2F0ZXBxYUBnbWFpbC5jb206QVRBVFQzeEZmR0YwbGd2bjJTdTdmWG9ZMTNnLU9OMmpjZWVScGZ0bWNfeGhkZFN0QmptLWwwd1pyQ0NMVTlHSXFJQTFPWlB4UmxPUXBXVVN6RUlvMXM3U29Oem5lOWF3YkF5UEZ3endXS0c0QWlORG9xeU1MYU53SnZFY0xkMzdfZzhrbnR2YlNvYy0tYTNSdEdHVllLQzNPQjQ4eDcwU2t3Z2dkQnQta2JqeENiVG56cnBMMlc4PTcxRTcxMEMx").
		when().log().all().get("/rest/api/3/issue/createmeta").then().log().all().statusCode(200);
	}
}
