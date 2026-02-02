package br.com.movieflix.movieflix.domain.dto.movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record MovieRequestDTO(
        @NotBlank(message = "The movie's name is required.")
        String name,
        @NotBlank(message = "The description is required.")
        String description,
        @NotBlank(message = "The release date is required.")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate releaseDate,
        @NotBlank(message = "The rating is required.")
        Double rating,
        @NotBlank(message = "The Categories is required.")
        List<Long> categories,
        @NotBlank(message = "The streamings is required.")
        List<Long> streamings
) {}
