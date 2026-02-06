package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.domain.Category;
import br.com.movieflix.movieflix.domain.Movie;
import br.com.movieflix.movieflix.domain.Streaming;
import br.com.movieflix.movieflix.domain.dto.movie.MovieCreateRequestDTO;
import br.com.movieflix.movieflix.domain.dto.movie.MovieResponseDTO;
import br.com.movieflix.movieflix.domain.dto.movie.MovieUpdateRequestDTO;
import br.com.movieflix.movieflix.domain.mapper.MovieMapper;
import br.com.movieflix.movieflix.exception.business.BusinessException;
import br.com.movieflix.movieflix.exception.notFound.ResourceNotFoundException;
import br.com.movieflix.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;


    public MovieResponseDTO create(MovieCreateRequestDTO request){

        if (repository.existsByNameIgnoreCase(request.name())) {
            throw new BusinessException("Movie already exists");
        }

        List<Category> categories = categoryService.findAllById(request.categories());
        if (categories.size() != request.categories().size()){
            throw new BusinessException("Some category does not exist");
        }


        List<Streaming> streamings = streamingService.findAllById(request.streamings());
        if (streamings.size() != request.streamings().size()){
            throw new BusinessException("Some streaming does not exist");
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

    public List<MovieResponseDTO> findAll (){
        List<Movie> movies = repository.findAll();
        return movies.stream().map(MovieMapper::toDto).toList();
    }

    public MovieResponseDTO findById(Long id){
        return repository.findById(id).map(MovieMapper::toDto).orElseThrow(()-> new ResourceNotFoundException("Movie", id));
    }

    public MovieResponseDTO update(Long id, MovieUpdateRequestDTO request){
        Movie foundMovie = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie", id));

        List<Category> categories = request.categories() == null
                ? foundMovie.getCategories()
                : categoryService.findAllById(request.categories());

        List<Streaming> streamings = request.streamings() == null
                ? foundMovie.getStreamings()
                : streamingService.findAllById(request.streamings());


        MovieMapper.update(request, foundMovie, categories, streamings);

        return MovieMapper.toDto(repository.save(foundMovie));

    }

    public List<MovieResponseDTO> findMovieByCategoryId(Long categoryId){
        List<Movie> moviesByCategoryId = repository.findMovieByCategories_Id(categoryId);

        if (moviesByCategoryId.isEmpty()) {
            throw new ResourceNotFoundException("Category", categoryId);
        }

        return moviesByCategoryId.stream()
                .map(MovieMapper::toDto)
                .toList();
    }


    public List<MovieResponseDTO> findMovieByStreamingId(Long streamingId){
        List<Movie> moviesByStreamingId = repository.findMovieByStreamings_Id(streamingId);
        if(moviesByStreamingId.isEmpty()){
            throw new ResourceNotFoundException("Streaming", streamingId);
        }

        return moviesByStreamingId.stream().map(MovieMapper::toDto).toList();
    }

    public void deleteById(Long id){

        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Movie", id);
        }
        repository.deleteById(id);
    }
}
