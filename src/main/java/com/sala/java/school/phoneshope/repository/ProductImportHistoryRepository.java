package com.sala.java.school.phoneshope.repository;

import com.sala.java.school.phoneshope.entity.ProductImportHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImportHistoryRepository extends JpaRepository<ProductImportHistory, Long>{

}
