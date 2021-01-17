package tn.booklab.services;

import tn.booklab.entities.Cart_Action;

import java.util.ArrayList;

public interface Cart_ActionInterface<T> {
    public T save(T t);  
    public void delete(T t);
    public void update(T t);
    public ArrayList<Cart_Action> getItemsByCartId(int cartID);


}
