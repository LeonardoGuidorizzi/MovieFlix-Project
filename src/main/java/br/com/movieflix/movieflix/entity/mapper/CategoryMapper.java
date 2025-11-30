package br.com.movieflix.movieflix.entity.mapper;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.entity.dto.category.reponse.CategoryResponse;
import br.com.movieflix.movieflix.entity.dto.category.request.CategoryRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toEntity(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
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
