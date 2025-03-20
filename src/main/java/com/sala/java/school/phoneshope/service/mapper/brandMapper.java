package com.sala.java.school.phoneshope.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sala.java.school.phoneshope.dto.BrandDTO;
import com.sala.java.school.phoneshope.entity.Brand;

@Mapper
public interface brandMapper {
	brandMapper INSTANCE = Mappers.getMapper(brandMapper.class);
	Brand toBrand(BrandDTO brandDTO);
	BrandDTO toBrandDTO (Brand entity);
}
