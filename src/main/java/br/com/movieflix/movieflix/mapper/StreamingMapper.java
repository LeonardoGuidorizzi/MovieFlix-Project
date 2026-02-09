package br.com.movieflix.movieflix.mapper;

import br.com.movieflix.movieflix.entity.Streaming;
import br.com.movieflix.movieflix.dto.streaming.StreamingResponseDTO;
import br.com.movieflix.movieflix.dto.streaming.StreamingCreateRequestDTO;
import br.com.movieflix.movieflix.dto.streaming.StreamingUpdateRequestDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    public static Streaming toEntity (StreamingCreateRequestDTO request){
        return Streaming
                .builder()
                .name(request.name())
                .build();

    }

    public static StreamingResponseDTO toDto (Streaming entity){
        return StreamingResponseDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public void update (StreamingUpdateRequestDTO dto, Streaming entity){
        if(dto.name() != null){
            entity.setName(dto.name());
        }
    }
}
