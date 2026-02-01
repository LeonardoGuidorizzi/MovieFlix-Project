package br.com.movieflix.movieflix.domain.dto.movie;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record MovieRequestDTO(
        String name,
        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate releaseDate,

        Double rating,
        List<Long> categories,
        List<Long> streamings
) {}
