package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.domain.dto.category.CategoryResponse;
import br.com.movieflix.movieflix.domain.dto.category.CategoryRequest;
import br.com.movieflix.movieflix.domain.dto.category.CategoryUpdate;
import br.com.movieflix.movieflix.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movieflix/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAll(){
        return ResponseEntity.ok(service.findAll().stream().toList()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    /*
    * Por que precisa do build()?
    Porque métodos como: notFound() badRequest()noContent()
    não retornam o ResponseEntity completo ainda.
    Eles retornam um builder (um “montador” de resposta).
    * */
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update (@PathVariable Long id, @RequestBody CategoryUpdate request){
        return ResponseEntity.ok(service.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
