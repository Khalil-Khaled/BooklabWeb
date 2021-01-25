package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.ShoppingCart;
import tn.esprit.spring.services.ShoppingCartImp;


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