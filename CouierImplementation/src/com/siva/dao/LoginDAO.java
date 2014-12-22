package com.siva.dao;

import com.siva.model.Login;

public interface LoginDAO {

	Login getUserByCredentials(String username, String password,String role);
}
