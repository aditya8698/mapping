package com.spring.app.service;

import java.util.List;

import com.spring.app.entity.Category;
import com.spring.app.entity.Product;

public interface MainService {

	void AddCategory(Category c);
	
	List<Category> listCategory();
	
	void AddProduct(Product p);
	
	List<Product> listProduct();
	
	Product findProduct(Integer id);
	
	void deleteProduct(Integer id);
	
	public List<Product> searchAll(String keyword);
}
