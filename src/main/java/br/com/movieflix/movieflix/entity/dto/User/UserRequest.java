package br.com.movieflix.movieflix.entity.dto.User;

import lombok.Builder;

@Builder
public record UserRequest(String name, String email, String password) {
}
