package com.kockumation.backEnd.controller.PlanPhase;


import com.kockumation.backEnd.service.planPhaseServices.cargos.WashModesService;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.machine.MachinePostObject;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.washMode.GetManualWashMode;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.washMode.GetWashMode;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/")
public class WashModesController {
    @Autowired
    WashModesService washModesService;

    @GetMapping("/getWashTypeIdsNames")
    public ResponseEntity<List<JSONObject>> getMachinesNames() {

        List<JSONObject>washTypesIds = null;

        ResponseEntity<List<JSONObject>> responseEntity = null;
        try {
            washTypesIds = washModesService.getWashTypeIdsNames().get();
            if (washTypesIds.size() == 0) {
                System.out.println("no element");
                responseEntity = new ResponseEntity<List<JSONObject>>(
                        washTypesIds,
                        HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<List<JSONObject>>(
                        washTypesIds,
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
    @PostMapping("/getWashMode")
    public ResponseEntity<JSONObject> getWashModeData(@Valid @RequestBody GetWashMode getWashMode) {


        JSONObject capacityDataThroughput = null;

        ResponseEntity<JSONObject> responseEntity = null;

        try {
            capacityDataThroughput = washModesService.getWashModeData(getWashMode).get();
            if (capacityDataThroughput.size() == 0) {
                System.out.println("Not valid information");
                responseEntity = new ResponseEntity<JSONObject>(
                        capacityDataThroughput,
                        HttpStatus.BAD_REQUEST);
            } else {
                responseEntity = new ResponseEntity<JSONObject>(
                        capacityDataThroughput,
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
    @PostMapping("/getManualWashMode")
    public ResponseEntity<JSONObject> getManualWashModeData(@Valid @RequestBody GetManualWashMode getManualWashMode) {

        JSONObject washModeObject = null;

        ResponseEntity<JSONObject> responseEntity = null;

        try {
            washModeObject = washModesService.getManualWashMode(getManualWashMode).get();
            if (washModeObject.size() == 0) {
                System.out.println("Not valid information");
                responseEntity = new ResponseEntity<JSONObject>(
                        washModeObject,
                        HttpStatus.BAD_REQUEST);
            } else {
                responseEntity = new ResponseEntity<JSONObject>(
                        washModeObject,
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return responseEntity;
    } // get Capacity Machines Names

} // Class
