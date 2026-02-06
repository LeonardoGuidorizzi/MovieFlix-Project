package br.com.movieflix.movieflix.domain.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryUpdateRequestDTO(
        @NotBlank(message = "The category's name is required to update.")
        String name
) {
}
