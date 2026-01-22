package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.entity.User;
import br.com.movieflix.movieflix.entity.dto.Auth.LoginRequest;
import br.com.movieflix.movieflix.entity.dto.Auth.LoginResponse;
import br.com.movieflix.movieflix.entity.dto.Auth.RegisterReponse;
import br.com.movieflix.movieflix.entity.dto.Auth.RegisterRequest;
import br.com.movieflix.movieflix.security.auth.AuthService;
import br.com.movieflix.movieflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movieflix/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterReponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }


}
