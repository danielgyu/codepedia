package com.hismayfly.orderexecution.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record RegisterShoeDTO(
        String brand,
        String koreanName,
        String englishName,
        String modelNumber,
        LocalDate releasedAt,
        List<RegisterShoeProductDTO> products
) {}
