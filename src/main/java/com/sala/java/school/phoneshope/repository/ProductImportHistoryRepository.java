package com.sala.java.school.phoneshope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sala.java.school.phoneshope.entity.ProductImportHistory;

@Repository
public interface ProductImportHistoryRepository extends JpaRepository<ProductImportHistory, Long>,JpaSpecificationExecutor<ProductImportHistory>{

}
