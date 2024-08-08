package com.wu.ecommerce.service;
 
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
 
public interface ProductService {
	public Optional<Product> addProduct(Product product) throws SQLException, ClassNotFoundException;
	public Product getProductByProductId(String id) throws IdNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	public List<Product> getProducts() throws DataNotFoundException, ClassNotFoundException, SQLException, InvalidPriceException, InvalidIdException;
	public List<Product> getAllProductByCatgory(String cat) throws DataNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	public String removeProductByProductId(String id);
	public Optional<Product> updateProductByProjectId(String id, Product product);
	default void display(){
		System.out.println("Hello from interface");
	}
}