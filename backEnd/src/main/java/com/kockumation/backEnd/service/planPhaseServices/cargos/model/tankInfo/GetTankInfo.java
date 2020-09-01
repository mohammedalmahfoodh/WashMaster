package com.kockumation.backEnd.service.planPhaseServices.cargos.model.tankInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTankInfo {


    private int tankId;
    private  int tcmId;
    private String tankName ;
    private String machine_char;
    private  String nozzle_diameter;
    private String machineName;


    public String getNozzle_diameter() {
        return nozzle_diameter;
    }

    public void setNozzle_diameter(String nozzle_diameter) {
        this.nozzle_diameter = nozzle_diameter;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public int getTcmId() {
        return tcmId;
    }

    public void setTcmId(int tcmId) {
        this.tcmId = tcmId;
    }

    public String getTankName() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }

    public String getMachine_char() {
        return machine_char;
    }

    public void setMachine_char(String machine_char) {
        this.machine_char = machine_char;
    }

    @Override
    public String toString() {
        return "GetTankInfo{" +
                "tankId=" + tankId +
                ", tcmId=" + tcmId +
                ", tankName='" + tankName + '\'' +
                ", machine_char='" + machine_char + '\'' +
                ", nozzle_diameter='" + nozzle_diameter + '\'' +
                ", machineName='" + machineName + '\'' +
                '}';
    }
}
