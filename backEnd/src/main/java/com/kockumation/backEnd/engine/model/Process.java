package com.kockumation.backEnd.engine.model;

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
    private String nozzle_diameter;
    private double nozzle_diameter_throughput;
    private int stepNumber;


    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getNozzle_diameter() {
        return nozzle_diameter;
    }

    public void setNozzle_diameter(String nozzle_diameter) {
        this.nozzle_diameter = nozzle_diameter;
    }

    public double getNozzle_diameter_throughput() {
        return nozzle_diameter_throughput;
    }

    public void setNozzle_diameter_throughput(double nozzle_diameter_throughput) {
        this.nozzle_diameter_throughput = nozzle_diameter_throughput;
    }

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

    @Override
    public String toString() {
        return "Process{" +
                "tcmId=" + tcmId +
                ", step_profile_name='" + step_profile_name + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", elapsedTime='" + elapsedTime + '\'' +
                ", RemainingTime='" + RemainingTime + '\'' +
                ", percentage='" + percentage + '\'' +
                ", decimalOfPercentage=" + decimalOfPercentage +
                ", processStatus=" + processStatus +
                ", currentNozzleAngle=" + currentNozzleAngle +
                ", stringCurrentNozzleAngle='" + stringCurrentNozzleAngle + '\'' +
                '}';
    }
}
