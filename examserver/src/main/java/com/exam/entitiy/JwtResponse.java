package com.exam.entitiy;

public class JwtResponse {
	
	String token;

	//O-param construcctor
	public JwtResponse() {
		
	}

	//parma constructor
	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
	

}
