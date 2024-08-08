package com.wu.ecommerce;

import java.sql.SQLException;

import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;

public class Main {
	public static void main(String[] args)
			throws SQLException, ClassNotFoundException, InvalidPriceException, InvalidIdException {

		ProductService productService = ProductServiceImpl.getInstance();
		UserService userService = UserServiceImpl.getInstance();
		try {
//			Product product = new Product("asdh8", 100, "Pens", "stationary1");
//			Product product1 = new Product("asdh9", 110, "Pens", "stationary1");
//			Product product2 = new Product("asdh10", 120, "Pens", "stationary1");
//			Product product3 = new Product("asdh11", 130, "Pens", "stationary1");
//			Product product4 = new Product("asdh12", 140, "Pens", "stationary1");
//			productService.addProduct(product);
//			productService.addProduct(product1);
//			productService.addProduct(product2);
//			productService.addProduct(product3);
//			productService.addProduct(product4);

//			System.out.println(productService.getProducts());
//			System.out.println(productService.getProductByProductId("asdh3"));
//			System.out.println(productService.getAllProductByCatgory("stationary"));
			
			User u1 = new User("1", "a", "b", 567765765);
			userService.addUser(u1);
			
			System.out.println(userService.getUserByUserId("1"));
			System.out.println(userService.getUsers());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
// dto = data transport object