package br.com.movieflix.movieflix.domain.dto.streaming;

import lombok.Builder;

@Builder
public record StreamingResponseDTO(Long id, String name) {
}
