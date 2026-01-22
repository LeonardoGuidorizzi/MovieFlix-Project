package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.entity.User;
import br.com.movieflix.movieflix.entity.dto.Auth.RegisterReponse;
import br.com.movieflix.movieflix.entity.dto.Auth.RegisterRequest;
import br.com.movieflix.movieflix.entity.mapper.UserMapper;
import br.com.movieflix.movieflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public RegisterReponse create (RegisterRequest request){
        User userEntity = UserMapper.toEntity(request);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return UserMapper.toDto(repository.save(userEntity));
    }
}
