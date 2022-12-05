package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateOrderRequest;
import com.kodlamaio.northwind.business.requests.DeleteOrderRequest;
import com.kodlamaio.northwind.business.requests.UpdateOrderRequest;
import com.kodlamaio.northwind.business.responses.CreateOrderResponse;
import com.kodlamaio.northwind.business.responses.DeleteOrderResponse;
import com.kodlamaio.northwind.business.responses.GetAllOrdersResponse;
import com.kodlamaio.northwind.business.responses.GetOrderResponse;
import com.kodlamaio.northwind.business.responses.UpdateOrderResponse;

public interface OrderService {
	List<GetAllOrdersResponse> getAll();
	CreateOrderResponse add(CreateOrderRequest createOrderRequest);
//	List<GetOrderResponse> getByName(String name);
	GetOrderResponse getById(int id);
	UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest);
	DeleteOrderResponse delete(DeleteOrderRequest deleteOrderRequest);
	public List<GetAllOrdersResponse> getByEmployeeId(int id);
}
