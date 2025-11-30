package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.entity.dto.streaming.StreamingRequest;
import br.com.movieflix.movieflix.entity.dto.streaming.StreamingResponse;
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
    public ResponseEntity<StreamingResponse> createStreaming(@RequestBody StreamingRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>>getAllStreamings(){
        return ResponseEntity.ok(service.findAll().stream().toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse>getByStreamingId(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByStreamingId(@PathVariable Long id){
         service.deleteByid(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
