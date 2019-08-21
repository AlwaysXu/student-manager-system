package com.nd.user.dao;

import java.util.List;

import com.nd.user.po.User;

public interface UserDao {
	public User login(User user);
	public List<User> getALL();
	public boolean updateStatus(int id,String status);
	public User getUserById(int id);
	public boolean updateUser(User user);
	public boolean addUser(User user);

}
