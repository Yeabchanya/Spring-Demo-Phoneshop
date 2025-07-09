package com.sala.java.school.phoneshope.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "saleDetails")
public class SaleDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "saleDetailId")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "saleId")
	private Sale sale;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	@Column(name = "soldAmount")
	private BigDecimal amount;

	private Integer unit;
}