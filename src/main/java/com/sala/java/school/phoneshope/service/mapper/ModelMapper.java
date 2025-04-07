package com.sala.java.school.phoneshope.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sala.java.school.phoneshope.dto.ModelDTO;
import com.sala.java.school.phoneshope.entity.Brand;
import com.sala.java.school.phoneshope.entity.Model;

@Mapper
public interface ModelMapper {
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

	@Mapping(target = "brand", source = "brandId")
	Model toModel(ModelDTO dto);

	default Brand toBrand(Integer brandId) {
		Brand brand = new Brand();
		brand.setId(brandId);
		return brand;

	}

}
