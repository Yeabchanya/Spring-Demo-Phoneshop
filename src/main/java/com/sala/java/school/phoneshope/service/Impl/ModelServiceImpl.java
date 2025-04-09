package com.sala.java.school.phoneshope.service.Impl;

import org.springframework.stereotype.Service;

import com.sala.java.school.phoneshope.entity.Model;
import com.sala.java.school.phoneshope.repository.ModelRepository;
import com.sala.java.school.phoneshope.service.BrandService;
import com.sala.java.school.phoneshope.service.ModelService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelServiceImpl implements ModelService {
	
	// stay one
//	@Autowired
//	private ModelRepository modelRepository;
//	@Autowired
//	private BrandService brandService;
	
	//stay two
	private ModelRepository modelRepository;
	private BrandService brandService;

	@Override
	public Model save(Model model) {
		Integer BrandId = model.getBrand().getId();
		brandService.getById(BrandId);
		return modelRepository.save(model);
	}

}
