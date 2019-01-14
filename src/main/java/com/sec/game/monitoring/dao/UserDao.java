package com.sec.game.monitoring.dao;

import java.util.List;

import com.sec.game.monitoring.model.User;

public interface UserDao {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	Object getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);
}