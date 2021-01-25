package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.entity.ShoppingCart;
import tn.esprit.spring.DAO.repository.ShoppingCartRepo;

@Service
public class ShoppingCartImp implements ShoppingCartInterface<ShoppingCart> {
    @Autowired
    private ShoppingCartRepo scR;


    @Override
    public ShoppingCart save(ShoppingCart t) {
       return scR.save(t);
    }

    @Override
    public ShoppingCart getLatestSC(ShoppingCart shoppingCart) {
        return scR.getLastCart(shoppingCart.getUserID().getUserid());
    }
   
    
}
