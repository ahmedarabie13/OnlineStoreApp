package dbEntities;
// Generated 23 Mar 2021, 23:39:24 by Hibernate Tools 6.0.0.Alpha2


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserData generated by hbm2java
 */
@Entity
@Table(name="user_data"
    ,catalog="ECommerceApp"
)
public class UserData  implements java.io.Serializable {


     private int id;
     private String firstName;
     private String lastName;
     private String phone;
     private String email;
     private String password;
     private String photo;
     private String street;
     private String city;
     private Date birthdate;
     private String userRole;
     private Set<Orders> orderses = new HashSet<Orders>(0);
     private Set<PotentialOrders> potentialOrderses = new HashSet<PotentialOrders>(0);

    public UserData() {
    }

	
    public UserData(int id, String firstName, String lastName, String phone, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    public UserData(int id, String firstName, String lastName, String phone, String email, String password, String photo, String street, String city, Date birthdate, String userRole, Set<Orders> orderses, Set<PotentialOrders> potentialOrderses) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.phone = phone;
       this.email = email;
       this.password = password;
       this.photo = photo;
       this.street = street;
       this.city = city;
       this.birthdate = birthdate;
       this.userRole = userRole;
       this.orderses = orderses;
       this.potentialOrderses = potentialOrderses;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="firstName", nullable=false, length=50)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="lastName", nullable=false, length=50)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="phone", nullable=false, length=11)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="email", nullable=false, length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="password", nullable=false, length=200)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="photo", length=200)
    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    
    @Column(name="street", length=200)
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    
    @Column(name="city", length=200)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="birthdate", length=10)
    public Date getBirthdate() {
        return this.birthdate;
    }
    
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    
    @Column(name="userRole", length=5)
    public String getUserRole() {
        return this.userRole;
    }
    
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userData")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userData")
    public Set<PotentialOrders> getPotentialOrderses() {
        return this.potentialOrderses;
    }
    
    public void setPotentialOrderses(Set<PotentialOrders> potentialOrderses) {
        this.potentialOrderses = potentialOrderses;
    }




}


