package br.com.movieflix.movieflix.domain.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateRequestDTO(
        @NotBlank(message = "The category's name is required.")
        String name
) {
}
