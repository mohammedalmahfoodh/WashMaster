package com.kockumation.backEnd.service.planPhaseServices.cargos;

import com.kockumation.backEnd.service.planPhaseServices.cargos.model.machine.MachinePostObject;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.washMode.GetManualWashMode;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.washMode.GetWashMode;
import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@Service
public class WashModesService {
    private ExecutorService executor;
    @Autowired
    private MachineService machineService;

    public WashModesService() {
        executor = Executors.newSingleThreadExecutor();

    }

    // Helper methods *************************  Helper methods  ******************************** Helper methods ************************************** Helper methods *****
    private double roundTowDigits(double value) {

        double roundedValue = Math.round(value * 100.0) / 100.0;
        return roundedValue;
    }


    // Helper methods *************************  Helper methods  ******************************** Helper methods ************************************** Helper methods *****


    // Get wash types and ids. ************** Get wash types and ids. *************** Get wash types and ids. ***************************
    public Future<List<JSONObject>> getWashTypeIdsNames() {
        List<JSONObject> washTypesIds = new ArrayList<>();

        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql = "SELECT wm.washType,wm.wash_mode_name   FROM wash_master.wash_modes wm ;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("washType", rs.getInt("washType"));
                jsonObject.put("wash_mode_name", rs.getString("wash_mode_name"));
                washTypesIds.add(jsonObject);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return executor.submit(() -> {

            return washTypesIds;
        });
    } // Get wash types and ids. ************** Get wash types and ids. *************** Get wash types and ids. ***************************

    //Get Get Wash Mode Data ************ Get Wash Mode Data  ********************
    public Future<JSONObject> getWashModeData(GetWashMode getWashMode) {
        JSONObject washModeObject = new JSONObject();
        JSONObject washing_capacity = new JSONObject();

        int washType = getWashMode.getWashType();
        double speed = getWashMode.getSpeed();
        double washingSector = getWashMode.getWashingSector();
        double bar = getWashMode.getBar();
        double desiredTime = getWashMode.getDesiredTime();
        String machineName = getWashMode.getMachineName();
        String wash_mode_name = null;
        String cleaning_machine_name = null;
        String nozzle_diameter = getWashMode.getNozzle_diameter();
        int lower_washing_sector = 0;
        double upper_washing_sector = 0;
        double pitch = 0.0;
        double cleaning_time_in_Minutes = 0;
        double cy = 0.0;
        boolean full_cycle = false;
        double number_of_cycles = 1.0;

        MachinePostObject machinePostObject = new MachinePostObject();
        machinePostObject.setMachineName(machineName);
        machinePostObject.setBar(bar);
        try {
            washing_capacity = machineService.getCapacityDataForBar(machinePostObject).get();
            //  System.out.println(washing_Media_Amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql2 = String.format("select * from wash_modes WHERE washType = %d", washType);

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);

            while (rs2.next()) {
                washingSector = washingSector == 0 ? rs2.getFloat("wash_sector") : washingSector;
                speed = speed == 0 ? rs2.getFloat("speed") : speed;
                washType = rs2.getInt("washType");
                wash_mode_name = rs2.getString("wash_mode_name");
                cleaning_machine_name = rs2.getString("cleaning_machine_name");
                upper_washing_sector = washingSector;
                pitch = rs2.getFloat("pitch");

            }
            if (desiredTime == 0) {
                double rpm = speed;
                int cleaningTime = (int) (((washingSector * 2) / pitch) / speed);
                cleaning_time_in_Minutes = cleaningTime;
            } else {
                cleaning_time_in_Minutes = (int) desiredTime;
            }

            cy = ((cleaning_time_in_Minutes * pitch * speed) / (washingSector * 2));
            full_cycle = cy >= 1 ? true : false;
            number_of_cycles = (Math.floor(cy) == cy) ? cy : roundTowDigits(cy);
            washModeObject.put("washType", washType);
            washModeObject.put("wash_mode_name", wash_mode_name);
            washModeObject.put("cleaning_machine_name", cleaning_machine_name);
            washModeObject.put("washing_sector", washingSector);
            washModeObject.put("lower_washing_sector", lower_washing_sector);
            washModeObject.put("upper_washing_sector", upper_washing_sector);
            washModeObject.put("speed", speed);
            washModeObject.put("pitch", pitch);
            washModeObject.put("cleaning_time_in_Minutes", (long) cleaning_time_in_Minutes);
            washModeObject.put("full_cycle", full_cycle);
            washModeObject.put("number_of_cycles", number_of_cycles);
            double nozzleDiameterTh = (double) washing_capacity.get(nozzle_diameter);
            washModeObject.put(nozzle_diameter, nozzleDiameterTh);
            double timeInHours = cleaning_time_in_Minutes / 60;
            // Calculating washing media amount  =  (nozzle diameter throughput * (TimeInMinutes / 60 ))
            double washingMediaAmount = nozzleDiameterTh * (timeInHours);
            washingMediaAmount = roundTowDigits(washingMediaAmount);

            String nozzleFor = String.format("nozzle_diameter_24_throughput for %f hours", timeInHours);
            JSONObject washingMediaAmountObject = new JSONObject();
            washingMediaAmountObject.put(nozzleFor, washingMediaAmount);
            washModeObject.put("washing_Media_Amount", washingMediaAmountObject);

            return executor.submit(() -> {

                return washModeObject;
            });

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return executor.submit(() -> {

            return washModeObject;
        });

    } //Get Get Wash Mode Data ************ Get Wash Mode Data  ********************

