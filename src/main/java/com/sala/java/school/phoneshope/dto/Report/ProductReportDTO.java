package com.sala.java.school.phoneshope.dto.Report;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductReportDTO {

	private Long productId;

	private String productName;

	private Integer unit;

	private BigDecimal totalAmount;
}
