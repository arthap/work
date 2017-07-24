package com.websystique.springmvc.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;

/**
 * Created by asargsyan on 2/2/17.
 */
@Entity
@Table(name="ey_users")
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "USERNAME", nullable = false)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "SOURCE", nullable = false)
    private int sourceCode;

    @Column(name = "EULA_ACCEPTED", nullable = false)
    private String eulaAccepted;

    @NotNull
    @Column(name = "LAST_LOGIN", nullable = false)
    @Type(type="timestamp")
    private Data lastLogin;


    @Column(name = "USER_TYPE", nullable = false)
    private int  userType;

//    @JoinColumn(name = "Id")
//    @Column(name = "MANUFACTURER_ID", nullable = false)
//    private long manufacturerId;

    @Column(name = "EMAIL", nullable = false)
    private  String eMail;

    @Column(name = "AVATAR", nullable = false)
    private String avatar;

    @Column(name = "TOKEN", nullable = false)
    private String token;

    @Column(name = "CURRENT_RATE", nullable = false)
    private String currentRate;


    @NotNull
    @Column(name = "CREATED_AT", nullable = false)
    @Type(type="timestamp")
    private Data createdAt;
    @NotNull
    @Column(name = "UPDATE_AT", nullable = false)
    @Type(type="timestamp")
    private Data updateAt;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "manufacturer_id")
    private Manufacturers manufacturers;

    public Users() {
    }


    public Users(String userName, String password, int sourceCode, String eulaAccepted, Data lastLogin, int userType, long manufacturerId, String eMail, String avatar, String token, String currentRate, Data createdAt, Data updateAt) {
        this.userName = userName;
        this.password = password;
        this.sourceCode = sourceCode;
        this.eulaAccepted = eulaAccepted;
        this.lastLogin = lastLogin;
        this.userType = userType;
//        this.manufacturerId = manufacturerId;
        this.eMail = eMail;
        this.avatar = avatar;
        this.token = token;
        this.currentRate = currentRate;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(int sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getEulaAccepted() {
        return eulaAccepted;
    }

    public void setEulaAccepted(String eulaAccepted) {
        this.eulaAccepted = eulaAccepted;
    }

    public Data getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Data lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

//    public long getManufacturerId() {
//        return manufacturerId;
//    }
//
//    public void setManufacturerId(long manufacturerId) {
//        this.manufacturerId = manufacturerId;
//    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(String currentRate) {
        this.currentRate = currentRate;
    }

    public Data getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Data createdAt) {
        this.createdAt = createdAt;
    }

    public Data getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Data updateAt) {
        this.updateAt = updateAt;
    }
}