    //Get Get Manual Wash Mode Data ************ Get Manual Wash Mode Data  ********************
    public Future<JSONObject> getManualWashMode(GetManualWashMode getManualWashMode) {
        JSONObject washModeObject = new JSONObject();
        JSONObject washing_capacity = new JSONObject();
        JSONObject washingMediaAmountObject = new JSONObject();

        String nozzle_diameter = getManualWashMode.getNozzle_diameter();
        double speed = getManualWashMode.getSpeed() == 0.0 ? 1 : getManualWashMode.getSpeed();
        double rpm = getManualWashMode.getRpm() == 0 ? 1 : getManualWashMode.getRpm();
        double pitch = getManualWashMode.getPitch() == 0.0 ? 3 : getManualWashMode.getPitch();
        long washSector = getManualWashMode.getuWsValue() - getManualWashMode.getlWsValue();
        double cleaningTimeInMinutes = getManualWashMode.getDesiredTime() == 0 ? ((washSector * 2 ) / pitch) / ((speed * rpm)) : getManualWashMode.getDesiredTime();
        double cy = (cleaningTimeInMinutes * pitch * speed * rpm) / (washSector * 2);
        cy = roundTowDigits(cy);
        cleaningTimeInMinutes = roundTowDigits(cleaningTimeInMinutes);
        washModeObject.put("cleaningTimeInMinutes",cleaningTimeInMinutes);
        washModeObject.put("cycles",cy);
        MachinePostObject machinePostObject = new MachinePostObject();
        machinePostObject.setBar(getManualWashMode.getBar());
        machinePostObject.setMachineName(getManualWashMode.getMachineName());


        try {
            washing_capacity = machineService.getCapacityDataForBar(machinePostObject).get();
            double nozzleDiameterTh = (double) washing_capacity.get(nozzle_diameter);
            double timeInHours = cleaningTimeInMinutes / 60;
            timeInHours = roundTowDigits(timeInHours);

            double washingMediaAmount = nozzleDiameterTh * (timeInHours);
            washingMediaAmount = roundTowDigits(washingMediaAmount);
            String nozzleFor = String.format("nozzle_diameter_24_throughput for %.2f hours", timeInHours);
            washingMediaAmountObject.put(nozzleFor, washingMediaAmount);
            washModeObject.put("washing_Media_Amount",washingMediaAmountObject);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return executor.submit(() -> {

            return washModeObject;
        });

    }//Get Get Manual Wash Mode Data ************ Get Manual Wash Mode Data  ********************


}
