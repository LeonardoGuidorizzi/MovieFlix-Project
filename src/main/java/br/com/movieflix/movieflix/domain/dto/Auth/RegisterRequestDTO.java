package br.com.movieflix.movieflix.domain.dto.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record RegisterRequestDTO(
        @NotBlank(message = "Your name is required.")
        String name,
        @NotBlank(message = "Your email address is required.")
        String email,
        @NotBlank(message = "Your password is required.")
        String password) {
}
