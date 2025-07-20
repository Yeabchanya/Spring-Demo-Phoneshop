package com.sala.java.school.phoneshope.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;

import com.sala.java.school.phoneshope.entity.ProductImportHistory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductImportHistorySpec implements Specification<ProductImportHistory> {

	private ProductImportHistoryFilter importFilter;

	@Override
	public Predicate toPredicate(Root<ProductImportHistory> importHistory, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<>();
		if (Objects.nonNull(importFilter.getStartDate())) {
			Predicate startDate = cb.greaterThanOrEqualTo(importHistory.get("dateImport"), importFilter.getStartDate());
			predicates.add(startDate);
		}
		if (Objects.nonNull(importFilter.getEndDate())) {
			Predicate endDate = cb.lessThanOrEqualTo(importHistory.get("dateImport"), importFilter.getEndDate());
			predicates.add(endDate);
		}
		Predicate predicate = cb.and(predicates.toArray(Predicate[]::new));
		return predicate;
	}

}