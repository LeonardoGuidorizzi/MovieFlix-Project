package br.com.movieflix.movieflix.entity.dto.category;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
