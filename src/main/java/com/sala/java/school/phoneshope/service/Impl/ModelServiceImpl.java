package com.sala.java.school.phoneshope.service.Impl;

import org.springframework.stereotype.Service;

import com.sala.java.school.phoneshope.entity.Model;
import com.sala.java.school.phoneshope.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService {
	private ModelServiceImpl modelServiceImpl;

	@Override
	public Model save(Model model) {
		return modelServiceImpl.save(model);
	}

}
