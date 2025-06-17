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
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

@Data
@Entity
@Table(name = "product",
uniqueConstraints = {@UniqueConstraint(columnNames = {"model_id", "color_id"})})
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "available_unit")
	private Integer availableUnit;
	
	

	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
	
	@DecimalMin(value = "0.000001", message = "Price must be greater than 0")
	@Column(name = "sale_price") 
	private BigDecimal salePrice;

}
