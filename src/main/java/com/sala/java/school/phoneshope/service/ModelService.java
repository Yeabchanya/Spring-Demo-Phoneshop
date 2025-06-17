package com.sala.java.school.phoneshope.service;

import java.util.List;

import com.sala.java.school.phoneshope.dto.ModelDTO;
import com.sala.java.school.phoneshope.entity.Model;

public interface ModelService {

	Model save(ModelDTO modelDTO);
	
	// count brand apple have different model
	List<Model> getByBrand(Integer brandId);
	
	Model getById(Long id);
	
}
