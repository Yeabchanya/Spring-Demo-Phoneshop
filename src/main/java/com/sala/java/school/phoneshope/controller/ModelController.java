package com.sala.java.school.phoneshope.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sala.java.school.phoneshope.dto.ModelDTO;
import com.sala.java.school.phoneshope.entity.Model;
import com.sala.java.school.phoneshope.service.ModelService;
import com.sala.java.school.phoneshope.service.mapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {

	private final ModelService modelService;

	// @RequestMapping(method = RequestMethod.POST) // the same
	@PostMapping
	public ResponseEntity<?> create(ModelDTO modelDTO) {
		Model model = ModelMapper.INSTANCE.toModel(modelDTO);
		model = modelService.save(model);
		return ResponseEntity.ok(model);
	}
}
