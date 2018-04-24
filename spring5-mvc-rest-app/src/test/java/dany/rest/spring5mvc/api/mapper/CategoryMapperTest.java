package dany.rest.spring5mvc.api.mapper;

import dany.rest.spring5mvc.api.model.CategoryDTO;
import dany.rest.spring5mvc.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bautisj on 4/4/2018.
 */
public class CategoryMapperTest {

    public static final String NAME = "PHP";
    public static final long ID = 1l;
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void categoryToCategoryDTO() throws Exception {

        //given
        Category category = new Category();
        category.setId(1L);
        category.setName(NAME);


        //When
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());

    }

}