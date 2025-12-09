package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.entity.dto.User.UserReponse;
import br.com.movieflix.movieflix.entity.dto.User.UserRequest;
import br.com.movieflix.movieflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movieflix/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserReponse> createUser (@RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
    }


}
