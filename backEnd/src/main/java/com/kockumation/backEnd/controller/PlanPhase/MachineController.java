package com.kockumation.backEnd.controller.PlanPhase;

import com.kockumation.backEnd.service.planPhaseServices.cargos.MachineService;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.machine.MachineName;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.machine.MachinePostObject;
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
public class MachineController {

    @Autowired
    MachineService machineService;

    @GetMapping("/getCapacityMachinesNames")
    public ResponseEntity<List<String>> getMachinesNames() {

        List<String>machinesNames = null;

        ResponseEntity<List<String>> responseEntity = null;
        try {
            machinesNames = machineService.getMachinesNames().get();
            if (machinesNames.size() == 0) {
                System.out.println("no element");
                responseEntity = new ResponseEntity<List<String>>(
                        machinesNames,
                        HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<List<String>>(
                        machinesNames,
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
    @PostMapping("/getCapacityDataForMachine")
    public ResponseEntity<List<JSONObject>> getCapacityDataForMachine(@Valid @RequestBody MachineName machinePostObject) {
        String machineName = machinePostObject.getMachineName();
        System.out.println(machineName);
        List<JSONObject>capacityDataThroughput = null;

        ResponseEntity<List<JSONObject>> responseEntity = null;
        try {
            capacityDataThroughput = machineService.getCapacityDataForMachine(machineName).get();
            if (capacityDataThroughput.size() == 0) {
                System.out.println("Not valid machine named");
                responseEntity = new ResponseEntity<List<JSONObject>>(
                        capacityDataThroughput,
                        HttpStatus.BAD_REQUEST);
            } else {
                responseEntity = new ResponseEntity<List<JSONObject>>(
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
    @PostMapping("/getCapacityDataForBar")
    public ResponseEntity<JSONObject> getCapacityDataForMachineForBar(@Valid @RequestBody MachinePostObject machinePostObject) {
        String machineName = machinePostObject.getMachineName();
        System.out.println(machineName);
        JSONObject capacityDataThroughput = null;

        ResponseEntity<JSONObject> responseEntity = null;

        try {
            capacityDataThroughput = machineService.getCapacityDataForBar(machinePostObject).get();
            if (capacityDataThroughput.size() == 0) {
                System.out.println("Not valid machine named");
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

}
