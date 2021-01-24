package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends AdminApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Transactional
    public void create() {
        String type = "COMPUTER";
        String title = "Computer";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assertions.assertNotNull(newCategory);
        Assertions.assertEquals(newCategory.getType(), type);
        Assertions.assertEquals(newCategory.getTitle(), title);
    }

    @Test
    public void read() {
        String type = "COMPUTER";

        Optional<Category> optionalCategory = categoryRepository.findByType(type);

        optionalCategory.ifPresent(c -> {

            Assertions.assertEquals(c.getType(), type);

            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });
    }

}
