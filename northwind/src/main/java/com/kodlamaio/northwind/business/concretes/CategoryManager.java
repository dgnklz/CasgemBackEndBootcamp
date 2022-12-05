package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.CategoryService;
import com.kodlamaio.northwind.business.requests.CreateCategoryRequest;
import com.kodlamaio.northwind.business.requests.DeleteCategoryRequest;
import com.kodlamaio.northwind.business.requests.UpdateCategoryRequest;
import com.kodlamaio.northwind.business.responses.CreateCategoryResponse;
import com.kodlamaio.northwind.business.responses.DeleteCategoryReponse;
import com.kodlamaio.northwind.business.responses.GetAllCategoriesResponses;
import com.kodlamaio.northwind.business.responses.GetCategoryResponse;
import com.kodlamaio.northwind.business.responses.UpdateCategoryResponse;
import com.kodlamaio.northwind.dataAccess.abstracts.CategoryRepository;
import com.kodlamaio.northwind.entities.Category;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryManager implements CategoryService{
	CategoryRepository categoryRepository;

	@Override
	public List<GetAllCategoriesResponses> getAll() {
		List<Category> categories = categoryRepository.findAll();
		List<GetAllCategoriesResponses> categoriesResponse = new ArrayList<>();
		for (Category category : categories) {
			GetAllCategoriesResponses responseItem = new GetAllCategoriesResponses();
			responseItem.setId(category.getId());
			responseItem.setName(category.getName());
			categoriesResponse.add(responseItem);
		}
		return categoriesResponse;
	}
	


	@Override
	public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) {
		Category category = new Category();
		category.setName(createCategoryRequest.getName());
		
		categoryRepository.save(category);
		
		CreateCategoryResponse categoryResponse = new CreateCategoryResponse();
		categoryResponse.setId(category.getId());
		categoryResponse.setName(category.getName());
		return categoryResponse;
	}

	@Override
	public List<GetCategoryResponse> getByName(String name) {
		List<Category> categories = categoryRepository.findByName(name);
		List<GetCategoryResponse> categoryResponses = new ArrayList<>();
		for (Category category : categories) {
			GetCategoryResponse responseItem = new GetCategoryResponse();
			responseItem.setId(category.getId());
			responseItem.setName(category.getName());
			categoryResponses.add(responseItem);
		}
		return categoryResponses;
	}

	@Override
	public GetCategoryResponse getById(int id) {
		Category category = categoryRepository.findById(id).get();
		GetCategoryResponse responseItem = new GetCategoryResponse();
		responseItem.setId(category.getId());
		responseItem.setName(category.getName());
		return responseItem;
	}

	@Override
	public UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest) {
		Category category = categoryRepository.findById(updateCategoryRequest.getId()).get();
		category.setName(updateCategoryRequest.getName());
		categoryRepository.save(category);
		
		UpdateCategoryResponse responseItem = new UpdateCategoryResponse();
		responseItem.setId(category.getId());
		responseItem.setName(category.getName());
		return responseItem;
	}

	@Override
	public DeleteCategoryReponse delete(DeleteCategoryRequest deleteCategoryRequest) {
		Category category = categoryRepository.findById(deleteCategoryRequest.getId()).get();
		categoryRepository.delete(category);
		
		DeleteCategoryReponse responseItem = new DeleteCategoryReponse();
		responseItem.setId(category.getId());
		responseItem.setName(category.getName());
		return responseItem;
	}
	
	
}
