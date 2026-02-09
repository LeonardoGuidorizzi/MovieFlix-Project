package br.com.movieflix.movieflix.mapper;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.entity.Movie;
import br.com.movieflix.movieflix.entity.Streaming;
import br.com.movieflix.movieflix.dto.category.CategoryResponseDTO;
import br.com.movieflix.movieflix.dto.movie.MovieResponseDTO;
import br.com.movieflix.movieflix.dto.movie.MovieCreateRequestDTO;
import br.com.movieflix.movieflix.dto.movie.MovieUpdateRequestDTO;
import br.com.movieflix.movieflix.dto.streaming.StreamingResponseDTO;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;

@UtilityClass
public class MovieMapper {
    public static Movie toEntity(MovieCreateRequestDTO request){
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

    public static MovieResponseDTO toDto(Movie entity){
        List<CategoryResponseDTO> categories = entity.getCategories().stream()
                .map(category -> CategoryMapper.toDto(category))
                .toList();

        List<StreamingResponseDTO> streamings = entity.getStreamings().stream()
                .map(streaming -> StreamingMapper.toDto(streaming))
                .toList();

        return MovieResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .releaseDate(entity.getReleaseDate())
                .rating(entity.getRating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public void update (
            MovieUpdateRequestDTO request,
            Movie entity,
            List<Category> categories,
            List<Streaming> streamings
    ){
        if(request.name() != null )entity.setName(request.name());

        if(request.description() != null )entity.setDescription(request.description());

        if(request.releaseDate() != null )entity.setReleaseDate(request.releaseDate());

        if(request.rating() != null )entity.setRating(request.rating());

        entity.setCategories(categories);
        entity.setStreamings(streamings);

        entity.setUpdatedAt(LocalDateTime.now());
    }


}
