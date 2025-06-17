package com.sala.java.school.phoneshope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sala.java.school.phoneshope.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long>{

}
