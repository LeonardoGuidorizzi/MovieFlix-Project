package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.domain.Category;
import br.com.movieflix.movieflix.domain.dto.category.CategoryResponse;
import br.com.movieflix.movieflix.domain.dto.category.CategoryRequest;
import br.com.movieflix.movieflix.domain.mapper.CategoryMapper;
import br.com.movieflix.movieflix.exception.notFound.ResourceNotFoundException;
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

    public CategoryResponse findById(Long id){
        return repository.findById(id).map(CategoryMapper::toDto).orElseThrow(()-> new ResourceNotFoundException("Category", id));
    }

    public List<Category> findAllById(List<Long> categoryIds){
        return repository.findAllById(categoryIds);
    }

    public CategoryResponse create(CategoryRequest category){
        return CategoryMapper.toDto(repository.save(CategoryMapper.toEntity(category)));
    }

    public void deleteById(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Category", id);
        }
        repository.deleteById(id);
    }
}
