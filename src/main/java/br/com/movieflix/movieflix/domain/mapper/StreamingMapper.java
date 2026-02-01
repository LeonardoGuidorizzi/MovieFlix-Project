package br.com.movieflix.movieflix.domain.mapper;

import br.com.movieflix.movieflix.domain.Streaming;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingResponseDTO;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingRequestDTO;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingUpdateRequestDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    public static Streaming toEntity (StreamingRequestDTO request){
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
