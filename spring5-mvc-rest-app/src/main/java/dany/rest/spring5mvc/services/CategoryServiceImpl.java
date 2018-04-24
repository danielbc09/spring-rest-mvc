package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.mapper.CategoryMapper;
import dany.rest.spring5mvc.api.model.CategoryDTO;
import dany.rest.spring5mvc.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bautisj on 4/4/2018.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return  categoryMapper
                .categoryToCategoryDTO(categoryRepository.findByName(name));

    }
}
