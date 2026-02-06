package br.com.movieflix.movieflix.domain.dto.movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record MovieCreateRequestDTO(

        @NotBlank(message = "Movie name is required to create.")
        String name,

        @NotBlank(message = "Movie description is required to create.")
        String description,

        @NotNull(message = "Release date is required to create.")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @Schema(
                type = "string",
                example = "06/02/2026",
                description = "Release date in format dd/MM/yyyy"
        )
        @PastOrPresent(message = "Release date cannot be in the future to create.")
        LocalDate releaseDate,

        @NotNull(message = "Rating is required to create.")
        @Positive(message = "Rating must be greater than zero to create.")
        Double rating,

        @NotNull(message = "Categories are required to create.")
        @Size(min = 1, message = "At least one category is required to create.")
        List<Long> categories,

        @NotNull(message = "Streamings are required to create.")
        @NotEmpty(message = "At least one streaming is required to create.")
        List<Long> streamings
) {}

