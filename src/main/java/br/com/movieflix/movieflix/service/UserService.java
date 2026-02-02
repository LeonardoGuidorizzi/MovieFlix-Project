package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.domain.User;
import br.com.movieflix.movieflix.domain.dto.Auth.RegisterReponseDTO;
import br.com.movieflix.movieflix.domain.dto.Auth.RegisterRequestDTO;
import br.com.movieflix.movieflix.domain.mapper.UserMapper;
import br.com.movieflix.movieflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public RegisterReponseDTO create (RegisterRequestDTO request){
        User userEntity = UserMapper.toEntity(request);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return UserMapper.toDto(repository.save(userEntity));
    }
}
