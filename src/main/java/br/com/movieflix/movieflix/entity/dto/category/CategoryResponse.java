package br.com.movieflix.movieflix.entity.dto.category;

import lombok.Builder;

import java.util.List;

@Builder
public record CategoryResponse(Long id, String name) {


}
