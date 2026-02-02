package br.com.movieflix.movieflix.domain.dto.Auth;

import lombok.Builder;

@Builder
public record RegisterRequestDTO(String name, String email, String password) {
}
