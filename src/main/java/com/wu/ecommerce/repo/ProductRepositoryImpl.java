package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.utils.DBUtils;

public class ProductRepositoryImpl implements ProductRepository {
	private static ProductRepository productRepository;

//	private Set<Product> products = new TreeSet<Product>(new Comparator<Product>() {
//		@Override
//		public int compare(Product o1, Product o2) {
//			return o1.getProductName().compareTo(o2.getProductName());
//		}
//	});

	private Set<Product> products = new TreeSet<Product>(
			(o1, o2) -> o1.getProductName().compareTo(o2.getProductName()));

	public static ProductRepository getInstance() {
		if (productRepository == null) {
			// create the object
			productRepository = new ProductRepositoryImpl();
		}
		return productRepository;
	}

	private ProductRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Optional<Product> addProduct(Product product) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String insertStatement = "insert into PRODUCT "
				+ "(PRODUCTID, PRODUCTNAME, PRODUCTCATEGORY, PRODUCTPRICE) values(?,?,?,?)";
		Connection connection = DBUtils.getInstance().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
		System.out.println(product.getProductId());
		preparedStatement.setString(1, product.getProductId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setString(3, product.getCategoryName());
		preparedStatement.setFloat(4, product.getPrice());

		int result = preparedStatement.executeUpdate();
		System.out.println(result);
		if (result > 0) {
			return Optional.ofNullable(product);
		} else {
			return null;
		}
	}

	@Override
	public Product getProductByProductId(String id) throws IdNotFoundException, SQLException, ClassNotFoundException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		String query = "select * from product where PRODUCTID = ?";
		Connection connection = DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		if(resultSet.next()) {
			Product product = new Product();
			product.setProductId(resultSet.getString("productid"));
			product.setProductName(resultSet.getString("productname"));
			product.setPrice(resultSet.getFloat("productprice"));
			product.setProductName(resultSet.getString("productcategory"));
			return product;
		}

		return null;
	}

	@Override
	public List<Product> getProducts() throws DataNotFoundException, ClassNotFoundException, SQLException,
			InvalidPriceException, InvalidIdException {
		// TODO Auto-generated method stub
		String query = "select * from product";
		Connection connection = DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();

		List<Product> products = new ArrayList<Product>();
		while (resultSet.next()) {
			Product product = new Product();
			product.setProductId(resultSet.getString("productid"));
			product.setProductName(resultSet.getString("productname"));
			product.setPrice(resultSet.getFloat("productprice"));
			product.setProductName(resultSet.getString("productcategory"));
			products.add(product);
		}

		return products;
	}

	@Override
	public List<Product> getAllProductByCatgory(String cat) throws DataNotFoundException, ClassNotFoundException,
			SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		String query = "select * from product where PRODUCTCATEGORY = ?";
		System.out.println(query);
		Connection connection = DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, cat);
		ResultSet resultSet = preparedStatement.executeQuery();

		List<Product> products = new ArrayList<Product>();
		while (resultSet.next()) {
			Product product = new Product();
			product.setProductId(resultSet.getString("productid"));
			product.setProductName(resultSet.getString("productname"));
			product.setPrice(resultSet.getFloat("productprice"));
			product.setProductName(resultSet.getString("productcategory"));
			products.add(product);
		}

		return (List<Product>) Optional.ofNullable(products).filter(e -> !e.isEmpty())
				.orElseThrow(() -> new DataNotFoundException("There is no data to return"));

//		return Optional
//				.ofNullable(products.stream().filter(e -> e.getCategoryName().equals(cat)).collect(Collectors.toList()))
//				.filter(e -> !e.isEmpty()).orElseThrow(() -> new DataNotFoundException("Data Not Founds"));
	}

	@Override
	public String removeProductByProductId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> updateProductByProjectId(String id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}