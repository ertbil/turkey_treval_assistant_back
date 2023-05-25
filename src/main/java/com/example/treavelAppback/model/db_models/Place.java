package com.example.treavelAppback.model.db_models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Place {

    @Id
    @SequenceGenerator(name = "place_sequence",
            sequenceName = "place_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "place_sequence")
    private Long id;
    private String name;
    private String city;
    private String type;
    private String tourismType;
    @Column(length = 1000)
    private String description;
    @Column(length = 1000)
    private String imageURL;
    private String address;
    private String directions;

    public Place() {
    }

    @Override
    public String toString() {
        return "Place {" +
                "id="+ id +
                ", name=" + name + '\'' +
                ", city=" + city + '\'' +
                ", type=" + type + '\'' +
                ", tourismType=" + tourismType + '\'' +
                ", description=" + description + '\'' +
                ", imageURL=" + imageURL + '\'' +
                ", address=" + address + '\'' +
                ", directions=" + directions + '\'' +
                '}';
    }

    public Place(Long id, String name, String city, String type, String tourismType, String description, String imageURL, String address, String directions) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.type = type;
        this.tourismType = tourismType;
        this.description = description;
        this.imageURL = imageURL;
        this.address = address;
        this.directions = directions;
    }
    public Place(String name, String city, String type, String tourismType, String description, String imageURL, String address, String directions) {
        this.name = name;
        this.city = city;
        this.type = type;
        this.tourismType = tourismType;
        this.description = description;
        this.imageURL = imageURL;
        this.address = address;
        this.directions = directions;
    }

    public void update(Place place) {

        //TODO object. assign araştır
        //TODO sadece isim değişimi olsa ne olacak
        this.name = place.name;
        this.city = place.city;
        this.type = place.type;
        this.tourismType = place.tourismType;
        this.description = place.description;
        this.imageURL = place.imageURL;
        this.address = place.address;
        this.directions = place.directions;
    }


}
