
package com.sala.java.school.phoneshope.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SaleDTO {
	@NotEmpty
	private List<ProductSoldDTO> products;
	private LocalDate saleDate;
}
