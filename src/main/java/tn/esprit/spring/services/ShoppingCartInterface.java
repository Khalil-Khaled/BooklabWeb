package tn.esprit.spring.services;


import tn.esprit.spring.DAO.entity.Payment_Card;
import tn.esprit.spring.DAO.entity.ShoppingCart;

public interface ShoppingCartInterface<T>{
    T save(T t);
    ShoppingCart getLatestSC(int userID);
    void delete(T t);
    int pay(Payment_Card card);
    double calculateTotal(int cartID);

}
