package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.OrderService;
import com.kodlamaio.northwind.business.requests.CreateOrderRequest;
import com.kodlamaio.northwind.business.requests.DeleteOrderRequest;
import com.kodlamaio.northwind.business.requests.UpdateOrderRequest;
import com.kodlamaio.northwind.business.responses.CreateOrderResponse;
import com.kodlamaio.northwind.business.responses.DeleteOrderResponse;
import com.kodlamaio.northwind.business.responses.GetAllOrdersResponse;
import com.kodlamaio.northwind.business.responses.GetOrderResponse;
import com.kodlamaio.northwind.business.responses.UpdateOrderResponse;
import com.kodlamaio.northwind.dataAccess.abstracts.OrderRepository;
import com.kodlamaio.northwind.entities.Employee;
import com.kodlamaio.northwind.entities.Order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {
	OrderRepository orderRepository;

	@Override
	public List<GetAllOrdersResponse> getAll() {
		List<Order> orders = orderRepository.findAll();
		List<GetAllOrdersResponse> ordersResponse = new ArrayList<GetAllOrdersResponse>();
		for (Order order : orders) {
			GetAllOrdersResponse responseItem = new GetAllOrdersResponse();
			responseItem.setId(order.getId());
			responseItem.setDate(order.getDate());
			responseItem.setEmployeeId(order.getEmployee().getId());
			responseItem.setEmployeeName(order.getEmployee().getFirstName()+" "+order.getEmployee().getLastName());
			ordersResponse.add(responseItem);
		}

		return ordersResponse;
	}

	@Override
	public CreateOrderResponse add(CreateOrderRequest createOrderRequest) {
		Order order = new Order();

		Employee employee = new Employee();
		employee.setId(createOrderRequest.getEmployeeId());
		order.setEmployee(employee);
		orderRepository.save(order);

		CreateOrderResponse orderResponse = new CreateOrderResponse();
		orderResponse.setId(order.getId());
		orderResponse.setEmployeeId(order.getEmployee().getId());
		orderResponse.setDate(order.getDate());

		return orderResponse;
	}

//	@Override
//	public List<GetOrderResponse> getByName(String name) {
//		List<Order> orders = orderRepository.findByFirstName(name);
//		List<GetOrderResponse> ordersResponses = new ArrayList<>();
//		for (Order order : orders) {
//			GetOrderResponse responseItem = new GetOrderResponse();
//			responseItem.setId(order.getId());
//			responseItem.setEmployee(order.getEmployee());
//			responseItem.setDate(order.getDate());
//			ordersResponses.add(responseItem);
//		}
//		return ordersResponses;
//	}

	@Override
	public GetOrderResponse getById(int id) {
		Order order = orderRepository.findById(id).get();
		GetOrderResponse responseItem = new GetOrderResponse();
		responseItem.setId(order.getId());
		responseItem.setEmployee(order.getEmployee());
		return responseItem;
	}

	@Override
	public UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest) {
		Order order = orderRepository.findById(updateOrderRequest.getId()).get();

		Employee employee = new Employee();
		employee.setId(updateOrderRequest.getEmployeeId());
		order.setEmployee(employee);

		orderRepository.save(order);

		return null;
	}

	@Override
	public DeleteOrderResponse delete(DeleteOrderRequest deleteOrderRequest) {
		Order order = orderRepository.findById(deleteOrderRequest.getId()).get();

		orderRepository.delete(order);

		DeleteOrderResponse orderResponse = new DeleteOrderResponse();
		orderResponse.setId(order.getId());
		orderResponse.setEmployeeId(order.getEmployee().getId());

		return orderResponse;
	}
	
	public List<GetAllOrdersResponse> getByEmployeeId(int id){
		List<Order> orders = orderRepository.findByEmployeeId(id);
		List<GetAllOrdersResponse> ordersResponses = new ArrayList<>();
		for (Order order : orders) {
			GetAllOrdersResponse responseItem = new GetAllOrdersResponse();
			responseItem.setDate(order.getDate());
			responseItem.setEmployeeName(order.getEmployee().getFirstName());
			ordersResponses.add(responseItem);
		}
		return ordersResponses;
	}

}
