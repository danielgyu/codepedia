package com.hismayfly.orderexecution.domain.dto;

public record RegisterShoeRespDTO(
        Boolean isSuccess,
        String failedReason,
        Long shoeId
) {
}
