package com.websystique.springmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asargsyan on 1/31/17.
 */

@Entity
@Table(name="PARENT_CATEGORY")
public class ParentCategory {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty
    @Column(name="NAME", nullable=false)
    private String Name;

    @NotEmpty
    @Column(name="TYPE",nullable=false)
    private  String Type;



    public ParentCategory() {
    }

    public ParentCategory(String name, String type) {
        Name = name;
        Type = type;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }


}

