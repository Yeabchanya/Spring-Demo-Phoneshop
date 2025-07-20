package com.sala.java.school.phoneshope.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sala.java.school.phoneshope.Projection.ProductSold;
import com.sala.java.school.phoneshope.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
//	select p.id as productId, p.name productName, sum(sd.unit) unit, sum(sd.unit * sd.sold_amount) totalAmount
//	from sale_details sd
//	inner join sales s on sd.sale_id = s.sale_id
//	inner join product p on p.id = sd.product_id
//	where date(s.sold_date) >= '2025-02-10' and date(s.sold_date) <='2025-02-17'
//	group by p.id, p.name

	@Query(value = "select p.id as productId, p.name productName, sum(sd.unit) unit, sum(sd.unit * sd.sold_amount) totalAmount\r\n"
			+ "from sale_details sd\r\n"
			+ "inner join sales s on sd.sale_id = s.sale_id\r\n"
			+ "inner join product p on p.id = sd.product_id\r\n"
			+ "where date(s.sold_date) >= :startDate and date(s.sold_date) <= :endDate \r\n"
			+ "group by p.id, p.name" + "", nativeQuery = true)
	List<ProductSold> findProductSold(LocalDate startDate, LocalDate endDate);

}
