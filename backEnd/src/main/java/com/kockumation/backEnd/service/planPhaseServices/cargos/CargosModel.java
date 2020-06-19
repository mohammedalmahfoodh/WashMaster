package com.kockumation.backEnd.service.planPhaseServices.cargos;

public class CargosModel {
    private int cargo_id;
    private String cargo_previous_name;

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    public String getCargo_previous_name() {
        return cargo_previous_name;
    }

    public void setCargo_previous_name(String cargo_previous_name) {
        this.cargo_previous_name = cargo_previous_name;
    }
}
