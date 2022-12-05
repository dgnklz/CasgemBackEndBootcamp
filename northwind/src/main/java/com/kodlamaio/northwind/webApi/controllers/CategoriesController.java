package com.kodlamaio.northwind.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.CategoryService;
import com.kodlamaio.northwind.business.requests.CreateCategoryRequest;
import com.kodlamaio.northwind.business.requests.DeleteCategoryRequest;
import com.kodlamaio.northwind.business.requests.UpdateCategoryRequest;
import com.kodlamaio.northwind.business.responses.CreateCategoryResponse;
import com.kodlamaio.northwind.business.responses.DeleteCategoryReponse;
import com.kodlamaio.northwind.business.responses.GetAllCategoriesResponses;
import com.kodlamaio.northwind.business.responses.GetCategoryResponse;
import com.kodlamaio.northwind.business.responses.UpdateCategoryResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
	private CategoryService categoryService;
	
	@GetMapping("/getAll")
	public List<GetAllCategoriesResponses> getAll(){
		return categoryService.getAll();
	}
	
	@PostMapping("/add")
	public CreateCategoryResponse add(@RequestBody CreateCategoryRequest createCategoryRequest){
		return categoryService.add(createCategoryRequest);
	}
	
	@GetMapping("/getByName")
	public List<GetCategoryResponse> getByName(String name){
		return categoryService.getByName(name);
	}
	
	@GetMapping("/getById")
	public GetCategoryResponse getById(int id){
		return categoryService.getById(id);
	}
	
	@PutMapping("/update")
	public UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest){
		return categoryService.update(updateCategoryRequest);
	}
	
	@DeleteMapping("/delete")
	DeleteCategoryReponse delete(DeleteCategoryRequest deleteCategoryRequest){
		return categoryService.delete(deleteCategoryRequest);
	}
}
