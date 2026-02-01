package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.domain.Streaming;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingResponseDTO;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingRequestDTO;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingUpdateRequestDTO;
import br.com.movieflix.movieflix.domain.mapper.StreamingMapper;
import br.com.movieflix.movieflix.exception.business.BusinessException;
import br.com.movieflix.movieflix.exception.notFound.ResourceNotFoundException;
import br.com.movieflix.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreamingService {
    private final StreamingRepository repository;

    public StreamingResponseDTO create(StreamingRequestDTO request){
        if (repository.existsByNameIgnoreCase(request.name())) {
            throw new BusinessException("Movie already exists");
        }
        return StreamingMapper.toDto(repository.save(StreamingMapper.toEntity(request)));
    }

    public List<StreamingResponseDTO> findAll(){
               List<Streaming> streamings = repository.findAll();
               return streamings.stream().map(StreamingMapper::toDto).toList();
    }
    public StreamingResponseDTO findById(Long id){
        return repository.findById(id).map(StreamingMapper::toDto).orElseThrow(()-> new ResourceNotFoundException("Streaming", id));
    }

    public List<Streaming> findAllById(List<Long> streamingIds){
        return repository.findAllById(streamingIds);
    }
    public StreamingResponseDTO update (Long id, StreamingUpdateRequestDTO request){
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
