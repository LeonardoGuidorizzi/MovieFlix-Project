package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.entity.Streaming;
import br.com.movieflix.movieflix.entity.dto.streaming.StreamingResponse;
import br.com.movieflix.movieflix.entity.dto.streaming.StreamingRequest;
import br.com.movieflix.movieflix.entity.mapper.StreamingMapper;
import br.com.movieflix.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {
    private final StreamingRepository repository;

    public List<StreamingResponse> findAll(){
               List<Streaming> streamings = repository.findAll();
               return streamings.stream().map(StreamingMapper::toDto).toList();
    }
    public Optional<StreamingResponse> findById(Long id){
        return repository.findById(id).map(StreamingMapper::toDto);
    }

    public List<Streaming> findAllById(List<Long> streamingIds){
        return repository.findAllById(streamingIds);
    }

    public StreamingResponse create(StreamingRequest request){
        return StreamingMapper.toDto(repository.save(StreamingMapper.toEntity(request)));
    }

    public void deleteByid (Long id){
        repository.deleteById(id);
    }


}
