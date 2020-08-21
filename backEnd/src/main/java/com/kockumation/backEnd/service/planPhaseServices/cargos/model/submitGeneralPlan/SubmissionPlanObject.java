package com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmissionPlanObject {
    @Valid
    @NotNull
    private  GeneralInfo generalInfo;
    @Valid
    @NotNull
    public   ArrayList<Tank>  tanks ;


    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public ArrayList<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(ArrayList<Tank> tanks) {
        this.tanks = tanks;
    }

    @Override
    public String toString() {
        return "SubmissionPlanObject{" +
                "generalInfo=" + generalInfo +
                ", tanks=" + tanks +
                '}';
    }
}
