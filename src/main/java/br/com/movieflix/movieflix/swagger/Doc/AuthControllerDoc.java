package br.com.movieflix.movieflix.swagger.Doc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import br.com.movieflix.movieflix.dto.Auth.LoginRequestDTO;
import br.com.movieflix.movieflix.dto.Auth.LoginResponseDTO;
import br.com.movieflix.movieflix.dto.Auth.RegisterReponseDTO;
import br.com.movieflix.movieflix.dto.Auth.RegisterRequestDTO;

@Tag(name = "Authentication", description = "Authentication and user registration endpoints")
public interface AuthControllerDoc {

    @Operation(summary = "Register a new user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User registered successfully"),
            @ApiResponse(responseCode = "400", description = "User already exists or invalid data")
    })
    ResponseEntity<RegisterReponseDTO> register(
            @RequestBody(description = "User registration data", required = true)
            RegisterRequestDTO request
    );

    @Operation(summary = "Authenticate user and generate JWT token")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User authenticated successfully"),
            @ApiResponse(responseCode = "401", description = "Invalid credentials")
    })
    ResponseEntity<LoginResponseDTO> login(
            @RequestBody(description = "User login credentials", required = true)
            LoginRequestDTO request
    );
}
