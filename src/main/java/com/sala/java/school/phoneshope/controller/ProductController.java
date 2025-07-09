package com.sala.java.school.phoneshope.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sala.java.school.phoneshope.dto.PriceDTO;
import com.sala.java.school.phoneshope.dto.ProductDTO;
import com.sala.java.school.phoneshope.dto.ProductImportDTO;
import com.sala.java.school.phoneshope.entity.Product;
import com.sala.java.school.phoneshope.service.ProductService;
import com.sala.java.school.phoneshope.service.mapper.ProductMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductMapper productMapper;
	private final ProductService productService;

	// @RequestMapping(method = RequestMethod.POST) // the same
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) { // @TODO
		Product product = productMapper.toProduct(productDTO);
		product = productService.create(product);
		return ResponseEntity.ok(product);
	}
	
	@PostMapping("importProduct")
	public ResponseEntity<?> importProduct(@RequestBody @Valid ProductImportDTO importDTO) {
		productService.ImportProduct(importDTO);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("{productId}/setSalePrice")
	public ResponseEntity<?> setSalePrice(@PathVariable Long productId, @RequestBody PriceDTO priceDTO){
		productService.setSalePrice(productId, priceDTO.getPrice());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("uploadProduct")
	public ResponseEntity<?> uploadProduct(@RequestParam("file") MultipartFile file){
		Map<Integer, String> Error = productService.uploadProduct(file);
		return ResponseEntity.ok(Error);
	}
}
