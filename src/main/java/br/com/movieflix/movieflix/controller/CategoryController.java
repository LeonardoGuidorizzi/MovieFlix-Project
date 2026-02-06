package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.domain.dto.category.CategoryResponseDTO;
import br.com.movieflix.movieflix.domain.dto.category.CategoryCreateRequestDTO;
import br.com.movieflix.movieflix.domain.dto.category.CategoryUpdateRequestDTO;
import br.com.movieflix.movieflix.service.CategoryService;
import br.com.movieflix.movieflix.swagger.Doc.CategoryControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movieflix/category")
public class CategoryController implements CategoryControllerDoc {
    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryCreateRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponseDTO>> getAll(){
        return ResponseEntity.ok(service.findAll().stream().toList()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    /*
    * Por que precisa do build()?
    Porque métodos como: notFound() badRequest()noContent()
    não retornam o ResponseEntity completo ainda.
    Eles retornam um builder (um “montador” de resposta).
    * */
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update (@PathVariable Long id, @RequestBody CategoryUpdateRequestDTO request){
        return ResponseEntity.ok(service.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
