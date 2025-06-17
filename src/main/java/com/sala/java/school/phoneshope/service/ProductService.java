package com.sala.java.school.phoneshope.service;

import com.sala.java.school.phoneshope.entity.Product;

public interface ProductService {
	Product create(Product product);
	
	Product getById(Long id);

}
