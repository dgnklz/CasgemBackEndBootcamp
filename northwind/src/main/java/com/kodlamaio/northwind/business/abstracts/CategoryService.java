package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateCategoryRequest;
import com.kodlamaio.northwind.business.requests.DeleteCategoryRequest;
import com.kodlamaio.northwind.business.requests.UpdateCategoryRequest;
import com.kodlamaio.northwind.business.responses.CreateCategoryResponse;
import com.kodlamaio.northwind.business.responses.DeleteCategoryReponse;
import com.kodlamaio.northwind.business.responses.GetAllCategoriesResponses;
import com.kodlamaio.northwind.business.responses.GetCategoryResponse;
import com.kodlamaio.northwind.business.responses.UpdateCategoryResponse;

public interface CategoryService {
	List<GetAllCategoriesResponses> getAll();
	CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest);
	List<GetCategoryResponse> getByName(String name);
	GetCategoryResponse getById(int id);
	UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest);
	DeleteCategoryReponse delete(DeleteCategoryRequest deleteCategoryRequest);
}
