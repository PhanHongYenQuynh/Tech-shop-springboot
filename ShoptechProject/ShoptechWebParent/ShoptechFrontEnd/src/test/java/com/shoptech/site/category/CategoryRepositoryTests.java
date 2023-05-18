package com.shoptech.site.category;

import com.shoptech.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
@EntityScan("com.shoptech.entity")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository repo;

    @Test
    public void testListEnabledCategories() {
        List<Category> categories = repo.findAllEnabled();
        categories.forEach(category -> {
            System.out.println(category.getName() + " (" + category.getEnable() + ")");
        });
    }

    @Test
    public void testFindCategoryByAlias() {
        String alias = "electronics";
        Category category = repo.findByAliasEnabled(alias);

        assertThat(category).isNotNull();
    }

}
