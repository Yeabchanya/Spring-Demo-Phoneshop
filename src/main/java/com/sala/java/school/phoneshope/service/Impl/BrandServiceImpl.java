package com.sala.java.school.phoneshope.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sala.java.school.phoneshope.Exception.ResourceNotFoundException;
import com.sala.java.school.phoneshope.Specification.BrandFilter;
import com.sala.java.school.phoneshope.Specification.BrandSpecification;
import com.sala.java.school.phoneshope.entity.Brand;
import com.sala.java.school.phoneshope.repository.BrandRepository;
import com.sala.java.school.phoneshope.service.BrandService;
import com.sala.java.school.phoneshope.service.Util.PageUtil;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Long id) {

//		Optional<Brand> brandOptional = brandRepository.findById(id);
//		if(brandOptional.isPresent()) {
//			return brandOptional.get();
//		}
//		//throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id =" + id + "not found");
//		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Brand with id = %d not found", id));

		return brandRepository.findById(id)
				// .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
				// String.format("Brand with id = %d not found", id)));
				.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Long id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName()); // @TODO improve update
		return brandRepository.save(brand);
	}

// 	@Override
//	public List<Brand> getBrands() {
//		return brandRepository.findAll();
//	}

	@Override // Method overload
	public List<Brand> getBrands(String name) {
		return brandRepository.findByNameIgnoreCase(name);
	}

	@Override
	public Page<Brand> getBrands(Map<String, String> params) {

		BrandFilter brandFilter = new BrandFilter();

		if (params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}

		if (params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id)); // @TODO convert
		}
		
		//@TODO add to function for pageAble
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMET;
		if (params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}

		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if (params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}

		BrandSpecification brandSpecification = new BrandSpecification(brandFilter);

		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);

		Page<Brand> page = brandRepository.findAll(brandSpecification, pageable);
		return page;

	}

}
