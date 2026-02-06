package br.com.movieflix.movieflix.domain.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateRequestDTO(
        @NotBlank(message = "Category name is required to create.")
        String name
) {
}
