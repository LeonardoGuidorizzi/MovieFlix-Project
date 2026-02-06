package br.com.movieflix.movieflix.domain.dto.movie;

import br.com.movieflix.movieflix.domain.dto.category.CategoryResponseDTO;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
@Builder
public record MovieResponseDTO(
        Long id,
        String name,
        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @Schema(
                type = "string",
                example = "06/02/2026",
                description = "Release date in format dd/MM/yyyy"
        )
        LocalDate releaseDate,

        Double rating,
        List<CategoryResponseDTO> categories,
        List<StreamingResponseDTO> streamings
) {}
