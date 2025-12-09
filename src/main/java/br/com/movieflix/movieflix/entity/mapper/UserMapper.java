package br.com.movieflix.movieflix.entity.mapper;

import br.com.movieflix.movieflix.entity.User;
import br.com.movieflix.movieflix.entity.dto.User.UserReponse;
import br.com.movieflix.movieflix.entity.dto.User.UserRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static User toEntity (UserRequest request){
        return User
                .builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }
    public static UserReponse toDto (User entity){
        return UserReponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
