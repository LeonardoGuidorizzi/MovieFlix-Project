package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.entity.Streaming;
import br.com.movieflix.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {
    private final StreamingRepository repository;

    public List<Streaming> findAll(){
        return repository.findAll();
    }
    public Streaming getById(Long id){
        Optional<Streaming> streaming = repository.findById(id);
        if(streaming.isPresent()){
            return streaming.get();
        }
        return null;
    }
}
