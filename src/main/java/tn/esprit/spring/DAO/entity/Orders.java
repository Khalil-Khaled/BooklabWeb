package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Orders implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @OneToOne
    private ShoppingCart cartID;


    private boolean orderStatus;


    @Temporal (TemporalType.DATE)
    private Date orderDate;


    private String orderRef;

    public Orders(){}
    public Orders(int orderID, ShoppingCart cartID, boolean orderStatus, Date orderDate, String orderRef) {
        this.orderID = orderID;
        this.cartID = cartID;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.orderRef = orderRef;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public ShoppingCart getCartID() {
        return cartID;
    }

    public void setCartID(ShoppingCart cartID) {
        this.cartID = cartID;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders order = (Orders) o;
        return orderID == order.orderID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", cartID=" + cartID +
                ", orderStatus=" + orderStatus +
                ", orderDate=" + orderDate +
                ", orderRef='" + orderRef + '\'' +
                '}';
    }
}