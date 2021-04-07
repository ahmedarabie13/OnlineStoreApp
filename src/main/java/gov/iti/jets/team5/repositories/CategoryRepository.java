package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.Category;
import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.dto.CategoryDto;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.enums.ProductStatus;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private static CategoryRepository categoryRepositoryInstance = null;

    EntityManagerFactory entityManagerFactory = AppSessionFactory.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static CategoryRepository getInstance() {
        if (categoryRepositoryInstance == null) {
            synchronized (CategoryRepository.class) {
                if (categoryRepositoryInstance == null) {
                    categoryRepositoryInstance = new CategoryRepository();
                }
            }
        }
        return categoryRepositoryInstance;
    }

    public List<CategoryDto> fetchCategories(){
        try{
            Query query = entityManager.createQuery("from Category");
            List<Category> categories = query.getResultList();
            List<CategoryDto> theCategories = new ArrayList<>();
            for (Category c : categories) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(c.getId());
                categoryDto.setName(c.getName());
                theCategories.add(categoryDto);
            }
            System.out.println("Returned Category List Size: " + categories.size());
            return theCategories;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
