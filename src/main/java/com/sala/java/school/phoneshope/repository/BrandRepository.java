package com.sala.java.school.phoneshope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sala.java.school.phoneshope.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
