package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.model.CategoryDTO;

import java.util.List;

/**
 * Created by bautisj on 4/4/2018.
 */
public interface CategoryService {

    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);
}
