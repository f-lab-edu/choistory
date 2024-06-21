package com.choistory.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDto {
    private int perPage;
    private int currentPage;
    private int totalPages;
    private long totalElements;

    public static PaginationDto of(int perPage, int currentPage, int totalPages, long totalElements) {
        return new PaginationDto(perPage, currentPage, totalPages, totalElements);
    }
}
