package com.kfc.dao;

import com.kfc.dto.User;

public interface LoginDao {

	User selectLogin(String user_id, String user_password);

	User getUser(String id);

	User getUserNaver(String id);

	int signUp(User user);

}
