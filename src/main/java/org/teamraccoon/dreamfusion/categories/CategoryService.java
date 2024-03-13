package org.teamraccoon.dreamfusion.categories;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    
}
