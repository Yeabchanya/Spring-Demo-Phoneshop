package com.sala.java.school.phoneshope.Specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.sala.java.school.phoneshope.entity.Brand;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class BrandSpecification implements Specification<Brand>{
	
	private final BrandFilter brandFilter;
	
	List<Predicate> predicates = new ArrayList<>();

	@Override
	public Predicate toPredicate(Root<Brand> brand, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		if (brandFilter.getName() != null) {
			//Predicate name = brand.get("name").in(brandFilter.getName()); // filter name use in
			//Predicate name = criteriaBuilder.like(brand.get("name"), "%" + brandFilter.getName() +"%"); //filter use like
			Predicate name = criteriaBuilder.like(criteriaBuilder.upper(brand.get("name")), "%" + brandFilter.getName().toUpperCase() +"%");	// use toUpperCase A or a
			predicates.add(name);
		}
		
		if (brandFilter.getId() != null) {
			Predicate id = brand.get("id").in(brandFilter.getId()); // filter name
			predicates.add(id);
		}
		
		// convert list to array in java predicate
//		Predicate[] pp = predicates.toArray(new Predicate[0]);
//		return criteriaBuilder.and(pp);
		
		return criteriaBuilder.and(predicates.toArray(Predicate[]::new)); // style recommend in java 8 up
	}

}

