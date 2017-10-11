package com.websystique.springmvc.model;

import javax.persistence.*;

/**
 * Created by sevak on 7/30/17.
 */
@Entity
@Table(name = "ratings")
public class Ratings {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_profile_id")
    private Long userProfileId;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "worker_id")
    private Long workerId;

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

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
}
