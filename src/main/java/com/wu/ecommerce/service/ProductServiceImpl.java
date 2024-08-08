package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.repo.ProductRepository;
import com.wu.ecommerce.repo.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {
	public ArrayList<Product> products = new ArrayList<Product>();
	private ProductRepository productRepository = ProductRepositoryImpl.getInstance();
	private static ProductService productService;

	private ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public static ProductService getInstance() {
		if (productService == null) {
			// create the object
			productService = new ProductServiceImpl();
		}
		return productService;
	}

	@Override
	public Optional<Product> addProduct(Product product) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.addProduct(product);
	}

	@Override
	public Product getProductByProductId(String id) throws IdNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException {

		// TODO Auto-generated method stub
		return productRepository.getProductByProductId(id);
	}

	@Override
	public List<Product> getProducts() throws DataNotFoundException, ClassNotFoundException, SQLException,
			InvalidPriceException, InvalidIdException {
		// TODO Auto-generated method stub
		return productRepository.getProducts();
	}

	@Override
	public List<Product> getAllProductByCatgory(String cat) throws DataNotFoundException, ClassNotFoundException,
			SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		return productRepository.getAllProductByCatgory(cat);
	}

	@Override
	public String removeProductByProductId(String id) {
		// TODO Auto-generated method stub
		return productRepository.removeProductByProductId(id);
	}

	@Override
	public Optional<Product> updateProductByProjectId(String id, Product product) {
		// TODO Auto-generated method stub
		return productRepository.updateProductByProjectId(id, product);
	}

//	public void printProducts (Optional<Product[]> productToPrint){
//		Optional<Product[]> optionaResult = productToPrint != null?productToPrint:this.getProducts();
//		System.out.println("remove with id : after");
//		if(optionaResult.isPresent()) {
//			Product[] returnedProducts = optionaResult.get();
//			for (Product product : returnedProducts) {
//				System.out.println(product);	
//			}
//		}
//		System.out.println();
//	}
}