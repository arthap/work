package com.websystique.springmvc.model;

import com.websystique.springmvc.model.enums.LotFailedLawPoint;
import com.websystique.springmvc.model.enums.LotState;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class Lot implements Serializable {

    private UUID id;
    private UUID tenderId;
    private String name;
    private LotState state;
    private Double quantity;
    private Double quantityTotal;
    private Integer number;
    private String winner;
    private String briefDescription;
    private String briefDescriptionPerContract;
    private String basisForSelecting;
    private LotFailedLawPoint basisForRejection;
    private String techSpec;
    private Timestamp dateInvitationPublication;
    private String lotName;
    
    public UUID getId() {
        return this.id;
    }
    
    public void setId(UUID newValue) {
        this.id = newValue;
    }

    public UUID getTenderId() {
        return this.tenderId;
    }
    
    public void setTenderId(UUID newValue) {
        this.tenderId = newValue;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String newValue) {
        this.name = newValue;
    }
    
    public LotState getState() {
        return this.state;
    }
    
    public void setState(LotState newValue) {
        this.state = newValue;
    }
    
    public Double getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Double newValue) {
        this.quantity = newValue;
    }
    
    public Double getQuantityTotal() {
        return this.quantityTotal;
    }
    
    public void setQuantityTotal(Double newValue) {
        this.quantityTotal = newValue;
    }
    
    public Integer getNumber() {
        return this.number;
    }
    
    public void setNumber(Integer newValue) {
        this.number = newValue;
    }
    
    public String getWinner() {
        return this.winner;
    }
    
    public void setWinner(String newValue) {
        this.winner = newValue;
    }
    
    public String getBriefDescription() {
        return this.briefDescription;
    }
    
    public void setBriefDescription(String newValue) {
        this.briefDescription = newValue;
    }
    
    public String getBriefDescriptionPerContract() {
        return this.briefDescriptionPerContract;
    }
    
    public void setBriefDescriptionPerContract(String newValue) {
        this.briefDescriptionPerContract = newValue;
    }
    
    public String getBasisForSelecting() {
        return this.basisForSelecting;
    }
    
    public void setBasisForSelecting(String newValue) {
        this.basisForSelecting = newValue;
    }
    
    public LotFailedLawPoint getBasisForRejection() {
        return this.basisForRejection;
    }
    
    public void setBasisForRejection(LotFailedLawPoint newValue) {
        this.basisForRejection = newValue;
    }
    
    public String getTechSpec() {
        return this.techSpec;
    }
    
    public void setTechSpec(String newValue) {
        this.techSpec = newValue;
    }
    
    public Timestamp getDateInvitationPublication() {
        return this.dateInvitationPublication;
    }
    
    public void setDateInvitationPublication(Timestamp newValue) {
        this.dateInvitationPublication = newValue;
    }
    
    public String getLotName() {
        return this.lotName;
    }
    
    public void setLotName(String newValue) {
        this.lotName = newValue;
    }
}

