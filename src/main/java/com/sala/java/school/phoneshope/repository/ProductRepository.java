package com.sala.java.school.phoneshope.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sala.java.school.phoneshope.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByModelIdAndColorId(Long modelId, long colorId);
}
