package br.com.movieflix.movieflix.domain.dto.streaming;

import jakarta.validation.constraints.NotBlank;

public record StreamingUpdateRequestDTO(
        @NotBlank(message = "The streaming's name is required to update.")
        String name) {
}
