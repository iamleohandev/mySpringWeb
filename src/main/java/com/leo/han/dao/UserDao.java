package com.leo.han.dao;

import java.util.List;

import com.leo.han.beans.Actor;
import com.leo.han.beans.User;

public interface UserDao {

	List<User> getUsers();
	
	boolean isUserExist(User user);
	
	void createUser(User user);
	
}
