package com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {

    private String tankPlanId ;
    private int tankId;
    private  String general_plan_id ;

    @NotNull
    @Min(1)
    @Max(15)
    private int stepProfile;

    @NotNull
    @Min(1)
    @Max(15)
    private int stepNumber;

    @NotNull
    private String step_profile_name;


    private String washingMedia;

    private int timeForOperation;

    private int lWsValue;

    private int uWsValue;

    private int cleaning_time_in_minutes;
    private double washing_Media_Amount;

    private int speed;

    private int pitch;

    private int washType;
    private double bar;

    public double getBar() {
        return bar;
    }

    public void setBar(double bar) {
        this.bar = bar;
    }

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public double getWashing_Media_Amount() {
        return washing_Media_Amount;
    }

    public void setWashing_Media_Amount(double washing_Media_Amount) {
        this.washing_Media_Amount = washing_Media_Amount;
    }

    public String getTankPlanId() {
        return tankPlanId;
    }

    public void setTankPlanId(String tankPlanId) {
        this.tankPlanId = tankPlanId;
    }

    public String getGeneral_plan_id() {
        return general_plan_id;
    }

    public void setGeneral_plan_id(String general_plan_id) {
        this.general_plan_id = general_plan_id;
    }

    public int getStepProfile() {
        return stepProfile;
    }

    public void setStepProfile(int stepProfile) {
        this.stepProfile = stepProfile;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
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

    public int getTimeForOperation() {
        return timeForOperation;
    }

    public void setTimeForOperation(int timeForOperation) {
        this.timeForOperation = timeForOperation;
    }

    public int getlWsValue() {
        return lWsValue;
    }

    public void setlWsValue(int lWsValue) {
        this.lWsValue = lWsValue;
    }

    public int getuWsValue() {
        return uWsValue;
    }

    public void setuWsValue(int uWsValue) {
        this.uWsValue = uWsValue;
    }

    public int getCleaning_time_in_minutes() {
        return cleaning_time_in_minutes;
    }

    public void setCleaning_time_in_minutes(int cleaning_time_in_minutes) {
        this.cleaning_time_in_minutes = cleaning_time_in_minutes;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public int getWashType() {
        return washType;
    }

    public void setWashType(int washType) {
        this.washType = washType;
    }

    @Override
    public String toString() {
        return "Step{" +
                "tankPlanId='" + tankPlanId + '\'' +
                ", tankId=" + tankId +
                ", general_plan_id='" + general_plan_id + '\'' +
                ", stepProfile=" + stepProfile +
                ", stepNumber=" + stepNumber +
                ", step_profile_name='" + step_profile_name + '\'' +
                ", washingMedia='" + washingMedia + '\'' +
                ", timeForOperation=" + timeForOperation +
                ", lWsValue=" + lWsValue +
                ", uWsValue=" + uWsValue +
                ", cleaning_time_in_minutes=" + cleaning_time_in_minutes +
                ", washing_Media_Amount=" + washing_Media_Amount +
                ", speed=" + speed +
                ", pitch=" + pitch +
                ", washType=" + washType +
                ", bar=" + bar +
                '}';
    }
}
