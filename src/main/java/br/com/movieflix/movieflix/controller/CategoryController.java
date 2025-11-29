package br.com.movieflix.movieflix.controller;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.entity.dto.category.reponse.CategoryResponse;
import br.com.movieflix.movieflix.entity.dto.category.request.CategoryRequest;
import br.com.movieflix.movieflix.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movieflix/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping()
    public List<CategoryResponse> getAllCategories(){
        return categoryService.findAll();
    }
    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryRequest request){
        return categoryService.saveCatogory(category);
    }
    @GetMapping("/{id}")
    public CategoryResponse getByCategoryId(@PathVariable Long id){
        return categoryService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteByCategoryId(@PathVariable Long id){
        categoryService.deleteById(id);
    }
}
