package com.estate.repository.paging;

public interface Pageable {
    Integer getOffset();
    Integer getPageSize();
    Integer getPageNumber();
}
