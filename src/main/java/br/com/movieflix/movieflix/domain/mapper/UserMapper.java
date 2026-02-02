package br.com.movieflix.movieflix.domain.mapper;

import br.com.movieflix.movieflix.domain.User;
import br.com.movieflix.movieflix.domain.dto.Auth.RegisterReponseDTO;
import br.com.movieflix.movieflix.domain.dto.Auth.RegisterRequestDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static User toEntity (RegisterRequestDTO request){
        return User
                .builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }
    public static RegisterReponseDTO toDto (User entity){
        return RegisterReponseDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
