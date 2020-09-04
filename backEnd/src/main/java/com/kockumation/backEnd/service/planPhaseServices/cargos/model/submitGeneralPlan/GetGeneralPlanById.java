package com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetGeneralPlanById {
    @NotNull
    @NotBlank(message = "General plan id is mandatory")
    @Pattern(regexp="^((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])\\s(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]$",message="Not Valid")
    private  String general_plan_id ;

    public String getGeneral_plan_id() {
        return general_plan_id;
    }

    public void setGeneral_plan_id(String general_plan_id) {
        this.general_plan_id = general_plan_id;
    }
}
