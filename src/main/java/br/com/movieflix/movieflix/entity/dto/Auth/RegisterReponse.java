package br.com.movieflix.movieflix.entity.dto.Auth;

import lombok.Builder;

@Builder
public record RegisterReponse(Long id, String name, String email) {
}
