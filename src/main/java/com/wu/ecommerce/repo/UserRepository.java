package com.wu.ecommerce.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.User;

public interface UserRepository {
	public User addUser(User user) throws SQLException, ClassNotFoundException;
	public User getUserByUserId(String id) throws SQLException, ClassNotFoundException;
	public ArrayList<User> getUsers() throws SQLException, ClassNotFoundException;
	public Optional<User[]> getAllUsersByCategory(String cat);
	public String removeUserByUserId(String id);
	public User updateUserByUserId(String id, User user);
}