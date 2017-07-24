package com.websystique.springmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by asargsyan on 1/31/17.
 */

@Entity
@Table(name="CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name="CATEGORY_NAME", nullable=false)
    private String categoryName;

    @NotEmpty
    @Column(name="CATEGORY_TYPE", nullable=false)
    private String type;


    @NotEmpty
    @Column(name="PARENT_CATEGORY", nullable=false)
    private String parenCategory;


    @ManyToOne( cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "parent_category_id", nullable = false)
    private ParentCategory parentCategory;

    public Category() {
    }

    public Category(String categoryName, String type, String parenCategory) {
        this.categoryName = categoryName;
        this.type = type;
        this.parenCategory = parenCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParenCategoryObj() {
        return parenCategory;
    }

    public void setParenCategory(String parenCategory) {
        this.parenCategory = parenCategory;
    }

    public ParentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }
}
