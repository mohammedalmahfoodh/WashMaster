package com.kockumation.backEnd.controller.PlanPhase;

import com.kockumation.backEnd.service.planPhaseServices.cargos.GetGeneralPlan;
import com.kockumation.backEnd.service.planPhaseServices.cargos.PlanSubmissionService;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CargosModel;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan.GetGeneralPlanById;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan.SubmissionPlanObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
@RestController
@RequestMapping("/api/")
public class PlanController {

    @Autowired
    PlanSubmissionService planSubmissionService;
    @Autowired
    GetGeneralPlan getGeneralPlan;

    @PostMapping("/submitPlan")
    public ResponseEntity<String> submitPlan(@Valid @RequestBody SubmissionPlanObject submissionPlanObject) {
        boolean submittedOrNot = false;

        ResponseEntity<String> responseEntity = null;
        try {
            submittedOrNot = planSubmissionService.submitGeneralPlan(submissionPlanObject).get();


            if (submittedOrNot) {
                System.out.println("General Plan has been Submitted successfully");
                responseEntity = new ResponseEntity<String>(
                        "General Plan has been Submitted successfully..",
                        HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<String>(
                        "Not Submitted ok..",
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return responseEntity;
    } // get Capacity Machines Names


    //*************************************************************************************************************

    @GetMapping("/generalPlansIds")
    public ResponseEntity<List<JSONObject>> getGeneralPlanIds() {

        List<JSONObject> generalPlansList = new ArrayList<>();
        ResponseEntity<List<JSONObject>> responseEntity = null;
        try {
            generalPlansList = getGeneralPlan.getGeneralPlanIds().get();
            if (generalPlansList.size() == 0) {
                System.out.println("No elements");
                responseEntity = new ResponseEntity<List<JSONObject>>(
                        generalPlansList,
                        HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<List<JSONObject>>(
                        generalPlansList,
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
//*************************************************************************************************************

    @PostMapping("/getGeneralPlan")
    public ResponseEntity<JSONObject> getGeneralPlanById(@Valid @RequestBody GetGeneralPlanById getGeneralPlanById) {

        JSONObject generalPlanObject = new JSONObject();
        ResponseEntity<JSONObject> responseEntity = null;
        try {
            generalPlanObject = getGeneralPlan.getGeneralPlanObject(getGeneralPlanById.getGeneral_plan_id()).get();
            if (generalPlanObject.size() == 0) {
                System.out.println("No general plan for this id ");
                responseEntity = new ResponseEntity<JSONObject>(
                        generalPlanObject,
                        HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<JSONObject>(
                        generalPlanObject,
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
