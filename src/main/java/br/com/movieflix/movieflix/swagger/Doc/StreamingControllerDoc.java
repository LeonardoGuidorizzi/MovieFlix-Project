package br.com.movieflix.movieflix.swagger.Doc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingRequestDTO;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingResponseDTO;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingUpdateRequestDTO;


import java.util.List;

@Tag(name = "Streaming", description = "Streaming platform management endpoints")
public interface StreamingControllerDoc {

    @Operation(summary = "Create a new streaming platform")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Streaming created successfully"),
            @ApiResponse(responseCode = "400", description = "Streaming already exists")
    })
    ResponseEntity<StreamingResponseDTO> create(
            @RequestBody(description = "Streaming data to be created", required = true)
            StreamingRequestDTO request
    );

    @Operation(summary = "Get all streaming platforms")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of streamings returned successfully")
    })
    ResponseEntity<List<StreamingResponseDTO>> getAll();

    @Operation(summary = "Get streaming platform by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Streaming found"),
            @ApiResponse(responseCode = "404", description = "Streaming not found")
    })
    ResponseEntity<StreamingResponseDTO> getById(
            @Parameter(description = "Streaming ID", example = "1")
            @PathVariable Long id
    );

    @Operation(summary = "Update a streaming platform")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Streaming updated successfully"),
            @ApiResponse(responseCode = "404", description = "Streaming not found")
    })
    ResponseEntity<StreamingResponseDTO> update(
            @Parameter(description = "Streaming ID", example = "1")
            @PathVariable Long id,
            @RequestBody(description = "Streaming data to update", required = true)
            StreamingUpdateRequestDTO request
    );

    @Operation(summary = "Delete streaming platform by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Streaming deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Streaming not found")
    })
    ResponseEntity<Void> deleteById(
            @Parameter(description = "Streaming ID", example = "1")
            @PathVariable Long id
    );
}
