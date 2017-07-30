package com.websystique.springmvc.model;

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

    @Enumerated
    @Column(name = "COUNTRY")
    private Country country;

    @Enumerated
    @Column(name = "REGION")
    private Region region;

    @Column(name = "ADDRESS")
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
