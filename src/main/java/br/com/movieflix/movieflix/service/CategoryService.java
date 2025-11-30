package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.entity.dto.category.reponse.CategoryResponse;
import br.com.movieflix.movieflix.entity.dto.category.request.CategoryRequest;
import br.com.movieflix.movieflix.entity.mapper.CategoryMapper;
import br.com.movieflix.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    public List<CategoryResponse> findAll(){

        List<Category> categories =  repository.findAll();
        return categories.stream().map(CategoryMapper::toDto).toList();
    }

    public CategoryResponse saveCatogory(CategoryRequest category){

        return CategoryMapper.toDto(repository.save(CategoryMapper.toEntity(category)));
    }
    public CategoryResponse findById(Long id){
        Category foundCategory = repository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        return CategoryMapper.toDto(foundCategory);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
