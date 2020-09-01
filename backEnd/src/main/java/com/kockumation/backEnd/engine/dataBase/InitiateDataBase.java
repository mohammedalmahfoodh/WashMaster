package com.kockumation.backEnd.engine.dataBase;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kockumation.backEnd.Global.DB;
import com.kockumation.backEnd.engine.TankCleaningMachine;
import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import com.kockumation.backEnd.utilities.TankInfo;
import com.kockumation.backEnd.utilities.TanksConfig;
import com.kockumation.backEnd.utilities.TanksInformation;

import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InitiateDataBase {
    TanksConfig tanksConfig;
    TanksInformation tanksInformation;
    private ExecutorService executor ;


    public InitiateDataBase() {
        tanksConfig = new TanksConfig();
        tanksInformation = new TanksInformation();
        executor = Executors.newSingleThreadExecutor();
    }


    // Check if data exists in Tanks info table *****************************************
    public Future<Boolean> checkIfDataExists() {
        String sql = "SELECT *  FROM tank_info WHERE tcmId=1 ";
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                //    System.out.println(rs.getString(2));
                return executor.submit(() -> {
                    Thread.sleep(1000);
                    return true;
                });
            } else {
                //   System.out.println(rs);
                return executor.submit(() -> {
                    Thread.sleep(1000);
                    return false;
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {

                return false;
            });
        }

    }// Check if data exists in Tanks info table *****************************************

    // Update Tanks table  ****************************** Update Tanks table    ***************************************
    public Future<Boolean> updateTanksInfoTable() {

        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String updateTanksInfo = "UPDATE tank_info set tankId = ?,tankName =?,machine_char =?,machineName =?,nozzle_diameter=?  where (tcmId = ? );";
            PreparedStatement preparedStmt = conn.prepareStatement(updateTanksInfo, Statement.RETURN_GENERATED_KEYS);
            for (TankInfo tankInfo : tanksInformation.getTanksConfig()) {
                preparedStmt.setInt(1, tankInfo.getTankId());
                preparedStmt.setString(2, tankInfo.getTankName());
                preparedStmt.setString(3, tankInfo.getMachine_char());
                preparedStmt.setString(4, tankInfo.getMachineName());
                preparedStmt.setString(5, tankInfo.getNozzle_diameter());
                preparedStmt.setInt(6, tankInfo.getTcmId());

                int rowAffected = preparedStmt.executeUpdate();
                preparedStmt.clearParameters();
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                return false;
            });
        }
        return executor.submit(() -> {
            return true;
        });

    }// Update Tanks table  ****************************** Update Tanks table    ***************************************

    // Insert into Tanks info table  ****************************** Insert into Tanks info table   ***************************************
    public Future<Boolean> insertTanksInfoTable() {

        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String query = "INSERT INTO tank_info (tankId,tankName,machine_char,machineName,nozzle_diameter) VALUES (?,?,?,?,?);";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (TankInfo tankInfo : tanksInformation.getTanksConfig()) {
                preparedStmt.setInt(1, tankInfo.getTankId());
                preparedStmt.setString(2, tankInfo.getTankName());
                preparedStmt.setString(3, tankInfo.getMachine_char());
                preparedStmt.setString(4, tankInfo.getMachineName());
                preparedStmt.setString(5, tankInfo.getNozzle_diameter());

                int rowAffected = preparedStmt.executeUpdate();
                preparedStmt.clearParameters();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                return false;
            });
        }
        return executor.submit(() -> {
            return true;
        });

    }  // Insert into Tanks info table  ****************************** Insert into Tanks info table   ***************************************

    // Get list of Tanks information ********* Get list of Tanks information *************************
    public Future<Boolean>  getListOfTanksInfo() {

        try {

           tanksInformation = new ObjectMapper().readValue(TanksConfig.getTanksConfigString(), TanksInformation.class);

         // Populate tankMap configurations with tanks configurations from file json..
          for (TankInfo tankInfo:    tanksInformation.getTanksConfig()) {
              TankCleaningMachine tankCleaningMachine = new TankCleaningMachine();
              tankCleaningMachine.setTcmID(tankInfo.getTcmId());
              tankCleaningMachine.setTankId(tankInfo.getTankId());
              tankCleaningMachine.setTankName(tankInfo.getTankName());
              tankCleaningMachine.setMachineName(tankInfo.getMachineName());
              tankCleaningMachine.setNozzle_diameter(tankInfo.getNozzle_diameter());
                DB.tcmMap.put(tankInfo.getTcmId(),tankCleaningMachine);
            }

           // System.out.println(DB.tankConfigurations.get(1));
        } catch (JsonProcessingException e) {
         //   e.printStackTrace();
            Scanner in = new Scanner(System.in);
            System.out.println("**************************************************** OOPS **********************************************************");
            System.out.println("Error .Config file is empty or has wrong format ");
            System.out.println("Type exit to exit or close the app with x on the right window corner");
            try {
                while (in.hasNextLine()) {

                    String line = in.nextLine().toLowerCase();
                    System.out.println("You have typed " + line);
                    System.out.println("Please type exit to quit the program");
                    if (line.equals("exit")) {
                        System.exit(0);
                        in.close();
                    }
                }

            } finally {
                if (in != null)
                    in.close();
            }

            return executor.submit(() -> {
                return false;
            });

        }

        return executor.submit(() -> {
            return true;
        });

    }  // Get list of Tanks information ********* Get list of Tanks information *************************


} // Class
