package com.choistory.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class PageResponseDto<T> {
    private final Object contents;
    private final PaginationDto paginationDto;

    public PageResponseDto(Page<T> page) {
        this.contents = page.getContent();

        this.paginationDto = PaginationDto.of(page.getPageable().getPageSize(),
            page.getPageable().getPageNumber() + 1, page.getTotalPages(), page.getTotalElements());
    }
    @JsonProperty("data")
    public Object getContents() {
        return contents;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("pagination")
    public PaginationDto getPaginationDto() {
        return paginationDto;
    }

    public static <T> PageResponseDto<T> of(Page<T> page) {

        return new PageResponseDto<>(page);
    }
}
