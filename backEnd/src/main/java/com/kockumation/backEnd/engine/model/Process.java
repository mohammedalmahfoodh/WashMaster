package com.kockumation.backEnd.engine.model;

public class Process {

    private int tcmId;
    private int profileNumber;
    private int stepNumber;
    private String finishTime;
    private String elapsedTime;
    private String RemainingTime;
    private double percentage;
    private int processStatus;
    private double nozzle_diameter;
    private double nozzle_diameter_throughput;
    private double currentNozzleAngle;






    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public double getNozzle_diameter() {
        return nozzle_diameter;
    }

    public void setNozzle_diameter(double nozzle_diameter) {
        this.nozzle_diameter = nozzle_diameter;
    }

    public double getNozzle_diameter_throughput() {
        return nozzle_diameter_throughput;
    }

    public void setNozzle_diameter_throughput(double nozzle_diameter_throughput) {
        this.nozzle_diameter_throughput = nozzle_diameter_throughput;
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

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
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
                ", step_profile_name='" + profileNumber + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", elapsedTime='" + elapsedTime + '\'' +
                ", RemainingTime='" + RemainingTime + '\'' +
                ", percentage='" + percentage + '\'' +
                ", processStatus=" + processStatus +
                ", currentNozzleAngle=" + currentNozzleAngle +
                '}';
    }
}
