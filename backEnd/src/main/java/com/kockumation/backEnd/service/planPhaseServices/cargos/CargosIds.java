package com.kockumation.backEnd.service.planPhaseServices.cargos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CargosIds {
    @NotNull
    @Min(1)
    @Max(22)
    private int cargo_id;
    @NotNull
    @Min(1)
    @Max(22)
    private int cargo_loaded_id;

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
}
