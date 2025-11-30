package br.com.movieflix.movieflix.entity.dto.category.reponse;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
