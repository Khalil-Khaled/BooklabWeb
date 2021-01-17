package tn.booklab.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tn.booklab.entities.Cart_Action;
import tn.booklab.repository.Cart_ActionRepo;

import java.util.ArrayList;

@Service
public class Cart_ActionImp implements Cart_ActionInterface<Cart_Action> {
    @Autowired
    private Cart_ActionRepo ca;

    @Override
    public Cart_Action save(Cart_Action t) {
        return ca.save(t);
    }

    @Override
    public void delete(Cart_Action t) {
        ca.delete(t.getItemID().getId(), t.getCartID().getCartID());
    }

    @Override
    public void update(Cart_Action t) {
        //ca.save(t);
    }

    public ArrayList<Cart_Action> getItemsByCartId(int cartID){
        return ca.getItemsFromCart(cartID);
    }


}
