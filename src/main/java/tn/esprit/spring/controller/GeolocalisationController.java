package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.Geolocalisation;
import tn.esprit.spring.services.GeolocalisationImp;

import javax.websocket.server.PathParam;

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

    @GetMapping("/getLocation/{userID}")
    public Geolocalisation getLocation(@PathParam("userID") int user){
        return serviceGeo.getGeoLocation(user);
    }

    @GetMapping("/getLocation/{userID1}/{userID2}")
    public double getLocation(@PathParam("userID1") int user1, @PathParam("userID2") int user2){
        Geolocalisation g1 = serviceGeo.getGeoLocation(user1);
        Geolocalisation g2 =serviceGeo.getGeoLocation(user2);

        return serviceGeo.getDistance(g1, g2);
    }



}
