package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sevak on 7/30/17.
 */
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserProfile userProfile;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
