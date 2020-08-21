package com.kockumation.backEnd.service.planPhaseServices.cargos.model.washMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetWashMode {
    @NotNull
    @Min(1)
    @Max(11)
    private int washType;
    @Min(1)
    @Max(2)
    private int numberOfMachines;
    private double speed;
    @NotNull
    @Min(0)
    private double washingSector;
    @NotNull
    @Min(0)
    private double desiredTime;
    @NotNull
    @Min(6)
    @Max(12)
    private double bar;
    @NotNull
    @NotBlank(message = "Machine name is mandatory")
    private String machineName;
    @NotNull
    @NotBlank(message = "Machine name is mandatory")
    private String nozzle_diameter;


    public int getWashType() {
        return washType;
    }

    public void setWashType(int washType) {
        this.washType = washType;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getWashingSector() {
        return washingSector;
    }

    public void setWashingSector(double washingSector) {
        this.washingSector = washingSector;
    }

    public double getDesiredTime() {
        return desiredTime;
    }

    public void setDesiredTime(double desiredTime) {
        this.desiredTime = desiredTime;
    }

    public double getBar() {
        return bar;
    }

    public void setBar(double bar) {
        this.bar = bar;
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

    public int getNumberOfMachines() {
        return numberOfMachines;
    }

    public void setNumberOfMachines(int numberOfMachines) {
        this.numberOfMachines = numberOfMachines;
    }

    @Override
    public String toString() {
        return "GetWashMode{" +
                "washType=" + washType +
                ", speed=" + speed +
                ", washingSector=" + washingSector +
                ", desiredTime=" + desiredTime +
                ", bar=" + bar +
                ", machineName='" + machineName + '\'' +
                ", nozzle_diameter='" + nozzle_diameter + '\'' +
                '}';
    }
}
