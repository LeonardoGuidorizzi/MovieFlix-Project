package br.com.movieflix.movieflix.entity.dto.movie;

import br.com.movieflix.movieflix.entity.dto.category.CategoryResponse;
import br.com.movieflix.movieflix.entity.dto.streaming.StreamingResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
@Builder
public record MovieResponse(
        Long id,
        String name,
        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate releaseDate,

        Double rating,
        List<CategoryResponse> categories,
        List<StreamingResponse> streamings
) {}
