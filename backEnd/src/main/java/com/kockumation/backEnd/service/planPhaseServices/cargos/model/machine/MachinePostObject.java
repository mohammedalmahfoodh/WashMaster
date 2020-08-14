package com.kockumation.backEnd.service.planPhaseServices.cargos.model.machine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MachinePostObject {

    @NotNull
    @NotBlank(message = "Machine name is mandatory")
    private String machineName;
    @NotNull
    @Min(6)
    @Max(12)
    private double bar;

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

    @Override
    public String toString() {
        return "MachinePostObject{" +
                "machineName='" + machineName + '\'' +
                ", bar=" + bar +
                '}';
    }
}
