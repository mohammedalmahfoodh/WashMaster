package com.kockumation.backEnd.service.sessionsReports.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetReportById {

    @NotNull(message = "Report id must not be null")
    @NotBlank(message = "Report Id is mandatory")
    @Pattern(regexp="^((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])\\s(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]$",message="Not Valid Format For Report Id")
    private String report_id;

    public String getReport_id() {
        return report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }
}
