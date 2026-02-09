package br.com.movieflix.movieflix.dto.category;

import lombok.Builder;

@Builder
public record CategoryResponseDTO(Long id, String name) {


}
