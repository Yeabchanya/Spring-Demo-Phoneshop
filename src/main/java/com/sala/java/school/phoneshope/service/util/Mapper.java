package com.sala.java.school.phoneshope.service.util;

import com.sala.java.school.phoneshope.dto.BrandDTO;
import com.sala.java.school.phoneshope.entity.Brand;

public class Mapper {
	
	public static Brand toBrand(BrandDTO brandDTO) {
		Brand brand = new Brand();
		//brand.setId(brandDTO.getId());
		brand.setName(brandDTO.getName());
		return brand;
	}
	
	public static BrandDTO toBrandDTO(Brand brand) {
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setName(brand.getName());
		return brandDTO;
	}
}
