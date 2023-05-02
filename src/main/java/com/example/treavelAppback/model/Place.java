package com.example.treavelAppback.model;

import jakarta.persistence.*;

@Entity
@Table
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTourismType() {
        return tourismType;
    }

    public void setTourismType(String tourismType) {
        this.tourismType = tourismType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
}
