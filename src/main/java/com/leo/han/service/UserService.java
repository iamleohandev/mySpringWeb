package com.leo.han.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.han.beans.User;
import com.leo.han.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void createUser(User user){
		userDao.createUser(user);
	}
	
	public boolean isUserExist(User user){
		return userDao.isUserExist(user);
	}
	
	public List<User> getUsers(){
		
		return userDao.getUsers();
	}

	

}
