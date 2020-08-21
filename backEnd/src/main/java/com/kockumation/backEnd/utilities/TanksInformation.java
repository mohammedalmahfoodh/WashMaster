package com.kockumation.backEnd.utilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TanksInformation {
    List<TankInfo> tanksConfig;

    public List<TankInfo> getTanksConfig() {
        return tanksConfig;
    }

    public void setTanksConfig(List<TankInfo> tanksConfig) {
        this.tanksConfig = tanksConfig;
    }

}
