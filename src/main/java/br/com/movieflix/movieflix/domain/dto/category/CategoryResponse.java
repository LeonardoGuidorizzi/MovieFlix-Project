package br.com.movieflix.movieflix.domain.dto.category;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {


}
