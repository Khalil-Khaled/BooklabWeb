package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.Payment_Card;
import tn.esprit.spring.DAO.entity.ShoppingCart;
import tn.esprit.spring.services.ShoppingCartImp;


@RestController
@RequestMapping("/SCC")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartImp serviceSC;

    @PostMapping("/addSC")
    public ShoppingCart addShoppingCart(@RequestBody ShoppingCart SC){
        return serviceSC.save(SC);
    }

    @PostMapping("/removeSC")
    public ShoppingCart removeShoppingCart(@RequestBody ShoppingCart SC){
        serviceSC.delete(SC);
        return SC;
    }

    @PostMapping("/getLatestSC") // BUGS OUT
    public ShoppingCart getLatestSC(@RequestBody ShoppingCart SC) {
        return serviceSC.getLatestSC(SC.getUserID().getUserid());
    }

    @PostMapping("/pay")
    public int pay(@RequestBody Payment_Card card){
        return serviceSC.pay(card);
    }

    //NOT TESTED
    @GetMapping("/getTotal/{cartID}")
    double calculateTotal(@Param("cartID") int cartID){
        return serviceSC.calculateTotal(cartID);
    }
}