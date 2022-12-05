package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.ProductService;
import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.requests.DeleteProductRequest;
import com.kodlamaio.northwind.business.requests.UpdateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductResponse;
import com.kodlamaio.northwind.business.responses.DeleteProductResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;
import com.kodlamaio.northwind.business.responses.UpdateProductResponse;
import com.kodlamaio.northwind.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.northwind.dataAccess.abstracts.ProductRepository;
import com.kodlamaio.northwind.entities.Category;
import com.kodlamaio.northwind.entities.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {
	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllProductResponse> getAll() {
		List<Product> products = productRepository.findAll();
		List<GetAllProductResponse> productsResponse = new ArrayList<GetAllProductResponse>();
		for (Product product : products) {
			GetAllProductResponse responseItem = new GetAllProductResponse();
			responseItem.setId(product.getId());
			responseItem.setName(product.getName());
			responseItem.setCategoryName(product.getCategory().getName());
			responseItem.setUnitPrice(product.getUnitPrice());
			responseItem.setUnitsInStock(product.getUnitsInStock());
			productsResponse.add(responseItem);
		}
		return productsResponse;
	}

	@Override
	public CreateProductResponse add(CreateProductRequest createProductRequest) {
		Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
//		Product product = new Product();
//		product.setName(createProductRequest.getName());
//
//		Category category = new Category();
//		category.setId(createProductRequest.getCategoryId());
//		product.setCategory(category);
//
//		product.setUnitPrice(createProductRequest.getUnitPrice());
//		product.setUnitsInStock(createProductRequest.getUnitsInStock());
		productRepository.save(product);

		CreateProductResponse productResponse = this.modelMapperService.forResponse().map(product, CreateProductResponse.class);
//		CreateProductResponse productResponse = new CreateProductResponse();
//		productResponse.setId(product.getId());
//		productResponse.setName(product.getName());
//		productResponse.setCategoryId(product.getCategory().getId());
//		productResponse.setUnitPrice(product.getUnitPrice());
//		productResponse.setUnitsInStock(product.getUnitsInStock());

		return productResponse;
	}

	@Override
	public List<GetProductResponse> getByName(String name) {
		List<Product> products = productRepository.findByName(name);
		List<GetProductResponse> productResponse = new ArrayList<GetProductResponse>();
		for (Product product : products) {
			GetProductResponse responseItem = new GetProductResponse();
			responseItem.setId(product.getId());
			responseItem.setName(product.getName());
			responseItem.setCategoryName(product.getCategory().getName());
			responseItem.setUnitPrice(product.getUnitPrice());
			responseItem.setUnitsInStock(product.getUnitsInStock());
			productResponse.add(responseItem);
		}
		return productResponse;
	}

	@Override
	public GetProductResponse getById(int id) {
		Product product = productRepository.findById(id).get();
		GetProductResponse responseItem = new GetProductResponse();
		responseItem.setId(product.getId());
		responseItem.setName(product.getName());
		responseItem.setCategoryName(product.getCategory().getName());
		responseItem.setUnitPrice(product.getUnitPrice());
		responseItem.setUnitsInStock(product.getUnitsInStock());
		return responseItem;
	}

	@Override
	public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
		Product product = productRepository.findById(updateProductRequest.getId()).get();
		product.setName(updateProductRequest.getName());

		Category category = new Category();
		category.setId(updateProductRequest.getCategoryId());
		product.setCategory(category);

		product.setUnitPrice(updateProductRequest.getUnitPrice());
		product.setUnitsInStock(updateProductRequest.getUnitsInStock());

		productRepository.save(product);

		UpdateProductResponse productResponse = new UpdateProductResponse();
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setCategoryId(product.getCategory().getId());
		productResponse.setUnitPrice(product.getUnitPrice());
		productResponse.setUnitsInStock(product.getUnitsInStock());
		return productResponse;
	}

	@Override
	public DeleteProductResponse delete(DeleteProductRequest deleteProductRequest) {
		Product product = productRepository.findById(deleteProductRequest.getId()).get();

		productRepository.delete(product);

		DeleteProductResponse productResponse = new DeleteProductResponse();
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setCategoryId(product.getCategory().getId());
		productResponse.setUnitPrice(product.getUnitPrice());
		productResponse.setUnitsInStock(product.getUnitsInStock());

		return productResponse;
	}

}
