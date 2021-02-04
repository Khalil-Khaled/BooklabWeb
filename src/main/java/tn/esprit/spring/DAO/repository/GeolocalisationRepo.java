package tn.esprit.spring.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.entity.Geolocalisation;
import tn.esprit.spring.DAO.entity.User;

@Repository
public interface GeolocalisationRepo extends JpaRepository<Geolocalisation, Integer> {
    @Query(value = "SELECT g FROM Geolocalisation g where g.id = (SELECT max(gg.id) FROM Geolocalisation gg where gg.user = :userid)")
    Geolocalisation getLocation(@Param("userid") User UserID);
}
