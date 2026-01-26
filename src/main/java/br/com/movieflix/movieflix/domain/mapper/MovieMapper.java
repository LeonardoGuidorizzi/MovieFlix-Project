package br.com.movieflix.movieflix.domain.mapper;

import br.com.movieflix.movieflix.domain.Category;
import br.com.movieflix.movieflix.domain.Movie;
import br.com.movieflix.movieflix.domain.Streaming;
import br.com.movieflix.movieflix.domain.dto.category.CategoryResponse;
import br.com.movieflix.movieflix.domain.dto.movie.MovieResponse;
import br.com.movieflix.movieflix.domain.dto.movie.MovieRequest;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {
    public static Movie toEntity(MovieRequest request){
        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map( streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Movie.builder()
                .name(request.name())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toDto(Movie entity){
        List<CategoryResponse> categories = entity.getCategories().stream()
                .map(category -> CategoryMapper.toDto(category))
                .toList();

        List<StreamingResponse> streamings = entity.getStreamings().stream()
                .map(streaming -> StreamingMapper.toDto(streaming))
                .toList();

        return MovieResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .releaseDate(entity.getReleaseDate())
                .rating(entity.getRating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }


}
