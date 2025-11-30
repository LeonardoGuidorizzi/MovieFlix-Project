package br.com.movieflix.movieflix.entity.dto.streaming.reponse;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id,String name) {
}
