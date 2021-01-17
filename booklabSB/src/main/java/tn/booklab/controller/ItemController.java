package tn.booklab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.booklab.entities.Item;
import tn.booklab.repository.ItemRepo;

@RestController
@RequestMapping("/IC")
public class ItemController {

    @Autowired
    private ItemRepo service;

    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item){
        return service.save(item);
    }
}
