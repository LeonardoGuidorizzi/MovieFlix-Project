package br.com.movieflix.movieflix.domain.dto.movie;

import java.time.LocalDate;
import java.util.List;

public record MovieUpdateRequestDTO(
        String name,
        String description,
        LocalDate releaseDate,
        Double rating,   // Agora é Double, aceita nulo
        List<Long> categories,
        List<Long> streamings
) {}
