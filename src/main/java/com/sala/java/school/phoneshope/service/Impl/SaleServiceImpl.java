package com.sala.java.school.phoneshope.service.Impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sala.java.school.phoneshope.Exception.ApiException;
import com.sala.java.school.phoneshope.Exception.ResourceNotFoundException;
import com.sala.java.school.phoneshope.dto.ProductSoldDTO;
import com.sala.java.school.phoneshope.dto.SaleDTO;
import com.sala.java.school.phoneshope.entity.Product;
import com.sala.java.school.phoneshope.entity.Sale;
import com.sala.java.school.phoneshope.entity.SaleDetail;
import com.sala.java.school.phoneshope.repository.ProductRepository;
import com.sala.java.school.phoneshope.repository.SaleDetailRepository;
import com.sala.java.school.phoneshope.repository.SaleRepository;
import com.sala.java.school.phoneshope.service.ProductService;
import com.sala.java.school.phoneshope.service.SaleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

	private final ProductService productService;
	private final ProductRepository productRepository;
	private final SaleRepository saleRepository;
	private final SaleDetailRepository saleDetailRepository;

	@Override
	public void sell(SaleDTO saleDTO) {
		List<Long> productIds = saleDTO.getProducts().stream().map(ProductSoldDTO::getProductId).toList();
		// validate product
		productIds.forEach(productService::getById);

		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
				.collect(Collectors.toMap(Product::getId, Function.identity()));

		// validate stock
		saleDTO.getProducts().forEach(ps -> {
			Product product = productMap.get(ps.getProductId());
			if (product.getAvailableUnit() < ps.getNumberOfUnit()) {
				throw new ApiException(HttpStatus.BAD_REQUEST,
						"Product [%s] is not enough in stock".formatted(product.getName()));
			}
		});

		// Sale
		Sale sale = new Sale();
		sale.setSoldDate(saleDTO.getSaleDate());
		saleRepository.save(sale);

		// Sale Detail
		saleDTO.getProducts().forEach(ps -> {
			Product product = productMap.get(ps.getProductId());
			SaleDetail saleDetail = new SaleDetail();
			saleDetail.setAmount(product.getSalePrice());
			saleDetail.setProduct(product);
			saleDetail.setSale(sale);
			saleDetail.setUnit(ps.getNumberOfUnit());
			saleDetailRepository.save(saleDetail);

			// cut stock
			Integer availableUnit = product.getAvailableUnit() - ps.getNumberOfUnit();
			product.setAvailableUnit(availableUnit);
			productRepository.save(product);
		});
	}

	private void saveSale(SaleDTO saleDTO) {
		saleDTO.getSaleDate();
		Sale sale = new Sale();
		sale.setSoldDate(saleDTO.getSaleDate());
		saleRepository.save(sale);

		// save Detail
		saleDTO.getProducts().forEach(ps -> {
			SaleDetail saleDetail = new SaleDetail();
			saleDetail.setAmount(null);
		});
	}

	private void validate(SaleDTO saleDTO) {

		List<Long> proId = saleDTO.getProducts().stream().map(ProductSoldDTO::getProductId).toList();

		// validateProduct
		proId.forEach(productService::getById);

		List<Product> products = productRepository.findAllById(proId);
		Map<Long, Product> ProductMap = products.stream()
				.collect(Collectors.toMap(Product::getId, Function.identity()));

		// validate stock
		saleDTO.getProducts().forEach(ps -> {
			Product product = ProductMap.get(ps.getProductId());
			if (product.getAvailableUnit() < ps.getNumberOfUnit()) {
				throw new ApiException(HttpStatus.BAD_REQUEST,
						"Product [%s] is not enough in stock".formatted(product.getName()));
			}
		});

	}

	@Override
	public Sale getById(Long saleId) {
		return saleRepository.findById(saleId).orElseThrow(() -> new ResourceNotFoundException("Sale", saleId));
	}

	@Override
	public void cancelSale(Long saleId) {
		// update sale status
		Sale sale = getById(saleId);
		sale.setActive(false);
		saleRepository.save(sale);

		// update stock
		List<SaleDetail> saleDetails = saleDetailRepository.findBySaleId(saleId);

		List<Long> productIds = saleDetails.stream().map(sd -> sd.getProduct().getId()).toList();

		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
				.collect(Collectors.toMap(Product::getId, Function.identity()));

		saleDetails.forEach(sd -> {
			Product product = productMap.get(sd.getProduct().getId());
			product.setAvailableUnit(product.getAvailableUnit() + sd.getUnit());
			productRepository.save(product);
		});

	}

}
