package com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralInfo {

    private  String general_plan_id ;

    @NotNull
    private String vesselName;

  private String planID;

    @NotNull
    private String voyageId;

    @NotNull
    private String nextLoadPort;
    @NotNull
    private String sequenceOfWashing;
    @NotNull
    private String positionOfTankCleaning;

    @NotNull
    private String manualLocation;
    @NotNull
    private String genInfoDate;

    @NotNull
    private String genInfoTime;

    @NotNull
    private String machineName;
    @NotNull
    private String nozzle_diameter;

    private String userName;


    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public String getGeneral_plan_id() {
        return general_plan_id;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getNozzle_diameter() {
        return nozzle_diameter;
    }

    public void setNozzle_diameter(String nozzle_diameter) {
        this.nozzle_diameter = nozzle_diameter;
    }

    public void setGeneral_plan_id(String general_plan_id) {
        this.general_plan_id = general_plan_id;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }


    public String getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(String voyageId) {
        this.voyageId = voyageId;
    }

    public String getNextLoadPort() {
        return nextLoadPort;
    }

    public void setNextLoadPort(String nextLoadPort) {
        this.nextLoadPort = nextLoadPort;
    }

    public String getSequenceOfWashing() {
        return sequenceOfWashing;
    }

    public void setSequenceOfWashing(String sequenceOfWashing) {
        this.sequenceOfWashing = sequenceOfWashing;
    }

    public String getPositionOfTankCleaning() {
        return positionOfTankCleaning;
    }

    public void setPositionOfTankCleaning(String positionOfTankCleaning) {
        this.positionOfTankCleaning = positionOfTankCleaning;
    }

    public String getManualLocation() {
        return manualLocation;
    }

    public void setManualLocation(String manualLocation) {
        this.manualLocation = manualLocation;
    }

    public String getGenInfoDate() {
        return genInfoDate;
    }

    public void setGenInfoDate(String genInfoDate) {
        this.genInfoDate = genInfoDate;
    }

    public String getGenInfoTime() {
        return genInfoTime;
    }

    public void setGenInfoTime(String genInfoTime) {
        this.genInfoTime = genInfoTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "GeneralInfo{" +
                "general_plan_id='" + general_plan_id + '\'' +
                ", vesselName='" + vesselName + '\'' +
                ", planID='" + planID + '\'' +
                ", voyageId='" + voyageId + '\'' +
                ", nextLoadPort='" + nextLoadPort + '\'' +
                ", sequenceOfWashing='" + sequenceOfWashing + '\'' +
                ", positionOfTankCleaning='" + positionOfTankCleaning + '\'' +
                ", manualLocation='" + manualLocation + '\'' +
                ", genInfoDate='" + genInfoDate + '\'' +
                ", genInfoTime='" + genInfoTime + '\'' +
                ", machineName='" + machineName + '\'' +
                ", nozzle_diameter='" + nozzle_diameter + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
