package com.sala.java.school.phoneshope.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductImportDTO {
	@NotNull(message = "Product id can`t be Null")
	private Long ProductId;

	@Min(value = 1, message = "import unit must be greater than 0")
	private Integer importUnit;

	@DecimalMin(value = "0.000001", message = "Price must be greater then 0")
	private BigDecimal pricePerUnit;

	@NotNull(message = "Import date can`t be null")
	private LocalDate dateImport;

}
