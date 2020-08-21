package com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tank {
    @Valid
    @NotNull
    public ArrayList<Step>  steps ;

    private int tcmId;
    private String tankPlanId ;
    private String general_plan_id;
    @NotNull
    @Min(1)
    @Max(50)
    private int  tankId;
    @NotNull
    private String cleaningMethod;

    @NotNull
    private String previous;

    @NotNull
    private String next;
    private int stepsCtr;
    private String tankCoating;
    private String tankAtmosphere;
    private double o2Level;
    private double hc;

    @NotNull
    @Min(0)
    @Max(50)
    private int tcmIda;

    @NotNull
    @Min(0)
    @Max(50)
    private int tcmIdb;
    private String tankComments;


    private int numberOfMachines;




    public int getNumberOfMachines() {
        return numberOfMachines;
    }

    public void setNumberOfMachines(int numberOfMachines) {
        this.numberOfMachines = numberOfMachines;
    }

    public int getTcmId() {
        return tcmId;
    }

    public void setTcmId(int tcmId) {
        this.tcmId = tcmId;
    }

    public String getGeneral_plan_id() {
        return general_plan_id;
    }

    public void setGeneral_plan_id(String general_plan_id) {
        this.general_plan_id = general_plan_id;
    }

    public String getTankPlanId() {
        return tankPlanId;
    }

    public void setTankPlanId(String tankPlanId) {
        this.tankPlanId = tankPlanId;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public String getCleaningMethod() {
        return cleaningMethod;
    }

    public void setCleaningMethod(String cleaningMethod) {
        this.cleaningMethod = cleaningMethod;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getStepsCtr() {
        return stepsCtr;
    }

    public void setStepsCtr(int stepsCtr) {
        this.stepsCtr = stepsCtr;
    }

    public String getTankCoating() {
        return tankCoating;
    }

    public void setTankCoating(String tankCoating) {
        this.tankCoating = tankCoating;
    }

    public String getTankAtmosphere() {
        return tankAtmosphere;
    }

    public void setTankAtmosphere(String tankAtmosphere) {
        this.tankAtmosphere = tankAtmosphere;
    }

    public double getO2Level() {
        return o2Level;
    }

    public void setO2Level(double o2Level) {
        this.o2Level = o2Level;
    }

    public double getHc() {
        return hc;
    }

    public void setHc(double hc) {
        this.hc = hc;
    }

    public int getTcmIda() {
        return tcmIda;
    }

    public void setTcmIda(int tcmIda) {
        this.tcmIda = tcmIda;
    }

    public int getTcmIdb() {
        return tcmIdb;
    }

    public void setTcmIdb(int tcmIdb) {
        this.tcmIdb = tcmIdb;
    }

    public String getTankComments() {
        return tankComments;
    }

    public void setTankComments(String tankComments) {
        this.tankComments = tankComments;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "steps=" + steps +
                ", tcmId=" + tcmId +
                ", tankPlanId='" + tankPlanId + '\'' +
                ", general_plan_id='" + general_plan_id + '\'' +
                ", tankId=" + tankId +
                ", cleaningMethod='" + cleaningMethod + '\'' +
                ", previous='" + previous + '\'' +
                ", next='" + next + '\'' +
                ", stepsCtr=" + stepsCtr +
                ", tankCoating='" + tankCoating + '\'' +
                ", tankAtmosphere='" + tankAtmosphere + '\'' +
                ", o2Level=" + o2Level +
                ", hc=" + hc +
                ", tcmIda=" + tcmIda +
                ", tcmIdb=" + tcmIdb +
                ", tankComments='" + tankComments + '\'' +
                ", numberOfMachines=" + numberOfMachines +
                '}';
    }
}
