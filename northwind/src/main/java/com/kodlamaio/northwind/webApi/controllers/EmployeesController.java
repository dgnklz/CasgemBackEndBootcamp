package com.kodlamaio.northwind.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.EmployeeService;
import com.kodlamaio.northwind.business.requests.CreateEmployeeRequest;
import com.kodlamaio.northwind.business.requests.DeleteEmployeeRequest;
import com.kodlamaio.northwind.business.requests.UpdateEmployeeRequest;
import com.kodlamaio.northwind.business.responses.CreateEmployeeResponse;
import com.kodlamaio.northwind.business.responses.DeleteEmployeeResponse;
import com.kodlamaio.northwind.business.responses.GetAllEmployeesResponse;
import com.kodlamaio.northwind.business.responses.GetEmployeeResponse;
import com.kodlamaio.northwind.business.responses.UpdateEmployeeResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {
	EmployeeService employeeService;

	@GetMapping("/getAll")
	public List<GetAllEmployeesResponse> getAll() {
		return employeeService.getAll();
	}

	@PostMapping("/add")
	public CreateEmployeeResponse add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		return employeeService.add(createEmployeeRequest);
	}

	@GetMapping("/getByName")
	public List<GetEmployeeResponse> getByName(String name) {
		return employeeService.getByName(name);
	}

	@GetMapping("/getById")
	public GetEmployeeResponse getById(int id) {
		return employeeService.getById(id);
	}

	@PutMapping("/update")
	public UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest) {
		return employeeService.update(updateEmployeeRequest);
	}

	@DeleteMapping("/delete")
	DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		return employeeService.delete(deleteEmployeeRequest);
	}


}
