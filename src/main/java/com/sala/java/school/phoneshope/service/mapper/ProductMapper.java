package com.sala.java.school.phoneshope.service.mapper;


import com.sala.java.school.phoneshope.dto.ProductImportDTO;
import com.sala.java.school.phoneshope.entity.ProductImportHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sala.java.school.phoneshope.dto.ProductDTO;
import com.sala.java.school.phoneshope.entity.Product;
import com.sala.java.school.phoneshope.service.ColorService;
import com.sala.java.school.phoneshope.service.ModelService;

@Mapper(componentModel = "spring", uses = { ModelService.class, ColorService.class })
public interface ProductMapper {

	@Mapping(target = "model", source = "modelId")
	@Mapping(target = "color", source = "colorId")
	Product toProduct(ProductDTO productDTO);
	
	@Mapping(target = "product", source = "product")
	@Mapping(target = "id", ignore = true) // not map product id
	ProductImportHistory toProductImportHistory(ProductImportDTO importDTO, Product product);

}
