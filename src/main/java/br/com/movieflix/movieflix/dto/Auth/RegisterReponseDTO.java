package br.com.movieflix.movieflix.dto.Auth;

import lombok.Builder;

@Builder
public record RegisterReponseDTO(Long id, String name, String email) {
}
