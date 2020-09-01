package com.kockumation.backEnd.service.planPhaseServices.cargos;

import com.kockumation.backEnd.service.planPhaseServices.cargos.model.machine.MachineName;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.machine.MachinePostObject;
import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MachineService {
    private ExecutorService executor
            = Executors.newSingleThreadExecutor();
    // Helper methods *************************  Helper methods  ******************************** Helper methods ************************************** Helper methods *****
    // Is Machine Name Valid ************** Is Machine Name Valid *************** Is Machine Name Valid ***************************
    public boolean isMachineNameValid(String machineName) {
        if (machineName != null) {
            String pattern = "pj[0-9]+_capacity_data";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(machineName.toLowerCase());
            boolean isMachineNameValid = m.matches();

            if (isMachineNameValid) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }// Is Machine Name Valid ************** Is Machine Name Valid *************** Is Machine Name Valid ***************************

    //Is machine name exists ******** Is machine name exists  ********************
    public Future<Boolean> isMachineNameExists(String machineName) {

        String sql = String.format("SELECT table_name  FROM information_schema.tables  WHERE table_schema ='wash_master' AND table_name =\"%s\"", machineName);
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return executor.submit(() -> {
                    return true;
                });
            } else {
                return executor.submit(() -> {

                    return false;
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {

                return false;
            });
        }
    } //Is machine name exists ******** Is machine name exists  ********************



    // Get Machine Name and Nozzle Diameter ******** Get Machine Name and Nozzle Diameter  ********************
    public Future<MachineName> getMachineNameNozzleDiameter(String general_plan_id) {
        MachineName machineName = new MachineName();
        String sql = String.format("SELECT machineName,nozzle_diameter  FROM general_plan  WHERE general_plan_id =%s",general_plan_id);
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                machineName.setMachineName(rs.getString("machineName"));
                machineName.setMachineName(rs.getString("nozzle_diameter"));
                return executor.submit(() -> {
                    return machineName;
                });
            } else {
                return executor.submit(() -> {

                    return machineName;
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {

                return machineName;
            });
        }
    } // Get Machine Name and Nozzle Diameter ******** Get Machine Name and Nozzle Diameter  ********************

    //Get Bar throughput object ************ Get Bar throughput object  ********************
    public Future<JSONObject> getBarThroughPutObject(MachinePostObject machinePostObject) {
        JSONObject lowBarThroughPutObject = new JSONObject();
        String machineName = machinePostObject.getMachineName();
        double bar = machinePostObject.getBar();


        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql2 = String.format("select * from %s WHERE bar = %f", machineName, bar);

            Statement stmt2 = conn.createStatement();

            ResultSet rs2 = stmt2.executeQuery(sql2);
            ResultSetMetaData resultSetMetaData = rs2.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (rs2.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    String columnName = resultSetMetaData.getColumnName(i);
                    lowBarThroughPutObject.put(columnName, rs2.getFloat(i));
                }

            }

            return executor.submit(() -> {

                return lowBarThroughPutObject;
            });

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return executor.submit(() -> {

            return lowBarThroughPutObject;
        });

    }  //Get Bar throughput object ************ Get Bar throughput object  ********************


    // Helper methods *************************  Helper methods  ******************************** Helper methods ************************************** Helper methods *****

    //Get Machines names ******** Machines names  ********************
    public Future<List<String>> getMachinesNames() {

        List<String> machinesNames = new ArrayList<>();

        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String pattern = "pj[0-9]+_capacity_data";
            Pattern p = Pattern.compile(pattern);
            String table_schema = "wash_master";
            String sql = String.format("SELECT table_name FROM information_schema.tables where (table_schema = \"%s\" );", table_schema);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Matcher m = p.matcher(rs.getString("TABLE_NAME"));
                boolean b = m.matches();
                if (b) {
                    machinesNames.add(rs.getString("TABLE_NAME"));
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return executor.submit(() -> {

            return machinesNames;
        });
    }//Get Machines names ******** Machines names  ********************

    //Get Capacity Data For Machine ******** Capacity Data For Machine ********************
    public Future<List<JSONObject>> getCapacityDataForMachine(String machineName) {

        List<JSONObject> capacityDataThroughput = new ArrayList<>();

        if (!isMachineNameValid(machineName)) {
            return executor.submit(() -> {
                System.out.println("Not valid");
                return capacityDataThroughput;
            });
        } else {
            try {
                boolean isMachineExists = isMachineNameExists(machineName).get();

                if (isMachineExists) {

                    try (Connection conn = MySQLJDBCUtil.getConnection()) {
                        String sql2 = String.format("select * from %s", machineName);
                        Statement stmt2 = conn.createStatement();

                        ResultSet rs2 = stmt2.executeQuery(sql2);
                        ResultSetMetaData resultSetMetaData = rs2.getMetaData();
                        int columnCount = resultSetMetaData.getColumnCount();
                        while (rs2.next()) {
                            JSONObject throughput = new JSONObject();
                            // The column count starts from 1
                            for (int i = 1; i <= columnCount; i++) {
                                if (!resultSetMetaData.getColumnName(i).endsWith("id")) {
                                    String columnName = resultSetMetaData.getColumnName(i);
                                    throughput.put(columnName, rs2.getFloat(i));
                                }
                            }
                            capacityDataThroughput.add(throughput);

                        }

                        return executor.submit(() -> {

                            return capacityDataThroughput;
                        });

                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    return executor.submit(() -> {
                        System.out.println("Not valid");
                        return capacityDataThroughput;
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();

                return executor.submit(() ->
                {
                    return capacityDataThroughput;
                });
            }
            return executor.submit(() -> {
                System.out.println("Not valid");
                return capacityDataThroughput;
            });
        }
    } //Get Capacity Data For Machine ******** Capacity Data For Machine ********************


// Get capacity for a specific Machine and pressure. ****************************** Get capacity for a specific Machine and pressure. ******************************************************

    public Future<JSONObject> getCapacityDataForBar(MachinePostObject machinePostObject) {
        String machineName = machinePostObject.getMachineName();
        double bar = machinePostObject.getBar();
        double decimalPart = (bar - Math.floor(bar)) * 10;
        double lowBar = Math.floor(bar);
        double highBar = lowBar + 1;

     /*/   System.out.println("decimal part is " + decimalPart);
        System.out.println("Bar is " + bar);
        System.out.println("Low bar is " + lowBar);
        System.out.println("High bar is " + highBar);
        System.out.println("decimal part: "+decimalPart);*/

        JSONObject capacityDataThroughput = new JSONObject();
        JSONObject lowCapacityThroughPut = new JSONObject();
        JSONObject highCapacityThroughPut = new JSONObject();

        if (!isMachineNameValid(machineName)) {
            return executor.submit(() -> {
                System.out.println("Not valid");
                return new JSONObject();
            });
        } else {
            try {
                boolean isMachineExists = isMachineNameExists(machineName).get();

                if (isMachineExists) {
                    machinePostObject.setBar(lowBar);
                    lowCapacityThroughPut = getBarThroughPutObject(machinePostObject).get();
                  //  System.out.println(lowCapacityThroughPut);
                    machinePostObject.setBar(highBar);
                    highCapacityThroughPut = getBarThroughPutObject(machinePostObject).get();
                  //  System.out.println(highCapacityThroughPut);
                    Set keys = lowCapacityThroughPut.keySet();
                  //  System.out.println(keys);
                    for (Object key : keys) {
                        String stringKey = key.toString();
                        if (!stringKey.equalsIgnoreCase("bar") && !stringKey.endsWith("id")){
                            double highTh = Double.parseDouble(highCapacityThroughPut.get(key).toString()) ;
                            double lowTh = Double.parseDouble(lowCapacityThroughPut.get(key).toString()) ;

                            double deltaPerDecimal = (highTh - lowTh) / 10 ;
                           double  throughPutBar = lowTh +  (deltaPerDecimal * decimalPart);
                         //   System.out.println("Key Low: "+key+" and value is: "+ lowTh );
                         //   System.out.println("Key High: "+key+" and value is: "+ highTh );
                            capacityDataThroughput.put(stringKey,throughPutBar);

                        }

                       // System.out.println(key.toString());
                    }

                } else {
                    JSONObject finalLowCapacityThroughPut = capacityDataThroughput;
                    return executor.submit(() -> {
                        System.out.println("Machine Not exists in db");
                        return finalLowCapacityThroughPut;
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();

                JSONObject finalLowCapacityThroughPut1 = capacityDataThroughput;
                return executor.submit(() ->
                {
                    return finalLowCapacityThroughPut1;
                });
            }
            JSONObject finalLowCapacityThroughPut2 = capacityDataThroughput;
            return executor.submit(() -> {

                return finalLowCapacityThroughPut2;
            });
        }


    }


// Get capacity for a specific Machine and pressure. ****************************** Get capacity for a specific Machine and pressure. *************************************




} // Class
