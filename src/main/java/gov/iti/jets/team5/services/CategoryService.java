package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> fetchCategories();
}
