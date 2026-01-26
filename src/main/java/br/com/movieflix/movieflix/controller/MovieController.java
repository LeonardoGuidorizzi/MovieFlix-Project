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

    @PostMapping()
    public ResponseEntity<MovieResponse> create(@RequestBody MovieRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping()
    public ResponseEntity<List<MovieResponse>> getAll(){
        return  ResponseEntity.ok(service.findAll().stream().toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/search/byCategory")
    public ResponseEntity<List<MovieResponse>> getMoviesByCategoryId(@RequestParam(name = "category") Long id){
        return ResponseEntity.ok(service.findMovieByCategoryId(id));
    }

    @GetMapping("/search/byStreaming")
    public ResponseEntity<List<MovieResponse>> getMoviesByStreamingId(@RequestParam(name = "streaming") Long id){
        return ResponseEntity.ok(service.findMovieByStreamingId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(
            @PathVariable Long id,
            @RequestBody MovieUpdateRequest request) {

        return ResponseEntity.ok(service.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
