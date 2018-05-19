package com.training.playgendary.reservation.entity.dto.request;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class PageableAssembler {
    private static final String DEFAULT_SORT_DIRECTION = "ASC";

    public Pageable createRequest(PageableDTO pageableDTO, Class<?> entityClass) {
        int pageNumber = pageableDTO.getPageNumber();
        int pageSize = pageableDTO.getPageSize();
        String sortedField = pageableDTO.getSortedField();
        String sortDirection = pageableDTO.getSortDirection();

        Sort sort = Sort.unsorted();

        if (sortedField != null && !sortedField.isEmpty() && isValidFieldName(entityClass, sortedField) && sortDirection != null) {
            Sort.Direction direction = DEFAULT_SORT_DIRECTION.equalsIgnoreCase(sortDirection) ? Sort.Direction.ASC : Sort.Direction.DESC;
            sort = new Sort(direction, sortedField);
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return pageable;
    }

    private boolean isValidFieldName(Class<?> entityClass, String sortedField) {
        for (Field field : entityClass.getDeclaredFields()) {
            String fieldName = field.getName();
            if (fieldName.equalsIgnoreCase(sortedField)) {
                return true;
            }
        }

        return false;
    }
}
