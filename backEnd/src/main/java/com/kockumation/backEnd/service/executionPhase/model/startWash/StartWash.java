package com.kockumation.backEnd.service.executionPhase.model.startWash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StartWash {
    @Min(1)
    @Max(55)
    private int tcmId;

    @Min(1)
    @Max(30)
  private int stepNumber;
    @NotNull
    @Min(1)
    @Max(25)
    private int profileNumber;

    @NotNull
    @NotBlank(message = "General Plan Id is mandatory")
    @Pattern(regexp="^((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])\\s(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]$",message="Not Valid")
    private String general_plan_id;

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
    private int speed;
    @NotNull
    @Min(1)
    @Max(10)
    private double pitch;

    @NotNull
    @Min(1)
    @Max(1700)
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




    public int getProfileNumber() {
        return profileNumber;
    }

    public void setProfileNumber(int profileNumber) {
        this.profileNumber = profileNumber;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
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

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }
}
