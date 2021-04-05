package gov.iti.jets.team5.models.dto;

import gov.iti.jets.team5.models.dbEntities.PotentialOrders;
import gov.iti.jets.team5.models.dbEntities.UserData;

import java.util.Date;

public class OrderDetailsDto {
    private int id;
    private Date orderDate;
    private long total;

    public OrderDetailsDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
