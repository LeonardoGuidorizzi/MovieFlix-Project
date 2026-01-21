package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.config.TokenService;
import br.com.movieflix.movieflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    @Override
    public UserDetails loadUserByUsername(String userRegister) throws UsernameNotFoundException {
        return repository.findByEmail(userRegister).orElseThrow(()-> new RuntimeException("Password or email could be wrong"));
    }
}
