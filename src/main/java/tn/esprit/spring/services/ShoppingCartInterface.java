package tn.esprit.spring.services;


import tn.esprit.spring.DAO.entity.ShoppingCart;

public interface ShoppingCartInterface<T>{
    public T save(T t);
    public ShoppingCart getLatestSC(T t);
   
}
