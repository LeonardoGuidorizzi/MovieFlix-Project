package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.domain.dto.streaming.StreamingCreateRequestDTO;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingResponseDTO;
import br.com.movieflix.movieflix.domain.dto.streaming.StreamingUpdateRequestDTO;
import br.com.movieflix.movieflix.service.StreamingService;
import br.com.movieflix.movieflix.swagger.Doc.StreamingControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movieflix/streaming")
public class StreamingController implements StreamingControllerDoc {
    @Autowired
    private StreamingService service;

    @PostMapping
    public ResponseEntity<StreamingResponseDTO> create(@RequestBody StreamingCreateRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponseDTO>>getAll(){
        return ResponseEntity.ok(service.findAll().stream().toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamingResponseDTO> update(@PathVariable Long id, @RequestBody StreamingUpdateRequestDTO request){
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteByid(id);
        return ResponseEntity.noContent().build();
    }


}
