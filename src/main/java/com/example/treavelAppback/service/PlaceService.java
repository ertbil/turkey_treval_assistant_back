package com.example.treavelAppback.service;

import com.example.treavelAppback.model.Place;
import com.example.treavelAppback.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    public boolean addNewPlace(Place place) {

        placeRepository.findPlaceByName(place.getName())

                .ifPresentOrElse(
                        (s) -> {
                            throw new IllegalStateException("id taken");


                        }, // if present
                        () -> {
                            placeRepository.save(place);

                        }
                );
        return true;
    }

    public boolean deletePlace(Long placeId) {
        boolean exists = placeRepository.existsById(placeId);
        if (!exists) {
            throw new IllegalStateException("place with id " + placeId + " does not exist");
        }
        placeRepository.deleteById(placeId);
        return true;
    }


    public boolean updatePlace(Long placeId, Place updatedPlace) {
        boolean exists = placeRepository.existsById(placeId);

        if (!exists) {
            throw new IllegalStateException("place with id " + placeId + " does not exist");

        }
        placeRepository.findById(placeId)
                .ifPresentOrElse(
                        (place) -> {
                            place.setName(updatedPlace.getName());
                            place.setCity(updatedPlace.getCity());
                            place.setAddress(updatedPlace.getAddress());
                            place.setType(updatedPlace.getType());
                            place.setName(updatedPlace.getName());
                            place.setTourismType(updatedPlace.getTourismType());
                            place.setDescription(updatedPlace.getDescription());
                            place.setImageURL(updatedPlace.getImageURL());
                            place.setDirections(updatedPlace.getDirections());

                        },
                        () -> {
                            throw new IllegalStateException("place with id " + placeId + " does not exist");
                        }
                );

        return true;


    }

    public Optional<Place> getPlaceById(Long placeId) {
        boolean exists = placeRepository.existsById(placeId);
        if (!exists) {
            throw new IllegalStateException("place with id " + placeId + " does not exist");
        }
        return placeRepository.findById(placeId);

    }
}