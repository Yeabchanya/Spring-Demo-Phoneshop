package com.sala.java.school.phoneshope.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sala.java.school.phoneshope.dto.ProductImportDTO;
import com.sala.java.school.phoneshope.entity.Product;

public interface ProductService {
	Product create(Product product);
	
	Product getById(Long id);

	void ImportProduct(ProductImportDTO importDTO);
	
	void setSalePrice(Long ProductId, BigDecimal price);
	
	void validateStock(Long proId, Integer Qty);
	
	Map<Integer, String> uploadProduct(MultipartFile file);
	
	Product getByModelIdAndColorId(Long modelId, long colorId);

}
