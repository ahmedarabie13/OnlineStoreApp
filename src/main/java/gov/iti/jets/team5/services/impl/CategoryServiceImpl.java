package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.CategoryDto;
import gov.iti.jets.team5.repositories.CategoryRepository;
import gov.iti.jets.team5.repositories.ProductRepository;
import gov.iti.jets.team5.services.CategoryService;
import gov.iti.jets.team5.services.ProductService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private static CategoryServiceImpl categoryServiceInstance = null;

    CategoryRepository c = CategoryRepository.getInstance();

    public static CategoryService getInstance() {
        if (categoryServiceInstance == null) {
            synchronized (ProductServiceImpl.class) {
                if (categoryServiceInstance == null) {
                    categoryServiceInstance = new CategoryServiceImpl();
                }
            }
        }
        return categoryServiceInstance;
    }


    @Override
    public List<CategoryDto> fetchCategories() {
        return c.fetchCategories();
    }
}
