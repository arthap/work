package com.websystique.springmvc.model;

import javax.persistence.*;

/**
 * Created by sevak on 7/30/17.
 */
@Entity
@Table(name = "SKILLS")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "SKILL_NAME")
    private String skillName;

//    private SkillCategory skillCategory;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
