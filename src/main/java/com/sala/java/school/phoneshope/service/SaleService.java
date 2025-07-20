package com.sala.java.school.phoneshope.service;

import com.sala.java.school.phoneshope.dto.SaleDTO;
import com.sala.java.school.phoneshope.entity.Sale;

public interface SaleService {

	void sell(SaleDTO saleDTO);

	Sale getById(Long saleId);

	void cancelSale(Long saleId);

}
