package com.websystique.springmvc.model;

import javax.persistence.*;

/**
 * Created by sevak on 7/30/17.
 */
@Entity
@Table(name = "SKILL_CATEGORY")
public class SkillCategory {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "PARENT_ID")
    private  Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
