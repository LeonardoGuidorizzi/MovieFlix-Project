package br.com.movieflix.movieflix.domain.dto.category;

import lombok.Builder;

@Builder
public record CategoryResponseDTO(Long id, String name) {


}
