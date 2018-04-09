package dany.rest.spring5mvc.controllers.v1;

import dany.rest.spring5mvc.api.model.CategoryDTO;
import dany.rest.spring5mvc.services.CategoryService;
import dany.rest.spring5mvc.services.ResourceNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by bautisj on 4/4/2018.
 */
public class CategoryControllerTest {

    public  static final String NAME = "Jim";

    @Mock
    CategoryService categoryService;
    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(new RestResponseEntityExceptionHandler())
                .build();
    }

    @Test
    public void testListCategories() throws Exception {
        CategoryDTO category1 = new CategoryDTO();
        category1.setId(1l);
        category1.setName(NAME);

        CategoryDTO category2 = new CategoryDTO();
        category2.setId(2l);
        category2.setName("Bob");

        List<CategoryDTO> categories = Arrays.asList(category1, category2);

        when(categoryService.getAllCategories()).thenReturn(categories);

        mockMvc.perform(get(CategoryController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.categories", equalTo(NAME)));
    }

    @Test
    public void testGetCategoryByName() throws Exception {
        CategoryDTO categoryDTO1 = new CategoryDTO();
        categoryDTO1.setId(1l);
        categoryDTO1.setName(NAME);

        when(categoryService.getCategoryByName(anyString())).thenReturn(categoryDTO1);

        mockMvc.perform(get(CategoryController.BASE_URL + "/Jim")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)));
    }

    @Test
    public void testGetByNameNotFound() throws Exception {

        when (categoryService.getCategoryByName(anyString()))
                .thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get(CategoryController.BASE_URL + "Foo")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}