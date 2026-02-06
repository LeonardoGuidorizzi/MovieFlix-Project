package br.com.movieflix.movieflix.domain.dto.streaming;

import jakarta.validation.constraints.NotBlank;

public record StreamingCreateRequestDTO(
        @NotBlank(message = "The streaming's name is required create.")
        String name
) {
}
