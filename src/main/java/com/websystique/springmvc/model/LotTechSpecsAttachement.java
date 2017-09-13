package com.websystique.springmvc.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.UUID;

public class LotTechSpecsAttachement implements Serializable {
    
    private UUID id;
    private UUID lotId;
    private String type;
    private byte[] content;
    
    public UUID getId() {
        return this.id;
    }
    
    public void setId(UUID newValue) {
        this.id = newValue;
    }
    
    public UUID getLotId() {
        return this.lotId;
    }
    
    public void setLotId(UUID newValue) {
        this.lotId = newValue;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String newValue) {
        this.type = newValue;
    }
    
    public byte[] getContent() {
        return this.content;
    }
    
    public void setContent(byte[] newValue) {
        this.content = newValue;
    }
}

