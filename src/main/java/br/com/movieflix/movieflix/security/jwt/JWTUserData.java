package br.com.movieflix.movieflix.entity.dto.Auth;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String name, String email, String password, String role ) {
}
