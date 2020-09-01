package com.kockumation.backEnd.service.executionPhase.model.startWash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartWash {
    @Min(1)
    @Max(55)
    private int tcmId;

    @NotNull
    @Min(1)
    @Max(15)
    private int stepProfile;

    @NotNull
    @NotBlank(message = "General Plan Id is mandatory")
    private String general_plan_id;
    @NotNull
    @NotBlank(message = "Step profile name is mandatory")
    private String step_profile_name;
    private String washingMedia;

    @NotNull
    @Min(1)
    @Max(50)
    private double rpm;
    @NotNull
    @Min(6)
    @Max(12)
    private double bar;
    @NotNull
    @Min(1)
    @Max(1500)
    private double speed;
    @NotNull
    @Min(1)
    @Max(1500)
    private double pitch;

    @NotNull
    @Min(1)
    @Max(1500)
    private int cleaning_time_in_minutes;

    @NotNull
    @Min(0)
    @Max(360)
    private double lWsValue;
    @NotNull
    @Min(0)
    @Max(360)
    private double uWsValue;




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

    public int getStepProfile() {
        return stepProfile;
    }

    public void setStepProfile(int stepProfile) {
        this.stepProfile = stepProfile;
    }

    public String getStep_profile_name() {
        return step_profile_name;
    }

    public void setStep_profile_name(String step_profile_name) {
        this.step_profile_name = step_profile_name;
    }

    public String getWashingMedia() {
        return washingMedia;
    }

    public void setWashingMedia(String washingMedia) {
        this.washingMedia = washingMedia;
    }

    public double getRpm() {
        return rpm;
    }

    public void setRpm(double rpm) {
        this.rpm = rpm;
    }

    public double getBar() {
        return bar;
    }

    public void setBar(double bar) {
        this.bar = bar;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public int getCleaning_time_in_minutes() {
        return cleaning_time_in_minutes;
    }

    public void setCleaning_time_in_minutes(int cleaning_time_in_minutes) {
        this.cleaning_time_in_minutes = cleaning_time_in_minutes;
    }

    public double getlWsValue() {
        return lWsValue;
    }

    public void setlWsValue(double lWsValue) {
        this.lWsValue = lWsValue;
    }

    public double getuWsValue() {
        return uWsValue;
    }

    public void setuWsValue(double uWsValue) {
        this.uWsValue = uWsValue;
    }
}
