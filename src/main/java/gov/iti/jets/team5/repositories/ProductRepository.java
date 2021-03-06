package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.Category;
import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.dto.CartItemDto;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.enums.ProductStatus;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductRepository {

    private static ProductRepository productRepositoryInstance = null;
    private int pageSize = 9;

    private EntityManagerFactory entityManagerFactory = AppSessionFactory.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static ProductRepository getInstance() {
        if (productRepositoryInstance == null) {
            synchronized (UserRepository.class) {
                if (productRepositoryInstance == null) {
                    productRepositoryInstance = new ProductRepository();
                }
            }
        }
        return productRepositoryInstance;
    }

    //    public List<ProductDto> fetchProducts(){
//        Query q = entityManager.createQuery("from Product");
//        List<Product> products = q.getResultList();
//        List<ProductDto> theProducts = new ArrayList<>();
//        for (Product p : products) {
//            ProductDto productDto = new ProductDto();
//            productDto.setProductID(String.valueOf(p.getId()));
//            productDto.setProductName(p.getProductName());
//            productDto.setProductImageURL("images/products/MeatlessPieces.png");
//            productDto.setProductPrice(p.getPrice().doubleValue());
//            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
//            theProducts.add(productDto);
//        }
//        System.out.println("Returned Product List Size: " + products.size());
//        return theProducts;
//    }
    public List<ProductDto> fetchProducts(int pageNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Product");
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);

        List<Product> products = query.getResultList();
        List<ProductDto> theProducts = new ArrayList<>();

        for (Product p : products) {
            ProductDto productDto = new ProductDto();
            productDto.setProductID(String.valueOf(p.getId()));
            productDto.setProductName(p.getProductName());
            productDto.setProductImageURL(p.getPhoto());
            productDto.setProductPrice(p.getPrice());
            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
            theProducts.add(productDto);
        }
        System.out.println("Returned Product List Size: " + products.size());
//        entityManager.getTransaction().commit();
        entityManager.close();
        return theProducts;
    }


    public List<ProductDto> fetchCatProducts(String category, int pageNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<ProductDto> theProducts = null;
        try {
            entityManager.getTransaction().begin();
            int categoryId = Integer.parseInt(category);
            int pageSize = 10;
            Query query = entityManager.createQuery("from Category cat where cat.id = :category")
                    .setParameter("category", categoryId);
            List<Category> returnedCatObj = query.getResultList();

//            entityManager.getTransaction().commit();
            if (returnedCatObj.isEmpty()) {
                return null;
            } else {
//                entityManager.getTransaction().begin();
                Set<Product> catProducts = returnedCatObj.get(0).getProducts();
                System.out.println(catProducts.size() + " THE SIZE");
                List<Product> catProductsList = new ArrayList<>(catProducts);
                theProducts = new ArrayList<>();
                int size = Math.min(pageSize, catProductsList.size());

                for (int i = (pageNumber - 1) * pageSize; i < size; i++) {

                    Product item = catProductsList.get(i);
                    ProductDto productDto = new ProductDto();
                    productDto.setProductID(String.valueOf(item.getId()));
                    productDto.setProductName(item.getProductName());
                    productDto.setProductImageURL(item.getPhoto());
                    productDto.setProductPrice(item.getPrice());
                    productDto.setProductStatus(ProductStatus.valueOf(item.getStatus()));
                    theProducts.add(productDto);
                }
//                return theProducts;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
            return theProducts;
        }
    }

    public List<ProductDto> fetchProductsByFilter(int pageNumber, int filterStart, int filterEnd) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BigDecimal filterStartDecimal = new BigDecimal(filterStart);
        BigDecimal filterEndDecimal = new BigDecimal(filterEnd);
        Query query = entityManager.createQuery(
                "from Product p where p.price between : startPrice and :endPrice")
                .setParameter("startPrice", filterStartDecimal)
                .setParameter("endPrice", filterEndDecimal);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);

        List<Product> products = query.getResultList();
        List<ProductDto> theProducts = new ArrayList<>();

        for (Product p : products) {
            ProductDto productDto = new ProductDto();
            productDto.setProductID(String.valueOf(p.getId()));
            productDto.setProductName(p.getProductName());
            productDto.setProductImageURL(p.getPhoto());
            productDto.setProductPrice(p.getPrice());
            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
            theProducts.add(productDto);
        }
        System.out.println("Returned Product List Size: " + products.size());
