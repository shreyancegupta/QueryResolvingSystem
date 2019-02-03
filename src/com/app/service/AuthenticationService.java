package com.app.service;

public interface AuthenticationService {
	Object retrieveUser(String username, String password, String role);
}
