package com.kockumation.backEnd.service.executionPhase.model.startWash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopSession {

    @Min(1)
    @Max(55)
    private int tcmId;

    public int getTcmId() {
        return tcmId;
    }

    public void setTcmId(int tcmId) {
        this.tcmId = tcmId;
    }
}
