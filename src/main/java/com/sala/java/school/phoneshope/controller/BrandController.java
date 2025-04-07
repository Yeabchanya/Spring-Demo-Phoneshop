package com.sala.java.school.phoneshope.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sala.java.school.phoneshope.entity.Brand;
import com.sala.java.school.phoneshope.service.BrandService;
import com.sala.java.school.phoneshope.service.mapper.brandMapper;

@RestController
@RequestMapping("brands")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		// Brand brand = Mapper.toBrand(brandDTO);
		Brand brand = brandMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(brandMapper.INSTANCE.toBrandDTO(brand));
		
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getOneId(@PathVariable("id") Integer brandId) {
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(brandMapper.INSTANCE.toBrandDTO(brand));

	}

	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO) {
		Brand brand = brandMapper.INSTANCE.toBrand(brandDTO);
		Brand brandUpdated = brandService.update(brandId, brand);
		return ResponseEntity.ok(brandMapper.INSTANCE.toBrandDTO(brandUpdated));

	}
	
	@GetMapping
	public ResponseEntity<?> getBrands() {
		List<BrandDTO> List = brandService.getBrands()
				.stream()
				.map(Brand -> brandMapper.INSTANCE.toBrandDTO(Brand))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(List);
	}
	
	@GetMapping("filter")
	public ResponseEntity<?> getBrands(@RequestParam("name") String name) {
		List<BrandDTO> List = brandService.getBrands(name)
				.stream()
				.map(Brand -> brandMapper.INSTANCE.toBrandDTO(Brand))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(List);
	}

}
