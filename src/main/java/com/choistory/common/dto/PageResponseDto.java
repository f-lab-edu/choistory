package com.choistory.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder
public class PageResponseDto<T> {
    private final List<T> contents;
    private final PaginationDto paginationDto;

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
        return PageResponseDto.<T>builder()
                .contents(page.getContent())
                .paginationDto(
                        PaginationDto.of(
                                page.getPageable().getPageSize(),
                                page.getPageable().getPageNumber()+1,
                                page.getTotalPages(),
                                page.getTotalElements()
                        )
                ).build();
    }

    public static <T> PageResponseDto<T> of(List<T> list) {
        return PageResponseDto.<T>builder()
            .contents(list)
            .build();
    }
}
