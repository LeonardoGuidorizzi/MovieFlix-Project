package br.com.movieflix.movieflix.domain.dto.movie;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record MovieUpdateRequestDTO(

        @NotBlank(message = "Movie name must not be blank to update.")
        String name,

        @NotBlank(message = "Movie description must not be blank to update.")
        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @Schema(
                type = "string",
                example = "06/02/2026",
                description = "Release date in format dd/MM/yyyy"
        )
        @PastOrPresent(message = "Release date cannot be in the future to update.")
        LocalDate releaseDate,

        @Positive(message = "Rating must be greater than zero to update.")
        Double rating,

        @NotEmpty(message = "At least one category is required to update.")
        List<Long> categories,

        @NotEmpty(message = "At least one streaming is required to update.")
        List<Long> streamings
) {}

