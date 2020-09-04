package com.kockumation.backEnd.controller.SessionsAndReportsController;


import com.kockumation.backEnd.service.sessionsReports.SessionsReportsService;
import com.kockumation.backEnd.service.sessionsReports.model.GetReportById;
import com.kockumation.backEnd.service.sessionsReports.model.GetSessionById;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api/")
public class SessionsReportsController {

    @Autowired
    SessionsReportsService sessionsReportsService;

    private ExecutorService executor;

    public SessionsReportsController() {
        executor = Executors.newSingleThreadExecutor();
    }




    @GetMapping("/getReportsIds")
    public ResponseEntity<List<JSONObject>> getReportsIds() {

        List<JSONObject> planIdsList = new ArrayList<>();
        ResponseEntity<List<JSONObject>> responseEntity = null;
        try {
            planIdsList = sessionsReportsService.getReportsIds().get();
            if (planIdsList.size() == 0) {
                System.out.println("No elements");
                responseEntity = new ResponseEntity<List<JSONObject>>(
                        planIdsList,
                        HttpStatus.NO_CONTENT);
            } else {
                responseEntity = new ResponseEntity<List<JSONObject>>(
                        planIdsList,
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return responseEntity;
    }//********************************* Get Reports Ids  ****************************************************************************


    //*************************** Get Session Ids    **********************************************************************************
    @GetMapping("/getSessionsIds")
    public ResponseEntity<List<JSONObject>> getSessionsIds() {

        List<JSONObject> sessionsList = new ArrayList<>();
        ResponseEntity<List<JSONObject>> responseEntity = null;
        try {
            sessionsList = sessionsReportsService.getSessionsIds().get();
            if (sessionsList.size() == 0) {
                System.out.println("No elements");
                responseEntity = new ResponseEntity<List<JSONObject>>(
                        sessionsList,
                        HttpStatus.NO_CONTENT);
            } else {
                responseEntity = new ResponseEntity<List<JSONObject>>(
                        sessionsList,
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return responseEntity;
    }//*************************** Get Session Ids    **********************************************************************************


    //************************* Get Report By Id ************************************************************************************
    @PostMapping("/getReportById")
    public ResponseEntity  getReportById(@Valid @RequestBody GetReportById getReportById) {

        JSONObject reportObject = new JSONObject();

        ResponseEntity<JSONObject> responseEntity = null;
        try {
            reportObject = sessionsReportsService.getReport(getReportById.getReport_id()).get();
            if (reportObject.size() == 0) {
                System.out.println("No report for this id ");
                return ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .body("Report not exists with report Id "+ getReportById.getReport_id());
            } else {
                responseEntity = new ResponseEntity<JSONObject>(
                        reportObject,
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return responseEntity;

    }//************************* Get Report By Id ************************************************************************************

    //************************* Get Report By Id ************************************************************************************
    @PostMapping("/getSessionById")
    public ResponseEntity getSessionById(@Valid @RequestBody GetSessionById getSessionById) {

        JSONObject sessionObject = new JSONObject();

        ResponseEntity<JSONObject> responseEntity = null;
        try {
            sessionObject = sessionsReportsService.getSessionObject(getSessionById.getSession_id()).get();
            if (sessionObject.size() == 0) {
                System.out.println("No session for this id ");
                return ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .body("Session not exists with session Id "+ getSessionById.getSession_id());

            } else {
                responseEntity = new ResponseEntity<JSONObject>(
                        sessionObject,
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return responseEntity;

    }//************************* Get Report By Id ************************************************************************************


}
