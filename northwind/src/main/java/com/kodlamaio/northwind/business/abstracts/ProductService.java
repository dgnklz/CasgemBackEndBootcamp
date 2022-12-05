package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.requests.DeleteProductRequest;
import com.kodlamaio.northwind.business.requests.UpdateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductResponse;
import com.kodlamaio.northwind.business.responses.DeleteProductResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;
import com.kodlamaio.northwind.business.responses.UpdateProductResponse;

public interface ProductService {
	List<GetAllProductResponse> getAll();
	CreateProductResponse add(CreateProductRequest createProductRequest);
	List<GetProductResponse> getByName(String name);
	GetProductResponse getById(int id);
	UpdateProductResponse update(UpdateProductRequest updateProductRequest);
	DeleteProductResponse delete(DeleteProductRequest deleteProductRequest);
}
