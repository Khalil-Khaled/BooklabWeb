package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.entity.Geolocalisation;
import tn.esprit.spring.DAO.entity.User;
import tn.esprit.spring.DAO.repository.GeolocalisationRepo;

@Service
public class GeolocalisationImp implements GeolocalisationInterface<Geolocalisation> {
    @Autowired
    private GeolocalisationRepo repo;

    @Override
    public Geolocalisation save(Geolocalisation geolocalisation) {
         repo.save(geolocalisation);
        return geolocalisation;
    }

    @Override
    public void delete(Geolocalisation geolocalisation) {
        repo.delete(geolocalisation);
    }


    @Override
    public Geolocalisation getGeoLocation(User user) {
        return repo.getLocation(user);
    }


    @Override
    public double getDistance(Geolocalisation geolocalisation1, Geolocalisation geolocalisation2) {
        double lat1 = geolocalisation1.getLatitude();
        double lon1 = geolocalisation1.getLongitude();

        double lat2 = geolocalisation2.getLatitude();
        double lon2 = geolocalisation2.getLongitude();


        int R = 6371; // Radius of the earth in km
        double dLat = deg2rad(lat2-lat1);  // deg2rad below
        double dLon = deg2rad(lon2-lon1);
        double a =
                Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon/2) * Math.sin(dLon/2)
                ;
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c; // Distance in km
        return d;
    }

    public double deg2rad(double deg) {
        return deg * (Math.PI/180);
    }


}
