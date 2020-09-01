package com.kockumation.backEnd.utilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TankInfo {

    private int tankId;
    private String tankName ;
    private int tcmId;
    private String machine_char;
    private String machineName;
    private String nozzle_diameter;


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

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public String getTankName() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }

    public int getTcmId() {
        return tcmId;
    }

    public void setTcmId(int tcmId) {
        this.tcmId = tcmId;
    }

    public String getMachine_char() {
        return machine_char;
    }

    public void setMachine_char(String machine_char) {
        this.machine_char = machine_char;
    }

    @Override
    public String toString() {
        return "TankInfo{" +
                "tankId=" + tankId +
                ", tankName='" + tankName + '\'' +
                ", tcmId=" + tcmId +
                ", machine_char='" + machine_char + '\'' +
                ", machineName='" + machineName + '\'' +
                ", nozzle_diameter='" + nozzle_diameter + '\'' +
                '}';
    }
}
