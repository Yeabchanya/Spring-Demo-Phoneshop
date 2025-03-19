package com.sala.java.school.phoneshope.service;

import com.sala.java.school.phoneshope.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand brandUpdate);

}
