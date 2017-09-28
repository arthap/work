package com.websystique.springmvc.model;

import com.websystique.springmvc.model.enums.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class Tender implements Serializable {
    
    private UUID id;
    private UUID authorityId;
    private String number;
    private String title;
    private String description;
    private String userName;
    private String code;
    private Integer parentCftId;
    private Integer parentLotName;
    private TenderState state;
    private TenderEvaluationType evaluation;
    private TenderProcedureType procedure;
    private TenderLottingType lotting;
    private ProcurementType procuremnetType;
    private Double estimatedValue;
    private Timestamp dateSubmitted;
    private Timestamp startedAt;
    private Timestamp deadline;
    private Timestamp dateCfTAmend;
    private Timestamp dateQuestionReceived;
    private Timestamp dateClarificationProvided;
    private Timestamp dateStandstillBegin;
    private Timestamp dateStandstillEnd;
    private String otherInfoLotsFailure;
    private String infoPublicAnnounce;
    private String unlawfulActs;
    private String appealsFiled;
    private String otherRelevantInfo;
    private String contractingAuthority;
    private String tendersForLots;
    private Integer awardinLots;
    private Integer numberOfLots;
    
    public UUID getId() {
        return this.id;
    }
    
    public void setId(UUID newValue) {
        this.id = newValue;
    }
    
    public UUID getAuthorityId() {
        return this.authorityId;
    }
    
    public void setAuthorityId(UUID newValue) {
        this.authorityId = newValue;
    }
    
    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String newValue) {
        this.number = newValue;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String newValue) {
        this.title = newValue;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String newValue) {
        this.description = newValue;
    }
    
    public String getArmepsUserName() {
        return this.userName;
    }
    
    public void setArmepsUserName(String newValue) {
        this.userName = newValue;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String newValue) {
        this.code = newValue;
    }
    
    public Integer getParentCftId() {
        return this.parentCftId;
    }
    
    public void setParentCftId(Integer newValue) {
        this.parentCftId = newValue;
    }
    
    public Integer getParentLotName() {
        return this.parentLotName;
    }
    
    public void setParentLotName(Integer newValue) {
        this.parentLotName = newValue;
    }
    
    public TenderState getState() {
        return this.state;
    }
    
    public void setState(TenderState newValue) {
        this.state = newValue;
    }
    
    public TenderEvaluationType getEvaluation() {
        return this.evaluation;
    }
    
    public void setEvaluation(TenderEvaluationType newValue) {
        this.evaluation = newValue;
    }
    
    public TenderProcedureType getProcedure() {
        return this.procedure;
    }
    
    public void setProcedure(TenderProcedureType newValue) {
        this.procedure = newValue;
    }
    
    public TenderLottingType getLotting() {
        return this.lotting;
    }
    
    public void setLotting(TenderLottingType newValue) {
        this.lotting = newValue;
    }
    
    public ProcurementType getProcuremnetType() {
        return this.procuremnetType;
    }
    
    public void setProcuremnetType(ProcurementType newValue) {
        this.procuremnetType = newValue;
    }
    
    public Double getEstimatedValue() {
        return this.estimatedValue;
    }
    
    public void setEstimatedValue(Double newValue) {
        this.estimatedValue = newValue;
    }
    
    public Timestamp getDateSubmitted() {
        return this.dateSubmitted;
    }
    
    public void setDateSubmitted(Timestamp newValue) {
        this.dateSubmitted = newValue;
    }
    
    public Timestamp getStartedAt() {
        return this.startedAt;
    }
    
    public void setStartedAt(Timestamp newValue) {
        this.startedAt = newValue;
    }
    
    public Timestamp getDeadline() {
        return this.deadline;
    }
    
    public void setDeadline(Timestamp newValue) {
        this.deadline = newValue;
    }
    
    public Timestamp getDateCfTAmend() {
        return this.dateCfTAmend;
    }
    
    public void setDateCfTAmend(Timestamp newValue) {
        this.dateCfTAmend = newValue;
    }
    
    public Timestamp getDateQuestionReceived() {
        return this.dateQuestionReceived;
    }
    
    public void setDateQuestionReceived(Timestamp newValue) {
        this.dateQuestionReceived = newValue;
    }
    
    public Timestamp getDateClarificationProvided() {
        return this.dateClarificationProvided;
    }
    
    public void setDateClarificationProvided(Timestamp newValue) {
        this.dateClarificationProvided = newValue;
    }
    
    public Timestamp getDateStandstillBegin() {
        return this.dateStandstillBegin;
    }
    
    public void setDateStandstillBegin(Timestamp newValue) {
        this.dateStandstillBegin = newValue;
    }
    
    public Timestamp getDateStandstillEnd() {
        return this.dateStandstillEnd;
    }
    
    public void setDateStandstillEnd(Timestamp newValue) {
        this.dateStandstillEnd = newValue;
    }
    
    public String getOtherInfoLotsFailure() {
        return this.otherInfoLotsFailure;
    }
    
    public void setOtherInfoLotsFailure(String newValue) {
        this.otherInfoLotsFailure = newValue;
    }
    
    public String getInfoPublicAnnounce() {
        return this.infoPublicAnnounce;
    }
    
    public void setInfoPublicAnnounce(String newValue) {
        this.infoPublicAnnounce = newValue;
    }
    
    public String getUnlawfulActs() {
        return this.unlawfulActs;
    }
    
    public void setUnlawfulActs(String newValue) {
        this.unlawfulActs = newValue;
    }
    
    public String getAppealsFiled() {
        return this.appealsFiled;
    }
    
    public void setAppealsFiled(String newValue) {
        this.appealsFiled = newValue;
    }
    
    public String getOtherRelevantInfo() {
        return this.otherRelevantInfo;
    }
    
    public void setOtherRelevantInfo(String newValue) {
        this.otherRelevantInfo = newValue;
    }

    public String getContractingAuthority() {
        return this.contractingAuthority;
    }
    
    public void setContractingAuthority(String newValue) {
        this.contractingAuthority = newValue;
    }

    public String getTendersForLots() {
        return this.tendersForLots;
    }
    
    public void setTendersForLots(String newValue) {
        this.tendersForLots = newValue;
    }
    
    public Integer getAwardinLots() {
        return this.awardinLots;
    }
    
    public void setAwardinLots(Integer newValue) {
        this.awardinLots = newValue;
    }
    
    public Integer getNumberOfLots() {
        return this.numberOfLots;
    }
    
    public void setNumberOfLots(Integer newValue) {
        this.numberOfLots = newValue;
    }
}

