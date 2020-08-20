package com.app.service;

import java.util.List;

import com.app.model.User;



public interface IUserService {
	public User save(User user);
	public User getOneById(int userId);
	public void deleteById(int userId);
	public List<User> getUserList();
	public User getUserByUsername(String user);

}
