package com.kodlamaio.northwind.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.OrderService;
import com.kodlamaio.northwind.business.requests.CreateOrderRequest;
import com.kodlamaio.northwind.business.requests.DeleteOrderRequest;
import com.kodlamaio.northwind.business.requests.UpdateOrderRequest;
import com.kodlamaio.northwind.business.responses.DeleteOrderResponse;
import com.kodlamaio.northwind.business.responses.GetAllOrdersResponse;
import com.kodlamaio.northwind.business.responses.GetOrderResponse;
import com.kodlamaio.northwind.business.responses.UpdateOrderResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrdersController {
	OrderService orderService;
	
	@GetMapping("/getAll")
	public List<GetAllOrdersResponse> getAll(){
		return orderService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateOrderRequest createOrderRequest) {
		orderService.add(createOrderRequest);
	}
	
	@GetMapping("/getById")
	public GetOrderResponse getById(int id) {
		return orderService.getById(id);
	}
	
	@PostMapping("/update")
	public UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest) {
		return orderService.update(updateOrderRequest);
	}
	
	@DeleteMapping("/delete")
	public DeleteOrderResponse delete(DeleteOrderRequest deleteOrderRequest) {
		return orderService.delete(deleteOrderRequest);
	}
	
	@GetMapping("/getByEmployeeId")
	public List<GetAllOrdersResponse> getByEmployeeId(int id){
		return orderService.getByEmployeeId(id);
	}
}
