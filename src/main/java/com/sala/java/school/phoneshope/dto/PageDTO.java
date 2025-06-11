package com.sala.java.school.phoneshope.dto;

import java.util.List;

import org.springframework.data.domain.Page;


/*
private int pageSize;
private int pageNumber;
private int totalPages;
private int totalElements;
private Long numberOfElements;

private boolean last;
private boolean first;
private boolean empty;
*/


import lombok.Data;
@Data
public class PageDTO {
	private List<?> list;
	private PaginationDTO pagination;

	public PageDTO(Page<?> page) {
		this.list = page.getContent();
		this.pagination = PaginationDTO.builder()
				.empty(page.isEmpty())
				.first(page.isFirst())
				.last(page.isLast())
				.pageSize(page.getPageable().getPageSize())
				.pageNumber(page.getPageable().getPageNumber() + 1)
				.totalPages(page.getTotalPages())
				.totalElements(page.getTotalElements())
				.numberOfElements(page.getNumberOfElements())
				.build();
	}
}
