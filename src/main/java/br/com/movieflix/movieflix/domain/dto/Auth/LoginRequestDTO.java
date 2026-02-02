package br.com.movieflix.movieflix.domain.dto.Auth;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank(message = "Your email address is required.")
        String email,
        @NotBlank(message = "Your password is required.")
        String password) {
}
