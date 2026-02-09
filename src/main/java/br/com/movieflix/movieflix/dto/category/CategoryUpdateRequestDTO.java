package br.com.movieflix.movieflix.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryUpdateRequestDTO(
        @NotBlank(message = "Category name is required to update.")
        String name
) {
}
