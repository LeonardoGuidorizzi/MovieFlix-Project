package br.com.movieflix.movieflix.entity.mapper;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.entity.dto.category.request.CategoryRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toEntity(CategoryRequest categoryRequest){
        Category category = new Category();
    }
}
