package tn.esprit.spring.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.entity.Geolocalisation;

@Repository
public interface GeolocalisationRepo extends JpaRepository<Geolocalisation, Integer> {
    @Query(value = "SELECT * FROM Geolocalisation where id = (SELECT max(id) FROM Geolocalisation where user = :userid)", nativeQuery = true)
    Geolocalisation getLocation(@Param("userid") int UserID);
}
