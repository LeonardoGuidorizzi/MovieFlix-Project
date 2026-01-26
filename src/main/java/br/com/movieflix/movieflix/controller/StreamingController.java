package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.domain.dto.streaming.StreamingRequest;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingResponse;
import br.com.movieflix.movieflix.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movieflix/streaming")
public class StreamingController {
    @Autowired
    private StreamingService service;

    @PostMapping
    public ResponseEntity<StreamingResponse> create(@RequestBody StreamingRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>>getAll(){
        return ResponseEntity.ok(service.findAll().stream().toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteByid(id);
        return ResponseEntity.noContent().build();
    }


}
