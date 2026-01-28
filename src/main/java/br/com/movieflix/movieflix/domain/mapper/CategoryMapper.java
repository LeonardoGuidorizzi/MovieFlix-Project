package br.com.movieflix.movieflix.domain.mapper;

import br.com.movieflix.movieflix.domain.Category;
import br.com.movieflix.movieflix.domain.dto.category.CategoryResponse;
import br.com.movieflix.movieflix.domain.dto.category.CategoryRequest;
import br.com.movieflix.movieflix.domain.dto.category.CategoryUpdateRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toEntity(CategoryRequest request){
        return Category
                .builder()
                .name(request.name())
                .build();
    }
    public static CategoryResponse toDto(Category entity){
        return CategoryResponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public void update (CategoryUpdateRequest dto, Category entity){
        if(dto.name() != null){
            entity.setName(dto.name());
        }
    }

}
