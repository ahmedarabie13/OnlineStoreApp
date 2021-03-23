package dbEntities;
// Generated 23 Mar 2021, 23:39:24 by Hibernate Tools 6.0.0.Alpha2


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name="category"
    ,catalog="ECommerceApp"
)
public class Category  implements java.io.Serializable {


     private int id;
     private String name;
     private Set<Product> products = new HashSet<Product>(0);

    public Category() {
    }

	
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Category(int id, String name, Set<Product> products) {
       this.id = id;
       this.name = name;
       this.products = products;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="product_categories", catalog="ECommerceApp", joinColumns = { 
        @JoinColumn(name="categoryId", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="productId", nullable=false, updatable=false) })
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


