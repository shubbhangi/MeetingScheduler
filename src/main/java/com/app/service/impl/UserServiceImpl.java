package com.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repo.UserRepository;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getOneById(int userId) {
		// TODO Auto-generated method stub
		return userRepository.getOne(userId);
	}

	@Override
	public void deleteById(int userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);	
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserByUsername(String user) {
		return (User) entityManager.createQuery("from User where user_Name=:username ")
				.setParameter("username", user)
				.getSingleResult();
		
		
		
	}
}
