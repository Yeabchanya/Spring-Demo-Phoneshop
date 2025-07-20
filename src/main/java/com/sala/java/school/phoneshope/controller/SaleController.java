package com.sala.java.school.phoneshope.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sala.java.school.phoneshope.dto.SaleDTO;
import com.sala.java.school.phoneshope.service.SaleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sales")
public class SaleController {

	private final SaleService saleService;

	@PostMapping
	public ResponseEntity<?> Sale(@RequestBody SaleDTO saleDTO) { // @TODO
		saleService.sell(saleDTO);
		return ResponseEntity.ok().build();
	}

	@PutMapping("{saleId}/cancel")
	public ResponseEntity<?> cancelSale(@PathVariable Long saleId) {
		saleService.cancelSale(saleId);
		return ResponseEntity.ok().build();
	}
}
