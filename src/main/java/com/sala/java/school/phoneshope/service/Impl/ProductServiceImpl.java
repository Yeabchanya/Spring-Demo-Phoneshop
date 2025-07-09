package com.sala.java.school.phoneshope.service.Impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sala.java.school.phoneshope.Exception.ApiException;
import com.sala.java.school.phoneshope.Exception.ResourceNotFoundException;
import com.sala.java.school.phoneshope.dto.ProductImportDTO;
import com.sala.java.school.phoneshope.entity.Product;
import com.sala.java.school.phoneshope.entity.ProductImportHistory;
import com.sala.java.school.phoneshope.repository.ProductImportHistoryRepository;
import com.sala.java.school.phoneshope.repository.ProductRepository;
import com.sala.java.school.phoneshope.service.ProductService;
import com.sala.java.school.phoneshope.service.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository ImportHistoryRepository;
	private final ProductMapper productMapper;

	@Override
	public Product create(Product product) {
		String name = "%s %s".formatted(product.getModel().getName(), product.getColor().getName());
		product.setName(name);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", id));
	}

	@Override
	public void ImportProduct(ProductImportDTO importDTO) {
		if(importDTO.getImportUnit() == null) {
			throw new ApiException(HttpStatus.BAD_REQUEST, "Import unit Can`t be null");
		}
		
		// Update Available Product unit
		Product product = getById(importDTO.getProductId()); // get product
		Integer AvailableUnit = 0;
		if(product.getAvailableUnit() != null) {
			AvailableUnit = product.getAvailableUnit();
		}
		product.setAvailableUnit(AvailableUnit + importDTO.getImportUnit()); // set product
		productRepository.save(product);
		
		
		// save Product history
		ProductImportHistory importHistory = productMapper.toProductImportHistory(importDTO, product);
		ImportHistoryRepository.save(importHistory);

	}

	@Override
	public void setSalePrice(Long ProductId, BigDecimal price) {
		Product product = getById(ProductId);
		product.setSalePrice(price);
		productRepository.save(product);
	}

	@Override
	public void validateStock(Long proId, Integer Qty) {
		
	}

	@Override
	public void uploadProduct(MultipartFile file) {
		
		try {
			Workbook workbook = new XSSFWorkbook(file.getInputStream());
			Sheet sheet = workbook.getSheet("products");
			Iterator<Row> RowIterator = sheet.iterator();
			
			RowIterator.next(); // TODO
			
			while (RowIterator.hasNext()) {
				Row row = RowIterator.next();
				Cell cellModelId = row.getCell(0);
				Long ModelId = (long) cellModelId.getNumericCellValue();
				
				System.out.println(ModelId);
				
			}
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
