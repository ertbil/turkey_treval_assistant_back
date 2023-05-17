package com.example.treavelAppback.service;

import com.example.treavelAppback.model.Place;
import com.example.treavelAppback.repository.PlaceRepository;
import com.example.treavelAppback.strings.ErrorInfo;
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
                            throw new IllegalStateException(ErrorInfo.idTaken);


                        }, // if present
                        () -> placeRepository.save(place)
                );
        return true;
    }

    public boolean deletePlace(Long placeId) {
        boolean exists = placeRepository.existsById(placeId);
        if (!exists) {
            throw new IllegalStateException(ErrorInfo.placeDoesNotExist(placeId.toString()));
        }
        placeRepository.deleteById(placeId);
        return true;
    }


    public boolean updatePlace(Long placeId, Place updatedPlace) {
        boolean exists = placeRepository.existsById(placeId);

        if (!exists) {
            throw new IllegalStateException(ErrorInfo.placeDoesNotExist(placeId.toString()));

        }
        placeRepository.findById(placeId)
                .ifPresentOrElse(
                        (Place place) -> {
                           place.update(updatedPlace);
                            placeRepository.save(place);

                        },
                        () -> {
                            throw new IllegalStateException(ErrorInfo.placeDoesNotExist(placeId.toString()));
                        }
                );

        return true;


    }

    public Optional<Place> getPlaceById(Long placeId) {
        boolean exists = placeRepository.existsById(placeId);
        if (!exists) {
            throw new IllegalStateException(ErrorInfo.placeDoesNotExist(placeId.toString()));
        }
        return placeRepository.findById(placeId);

    }
}