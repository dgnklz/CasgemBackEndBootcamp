package com.kodlamaio.northwind.business.responses;

import java.time.LocalDate;

import com.kodlamaio.northwind.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {
	private int id;
	private LocalDate date;
	private Employee employee;
}
