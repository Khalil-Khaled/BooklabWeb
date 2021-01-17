package tn.booklab.entities;

import java.io.Serializable;

import javax.persistence.*;
import tn.booklab.entities.Item;

@Entity
public class Cart_Action implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actionID;

    @OneToOne
    @JoinColumn(nullable = false)
    private Item itemID;

    @Column
    private int amount;
    
    @ManyToOne
    ShoppingCart cartID;

    public Cart_Action() {}

    public Cart_Action(int actionID, Item itemID, int amount, ShoppingCart sc) {
        this.actionID = actionID;
        this.itemID = itemID;
        this.amount = amount;
        this.cartID = cartID;
    }

    public Item getItemID() {
        return itemID;
    }

    public void setItemID(Item itemID) {
        this.itemID = itemID;
    }

    public ShoppingCart getCartID() {
        return cartID;
    }

    public void setCartID(ShoppingCart cartID) {
        this.cartID = cartID;
    }

    public int getActionID() {
        return actionID;
    }

    public void setActionID(int actionID) {
        this.actionID = actionID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ShoppingCart getSc() {
        return cartID;
    }

    public void setSc(ShoppingCart cartID) {
        this.cartID = cartID;
    }




}
