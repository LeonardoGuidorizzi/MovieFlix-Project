package br.com.movieflix.movieflix.domain.dto.streaming;

import jakarta.validation.constraints.NotBlank;

public record StreamingCreateRequestDTO(
        @NotBlank(message = "Streaming name is required to create.")
        String name
) {
}
