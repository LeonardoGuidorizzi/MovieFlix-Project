package br.com.movieflix.movieflix.domain.dto.movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.List;

public record MovieCreateRequestDTO(
        String name,
        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @Schema(
                type = "string",
                example = "06/02/2026",
                description = "Release date in format dd/MM/yyyy"
        )
        @PastOrPresent
        LocalDate releaseDate,
        @NotNull
        @NotBlank
        Double rating,
        @NotNull
        @NotEmpty
        List<Long> categories,
        @NotNull
        @NotEmpty
        List<Long> streamings
) {}
