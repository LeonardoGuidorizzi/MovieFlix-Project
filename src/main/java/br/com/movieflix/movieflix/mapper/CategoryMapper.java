package br.com.movieflix.movieflix.mapper;

import br.com.movieflix.movieflix.entity.Category;
import br.com.movieflix.movieflix.dto.category.CategoryResponseDTO;
import br.com.movieflix.movieflix.dto.category.CategoryCreateRequestDTO;
import br.com.movieflix.movieflix.dto.category.CategoryUpdateRequestDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toEntity(CategoryCreateRequestDTO request){
        return Category
                .builder()
                .name(request.name())
                .build();
    }
    public static CategoryResponseDTO toDto(Category entity){
        return CategoryResponseDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public void update (CategoryUpdateRequestDTO dto, Category entity){
        if(dto.name() != null){
            entity.setName(dto.name());
        }
    }

}
