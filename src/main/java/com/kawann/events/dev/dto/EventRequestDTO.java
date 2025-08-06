package com.kawann.events.dev.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record EventRequestDTO(
        Long id,

        @NotBlank(message = "The name cannot be blank.")
        @Size(max = 100, message = "The name can have a maximum of 100 characters.")
        String name,
        @NotBlank(message = "The description cannot be left blank.")
        String description,
        @NotNull(message = "The date cannot be left blank.")
        LocalDate date,
        @NotBlank(message = "The location cannot be left blank.")
        String Local
) {}
