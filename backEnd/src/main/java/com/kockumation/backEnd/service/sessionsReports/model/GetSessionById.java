package com.kockumation.backEnd.service.sessionsReports.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSessionById {
    @NotNull(message = "Session id must not be null")
    @NotBlank(message = "Session Id is mandatory")
    @Pattern(regexp="^((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])\\s(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]$",message="Not Valid Format For Session Id")
    private String session_id;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
}
