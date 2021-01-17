package tn.booklab.services;


import tn.booklab.entities.ShoppingCart;

public interface ShoppingCartInterface<T>{
    public T save(T t);
    public ShoppingCart getLatestSC(T t);

}
