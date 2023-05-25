package com.example.treavelAppback.controller;

import com.example.treavelAppback.consts.strings.PathVariables;
import com.example.treavelAppback.consts.strings.Paths;
import com.example.treavelAppback.model.db_models.Place;
import com.example.treavelAppback.model.response_models.ResponseDao;
import com.example.treavelAppback.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = Paths.placesPath)
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("")
    public ResponseEntity<ResponseDao<List<Place>>> getPlaces() {
        try {
            List<Place> places = placeService.getPlaces();
            return ResponseEntity.ok().body(new ResponseDao<>(places));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDao<>(ex.getMessage()));
        }
    }

    @GetMapping(path = Paths.placeID)
    public ResponseEntity<ResponseDao<Optional<Place>>> getPlaceById(@PathVariable(PathVariables.placeId) Long placeId) {
        try {
            Optional<Place> place = placeService.getPlaceById(placeId);
            return ResponseEntity.ok().body(new ResponseDao<>(place));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDao<>(ex.getMessage()));
        }
    }

    @PostMapping("")
    public ResponseEntity<ResponseDao<Place>> addNewPlace(@RequestBody Place place) {
        try {
            placeService.addNewPlace(place);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDao<>(place));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDao<>(ex.getMessage()));
        }
    }

    @DeleteMapping(path = Paths.placeID)
    public ResponseEntity<ResponseDao<Void>> deletePlace(@PathVariable(PathVariables.placeId) Long placeId) {
        try {
            placeService.deletePlace(placeId);
            return ResponseEntity.ok().body(new ResponseDao<>(true, null, null));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDao<>(ex.getMessage()));
        }
    }


}






