package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.entity.Movie;
import br.com.movieflix.movieflix.entity.Streaming;
import br.com.movieflix.movieflix.entity.dto.movie.MovieRequest;
import br.com.movieflix.movieflix.entity.dto.movie.MovieResponse;
import br.com.movieflix.movieflix.entity.dto.movie.MovieUpdateRequest;
import br.com.movieflix.movieflix.entity.mapper.MovieMapper;
import br.com.movieflix.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public List<MovieResponse> findAll (){
        List<Movie> movies = repository.findAll();
        return movies.stream().map(MovieMapper::toDto).toList();
    }

    public Optional<MovieResponse> findByid(Long id){
        return repository.findById(id).map(MovieMapper::toDto);
    }

    public MovieResponse create(MovieRequest request){

        List<Category> categories = categoryService.findAllById(request.categories());
        if (categories.size() != request.categories().size()){
            throw new RuntimeException("Some category does not exist");
        }


        List<Streaming> streamings = streamingService.findAllById(request.streamings());
        if (streamings.size() != request.streamings().size()){
            throw new RuntimeException("Some category does not exist");
        }
         Movie movie = Movie.builder()
                .name(request.name())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();

       return MovieMapper.toDto(repository.save(movie));
    }

    public MovieResponse update(Long id, MovieUpdateRequest request){
        Movie foundMovie = repository.findById(id).orElseThrow(()->new RuntimeException("Movie not found"));
        if(request.name() != null )foundMovie.setName(request.name());
        if(request.description() != null )foundMovie.setName(request.name());
        if(request.releaseDate() != null )foundMovie.setName(request.name());
        if(request.rating() != null )foundMovie.setName(request.name());

        if(request.categories() != null){
            List<Category> categories = categoryService.findAllById(request.categories());
            foundMovie.setCategories(categories);
        }


        if(request.streamings() != null){
            List<Streaming> streamings = streamingService.findAllById(request.streamings());
            foundMovie.setStreamings(streamings);
        }

        foundMovie.setUpdatedAt(LocalDateTime.now());

        return MovieMapper.toDto(repository.save(foundMovie));


    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<MovieResponse> findMovieByCategoryId(Long categoryId){
        List<Movie> moviesByCategoryIds = repository.findMovieByCategories_Id(categoryId);
        return moviesByCategoryIds.stream().map(MovieMapper::toDto).toList();
    }

    public List<MovieResponse> findMovieByStreamingId(Long streamingId){
        List<Movie> moviesByStreamingId = repository.findMovieByStreamings_Id(streamingId);
        return moviesByStreamingId.stream().map(MovieMapper::toDto).toList();
    }
}
