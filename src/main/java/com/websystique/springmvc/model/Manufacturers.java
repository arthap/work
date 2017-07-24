package com.websystique.springmvc.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;


@Entity
@Table(name="ey_manufacturers")
public class Manufacturers {

    @Id
    @Column(name = "MANUFACTURER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "CONTACT_PERSON", nullable = false)
    private String contactPerson;

    @Column(name = "CONTACT_EMAIL", nullable = false)
    private String contactEmail;

    @Column(name = "CONTACT_PHONE", nullable = false)
    private String contactPhone;

    @Column(name = "URL", nullable = false)
    private String url;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @NotNull
    @Column(name = "CREATED_AT", nullable = false)
    @Type(type="timestamp")
    private Data createdAt;

    @NotNull
    @Column(name = "UPDATE_AT", nullable = false)
    @Type(type="timestamp")
    private Data updateAt;

    public Manufacturers() {
    }

    public Manufacturers(Data updateAt, String name, String address, String contactPerson, String contactEmail, String contactPhone, String url, String status, Data createdAt) {
        this.updateAt = updateAt;
        this.name = name;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.url = url;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Data getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Data updateAt) {
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Data createdAt) {
        this.createdAt = createdAt;
    }
}
