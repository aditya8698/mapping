package com.spring.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.entity.Category;
import com.spring.app.entity.Product;
import com.spring.app.repository.CategoryRepository;
import com.spring.app.repository.ProductRepository;

@Service
public class ServiceImpl implements MainService{

	@Autowired 
	private ProductRepository prepo;
	
	@Autowired
	private CategoryRepository crepo;

	@Override
	public void AddCategory(Category c) {
		crepo.save(c);
	}

	@Override
	public List<Category> listCategory() {
		List<Category> clist = crepo.findAll();
		return clist;
	}
	
	@Override
	public void AddProduct(Product p) {
		prepo.save(p);
	}

	@Override
	public List<Product> listProduct() {
		List<Product> plist = prepo.findAll();
		return plist;
	}

	@Override
	public Product findProduct(Integer id) {
		Product p = prepo.findById(id).get();
		return p;
	}

	@Override
	public void deleteProduct(Integer id) {
		prepo.deleteById(id);
	}

	@Override
	public List<Product> searchAll(String keyword) {
		if (keyword != null) {
            return prepo.search(keyword);
        }
        return prepo.findAll();
	}
	
}
