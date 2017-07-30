package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by sevak on 7/30/17.
 */
@Entity
@Table(name = "WORKERS")
public class Worker {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_PROFILE_ID")
    private Long userProfileId;

    @OneToOne
    private Location location;

//    private Set<Skill> skills;

//    private Set<Photo> photos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
