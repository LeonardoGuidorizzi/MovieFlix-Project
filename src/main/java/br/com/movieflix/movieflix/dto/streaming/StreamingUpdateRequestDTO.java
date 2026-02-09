package br.com.movieflix.movieflix.dto.streaming;

import jakarta.validation.constraints.NotBlank;

public record StreamingUpdateRequestDTO(
        @NotBlank(message = "Streaming name is required to update.")
        String name) {
}
