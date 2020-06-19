package com.kockumation.backEnd.controller.PlanPhase;

import com.kockumation.backEnd.service.planPhaseServices.cargos.Cargos;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/plan")
public class cargos {

    @GetMapping("/previousCargos")
    public List<Integer> getPreviousCargos() {
        HashMap<String, JSONObject> map = new HashMap<>();
        List<Integer>integerList = new ArrayList<>();
        Cargos cargos = new Cargos();
        try {
            integerList = cargos.getPreviousCargos().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return integerList;
    }

}
