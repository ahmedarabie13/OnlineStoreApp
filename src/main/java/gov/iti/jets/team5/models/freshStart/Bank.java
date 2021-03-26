//package gov.iti.jets.team5.models.freshStart;
//// Generated 23 Mar 2021, 23:39:24 by Hibernate Tools 6.0.0.Alpha2
//
//
//import javax.persistence.*;
//
///**
// * Bank generated by hbm2java
// */
//@Entity
//@Table(name = "bank"
//        , catalog = "ECommerceApp"
//        , uniqueConstraints = @UniqueConstraint(columnNames = "creditNumber")
//)
//public class Bank implements java.io.Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", unique = true, nullable = false)
//    private int id;
//
//    @Column(name = "creditNumber", unique = true, nullable = false, length = 16)
//    private String creditNumber;
//
//    @Column(name = "cvv", nullable = false, length = 3)
//    private String cvv;
//
//    @Column(name = "balance", precision = 10, scale = 2)
//    private long balance;
//
//    public Bank() {}
//
//
//    public Bank(int id, String creditNumber, String cvv) {
//        this.id = id;
//        this.creditNumber = creditNumber;
//        this.cvv = cvv;
//    }
//
//    public Bank(int id, String creditNumber, String cvv, Long balance) {
//        this.id = id;
//        this.creditNumber = creditNumber;
//        this.cvv = cvv;
//        this.balance = balance;
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
//    public String getCreditNumber() {
//        return this.creditNumber;
//    }
//
//    public void setCreditNumber(String creditNumber) {
//        this.creditNumber = creditNumber;
//    }
//
//    public String getCvv() {
//        return this.cvv;
//    }
//
//    public void setCvv(String cvv) {
//        this.cvv = cvv;
//    }
//
//    public Long getBalance() {
//        return this.balance;
//    }
//
//    public void setBalance(Long balance) {
//        this.balance = balance;
//    }
//
//}
//
//