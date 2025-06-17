package com.sala.java.school.phoneshope.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sala.java.school.phoneshope.dto.BrandDTO;
import com.sala.java.school.phoneshope.dto.ModelDTO;
import com.sala.java.school.phoneshope.dto.PageDTO;
import com.sala.java.school.phoneshope.entity.Brand;
import com.sala.java.school.phoneshope.entity.Model;
import com.sala.java.school.phoneshope.service.BrandService;
import com.sala.java.school.phoneshope.service.ModelService;
import com.sala.java.school.phoneshope.service.mapper.ModelMapper;
import com.sala.java.school.phoneshope.service.mapper.brandMapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("brands")
public class BrandController {

	@Autowired
	private BrandService brandService;
	@Autowired
	private ModelService modelService;
	
	private final ModelMapper modelMapper;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		// Brand brand = Mapper.toBrand(brandDTO);
		Brand brand = brandMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(brandMapper.INSTANCE.toBrandDTO(brand));
		
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getOneId(@PathVariable("id") Long brandId) {
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(brandMapper.INSTANCE.toBrandDTO(brand));

	}

	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long brandId, @RequestBody BrandDTO brandDTO) {
		Brand brand = brandMapper.INSTANCE.toBrand(brandDTO);
		Brand brandUpdated = brandService.update(brandId, brand);
		return ResponseEntity.ok(brandMapper.INSTANCE.toBrandDTO(brandUpdated));

	}
	
//	@GetMapping
//	public ResponseEntity<?> getBrands() {
//		List<BrandDTO> List = brandService.getBrands()
//				.stream()
//				.map(Brand -> brandMapper.INSTANCE.toBrandDTO(Brand))
//				.collect(Collectors.toList());
//		
//		return ResponseEntity.ok(List);
//	}
	
	@GetMapping
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params) {
		
		Page<Brand> page = brandService.getBrands(params);
		
		PageDTO pageDTO = new PageDTO(page);
		
//		List<BrandDTO> List = brandService.getBrands(params)
//				.stream()
//				.map(Brand -> brandMapper.INSTANCE.toBrandDTO(Brand))
//				.collect(Collectors.toList());
//		
		return ResponseEntity.ok(pageDTO);
		
	}
	
	
	@GetMapping("{id}/models")
	public ResponseEntity<?> getModelsByBrand(@PathVariable("id") Integer brandId) {
		List<Model> brands = modelService.getByBrand(brandId);
		List<ModelDTO> list = brands.stream()
			//.map(mode -> modelMapper.toModelDTO(mode))
			.map(modelMapper::toModelDTO) // style method referent
			.toList();
		return ResponseEntity.ok(list);

	}

}
