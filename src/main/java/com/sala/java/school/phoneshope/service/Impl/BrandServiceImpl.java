package com.sala.java.school.phoneshope.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sala.java.school.phoneshope.entity.Brand;
import com.sala.java.school.phoneshope.repository.BrandRepository;
import com.sala.java.school.phoneshope.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}
	
}
