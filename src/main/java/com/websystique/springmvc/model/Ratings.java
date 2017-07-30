package com.websystique.springmvc.model;

import javax.persistence.*;

/**
 * Created by sevak on 7/30/17.
 */
@Entity
@Table(name = "RATINGS")
public class Ratings {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_PROFILE_ID")
    private Long userProfileId;

    @Column(name = "RATING")
    private Integer rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }


    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }
}
