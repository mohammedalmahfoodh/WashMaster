package com.kockumation.backEnd.service.planPhaseServices.cargos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Cargos {
    private ExecutorService executor
            = Executors.newSingleThreadExecutor();
   List<Integer>integerList = new ArrayList<>();
    public Future<List<Integer>> getPreviousCargos() {
        return executor.submit(() -> {
            integerList.add(1);
            integerList.add(2);
            Thread.sleep(2000);
            return integerList;
        });
    }

}
