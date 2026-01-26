package br.com.movieflix.movieflix.domain.dto.Auth;

import lombok.Builder;

@Builder
public record RegisterRequest(String name, String email, String password) {
}
