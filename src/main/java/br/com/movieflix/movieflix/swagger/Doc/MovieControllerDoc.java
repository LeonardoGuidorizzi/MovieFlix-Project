package br.com.movieflix.movieflix.swagger.Doc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.movieflix.movieflix.domain.dto.movie.MovieRequest;
import br.com.movieflix.movieflix.domain.dto.movie.MovieResponse;
import br.com.movieflix.movieflix.domain.dto.movie.MovieUpdateRequest;

import java.util.List;

@Tag(name = "Movie", description = "Movie management endpoints")
public interface MovieControllerDoc {
    @Operation(summary = "Create a new movie")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Movie created successfully"),
            @ApiResponse(responseCode = "400", description = "Movie already exists or invalid category/streaming")
    })
    ResponseEntity<MovieResponse> create(
            @RequestBody(description = "Movie data to be created", required = true)
            MovieRequest request
    );

    @Operation(summary = "Get all movies")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of movies returned successfully")
    })
    ResponseEntity<List<MovieResponse>> getAll();

    @Operation(summary = "Get movie by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movie found"),
            @ApiResponse(responseCode = "404", description = "Movie not found")
    })
    ResponseEntity<MovieResponse> getById(
            @Parameter(description = "Movie ID", example = "1")
            @PathVariable Long id
    );

    @Operation(summary = "Get movies by category ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movies returned successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    ResponseEntity<List<MovieResponse>> getMoviesByCategoryId(
            @Parameter(description = "Category ID", example = "2")
            @RequestParam(name = "category") Long id
    );

    @Operation(summary = "Get movies by streaming ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movies returned successfully"),
            @ApiResponse(responseCode = "404", description = "Streaming not found")
    })
    ResponseEntity<List<MovieResponse>> getMoviesByStreamingId(
            @Parameter(description = "Streaming ID", example = "3")
            @RequestParam(name = "streaming") Long id
    );

    @Operation(summary = "Update a movie")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movie updated successfully"),
            @ApiResponse(responseCode = "404", description = "Movie not found")
    })
    ResponseEntity<MovieResponse> update(
            @Parameter(description = "Movie ID", example = "1")
            @PathVariable Long id,
            @RequestBody(description = "Movie data to update", required = true)
            MovieUpdateRequest request
    );

    @Operation(summary = "Delete movie by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Movie deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Movie not found")
    })
    ResponseEntity<Void> deleteById(
            @Parameter(description = "Movie ID", example = "1")
            @PathVariable Long id
    );
}
