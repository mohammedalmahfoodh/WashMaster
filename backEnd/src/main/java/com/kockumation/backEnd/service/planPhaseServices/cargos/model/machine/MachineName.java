package com.kockumation.backEnd.service.planPhaseServices.cargos.model.machine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MachineName {
    @NotNull
    @NotBlank(message = "Machine name is mandatory")
    private String machineName;

    private  String nozzle_diameter;

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
}
