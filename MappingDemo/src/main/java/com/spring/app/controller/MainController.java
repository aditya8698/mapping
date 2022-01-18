package com.spring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.app.entity.Category;
import com.spring.app.entity.Product;
import com.spring.app.service.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping("/MainPage")
	public String getIndex() {
		return "Index";
	}
	
	@GetMapping("/AddCategory")
	public String addCategory() {
		return "Category";
	}
	
	@PostMapping("/saveCategory")
	public String insertcategory(Category c) {
		service.AddCategory(c);
		return "Index";
	}
	
	@GetMapping("/AddProducts")
	public String addProduct(Model m) {
		m.addAttribute("category", service.listCategory());
		return "Product";
	}
	
	@PostMapping("/saveProduct")
	public String insertProduct(Product p) {
		service.AddProduct(p);
		return "Index";
	}
	
	@GetMapping("/UpdateProduct")
	public String editProduct(Model m,@RequestParam Integer id) {
		Product prd = service.findProduct(id);
		m.addAttribute("prd", prd);
		m.addAttribute("category", service.listCategory());
		return "Update";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam Integer id) {
		service.deleteProduct(id);
		return "Index";
	}
	
	
	@GetMapping("/")
	public String listOfProducts(Model m,@Param("keyword") String keyword) {
		List<Product> list = service.searchAll(keyword);
		m.addAttribute("list", list);
		return "ListProduct";
	}
}
