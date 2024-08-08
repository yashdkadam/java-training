package com.wu.ecommerce.dto;

import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
//@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Product 
//implements Comparable<Product>
{
	private String productId;
	@lombok.ToString.Exclude
	private float price;
	
	public void setProductId(String productId) throws InvalidIdException{
		if(productId == null || productId.equals("") || productId.length() < 3) {
			throw new InvalidIdException("id is invalid");
		}
		this.productId = productId;
	}
	
	public void setPrice(float price) throws InvalidPriceException {
		if(price < 0) {
			throw new InvalidPriceException("Price id invalid");
		}
		this.price = price;
	}
	
	@Setter
	private String productName;
	@Setter
	private String categoryName;

//	@Override
//	public int compareTo(Product o) {
//		// TODO Auto-generated method stub
//		return this.productId.compareTo(o.productId);
//	}
}
