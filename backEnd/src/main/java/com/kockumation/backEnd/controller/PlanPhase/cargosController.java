package com.kockumation.backEnd.controller.PlanPhase;

import com.kockumation.backEnd.service.planPhaseServices.cargos.*;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CargoToBeLoaded;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CargosIds;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CargosModel;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CleaningGuideInstructions;
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
public class cargosController {
    @Autowired
    CargosService cargosService;


    @GetMapping("/previousCargos")
    public ResponseEntity<List<CargosModel>> getPreviousCargos() {

        List<CargosModel> cargosModelList = new ArrayList<>();

        ResponseEntity<List<CargosModel>> responseEntity = null;
        try {
            cargosModelList = cargosService.getPreviousCargos().get();
            if (cargosModelList.size() == 0) {
                System.out.println("No elements");
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
        CargosService cargosService = new CargosService();
        ResponseEntity<List<CargoToBeLoaded>> responseEntity = null;
        try {
            cargosModelList = cargosService.cargoToBeLoaded().get();
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


     //   System.out.println(cleaningInstructions.getCargo_loaded_id());
     //   System.out.println(instanceof cleaningInstructions.getCargo_id());
      //  System.out.println(cleaningInstructions);

       List<CleaningGuideInstructions> cleaningGuideInstructions = new ArrayList<>();
        CargosService cargosService = new CargosService();
        ResponseEntity<List<CleaningGuideInstructions>> responseEntity = null;
        try {
            cleaningGuideInstructions = cargosService.GetCleaningInstructions(cargosIds).get();
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






} // Class
