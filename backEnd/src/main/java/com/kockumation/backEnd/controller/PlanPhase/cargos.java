package com.kockumation.backEnd.controller.PlanPhase;

import com.kockumation.backEnd.service.planPhaseServices.cargos.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/plan")
public class cargos {

    @GetMapping("/previousCargos")
    public ResponseEntity<List<CargosModel>> getPreviousCargos() {

        List<CargosModel> cargosModelList = new ArrayList<>();
        Cargos cargos = new Cargos();
        ResponseEntity<List<CargosModel>> responseEntity = null;
        try {
            cargosModelList = cargos.getPreviousCargos().get();
            if (cargosModelList.size() == 0) {
                System.out.println("no element");
                responseEntity = new ResponseEntity<List<CargosModel>>(
                        cargosModelList,
                        HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<List<CargosModel>>(
                        cargosModelList,
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return responseEntity;
    }

    @GetMapping("/cargosToBeLoaded")
    public ResponseEntity<List<CargoToBeLoaded>> cargoToBeLoaded() {

        List<CargoToBeLoaded> cargosModelList = new ArrayList<>();
        Cargos cargos = new Cargos();
        ResponseEntity<List<CargoToBeLoaded>> responseEntity = null;
        try {
            cargosModelList = cargos.cargoToBeLoaded().get();
            if (cargosModelList.size() == 0) {
                System.out.println("no element");
                responseEntity = new ResponseEntity<List<CargoToBeLoaded>>(
                        cargosModelList,
                        HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<List<CargoToBeLoaded>>(
                        cargosModelList,
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return responseEntity;
    }

    @PostMapping("/getCleaningInstructions")
    public ResponseEntity<?> getCleaningInstructions(@Valid @RequestBody CargosIds cargosIds) {

        System.out.println(cargosIds.getCargo_id());
     //   System.out.println(cleaningInstructions.getCargo_loaded_id());
     //   System.out.println(instanceof cleaningInstructions.getCargo_id());
      //  System.out.println(cleaningInstructions);

       List<CleaningGuideInstructions> cleaningGuideInstructions = new ArrayList<>();
        Cargos cargos = new Cargos();
        ResponseEntity<List<CleaningGuideInstructions>> responseEntity = null;
        try {
            cleaningGuideInstructions = cargos.GetCleaningInstructions(cargosIds).get();
            if (cleaningGuideInstructions.size() == 0) {
                System.out.println("no element");
                responseEntity = new ResponseEntity<List<CleaningGuideInstructions>>(
                        cleaningGuideInstructions,
                        HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<List<CleaningGuideInstructions>>(
                        cleaningGuideInstructions,
                        HttpStatus.OK);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return responseEntity;
    }
/* boolean b1 = Pattern.matches("^\\d+$", data);
        boolean b2 = Pattern.matches("[0-9a-zA-Z([+-]?\\d*\\.+\\d*)]*", data);
        boolean b3 = Pattern.matches("^([+-]?\\d*\\.+\\d*)$", data);
        if(b1) {
            System.out.println("It is integer.");
        } else if(b2) {
            System.out.println("It is String. ");
        } else if(b3) {
            System.out.println("It is Float. ");
        }*/
}
