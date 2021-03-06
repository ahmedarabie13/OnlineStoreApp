//package gov.iti.jets.team5.models.freshStart;
//// Generated 23 Mar 2021, 23:39:24 by Hibernate Tools 6.0.0.Alpha2
//
//
//import gov.iti.jets.team5.models.dbEntities.Orders;
//import gov.iti.jets.team5.models.dbEntities.PotentialOrders;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * UserData generated by hbm2java
// */
//@Entity
//@Table(name = "user_data"
//        , catalog = "ECommerceApp"
//)
//public class UserData implements java.io.Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", unique = true, nullable = false)
//    private int id;
//
//    @Column(name = "firstName", nullable = false, length = 50)
//    private String firstName;
//
//    @Column(name="lastName", nullable=false, length = 50)
//    private String lastName;
//
//    @Column(name="phone", unique=true, nullable=false, length = 11)
//    private String phone;
//
//    @Column(name="email", unique=true, nullable=false, length = 50)
//    private String email;
//
//    @Column(name="password", nullable=false)
//    private String password;
//
//    @Column(name="photo")
//    private String photo;
//
//    @Column(name="street")
//    private String street;
//
//    @Column(name="city")
//    private String city;
//
//    //todo ask about this temporal thing??
//    @Temporal(TemporalType.DATE)
//    @Column(name="birthdate")
//    private Date birthdate;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name="userRole", nullable=false, columnDefinition = "varchar(10) default 'USER'")
//    private Role userRole;
//
//    //todo in the orders table it will be a reference attribute named user
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private Set<Order> orders = new HashSet<Order>(0);
//
//    //todo dunno yet how to represent this relation guess its many-to-many
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private Set<PotentialOrders> potentialOrders = new HashSet<PotentialOrders>(0);
//
//    public UserData() {}
//
//
//    //todo do we need the id in the constructor???
//    public UserData(int id, String firstName, String lastName, String phone, String email, String password, Role userRole) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.email = email;
//        this.password = password;
//        //todo added the user role as its essential!!!
//        this.userRole = userRole;
//    }
//
//    public UserData(int id, String firstName, String lastName, String phone, String email, String password, String photo, String street, String city, Date birthdate, Role userRole, Set<Order> orders, Set<PotentialOrders> potentialOrders) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.email = email;
//        this.password = password;
//        this.photo = photo;
//        this.street = street;
//        this.city = city;
//        this.birthdate = birthdate;
//        this.userRole = userRole;
//        this.orders = orders;
//        this.potentialOrders = potentialOrders;
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
//    public String getFirstName() {
//        return this.firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return this.lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPhone() {
//        return this.phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getEmail() {
//        return this.email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return this.password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhoto() {
//        return this.photo;
//    }
//
//    public void setPhoto(String photo) {
//        this.photo = photo;
//    }
//
//    public String getStreet() {
//        return this.street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getCity() {
//        return this.city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public Date getBirthdate() {
//        return this.birthdate;
//    }
//
//    public void setBirthdate(Date birthdate) {
//        this.birthdate = birthdate;
//    }
//
//    public Role getUserRole() {
//        return this.userRole;
//    }
//
//    public void setUserRole(Role userRole) {
//        this.userRole = userRole;
//    }
//
//    public Set<Order> getOrders() {
//        return this.orders;
//    }
//
//    public void setOrders(Set<Order> orders) {
//        this.orders = orders;
//    }
//
//    public Set<PotentialOrders> getPotentialOrders() {
//        return this.potentialOrders;
//    }
//
//    public void setPotentialOrders(Set<PotentialOrders> potentialOrders) {
//        this.potentialOrders = potentialOrders;
//    }
//
//
//}
//
//
