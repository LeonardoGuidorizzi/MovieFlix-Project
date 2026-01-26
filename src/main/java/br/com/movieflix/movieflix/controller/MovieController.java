package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.domain.dto.movie.MovieRequest;
import br.com.movieflix.movieflix.domain.dto.movie.MovieResponse;
import br.com.movieflix.movieflix.domain.dto.movie.MovieUpdateRequest;
import br.com.movieflix.movieflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("movieflix/movie")
public class MovieController {
    @Autowired
    private MovieService service;
    @GetMapping()
    public ResponseEntity<List<MovieResponse>> getAllMovies(){
        return  ResponseEntity.ok(service.findAll().stream().toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieByid(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
                //requisição
                //achou?
                //resposta: ok
                //não achou?
                //resposta: not found
    }
    @PostMapping()
    public ResponseEntity<MovieResponse> createMovie(@RequestBody MovieRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse>updateMovie(@PathVariable Long id, @RequestBody MovieUpdateRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByMovieId(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/search/byCategory")
    public ResponseEntity<List<MovieResponse>>findMoviesByCategoryId(@RequestParam(name = "category") Long id){
        return ResponseEntity.ok(service.findMovieByCategoryId(id));
    }

    @GetMapping("/search/byStreaming")
    public ResponseEntity<List<MovieResponse>> findMoviesByStreamingId(@RequestParam(name = "streaming") Long id){
        return ResponseEntity.ok(service.findMovieByStreamingId(id));
    }

}
