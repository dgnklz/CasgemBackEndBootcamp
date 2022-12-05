package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.EmployeeService;
import com.kodlamaio.northwind.business.requests.CreateEmployeeRequest;
import com.kodlamaio.northwind.business.requests.DeleteEmployeeRequest;
import com.kodlamaio.northwind.business.requests.UpdateEmployeeRequest;
import com.kodlamaio.northwind.business.responses.CreateEmployeeResponse;
import com.kodlamaio.northwind.business.responses.DeleteEmployeeResponse;
import com.kodlamaio.northwind.business.responses.GetAllEmployeesResponse;
import com.kodlamaio.northwind.business.responses.GetEmployeeResponse;
import com.kodlamaio.northwind.business.responses.UpdateEmployeeResponse;
import com.kodlamaio.northwind.dataAccess.abstracts.EmployeeRepository;
import com.kodlamaio.northwind.entities.Employee;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<GetAllEmployeesResponse> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		List<GetAllEmployeesResponse> employeesResponse = new ArrayList<GetAllEmployeesResponse>();
		for (Employee employee : employees) {
			GetAllEmployeesResponse responseItem = new GetAllEmployeesResponse();
			responseItem.setId(employee.getId());
			responseItem.setFirstName(employee.getFirstName());
			responseItem.setLastName(employee.getLastName());
			responseItem.setSalary(employee.getSalary());
			employeesResponse.add(responseItem);
		}
		
		return employeesResponse;
	}

	@Override
	public CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = new Employee();
		employee.setFirstName(createEmployeeRequest.getFirstName());
		employee.setLastName(createEmployeeRequest.getLastName());
		employee.setSalary(createEmployeeRequest.getSalary());
		employeeRepository.save(employee);
		
		CreateEmployeeResponse employeeResponse = new CreateEmployeeResponse();
		employeeResponse.setFirstName(employee.getFirstName());
		employeeResponse.setLastName(employee.getLastName());
		employeeResponse.setSalary(employee.getSalary());
		return employeeResponse;
	}

	@Override
	public List<GetEmployeeResponse> getByName(String name) {
		List<Employee> employees = employeeRepository.findByFirstName(name);
		List<GetEmployeeResponse> employeesResponse = new ArrayList<GetEmployeeResponse>();
		for (Employee employee : employees) {
			GetEmployeeResponse responseItem = new GetEmployeeResponse();
			responseItem.setId(employee.getId());
			responseItem.setFirstName(employee.getFirstName());
			responseItem.setLastName(employee.getLastName());
			responseItem.setSalary(employee.getSalary());
			employeesResponse.add(responseItem);
		}
		return employeesResponse;
	}

	@Override
	public GetEmployeeResponse getById(int id) {
		Employee employee = employeeRepository.findById(id).get();
		GetEmployeeResponse responseItem = new GetEmployeeResponse();
		responseItem.setId(employee.getId());
		responseItem.setFirstName(employee.getFirstName());
		responseItem.setLastName(employee.getLastName());
		responseItem.setSalary(employee.getSalary());
		return responseItem;
	}
	
	@Override
	public UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest) {
		Employee employee = employeeRepository.findById(updateEmployeeRequest.getId()).get();
		employee.setFirstName(updateEmployeeRequest.getFirstName());
		employee.setLastName(updateEmployeeRequest.getLastName());
		employee.setSalary(updateEmployeeRequest.getSalary());
		employeeRepository.save(employee);
		
		UpdateEmployeeResponse employeeResponse = new UpdateEmployeeResponse();
		employeeResponse.setId(employee.getId());
		employeeResponse.setFirstName(employee.getFirstName());
		employeeResponse.setLastName(employee.getLastName());
		employeeResponse.setSalary(employee.getSalary());
		return employeeResponse;
	}

	@Override
	public DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		Employee employee = employeeRepository.findById(deleteEmployeeRequest.getId()).get();
		
		employeeRepository.delete(employee);
		
		DeleteEmployeeResponse employeeResponse = new DeleteEmployeeResponse();
		employeeResponse.setId(employee.getId());
		employeeResponse.setFirstName(employee.getFirstName());
		employeeResponse.setLastName(employee.getLastName());
		employeeResponse.setSalary(employee.getSalary());
		
		
		
		return employeeResponse;
	}
	
}
