package com.example.treavelAppback.repository;


import com.example.treavelAppback.model.db_models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/***
 burada yazılan interface JPA repository interface'inin yetmediği özel sorguları gerçekleştirmek için vardır.


 ***/
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("SELECT p FROM Place p WHERE p.name = ?1")
    Optional<Place> findPlaceByName(String name);


}