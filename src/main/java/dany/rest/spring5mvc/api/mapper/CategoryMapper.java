package dany.rest.spring5mvc.api.mapper;

import dany.rest.spring5mvc.api.model.CategoryDTO;
import dany.rest.spring5mvc.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

/**
 * Created by bautisj on 4/4/2018.
 */
@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "id", target = "id")
    CategoryDTO categoryToCategoryDTO(Category category);
}
