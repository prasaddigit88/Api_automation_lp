package com.liveperson.services;

import java.util.HashMap;
import java.util.Map;

public class ShoeFinderBotHeaders {

	public Map<String,String> setHeadersForLogin(){
		Map<String,String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "Basic 36b37038-ef3b-4bac-a4ed-ed3677025166");
		headers.put("OrganizationId", "2c90a95b-0a8d-4c60-bde5-a935ee9299db");
		return headers;
		
	}

}
