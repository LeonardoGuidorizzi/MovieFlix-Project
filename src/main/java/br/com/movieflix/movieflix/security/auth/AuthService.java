package br.com.movieflix.movieflix.security.auth;

import br.com.movieflix.movieflix.entity.User;
import br.com.movieflix.movieflix.entity.dto.Auth.LoginRequest;
import br.com.movieflix.movieflix.entity.dto.Auth.LoginResponse;
import br.com.movieflix.movieflix.security.jwt.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService{
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public LoginResponse login (LoginRequest request){
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                );

        Authentication authentication =
                authenticationManager.authenticate(authToken);

        User user = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(user);
        return  new LoginResponse(token);
    }

}
