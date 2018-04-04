package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.mapper.CategoryMapper;
import dany.rest.spring5mvc.api.model.CategoryDTO;
import dany.rest.spring5mvc.domain.Category;
import dany.rest.spring5mvc.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by bautisj on 4/4/2018.
 */
public class CategoryServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";

    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }


    @Test
    public void getAllCategories() throws Exception {

        //Giv
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());
        when(categoryRepository.findAll()).thenReturn(categories);

        //When
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        //Then
        assertEquals(3, categoryDTOS.size());

    }

    @Test
    public void getCategoryByName() throws Exception {

        //Given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(category.getName())).thenReturn(category);

        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

        assertEquals(NAME, categoryDTO.getName());
        assertEquals(ID, categoryDTO.getId());

    }

}