package com.sala.java.school.phoneshope.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sala.java.school.phoneshope.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>, JpaSpecificationExecutor<Brand>{
	
	//JPA Query Methods
	List<Brand> findByNameIgnoreCase(String name); // filter search
}
