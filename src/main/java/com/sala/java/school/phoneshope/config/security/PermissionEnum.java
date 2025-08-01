package com.sala.java.school.phoneshope.config.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PermissionEnum {
	
	BRAND_WRITE("brand:write"),
	BRAND_READ("brand:read"),
	MODEL_WRITE("model:write"),
	MODEL_READ("model:read");
	
	private String description;
	
//	private PermissionEnum(String desc) {
//		this.description = desc;
//	}
	
}
