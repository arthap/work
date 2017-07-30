package com.websystique.springmvc.model;

import com.websystique.springmvc.model.enums.Country;
import com.websystique.springmvc.model.enums.Region;

import javax.persistence.*;

/**
 * Created by sevak on 7/30/17.
 */
@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "COUNTRY", nullable = false)
    private Country country;

    @Enumerated(EnumType.STRING)
    @Column(name = "REGION",nullable = false)
    private Region region;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
