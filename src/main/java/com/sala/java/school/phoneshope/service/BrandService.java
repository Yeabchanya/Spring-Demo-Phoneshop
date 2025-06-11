package com.sala.java.school.phoneshope.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.sala.java.school.phoneshope.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);

	Brand getById(Integer id);

	Brand update(Integer id, Brand brandUpdate);

	List<Brand> getBrands(String name);
	
	//List<Brand> getBrands(Map<String, String> params);
	
	Page<Brand>	getBrands(Map<String, String> params);
}
