package br.com.movieflix.movieflix.domain.mapper;

import br.com.movieflix.movieflix.domain.User;
import br.com.movieflix.movieflix.domain.dto.Auth.RegisterReponse;
import br.com.movieflix.movieflix.domain.dto.Auth.RegisterRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static User toEntity (RegisterRequest request){
        return User
                .builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }
    public static RegisterReponse toDto (User entity){
        return RegisterReponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
