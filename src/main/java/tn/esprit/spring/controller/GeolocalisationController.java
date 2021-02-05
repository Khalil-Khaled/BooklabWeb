package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.Geolocalisation;
import tn.esprit.spring.DAO.entity.User;
import tn.esprit.spring.services.GeolocalisationImp;



@RestController
@RequestMapping("/loc")
public class GeolocalisationController {

    @Autowired
    private GeolocalisationImp serviceGeo;

    @PostMapping("/add")
    public Geolocalisation addGeo(@RequestBody Geolocalisation geolocalisation){
        return serviceGeo.save(geolocalisation);
    }

    @PostMapping("/delete")
    public void deleteGeo(@RequestBody Geolocalisation geolocalisation){
        serviceGeo.delete(geolocalisation);
    }

    @PostMapping("/getLocation")
    public Geolocalisation getLocation(@RequestBody User user){
        return serviceGeo.getGeoLocation(user);
    }

    @GetMapping("/getDistance/{userID1}/{userID2}")
    public double getLocation(@PathVariable("userID1") int user1v, @PathVariable("userID2") int user2v){

        User user1 = new User();
        User user2= new User();
        user1.setUserid(user1v);
        user2.setUserid(user2v);
        Geolocalisation g1 = serviceGeo.getGeoLocation(user1);
        Geolocalisation g2 =serviceGeo.getGeoLocation(user2);

        return serviceGeo.getDistance(g1, g2);
    }



}

