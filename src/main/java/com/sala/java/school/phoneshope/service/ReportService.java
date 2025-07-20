package com.sala.java.school.phoneshope.service;

import java.time.LocalDate;
import java.util.List;

import com.sala.java.school.phoneshope.Projection.ProductSold;
import com.sala.java.school.phoneshope.dto.Report.ExpenseReportDTO;
import com.sala.java.school.phoneshope.dto.Report.ProductReportDTO;

public interface ReportService {
	
	List<ProductSold> getProductSold(LocalDate startDate, LocalDate endDate);
	
	List<ProductReportDTO> getProductReport(LocalDate startDate, LocalDate endDate);
	
	List<ExpenseReportDTO> getExpenseReport(LocalDate startDate, LocalDate endDate);
}
