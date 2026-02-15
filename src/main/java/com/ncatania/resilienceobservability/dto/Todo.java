package com.ncatania.resilienceobservability.dto;

public record Todo(
        Long id,
        Long userId,
        String title,
        Boolean completed
) {
}
