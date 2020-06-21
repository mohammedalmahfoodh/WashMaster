package com.kockumation.backEnd.service.planPhaseServices.cargos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CargoToBeLoaded {
    @NotNull
    @Min(1)
    @Max(22)
    private int cargo_loaded_id;
    private String cargo_load_name;

    public int getCargo_loaded_id() {
        return cargo_loaded_id;
    }

    public void setCargo_loaded_id(int cargo_loaded_id) {
        this.cargo_loaded_id = cargo_loaded_id;
    }

    public String getCargo_load_name() {
        return cargo_load_name;
    }

    public void setCargo_load_name(String cargo_load_name) {
        this.cargo_load_name = cargo_load_name;
    }
}
