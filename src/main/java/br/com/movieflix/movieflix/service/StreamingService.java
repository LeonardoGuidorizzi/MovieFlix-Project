package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.domain.Streaming;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingResponse;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingRequest;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingUpdate;
import br.com.movieflix.movieflix.domain.mapper.StreamingMapper;
import br.com.movieflix.movieflix.exception.business.BusinessException;
import br.com.movieflix.movieflix.exception.notFound.ResourceNotFoundException;
import br.com.movieflix.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {
    private final StreamingRepository repository;

    public StreamingResponse create(StreamingRequest request){
        if (repository.existsByNameIgnoreCase(request.name())) {
            throw new BusinessException("Movie already exists");
        }
        return StreamingMapper.toDto(repository.save(StreamingMapper.toEntity(request)));
    }

    public List<StreamingResponse> findAll(){
               List<Streaming> streamings = repository.findAll();
               return streamings.stream().map(StreamingMapper::toDto).toList();
    }
    public StreamingResponse findById(Long id){
        return repository.findById(id).map(StreamingMapper::toDto).orElseThrow(()-> new ResourceNotFoundException("Streaming", id));
    }

    public List<Streaming> findAllById(List<Long> streamingIds){
        return repository.findAllById(streamingIds);
    }
    public StreamingResponse update (Long id, StreamingUpdate request){
        Streaming foundStreaming = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Streaming", id));
        StreamingMapper.update(request, foundStreaming);
        Streaming streaming = repository.save(foundStreaming);
        return StreamingMapper.toDto(streaming);
    }
    public void deleteByid (Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Streaming", id);
        }
        repository.deleteById(id);
    }


}
