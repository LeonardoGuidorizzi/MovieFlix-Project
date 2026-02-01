package br.com.movieflix.movieflix.swagger.Doc;

import br.com.movieflix.movieflix.domain.dto.category.CategoryRequestDTO;
import br.com.movieflix.movieflix.domain.dto.category.CategoryResponseDTO;
import br.com.movieflix.movieflix.domain.dto.category.CategoryUpdateRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import io.swagger.v3.oas.annotations.parameters.RequestBody;



import java.util.List;

@Tag(name = "Category", description = "Category management endpoints")
public interface CategoryControllerDoc {

    @Operation(summary = "Create a new category")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Category created successfully"),
            @ApiResponse(responseCode = "400", description = "Category already exists")
    })
    ResponseEntity<CategoryResponseDTO> createCategory(
            @RequestBody(description = "Category data to be created", required = true)
            CategoryRequestDTO request
    );

    @Operation(summary = "Get all categories")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of categories returned successfully")
    })
    ResponseEntity<List<CategoryResponseDTO>> getAll();

    @Operation(summary = "Get category by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Category found"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    ResponseEntity<CategoryResponseDTO> getById(
            @Parameter(description = "Category ID", example = "1")
            @PathVariable Long id
    );

    @Operation(summary = "Update a category")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Category updated successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    ResponseEntity<CategoryResponseDTO> update(
            @Parameter(description = "Category ID", example = "1")
            @PathVariable Long id,
            @RequestBody(description = "Category data to update", required = true)
            CategoryUpdateRequestDTO request
    );

    @Operation(summary = "Delete category by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Category deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    ResponseEntity<Void> deleteById(
            @Parameter(description = "Category ID", example = "1")
            @PathVariable Long id
    );
}