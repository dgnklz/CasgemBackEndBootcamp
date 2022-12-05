package com.kodlamaio.northwind.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.ProductService;
import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.requests.DeleteProductRequest;
import com.kodlamaio.northwind.business.requests.UpdateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductResponse;
import com.kodlamaio.northwind.business.responses.DeleteProductResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;
import com.kodlamaio.northwind.business.responses.UpdateProductResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
	private ProductService productService;
	
	@GetMapping("/getAll")
	public List<GetAllProductResponse> getAll(){
		return productService.getAll();
	}
	
	@PostMapping("/add")
	public CreateProductResponse add(@RequestBody CreateProductRequest createProductRequest) {
		return productService.add(createProductRequest);
	}
	
	@GetMapping("/getByName")
	public List<GetProductResponse> getByName(String name){
		return productService.getByName(name);
	}
	
	@GetMapping("/getById")
	public GetProductResponse getById(int id) {
		return productService.getById(id);
	}
	
	@PostMapping("/update")
	public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
		return productService.update(updateProductRequest);
	}
	
	@DeleteMapping("/delete")
	public DeleteProductResponse delete(DeleteProductRequest deleteProductRequest) {
		return productService.delete(deleteProductRequest);
	}
}
