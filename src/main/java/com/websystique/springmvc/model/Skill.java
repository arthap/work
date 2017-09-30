package com.websystique.springmvc.model;

import javax.persistence.*;
/**
 * Created by sevak on 7/30/17.
 */
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "skill_name")
    private String skillName;

    @Column( name = "skill_category_id", nullable = false)
    private Long skillCategoryId;

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

    public Long getSkillCategoryId() {
        return skillCategoryId;
    }

    public void setSkillCategoryId(Long skillCategoryId) {
        this.skillCategoryId = skillCategoryId;
    }
}
