package com.kockumation.backEnd.service.executionPhase.model.startPreWash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StartPreWash {
    @NotNull
    @NotBlank(message = "General Plan Id is mandatory")
    private String general_plan_id;

    @Min(1)
    @Max(55)
    private int tcmId;

    @NotNull
    @NotBlank(message = "Step profile name is mandatory")
    private String step_profile_name;
    @NotNull
    @Min(1)
    @Max(15)
    private int stepProfile;

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

    public String getStep_profile_name() {
        return step_profile_name;
    }

    public void setStep_profile_name(String step_profile_name) {
        this.step_profile_name = step_profile_name;
    }

    public int getStepProfile() {
        return stepProfile;
    }

    public void setStepProfile(int stepProfile) {
        this.stepProfile = stepProfile;
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
                ", step_profile_name='" + step_profile_name + '\'' +
                ", stepProfile=" + stepProfile +
                ", timeForOperation=" + timeForOperation +
                '}';
    }
}
