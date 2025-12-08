package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.entity.dto.category.CategoryResponse;
import br.com.movieflix.movieflix.entity.dto.category.CategoryRequest;
import br.com.movieflix.movieflix.entity.mapper.CategoryMapper;
import br.com.movieflix.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    public List<CategoryResponse> findAll(){
        List<Category> categories =  repository.findAll();
        return categories.stream().map(CategoryMapper::toDto).toList();
    }

    public Optional<CategoryResponse> findById(Long id){
        return repository.findById(id).map(CategoryMapper::toDto);
    }

    public List<Category> findAllById(List<Long> categoryIds){
        return repository.findAllById(categoryIds);
    }

    public CategoryResponse create(CategoryRequest category){
        return CategoryMapper.toDto(repository.save(CategoryMapper.toEntity(category)));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
