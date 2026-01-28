package br.com.movieflix.movieflix.domain.mapper;

import br.com.movieflix.movieflix.domain.Category;
import br.com.movieflix.movieflix.domain.Streaming;
import br.com.movieflix.movieflix.domain.dto.category.CategoryUpdate;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingResponse;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingRequest;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingUpdate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    public static Streaming toEntity (StreamingRequest request){
        return Streaming
                .builder()
                .name(request.name())
                .build();

    }

    public static StreamingResponse toDto (Streaming entity){
        return StreamingResponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public void update (StreamingUpdate dto, Streaming entity){
        if(dto.name() != null){
            entity.setName(dto.name());
        }
    }
}
