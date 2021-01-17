package tn.booklab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.booklab.entities.Cart_Action;
import tn.booklab.repository.Cart_ActionRepo;
import tn.booklab.services.Cart_ActionImp;

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