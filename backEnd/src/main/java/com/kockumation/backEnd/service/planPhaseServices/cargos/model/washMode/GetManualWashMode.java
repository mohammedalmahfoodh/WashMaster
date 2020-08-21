package com.kockumation.backEnd.service.planPhaseServices.cargos.model.washMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.validation.constraints.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetManualWashMode {


    @Min(10)
    @Max(360)
    private long uWsValue;

    @Min(0)
    @Max(360)
    private long lWsValue;

    @Min(0)
    private double speed;


    @Min(0)
    private double desiredTime;


    @Min(0)
    @Max(15)
    private double pitch;

    @Min(0)
    @Max(15)
    private double rpm;


    @Min(6)
    @Max(12)
    private double bar;

    @NotNull
    @NotBlank(message = "Machine name is mandatory")
    private String machineName;

    @NotNull
    @Min(1)
    @Max(2)
    private int numberOfMachines ;

    @NotNull
    @NotBlank(message = "nozzle_diameter is mandatory")
    private String nozzle_diameter;


    public long getuWsValue() {
        return uWsValue;
    }

    public void setuWsValue(long uWsValue) {
        this.uWsValue = uWsValue;
    }

    public long getlWsValue() {
        return lWsValue;
    }

    public void setlWsValue(long lWsValue) {
        this.lWsValue = lWsValue;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDesiredTime() {
        return desiredTime;
    }

    public void setDesiredTime(double desiredTime) {
        this.desiredTime = desiredTime;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
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

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public int getNumberOfMachines() {
        return numberOfMachines;
    }

    public void setNumberOfMachines(int numberOfMachines) {
        this.numberOfMachines = numberOfMachines;
    }

    public String getNozzle_diameter() {
        return nozzle_diameter;
    }

    public void setNozzle_diameter(String nozzle_diameter) {
        this.nozzle_diameter = nozzle_diameter;
    }

    @Override
    public String toString() {
        return "GetManualWashMode{" +
                "uWsValue=" + uWsValue +
                ", lWsValue=" + lWsValue +
                ", speed=" + speed +
                ", desiredTime=" + desiredTime +
                ", pitch=" + pitch +
                ", rpm=" + rpm +
                ", bar=" + bar +
                ", machineName='" + machineName + '\'' +
                ", numberOfMachines=" + numberOfMachines +
                ", nozzle_diameter='" + nozzle_diameter + '\'' +
                '}';
    }
}
