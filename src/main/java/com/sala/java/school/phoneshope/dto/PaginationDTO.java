package com.sala.java.school.phoneshope.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationDTO {

	private int pageSize;
	private int pageNumber;
	private int totalPages;
	private Long totalElements;
	private int numberOfElements;

	private boolean last;
	private boolean first;
	private boolean empty;

	/*
	 * "pageable": { "pageNumber": 0, "pageSize": 10, "sort": { "empty": true,
	 * "sorted": false, "unsorted": true }, "offset": 0, "paged": true, "unpaged":
	 * false }, "last": false, "totalPages": 3, "totalElements": 26, "first": true,
	 * "size": 10, "number": 0, "sort": { "empty": true, "sorted": false,
	 * "unsorted": true }, "numberOfElements": 10, "empty": false
	 * 
	 */

}
