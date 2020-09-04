package com.kockumation.backEnd.service.executionPhase.model.startPreWash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StartPreWash {

    @NotNull
    @NotBlank(message = "General Plan Id is mandatory")
    @Pattern(regexp="^((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])\\s(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]$",message="Not Valid")
    private String general_plan_id;

    @Min(1)
    @Max(55)
    private int tcmId;

    @NotNull
    @Min(1)
    @Max(15)
    private int profileNumber;
    //private int stepNumber;
    @NotNull
    @Min(1)
    @Max(500000)
   private int  timeForOperation ;

    public String getGeneral_plan_id() {
        return general_plan_id;
    }

    public void setGeneral_plan_id(String general_plan_id) {
        this.general_plan_id = general_plan_id;
    }

    public int getTcmId() {
        return tcmId;
    }

    public void setTcmId(int tcmId) {
        this.tcmId = tcmId;
    }



    public int getProfileNumber() {
        return profileNumber;
    }

    public void setProfileNumber(int profileNumber) {
        this.profileNumber = profileNumber;
    }

    public int getTimeForOperation() {
        return timeForOperation;
    }

    public void setTimeForOperation(int timeForOperation) {
        this.timeForOperation = timeForOperation;
    }

    @Override
    public String toString() {
        return "StartPreWash{" +
                "general_plan_id='" + general_plan_id + '\'' +
                ", tcmId=" + tcmId +

                ", stepProfile=" + profileNumber +
                ", timeForOperation=" + timeForOperation +
                '}';
    }
}
