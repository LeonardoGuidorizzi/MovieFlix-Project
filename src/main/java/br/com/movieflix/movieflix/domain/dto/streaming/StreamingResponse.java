package br.com.movieflix.movieflix.domain.dto.streaming;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id,String name) {
}
