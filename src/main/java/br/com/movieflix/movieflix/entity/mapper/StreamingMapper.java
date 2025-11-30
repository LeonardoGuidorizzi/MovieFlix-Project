package br.com.movieflix.movieflix.entity.mapper;

import br.com.movieflix.movieflix.entity.Streaming;
import br.com.movieflix.movieflix.entity.dto.streaming.StreamingResponse;
import br.com.movieflix.movieflix.entity.dto.streaming.StreamingRequest;
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
}
