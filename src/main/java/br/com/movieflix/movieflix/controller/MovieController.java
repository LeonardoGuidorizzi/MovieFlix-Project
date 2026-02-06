package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.domain.dto.movie.MovieCreateRequestDTO;
import br.com.movieflix.movieflix.domain.dto.movie.MovieResponseDTO;
import br.com.movieflix.movieflix.domain.dto.movie.MovieUpdateRequestDTO;
import br.com.movieflix.movieflix.service.MovieService;
import br.com.movieflix.movieflix.swagger.Doc.MovieControllerDoc;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("movieflix/movie")
public class MovieController implements MovieControllerDoc {
    @Autowired
    private MovieService service;

    @PostMapping()
    public ResponseEntity<MovieResponseDTO> create(@Valid @RequestBody MovieCreateRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping()
    public ResponseEntity<List<MovieResponseDTO>> getAll(){
        return  ResponseEntity.ok(service.findAll().stream().toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/search/byCategory")
    public ResponseEntity<List<MovieResponseDTO>> getMoviesByCategoryId(@RequestParam(name = "category") Long id){
        return ResponseEntity.ok(service.findMovieByCategoryId(id));
    }

    @GetMapping("/search/byStreaming")
    public ResponseEntity<List<MovieResponseDTO>> getMoviesByStreamingId(@RequestParam(name = "streaming") Long id){
        return ResponseEntity.ok(service.findMovieByStreamingId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody MovieUpdateRequestDTO request) {

        return ResponseEntity.ok(service.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
