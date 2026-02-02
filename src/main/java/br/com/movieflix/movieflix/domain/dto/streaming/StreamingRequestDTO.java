package br.com.movieflix.movieflix.domain.dto.streaming;

import jakarta.validation.constraints.NotBlank;

public record StreamingRequestDTO(
        @NotBlank(message = "The streaming's name is required.")
        String name
) {
}
