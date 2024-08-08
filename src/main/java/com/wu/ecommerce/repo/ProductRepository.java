package com.wu.ecommerce.repo;
 
import java.sql.SQLException;
import java.util.*;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
 
public interface ProductRepository {
	public Optional<Product> addProduct(Product product) throws SQLException, ClassNotFoundException;
	public Product getProductByProductId(String id) throws IdNotFoundException, SQLException, ClassNotFoundException, InvalidIdException, InvalidPriceException;
	public List<Product> getProducts() throws DataNotFoundException, ClassNotFoundException, SQLException, InvalidPriceException, InvalidIdException;
	public List<Product> getAllProductByCatgory(String cat) throws DataNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	public String removeProductByProductId(String id);
	public Optional<Product> updateProductByProjectId(String id, Product product);
	default void display(){
		System.out.println("Hello from interface");
	}
}