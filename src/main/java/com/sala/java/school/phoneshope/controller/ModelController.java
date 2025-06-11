package com.sala.java.school.phoneshope.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	private final ModelMapper modelMapper;

	// @RequestMapping(method = RequestMethod.POST) // the same
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO) { //@TODO
		//Model model = ModelMapper.INSTANCE.toModel(modelDTO);
		Model model = modelMapper.toModel(modelDTO);
		model = modelService.save(modelDTO);
		return ResponseEntity.ok(modelMapper.toModelDTO(model));
	}
}
 