//package gov.iti.jets.team5.models.freshStart;
//// Generated 23 Mar 2021, 23:39:24 by Hibernate Tools 6.0.0.Alpha2
//
//
//import gov.iti.jets.team5.models.freshStart.Product;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Category generated by hbm2java
// */
//@Entity
//@Table(name = "category"
//        , catalog = "ECommerceApp"
//)
//public class Category implements java.io.Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", unique = true, nullable = false)
//    private int id;
//
//    @Column(name = "name", nullable = false, length = 50)
//    private String name;
//
//    @ManyToMany(mappedBy = "categories")
////    @ManyToMany(fetch = FetchType.LAZY)
////    @JoinTable(name = "product_categories", catalog = "ECommerceApp",
////            joinColumns = {@JoinColumn(name = "categoryId", nullable = false, updatable = false)},
////            inverseJoinColumns = {@JoinColumn(name = "productId", nullable = false, updatable = false)})
//    private Set<Product> products = new HashSet<Product>(0);
//
//    public Category() {}
//
//    public Category(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Category(int id, String name, Set<Product> products) {
//        this.id = id;
//        this.name = name;
//        this.products = products;
//    }
//
//    public int getId() {
//        return this.id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<Product> getProducts() {
//        return this.products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
//
//
//}
//
//