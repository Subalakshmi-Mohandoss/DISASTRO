package com.example.disastrospringboot;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class FormsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;
    private String rescueLocation;
    private String district;
    private String pinCode;
    private int peopleCount;
    private String severity;
    private String disasterType;
    private String latitude;
    private String longitude;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "gid")
    private List<Good> goods;

    // Constructors
    public FormsModel() {
    }

    public FormsModel(Long id, String name, String contact, String rescueLocation, String district, String pinCode,
            int peopleCount,
            String severity, String disasterType, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.rescueLocation = rescueLocation;
        this.district = district;
        this.pinCode = pinCode;
        this.peopleCount = peopleCount;
        this.severity = severity;
        this.disasterType = disasterType;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }
}
