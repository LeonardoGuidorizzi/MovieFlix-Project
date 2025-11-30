package br.com.movieflix.movieflix.entity.dto.streaming;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id,String name) {
}
