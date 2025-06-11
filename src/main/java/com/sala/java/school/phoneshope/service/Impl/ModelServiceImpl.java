package com.sala.java.school.phoneshope.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sala.java.school.phoneshope.dto.ModelDTO;
import com.sala.java.school.phoneshope.entity.Model;
import com.sala.java.school.phoneshope.repository.ModelRepository;
import com.sala.java.school.phoneshope.service.ModelService;
import com.sala.java.school.phoneshope.service.mapper.ModelMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelServiceImpl implements ModelService {
	
	// style one
//	@Autowired
//	private ModelRepository modelRepository;
//	@Autowired
//	private BrandService brandService;
	
	//style two
	private ModelRepository modelRepository;
	private ModelMapper modelMapper;

	@Override
	public Model save(ModelDTO modelDTO) {
		Model model = modelMapper.toModel(modelDTO);
		return modelRepository.save(model);
	}

	@Override
	public List<Model> getByBrand(Integer brandId) {
		// TODO Auto-generated method stub
		return modelRepository.findByBrandId(brandId);
	}

}
