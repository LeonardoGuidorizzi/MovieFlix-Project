package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    public List<Category> findAll(){
       return repository.findAll();
    }

    public Category saveCatogory(Category category){
        return repository.save(category);
    }
    public Category findById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
