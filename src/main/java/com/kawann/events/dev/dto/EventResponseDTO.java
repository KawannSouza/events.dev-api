package com.kawann.events.dev.dto;

import java.time.LocalDate;

public record EventResponseDTO(
        Long id,
        String name,
        String description,
        LocalDate date,
        String local
) {}