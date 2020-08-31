package com.kockumation.backEnd.engine.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Process {

    private int tcmId;
    private String step_profile_name;
    private String finishTime;
    private String elapsedTime;
    private String RemainingTime;

    private String percentage;
    private double decimalOfPercentage;
    private int processStatus;
    private double currentNozzleAngle;
   private String stringCurrentNozzleAngle;


    public String getStringCurrentNozzleAngle() {
        return stringCurrentNozzleAngle;
    }

    public void setStringCurrentNozzleAngle(String stringCurrentNozzleAngle) {
        this.stringCurrentNozzleAngle = stringCurrentNozzleAngle;
    }

    public double getCurrentNozzleAngle() {
        return currentNozzleAngle;
    }

    public void setCurrentNozzleAngle(double currentNozzleAngle) {
        this.currentNozzleAngle = currentNozzleAngle;
    }

    public int getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(int processStatus) {
        this.processStatus = processStatus;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public double getDecimalOfPercentage() {
        return decimalOfPercentage;
    }

    public void setDecimalOfPercentage(double decimalOfPercentage) {
        this.decimalOfPercentage = decimalOfPercentage;
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

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getRemainingTime() {
        return RemainingTime;
    }

    public void setRemainingTime(String remainingTime) {
        RemainingTime = remainingTime;
    }




}
