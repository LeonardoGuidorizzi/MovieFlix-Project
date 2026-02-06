package br.com.movieflix.movieflix.service;

import br.com.movieflix.movieflix.domain.Category;
import br.com.movieflix.movieflix.domain.dto.category.CategoryResponseDTO;
import br.com.movieflix.movieflix.domain.dto.category.CategoryCreateRequestDTO;
import br.com.movieflix.movieflix.domain.dto.category.CategoryUpdateRequestDTO;
import br.com.movieflix.movieflix.domain.mapper.CategoryMapper;
import br.com.movieflix.movieflix.exception.business.BusinessException;
import br.com.movieflix.movieflix.exception.notFound.ResourceNotFoundException;
import br.com.movieflix.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryResponseDTO create(CategoryCreateRequestDTO request){
        if (repository.existsByNameIgnoreCase(request.name())) {
            throw new BusinessException("Category already exists");
        }
        return CategoryMapper.toDto(repository.save(CategoryMapper.toEntity(request)));
    }

    public List<CategoryResponseDTO> findAll(){
        List<Category> categories =  repository.findAll();
        return categories.stream().map(CategoryMapper::toDto).toList();
    }

    public CategoryResponseDTO findById(Long id){
        return repository.findById(id).map(CategoryMapper::toDto).orElseThrow(()-> new ResourceNotFoundException("Category", id));
    }

    public List<Category> findAllById(List<Long> categoryIds){
        return repository.findAllById(categoryIds);
    }

    public CategoryResponseDTO update(Long id, CategoryUpdateRequestDTO request ){
        Category foundCategory = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", id));
        CategoryMapper.update(request, foundCategory);
        Category category = repository.save(foundCategory);
        return CategoryMapper.toDto(category);
    }

    public void deleteById(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Category", id);
        }
        repository.deleteById(id);
    }
}
