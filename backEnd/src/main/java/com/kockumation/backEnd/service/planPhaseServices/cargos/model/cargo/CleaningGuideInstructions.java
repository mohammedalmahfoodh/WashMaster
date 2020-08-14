package com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CleaningGuideInstructions {
  private int  cleaning_guide_id;
  private int  cargo_id;
    private int  cargo_loaded_id;
    private String  method;
    private String  P;
    private String  M;
    private String  X;
    private String  S;
    private String  LUB;
    private String  notes;

    public int getCleaning_guide_id() {
        return cleaning_guide_id;
    }

    public void setCleaning_guide_id(int cleaning_guide_id) {
        this.cleaning_guide_id = cleaning_guide_id;
    }

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    public int getCargo_loaded_id() {
        return cargo_loaded_id;
    }

    public void setCargo_loaded_id(int cargo_loaded_id) {
        this.cargo_loaded_id = cargo_loaded_id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getP() {
        return P;
    }

    public void setP(String p) {
        P = p;
    }

    public String getM() {
        return M;
    }

    public void setM(String m) {
        M = m;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getS() {
        return S;
    }

    public void setS(String s) {
        S = s;
    }

    public String getLUB() {
        return LUB;
    }

    public void setLUB(String LUB) {
        this.LUB = LUB;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
