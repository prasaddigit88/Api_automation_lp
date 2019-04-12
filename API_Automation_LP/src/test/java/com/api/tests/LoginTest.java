package com.api.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.*;
//import org.junit.Before;
//import org.junit.Test;
import com.liveperson.utils.*;
import com.liveperson.data.Login;
import com.liveperson.services.LoginHeaders;
import com.liveperson.urls.*;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;

public class LoginTest {
	public Map<String, String> mp;
	public String ls;

	public String request = "{\"userId\": \"prasad@digit88.com\", \"password\": \"Password123\"}";

	/*
	 * @Before
	 * 
	 * 
	 * public void setUp() {
	 * 
	 * RestAssured.baseURI = System.getProperty("baseurl");
	 * PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
	 * authScheme.setUserName("prasad@digit88.com");
	 * authScheme.setPassword("Password123"); RestAssured.authentication =
	 * authScheme; }
	 */
	@BeforeTest
	public void setUP() {
		LoginHeaders lh = new LoginHeaders();
		mp = lh.setHeadersForLogin();

		Login l = new Login();
		l.setUserId("prasad@digit88.com");
		l.setPassword("Password123");
		String ls = l.toString();

	}

	@Test
	public void loginTest_01() {

		Reporter.log("Test Case Execution started for loginTest_01");

		String baseurl = LoginUrls.baseurl;
		String endurl = LoginUrls.endpointurl;
		Response res = RestAssuredUtil.executePOSTRequest(baseurl, endurl, request, mp);
		System.out.println(res.asString());

		Assert.assertEquals(200, res.getStatusCode());

		String status = RestAssuredUtil.getJsonElementValueAsString(res.asString(),
				"successResult.chatBotPlatformUser.status");

		System.out.println(status);

		Assert.assertEquals("ACTIVE", status);
		System.out.println("login test case executed");

		Reporter.log("Test Case executed successfully");

	}

	@Test
	public void responseStatusValidation() {

		Reporter.log("Test Case Response status validation");

		String baseurl = LoginUrls.baseurl;
		String endurl = LoginUrls.endpointurl;
		Response res = RestAssuredUtil.executePOSTRequest(baseurl, endurl, request, mp);
		System.out.println(res.asString());

		String status = RestAssuredUtil.getJsonElementValueAsString(res.asString(),
				"successResult.chatBotPlatformUser.status");

		System.out.println(status);

		Assert.assertEquals("ACTIVE", status);

		System.out.println("login test case executed");

		Reporter.log("Test Case Response status validation executed successfully");

	}

	
	@Test(enabled=false)
	
	public void responseStatusValidation_failureScenario() {

		Reporter.log("Test Case Response status validation : failure scenario");

		String baseurl = LoginUrls.baseurl;
		String endurl = LoginUrls.endpointurl;
		Response res = RestAssuredUtil.executePOSTRequest(baseurl, endurl, request, mp);
		System.out.println(res.asString());

		String status = RestAssuredUtil.getJsonElementValueAsString(res.asString(),
				"successResult.chatBotPlatformUser.status");

		System.out.println(status);

		Assert.assertEquals("EXPIRED", status);

		System.out.println("login test case executed");

		Reporter.log("Test Case Response status validation : failure scenario executed successfully");

	}

}
