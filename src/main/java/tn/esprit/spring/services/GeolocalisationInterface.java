package tn.esprit.spring.services;


import tn.esprit.spring.DAO.entity.Geolocalisation;
import tn.esprit.spring.DAO.entity.User;

public interface GeolocalisationInterface<T> {
    public T save(T t);
    public void delete(T t);
    Geolocalisation getGeoLocation(User userid);
    double getDistance(T t1, T t2);
}
