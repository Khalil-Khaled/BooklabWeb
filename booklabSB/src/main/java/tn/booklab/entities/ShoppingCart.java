package tn.booklab.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
public class ShoppingCart implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartID;

    @ManyToOne
    private User userID;

    @Temporal (TemporalType.DATE)
    private Date creationDate;

    public ShoppingCart() {
    }

    public ShoppingCart(int cartID, User userID, Date creationDate) {
        this.cartID = cartID;
        this.userID = userID;
        this.creationDate = creationDate;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return cartID == that.cartID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartID);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartID=" + cartID +
                ", userID=" + userID +
                ", creationDate=" + creationDate +
                '}';
    }
}