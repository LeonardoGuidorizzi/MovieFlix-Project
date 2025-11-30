package br.com.movieflix.movieflix.entity.mapper;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.entity.dto.category.CategoryResponse;
import br.com.movieflix.movieflix.entity.dto.category.CategoryRequest;
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
}
