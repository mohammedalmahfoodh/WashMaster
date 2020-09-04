package com.kockumation.backEnd.engine.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Session {
    @NotNull
    @NotBlank(message = "General Plan Id is mandatory")
    private String general_plan_id;
    private String session_id;
    private String session_start_date;
    private String session_end_date;

    public String getGeneral_plan_id() {
        return general_plan_id;
    }

    public void setGeneral_plan_id(String general_plan_id) {
        this.general_plan_id = general_plan_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getSession_start_date() {
        return session_start_date;
    }

    public void setSession_start_date(String session_start_date) {
        this.session_start_date = session_start_date;
    }

    public String getSession_end_date() {
        return session_end_date;
    }

    public void setSession_end_date(String session_end_date) {
        this.session_end_date = session_end_date;
    }
}
