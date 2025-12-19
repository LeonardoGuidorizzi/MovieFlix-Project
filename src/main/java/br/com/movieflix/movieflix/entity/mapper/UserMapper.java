package br.com.movieflix.movieflix.entity.mapper;

import br.com.movieflix.movieflix.entity.User;
import br.com.movieflix.movieflix.entity.dto.User.RegisterReponse;
import br.com.movieflix.movieflix.entity.dto.User.RegisterRequest;
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
