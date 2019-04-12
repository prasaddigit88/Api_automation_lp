package com.liveperson.services;

import java.util.HashMap;
import java.util.Map;

public class LoginHeaders {
	
	public Map<String,String> setHeadersForLogin(){
		Map<String,String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "Basic cHJhc2FkQGRpZ2l0ODguY29tOlBhc3N3b3JkMTIz");
		return headers;
		
	}

}
