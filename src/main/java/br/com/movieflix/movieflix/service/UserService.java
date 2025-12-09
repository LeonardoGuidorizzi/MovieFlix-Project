package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.entity.dto.User.UserReponse;
import br.com.movieflix.movieflix.entity.dto.User.UserRequest;
import br.com.movieflix.movieflix.entity.mapper.UserMapper;
import br.com.movieflix.movieflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserReponse create (UserRequest request){
        return UserMapper.toDto(repository.save(UserMapper.toEntity(request)));
    }
}