//        entityManager.getTransaction().commit();
        entityManager.close();
        return theProducts;
    }

    public List<ProductDto> fetchProductsByFilterAndCategory(int pageNumber, String category, int filterStart, int filterEnd) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BigDecimal filterStartDecimal = new BigDecimal(filterStart);
        BigDecimal filterEndDecimal = new BigDecimal(filterEnd);
        List<ProductDto> theProducts = null;
        try {
            entityManager.getTransaction().begin();
            int categoryId = Integer.parseInt(category);
            Query query = entityManager.createQuery("from Category cat where cat.id = :category")
                    .setParameter("category", categoryId);
            List<Category> returnedCatObj = query.getResultList();
            if (returnedCatObj.isEmpty()) {
                return null;
            } else {
                Set<Product> catProducts = returnedCatObj.get(0).getProducts();
                List<Product> catProductsList = new ArrayList<>(catProducts);
                theProducts = new ArrayList<>();
                int size = Math.min(pageSize, catProductsList.size());
                for (int i = (pageNumber - 1) * pageSize; i < size; i++) {
                    Product product = catProductsList.get(i);
                    if (product.getPrice().compareTo(filterStartDecimal) > 0 && product.getPrice().compareTo(filterEndDecimal) < 0) {
                        ProductDto productDto = new ProductDto();
                        productDto.setProductID(String.valueOf(product.getId()));
                        productDto.setProductName(product.getProductName());
                        productDto.setProductImageURL(product.getPhoto());
                        productDto.setProductPrice(product.getPrice());
                        productDto.setProductStatus(ProductStatus.valueOf(product.getStatus()));
                        theProducts.add(productDto);
                    }
                }
//                return theProducts;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
            return theProducts;
        }
    }

    public long fetchNumOfProducts(String categoryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("CatID = " + categoryId);
        if (categoryId == null || categoryId.equals("null") || categoryId.equals("")) {
            Query q = entityManager.createQuery("select count(*) from Product");
            var productsNum = q.getResultList();
            System.out.println("number of products: " + (long) productsNum.get(0));
            return (long) productsNum.get(0);
        } else {
            try {
                int catId = Integer.parseInt(categoryId);
                Query q = entityManager.createQuery("from Category c where c.id = :cid")
                        .setParameter("cid", catId);
                System.out.println("Not reached");
                List<Category> cats = q.getResultList();
                if (cats.isEmpty()) {
                    System.out.println("vsvsdvsdvs");
                    entityManager.close();
                    return -1;
                }
                Category theCat = cats.get(0);
                System.out.println("number of products with cat: " + (long) theCat.getProducts().size());
                return (long) theCat.getProducts().size();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Excep");
                entityManager.close();
                return -1;
            }
        }
    }

    public Product fetchProductData(String productId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            int id = Integer.parseInt(productId);
            Query q = entityManager.createQuery("from Product p where p.id = :pid")
                    .setParameter("pid", id);
            List<Product> product = q.getResultList();

            if (product.isEmpty()) {
                entityManager.close();
                return null;
            } else {
                entityManager.close();
                return product.get(0);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            entityManager.close();
            return null;
        }
    }

    public List<ProductDto> searchForProducts(String productName) {
        List<ProductDto> theProducts = null;
        try {

            entityManager.getTransaction().begin();
            System.out.println(productName);
            String productNameLike = "%" + productName + "%";
            String queryString = "from Product p WHERE p.productName LIKE :name";
            Query q = entityManager.createQuery(queryString).setParameter("name", productNameLike);
            List<Product> products = q.getResultList();
            theProducts = new ArrayList<>();
            System.out.println(products);
            for (Product p : products) {
                ProductDto productDto = new ProductDto();
                productDto.setProductID(String.valueOf(p.getId()));
                productDto.setProductName(p.getProductName());
                productDto.setProductImageURL(p.getPhoto());
                productDto.setProductPrice(p.getPrice());
                productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
                theProducts.add(productDto);
            }
            System.out.println("Returned Product List Size: " + products.size());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

        }
        return theProducts;


    }

    public void updateProductAfterCheckout(CartItemDto cartItem) {
        try {
            entityManager.getTransaction().begin();
            int productId = Integer.parseInt(cartItem.getProduct().getProductID());
            Product product = entityManager.find(Product.class, productId);
            int oldQuantity = product.getQuantity();
            int newQuantity = oldQuantity - cartItem.getQuantity();
            product.setQuantity(newQuantity);
            entityManager.merge(product);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    public boolean updateProduct(int id, ProductDto product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Product productToUpdate = entityManager.find(Product.class, id);
            productToUpdate.setProductName(product.getProductName());
            productToUpdate.setProductDescription(product.getProductDescription());
            productToUpdate.setPrice(product.getProductPrice());
            productToUpdate.setQuantity(product.getProductQuantity());
            productToUpdate.setStatus(product.getProductStatus().getProductStatus());
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.close();
            return false;
        }
    }

    public boolean deleteProduct(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Product productToDelete = entityManager.find(Product.class, id);
            entityManager.remove(productToDelete);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.close();
            return false;
        }
    }

    public boolean addProduct(ProductDto product, String[] catList) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Product productToAdd = new Product();
            productToAdd.setProductName(product.getProductName());
            productToAdd.setProductDescription(product.getProductDescription());
            productToAdd.setPrice(product.getProductPrice());
            productToAdd.setQuantity(product.getProductQuantity());
//            productToAdd.setPhoto("empty");
            productToAdd.setSellerName("Rivo");
            productToAdd.setStatus(ProductStatus.NEW.getProductStatus());
            productToAdd.setPhoto(product.getProductImageURL());
            if (catList != null) {
                Set<Category> cats = getCats(catList);
                productToAdd.setCategories(cats);
            }
            entityManager.persist(productToAdd);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.close();
            return false;
        }
    }

    public Set<Category> getCats(String[] cats) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Set<Category> catsList = new HashSet<>();
        for (String c : cats) {
            Category cat = entityManager.find(Category.class, Integer.parseInt(c));
            catsList.add(cat);
        }
        entityManager.close();
        return catsList;
    }

    public List<ProductDto> fetchLastRecentTenProducts() {
        List<Product> products = entityManager.createQuery(
                "from Product p ORDER BY id Desc")
                .setMaxResults(pageSize)
                .getResultList();

        List<ProductDto> theProducts = new ArrayList<>();

        for (Product p : products) {
            ProductDto productDto = new ProductDto();
            productDto.setProductID(String.valueOf(p.getId()));
            productDto.setProductName(p.getProductName());
            productDto.setProductImageURL(p.getPhoto());
            productDto.setProductPrice(p.getPrice());
            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
            theProducts.add(productDto);
        }
        return theProducts;
    }
}
