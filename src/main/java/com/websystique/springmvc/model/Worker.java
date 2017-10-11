package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by sevak on 7/30/17.
 */
@Entity
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private UserProfile userProfile;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Location location;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "worker_skills", joinColumns = {
            @JoinColumn(name = "worker_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "skill_id",
                    nullable = false, updatable = false)})
    private Set<Skill> skills;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    private Set<Photo> photos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    private Set<Ratings> ratings;

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

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }
}
