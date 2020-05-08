package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.dao.ProductDao;

@RestController
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	
	@PostMapping("/product")
	public String addProduct(ProductBean productBean)
	{
		productDao.addProduct(productBean);
		return "Success!!!Product has been added...";
	}
	
	@GetMapping("/products")
	public ArrayList<ProductBean> listProducts()
	{
		return productDao.listProducts();
	}
	
	@DeleteMapping("/product/{id}")
	public ArrayList<ProductBean> deleteProduct(@PathVariable("id")int id)
	{
		productDao.deleteProduct(id);
		return productDao.listProducts();
	}
	
	@PutMapping("/product")
	public ArrayList<ProductBean> updateProduct(ProductBean productBean)
	{
		productDao.updateProduct(productBean);
		return productDao.listProducts();
	}
}
