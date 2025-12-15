package br.com.movieflix.movieflix.entity.dto.User;

import lombok.Builder;

@Builder
public record UserReponse(Long id, String name, String email) {
}
