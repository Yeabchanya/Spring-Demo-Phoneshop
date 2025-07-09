package com.sala.java.school.phoneshope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sala.java.school.phoneshope.entity.Sale;
import com.sala.java.school.phoneshope.entity.SaleDetail;

public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {

}
