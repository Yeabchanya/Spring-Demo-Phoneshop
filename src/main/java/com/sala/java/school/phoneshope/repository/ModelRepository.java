package com.sala.java.school.phoneshope.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sala.java.school.phoneshope.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long>{
	List<Model> findByBrandId(Integer brandId);
}
