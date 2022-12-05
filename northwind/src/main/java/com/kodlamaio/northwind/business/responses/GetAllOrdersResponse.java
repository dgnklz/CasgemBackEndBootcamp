package com.kodlamaio.northwind.business.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrdersResponse {
	private int id;
	private LocalDate date;
	private int employeeId;
	private String employeeName;
}
