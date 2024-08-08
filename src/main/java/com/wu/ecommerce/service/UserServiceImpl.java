package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.repo.UserRepository;
import com.wu.ecommerce.repo.UserRepositoryImpl;

public class UserServiceImpl implements UserService{
	private UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private ArrayList<User> users = new ArrayList<User>();
	
	public static UserService userService;
	
	public static UserService getInstance() {
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}
	private UserRepository userRepository = UserRepositoryImpl.getInstance(); 
	

	@Override
	public User addUser(User user){
		try {
			return userRepository.addUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserByUserId(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getUserByUserId(id);
	}

	@Override
	public ArrayList<User> getUsers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getUsers();
	}

	@Override
	public Optional<User[]> getAllUsersByCategory(String cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeUserByUserId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserByUserId(String id, User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
