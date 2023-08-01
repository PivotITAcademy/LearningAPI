package com.apiautomation.LearningAPI.jiraTests;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.response.Response;

public class CreateIssueApiTest {

	//Implement call to CreateIssueMetadata and extract the project id and story id in context.
	String projectId ="10002";
	String storyId="10009";
	
	@Test
	public void testCreateIssueApi() {
		
		
		//Create requestBody
		
		JsonObject createIssueRequest = new JsonObject();

		JsonObject fields = new JsonObject();

		fields.addProperty("summary", "Test Summary as shown in class");

		JsonObject project = new JsonObject();

		project.addProperty("id", projectId);

		fields.add("project", project);

		JsonObject description = new JsonObject();

		description.addProperty("type", "doc");
		description.addProperty("version", 1);

		JsonArray content = new JsonArray();

		JsonObject contentObject = new JsonObject();

		contentObject.addProperty("type", "paragraph");

		JsonObject contentInternalObject = new JsonObject();
		contentInternalObject.addProperty("text", "Test description as shown in class");

		contentInternalObject.addProperty("type", "text");

		JsonArray contentInternalArray = new JsonArray();
		contentInternalArray.add(contentInternalObject);

		contentObject.add("content", contentInternalArray);

		content.add(contentObject);

		description.add("content", content);

		fields.add("description", description);

		JsonObject issuetype = new JsonObject();
		issuetype.addProperty("id", storyId);

		fields.add("issuetype", issuetype);

		createIssueRequest.add("fields", fields);
		
		System.out.println(createIssueRequest.toString());

		Response response = given().header("Authorization",
				"Basic a2F0ZXBxYUBnbWFpbC5jb206QVRBVFQzeEZmR0YwbGd2bjJTdTdmWG9ZMTNnLU9OMmpjZWVScGZ0bWNfeGhkZFN0QmptLWwwd1pyQ0NMVTlHSXFJQTFPWlB4UmxPUXBXVVN6RUlvMXM3U29Oem5lOWF3YkF5UEZ3endXS0c0QWlORG9xeU1MYU53SnZFY0xkMzdfZzhrbnR2YlNvYy0tYTNSdEdHVllLQzNPQjQ4eDcwU2t3Z2dkQnQta2JqeENiVG56cnBMMlc4PTcxRTcxMEMx")
				.header("Content-Type", "application/json").body(createIssueRequest).when().log().all()
				.post("/rest/api/3/issue");

		Assert.assertEquals(response.statusCode(), 201);

		storyId = response.body().jsonPath().getString("id");
		
	}
}
