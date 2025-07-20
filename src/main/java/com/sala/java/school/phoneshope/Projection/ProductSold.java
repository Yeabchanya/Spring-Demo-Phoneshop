package com.sala.java.school.phoneshope.Projection;

import java.math.BigDecimal;

public interface ProductSold {
	Long getProductId();

	String getProductName();

	Integer getUnit();

	BigDecimal getTotalAmount();
}
