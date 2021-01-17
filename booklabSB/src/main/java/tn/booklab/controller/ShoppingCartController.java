package tn.booklab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.booklab.entities.ShoppingCart;
import tn.booklab.services.ShoppingCartImp;


@RestController
@RequestMapping("/SCC")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartImp serviceSC;

    @GetMapping("/welcome")
    public String start() {
        return "WELCOMMME!";
    }

    @PostMapping("/addSC")
    public ShoppingCart addShoppingCart(@RequestBody ShoppingCart SC){
        return serviceSC.save(SC);
    }

    @PostMapping("/getLatestSC") // BUGS OUT
    public ShoppingCart getLatestSC(@RequestBody ShoppingCart SC) {
        return serviceSC.getLatestSC(SC);
    }
}