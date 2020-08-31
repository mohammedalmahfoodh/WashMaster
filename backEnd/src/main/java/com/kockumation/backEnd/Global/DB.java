package com.kockumation.backEnd.Global;

import com.kockumation.backEnd.engine.TankCleaningMachine;


import java.util.HashMap;
import java.util.Map;

public class DB {

    public static Map<Integer, TankCleaningMachine> tcmMap = new HashMap<>();
    public static void iterateTankConfigurations() {
        tcmMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
    }

}
