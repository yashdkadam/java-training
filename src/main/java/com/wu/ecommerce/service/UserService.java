package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.User;

public interface UserService {
	public User addUser(User user) throws ClassNotFoundException, SQLException;
	public User getUserByUserId(String id) throws ClassNotFoundException, SQLException;
	public ArrayList<User> getUsers() throws ClassNotFoundException, SQLException;
	public Optional<User[]> getAllUsersByCategory(String cat);
	public String removeUserByUserId(String id);
	public User updateUserByUserId(String id, User user);
}