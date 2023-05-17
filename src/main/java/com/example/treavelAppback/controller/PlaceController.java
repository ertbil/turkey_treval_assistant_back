package com.example.treavelAppback.controller;

import com.example.treavelAppback.model.Place;
import com.example.treavelAppback.model.ResponseDto;
import com.example.treavelAppback.service.PlaceService;
import com.example.treavelAppback.consts.strings.PathVariables;
import com.example.treavelAppback.consts.strings.Paths;
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
    public ResponseEntity<ResponseDto<List<Place>>> getPlaces() {
        try {
            List<Place> places = placeService.getPlaces();
            return ResponseEntity.ok().body(new ResponseDto<> (places));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(ex.getMessage()));
        }
    }

    @GetMapping(path = Paths.placeID)
    public ResponseEntity<ResponseDto<Optional<Place>>> getPlaceById(@PathVariable(PathVariables.placeId) Long placeId) {
        try {
            Optional<Place> place = placeService.getPlaceById(placeId);
            return ResponseEntity.ok().body(new ResponseDto<>(place));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(false, null, ex.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ResponseDto<Place>> addNewPlace(@RequestBody Place place) {
        try {
            placeService.addNewPlace(place);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto<>(true, place, null));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(false, null, ex.getMessage()));
        }
    }

    @DeleteMapping(path = Paths.placeID)
    public ResponseEntity<ResponseDto<Void>> deletePlace(@PathVariable(PathVariables.placeId) Long placeId) {
        try {
            placeService.deletePlace(placeId);
            return ResponseEntity.ok().body(new ResponseDto<>(true, null, null));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(false, null, ex.getMessage()));
        }
    }


}






