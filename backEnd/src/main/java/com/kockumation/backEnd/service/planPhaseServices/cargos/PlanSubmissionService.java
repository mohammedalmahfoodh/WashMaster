package com.kockumation.backEnd.service.planPhaseServices.cargos;

import com.kockumation.backEnd.service.planPhaseServices.cargos.model.machine.MachinePostObject;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan.GeneralInfo;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan.Step;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan.SubmissionPlanObject;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan.Tank;
import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PlanSubmissionService {
    @Autowired
    private MachineService machineService;
    private ExecutorService executor;

    public PlanSubmissionService() {
        executor = Executors.newSingleThreadExecutor();
    }

    // Helper methods *************************  Helper methods  ******************************** Helper methods ************************************** Helper methods *****
    private double roundTowDigits(double value) {

        double roundedValue = Math.round(value * 100.0) / 100.0;
        return roundedValue;
    }

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






    // Insert General plan into  General plan table ****************************** Insert General plan into  General plan table   ***************************************
    public Future<Boolean> insertGeneralPlan(GeneralInfo generalInfo) {

        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String query = "INSERT INTO general_plan (general_plan_id ,vesselName ,voyageId,nextLoadPort,sequenceOfWashing,positionOfTankCleaning,genInfoDate,genInfoTime,userName,manualLocation,machineName,nozzle_diameter,planID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setString(1, generalInfo.getGeneral_plan_id());
            preparedStmt.setString(2, generalInfo.getVesselName());
            preparedStmt.setString(3, generalInfo.getVoyageId());
            preparedStmt.setString(4, generalInfo.getNextLoadPort());
            preparedStmt.setString(5, generalInfo.getSequenceOfWashing());
            preparedStmt.setString(6, generalInfo.getPositionOfTankCleaning());
            preparedStmt.setString(7, generalInfo.getGenInfoDate());
            preparedStmt.setString(8, generalInfo.getGenInfoTime());
            preparedStmt.setString(9, generalInfo.getUserName());
            preparedStmt.setString(10, generalInfo.getManualLocation());
            preparedStmt.setString(11, generalInfo.getMachineName());
            preparedStmt.setString(12, generalInfo.getNozzle_diameter());
            preparedStmt.setString(13, generalInfo.getPlanID());
            int rowAffected = preparedStmt.executeUpdate();

            preparedStmt.clearParameters();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                return false;
            });
        }
        return executor.submit(() -> {

            return true;
        });

    }// Insert General plan into  General plan table ****************************** Insert General plan into  General plan table   ***************************************


    // Insert Tank plan into Tank Plans table *****************************************
    public Future<Boolean> insertTanksPlan(List<Tank> tanks) {

        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            String query = "INSERT INTO tank_plans (tankPlanId,tankId,tcmId,general_plan_id,cleaningMethod,stepsCtr,tcmIda,tcmIdb,nextCargo,previousCargo,tankCoating,tankAtmosphere,oxygenLevel,tankComments,hc,numberOfMachines,cleaningMethod2,nextMarpol,previousMarpol,hcLabel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            for (Tank tank : tanks) {

                preparedStmt.setString(1, tank.getTankPlanId());
                preparedStmt.setInt(2, tank.getTankId());
                preparedStmt.setInt(3, tank.getTcmId());
                preparedStmt.setString(4, tank.getGeneral_plan_id());
                preparedStmt.setString(5, tank.getCleaningMethod());
                preparedStmt.setInt(6, tank.getStepsCtr());
                preparedStmt.setInt(7, tank.getTcmIda());
                preparedStmt.setInt(8, tank.getTcmIdb());
                preparedStmt.setString(9, tank.getNextCargo());
                preparedStmt.setString(10, tank.getPreviousCargo());
                preparedStmt.setString(11, tank.getTankCoating());
                preparedStmt.setString(12, tank.getTankAtmosphere());
                preparedStmt.setDouble(13, tank.getOxygenLevel());
                preparedStmt.setString(14, tank.getTankComments());
                preparedStmt.setDouble(15, tank.getHc());
                preparedStmt.setInt(16, tank.getNumberOfMachines());
                preparedStmt.setInt(17, tank.getCleaningMethod2());
                preparedStmt.setString(18, tank.getNextMarpol());
                preparedStmt.setString(19, tank.getPreviousMarpol());
                preparedStmt.setString(20, tank.getHcLabel());


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
            //  Thread.sleep(3000);
            return true;
        });

    } // Insert Tank plan into Tank Plans table *****************************************

    // Insert Step plan into steps table *****************************************
    public Future<Boolean> insertStepsPlan(List<Step> steps) {

        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            String query = "INSERT INTO steps (stepNumber,tankId,tankPlanId,general_plan_id,stepProfile,step_profile_name,timeForOperation,washType,lWsValue,uWsValue,washingMedia,cleaning_time_in_minutes,speed,pitch,washing_Media_Amount,washingMedia2,comments) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            for (Step step : steps) {

                preparedStmt.setInt(1, step.getStepNumber());
                preparedStmt.setInt(2, step.getTankId());
                preparedStmt.setString(3, step.getTankPlanId());
                preparedStmt.setString(4, step.getGeneral_plan_id());
                preparedStmt.setInt(5, step.getStepProfile());
                preparedStmt.setString(6, step.getStep_profile_name());
                preparedStmt.setInt(7, step.getTimeForOperation());
                preparedStmt.setInt(8, step.getWashType());
                preparedStmt.setInt(9, step.getlWsValue());
                preparedStmt.setInt(10, step.getuWsValue());
                preparedStmt.setInt(11, step.getWashingMedia());
                preparedStmt.setInt(12, step.getCleaning_time_in_minutes());
                preparedStmt.setInt(13, step.getSpeed());
                preparedStmt.setDouble(14, step.getPitch());
                preparedStmt.setDouble(15, step.getWashing_Media_Amount());
                preparedStmt.setInt(16, step.getWashingMedia2());
                preparedStmt.setString(17, step.getComments());
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
            //  Thread.sleep(3000);
            return true;
        });

    } // Insert Step plan into steps table *****************************************

    // Helper methods *************************  Helper methods  ******************************** Helper methods *******

    // Submit General plan. ************** Submit General plan. *************** Submit General plan. ***************************
    public Future<Boolean> submitGeneralPlan(SubmissionPlanObject submissionPlanObject) {
        boolean isMachineNameValid = isMachineNameValid(submissionPlanObject.getGeneralInfo().getMachineName()) ;
        if (isMachineNameValid){
            System.out.println("Machine name is valid..");
        }else {
            return executor.submit(() -> {

                return false;
            });
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String general_plan_id = LocalDateTime.now(Clock.systemUTC()).format(formatter);

        submissionPlanObject.getGeneralInfo().setGeneral_plan_id(general_plan_id);

        for (Tank tank : submissionPlanObject.getTanks()) {
            String tankPlanId = LocalDateTime.now(Clock.systemUTC()).format(formatter);
            tankPlanId = tankPlanId.concat(" tankId " + tank.getTankId());

            // **********************   Tank preparation *************************************** //
            tank.setGeneral_plan_id(general_plan_id);
            tank.setTankPlanId(tankPlanId);
            if (tank.getTcmIda() != 0) {
                tank.setTcmId(tank.getTcmIda());
            } else if (tank.getTcmIdb() != 0) {
                tank.setTcmId(tank.getTcmIdb());
            }

            if (tank.getTcmIda() == 0 || tank.getTcmIdb() == 0) {
                tank.setNumberOfMachines(1);
            } else {
                tank.setNumberOfMachines(2);
            }
            // *************************      Step preparation   ************************************ //
            for (Step step : tank.getSteps()) {
                step.setGeneral_plan_id(general_plan_id);
                step.setTankPlanId(tankPlanId);
                step.setTankId(tank.getTankId());

                if (step.getStepProfile() == 4) {
                    JSONObject washing_capacity = new JSONObject();
                    MachinePostObject machinePostObject = new MachinePostObject();
                    machinePostObject.setBar(step.getBar());
                    machinePostObject.setMachineName(submissionPlanObject.getGeneralInfo().getMachineName());
                  // System.out.println(machinePostObject);
                    try {
                        washing_capacity = machineService.getCapacityDataForBar(machinePostObject).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                     if (step.getBar() >= 6 && step.getBar() <= 12  && submissionPlanObject.getGeneralInfo().getMachineName() !=null){
                         double nozzleDiameterTh = (double) washing_capacity.get(submissionPlanObject.getGeneralInfo().getNozzle_diameter());
                         //    System.out.println(nozzleDiameterTh);
                         double timeInHours = (double) step.getCleaning_time_in_minutes() / 60;
                         //  System.out.println(timeInHours);
                         timeInHours = roundTowDigits(timeInHours);
                         double washingMediaAmount = nozzleDiameterTh * (timeInHours);
                         washingMediaAmount = roundTowDigits(washingMediaAmount);

                         double allWashingMediaAmount = tank.getNumberOfMachines() * washingMediaAmount;
                         step.setWashing_Media_Amount(allWashingMediaAmount);
                     }
                }
            }

        }

        boolean generalPlanInserted = false;
        boolean tanksPlanInserted = false;
        boolean stepsInserted = false;
        try {
            generalPlanInserted = insertGeneralPlan(submissionPlanObject.getGeneralInfo()).get();
            if (generalPlanInserted) {

                tanksPlanInserted = insertTanksPlan(submissionPlanObject.getTanks()).get();
                if (tanksPlanInserted) {
                    System.out.println("Tanks plans inserted");

                    for (Tank tank : submissionPlanObject.getTanks()) {
                        stepsInserted = insertStepsPlan(tank.getSteps()).get();
                    }

                } else {
                    System.out.println("Tanks plan not inserted");
                    return executor.submit(() -> {
                        return false;
                    });
                }

                System.out.println("General Plan Inserted..");


            } else {
                System.out.println("General plan not inserted");
                return executor.submit(() -> {
                    return false;
                });
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return executor.submit(() -> {

            return true;
        });
    } // Submit General plan. ************** Submit General plan. *************** Submit General plan. ***************************


}
