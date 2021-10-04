package com.aha.dao;

import java.util.List;

import com.aha.model.UserBean;

public interface UserDao {
	public UserBean getUser(String rollNo);
	public List<UserBean> getAllUsers();
	public int addUser(UserBean user);
	public String getUserType(String username);
	public int authenticateUser(String username, String password);
	public int registerStudent(String rollNo, String state);
	public boolean isRegistered(String username);
}
