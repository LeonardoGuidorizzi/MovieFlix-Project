package br.com.movieflix.movieflix.dto.streaming;

import lombok.Builder;

@Builder
public record StreamingResponseDTO(Long id, String name) {
}
