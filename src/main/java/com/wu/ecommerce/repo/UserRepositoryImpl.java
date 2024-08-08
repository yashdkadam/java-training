package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.utils.DBUtils;

public class UserRepositoryImpl implements UserRepository {
	private static UserRepository userRepository;

	public static UserRepository getInstance() {
		if (userRepository == null) {
			// create the object
			userRepository = new UserRepositoryImpl();
		}
		return userRepository;
	}

	@Override
	public User addUser(User user) throws SQLException, ClassNotFoundException {
		String insertStatement = "insert into USER_TABLE "
				+ "(USERID, FIRSTNAME, LASTNAME, CONTACTNUMBER) values(?,?,?,?)";
		Connection connection = DBUtils.getInstance().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);

		preparedStatement.setString(1, user.getUserId());
		preparedStatement.setString(2, user.getFirstName());
		preparedStatement.setString(3, user.getLastName());
		preparedStatement.setLong(4, user.getContactNumber());

		int result = preparedStatement.executeUpdate();
//		System.out.println(result);
		if (result > 0) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public User getUserByUserId(String id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String query = "select * from USER_TABLE where USERID = ?";
		Connection connection = DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			User user = new User();
			user.setUserId(resultSet.getString("userid"));
			user.setFirstName(resultSet.getString("firstName"));
			user.setLastName(resultSet.getString("lastName"));
			user.setContactNumber(resultSet.getLong("contactNumber"));
			return user;
		}

		return null;
	}

	@Override
	public ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String query = "select * from USER_TABLE";
		Connection connection = DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<User> users = new ArrayList<User>();
		while(resultSet.next()) {
			User user = new User();
			user.setUserId(resultSet.getString("userid"));
			user.setFirstName(resultSet.getString("firstName"));
			user.setLastName(resultSet.getString("lastName"));
			user.setContactNumber(resultSet.getLong("contactNumber"));
			users.add(user);
		}

		return users;
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
