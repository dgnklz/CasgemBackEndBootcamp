package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateEmployeeRequest;
import com.kodlamaio.northwind.business.requests.DeleteEmployeeRequest;
import com.kodlamaio.northwind.business.requests.UpdateEmployeeRequest;
import com.kodlamaio.northwind.business.responses.CreateEmployeeResponse;
import com.kodlamaio.northwind.business.responses.DeleteEmployeeResponse;
import com.kodlamaio.northwind.business.responses.GetAllEmployeesResponse;
import com.kodlamaio.northwind.business.responses.GetEmployeeResponse;
import com.kodlamaio.northwind.business.responses.UpdateEmployeeResponse;

public interface EmployeeService {
	List<GetAllEmployeesResponse> getAll();
	CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest);
	List<GetEmployeeResponse> getByName(String name);
	GetEmployeeResponse getById(int id);
	UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest);
	DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest);
}
