package com.sala.java.school.phoneshope.Specification;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SaleDetailFilter {

	private LocalDate startDate;
	
	private LocalDate endDate;
}
