package com.api.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import com.jayway.jsonpath.JsonPath;
import com.liveperson.constants.Constants;
import com.liveperson.data.Login;
import com.liveperson.services.LoginHeaders;
import com.liveperson.services.ShoeFinderBotHeaders;
import com.liveperson.urls.LoginUrls;
import com.liveperson.utils.RestAssuredUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ShoeFinderTest {
	public Map<String, String> mp;
	
	@BeforeTest
	public void setUP() {
		ShoeFinderBotHeaders lh = new ShoeFinderBotHeaders();
		mp = lh.setHeadersForLogin();


	}

	@Test
	public void shoeFinderTest() {

		Reporter.log("Test Case Execution started for loginTest_01");

		String baseurl = Constants.boturl;
		String endurl = "";
		//Response res = RestAssuredUtil.executePOSTRequest(baseurl, endurl, request, mp);
		Response res = RestAssuredUtil.executeGetRequestWithoutParameters(baseurl, endurl, mp);
		System.out.println(res.asString());

		Assert.assertEquals(200, res.getStatusCode());

		
		

		Reporter.log("Test Case  shoeFinderTest executed successfully");

		/*String encodedString= "36b37038-ef3b-4bac-a4ed-ed3677025166";
		String GET_PUSH_API = "https://dev.service.botcentralapi.com/bot-platform-manager-0.1/assist/entities?domainId=34b288e8-722f-4f28-b7f8-9785726cf3c9&query=Do%20you%20have%20a%20particular%20color%20in%20mind?%20%20%20%20%20%20%20%20%20%20%20%20%20Black%20%20%20White%20%20%20Leopard";
		io.restassured.path.json.JsonPath response = RestAssured
				.given()
				    .header("Authorization", "36b37038-ef3b-4bac-a4ed-ed3677025166")
				    .when()
				    .get(GET_PUSH_API)
				.then()
				    .statusCode(200)
				    .extract().jsonPath();   
		System.out.println(response);*/
	}
}
