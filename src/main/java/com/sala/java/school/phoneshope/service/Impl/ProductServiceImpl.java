package com.sala.java.school.phoneshope.service.Impl;

import org.springframework.stereotype.Service;

import com.sala.java.school.phoneshope.Exception.ResourceNotFoundException;
import com.sala.java.school.phoneshope.entity.Product;
import com.sala.java.school.phoneshope.repository.ProductRepository;
import com.sala.java.school.phoneshope.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepository;

	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", id));
	}

}
