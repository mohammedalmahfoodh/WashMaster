package com.kockumation.backEnd.controller.PlanPhase;

import com.kockumation.backEnd.service.planPhaseServices.cargos.GetTankInfoService;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CargosModel;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.tankInfo.GetTankInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/")
public class GetTankInfoController {

    @Autowired
    GetTankInfoService getTankInfoService;

    @GetMapping("/getTankInfo")
    public ResponseEntity<List<GetTankInfo>> getPreviousCargos() {

        List<GetTankInfo> getTankInfoList ;

        ResponseEntity<List<GetTankInfo>> responseEntity = null;
        try {
            getTankInfoList = getTankInfoService.getTankInfo().get();
            if (getTankInfoList.size() == 0) {
                System.out.println("No elements");
                responseEntity = new ResponseEntity<List<GetTankInfo>>(
                        getTankInfoList,
                        HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<List<GetTankInfo>>(
                        getTankInfoList,
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
