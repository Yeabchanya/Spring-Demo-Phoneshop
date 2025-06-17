package com.sala.java.school.phoneshope.service.Impl;

import org.springframework.stereotype.Service;

import com.sala.java.school.phoneshope.Exception.ResourceNotFoundException;
import com.sala.java.school.phoneshope.entity.Color;
import com.sala.java.school.phoneshope.repository.ColorRepository;
import com.sala.java.school.phoneshope.service.ColorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService{
	
	private final ColorRepository colorRepository;

	@Override
	public Color create(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getById(Long id) {
		// TODO Auto-generated method stub
		return colorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("color", id));
	}

}
