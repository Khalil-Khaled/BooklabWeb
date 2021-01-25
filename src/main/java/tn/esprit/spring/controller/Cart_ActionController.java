package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.Cart_Action;
import tn.esprit.spring.services.Cart_ActionImp;

import java.util.ArrayList;


@RestController
@RequestMapping("/CAC")
public class Cart_ActionController {
    @Autowired
    private Cart_ActionImp caService;

    @PostMapping("/addItemToCart")
    public Cart_Action addShoppingCart(@RequestBody Cart_Action ca){
        return caService.save(ca);
    }

    @PostMapping("/deleteItemFromCart")
    public void deleteItemFromCart(@RequestBody Cart_Action ca){
        caService.delete(ca);
    }

    @GetMapping("/getAllItemsFromCart/{cartID}")
    ArrayList<Cart_Action> all(@PathVariable int cartID) {
        return caService.getItemsByCartId(cartID);
    }




}