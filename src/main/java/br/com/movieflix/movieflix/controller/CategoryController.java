package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.entity.dto.category.CategoryResponse;
import br.com.movieflix.movieflix.entity.dto.category.CategoryRequest;
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
    private CategoryService categoryService;
    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){

        return ResponseEntity.ok(categoryService.findAll().stream().toList()) ;
    }
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id){
        return categoryService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    /*
    * Por que precisa do build()?
    Porque métodos como: notFound() badRequest()noContent()
    não retornam o ResponseEntity completo ainda.
    Eles retornam um builder (um “montador” de resposta).
    * */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByCategoryId(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
