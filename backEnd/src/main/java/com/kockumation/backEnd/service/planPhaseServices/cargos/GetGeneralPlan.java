package com.kockumation.backEnd.service.planPhaseServices.cargos;

import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CargoToBeLoaded;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.submitGeneralPlan.GeneralInfo;
import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class GetGeneralPlan {

    private ExecutorService executor;

    public GetGeneralPlan() {
        executor = Executors.newSingleThreadExecutor();
    }

    // Helper methods *************************  Helper methods  ******************************** Helper methods ********************************
    // Get General plan from  General plan table ****************************** Get General plan from  General plan table   ***************************************
    public Future<JSONObject> getGeneralPlanInformation(String general_plan_id) {
        JSONObject generalPlanObject = new JSONObject();
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql = String.format("SELECT * FROM wash_master.general_plan gp  WHERE general_plan_id =\"%s\"", general_plan_id);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                generalPlanObject.put("general_plan_id", rs.getString("general_plan_id"));
                generalPlanObject.put("genInfoDate", rs.getString("genInfoDate"));
                generalPlanObject.put("genInfoTime", rs.getString("genInfoTime"));
                generalPlanObject.put("nextLoadPort", rs.getString("nextLoadPort"));
                generalPlanObject.put("positionOfTankCleaning", rs.getString("positionOfTankCleaning"));
                generalPlanObject.put("manualLocation", rs.getString("manualLocation"));
                generalPlanObject.put("sequenceOfWashing", rs.getString("sequenceOfWashing"));
                generalPlanObject.put("userName", rs.getString("userName"));
                generalPlanObject.put("vesselName", rs.getString("vesselName"));
                generalPlanObject.put("voyageId", rs.getString("voyageId"));
                generalPlanObject.put("machineName", rs.getString("machineName"));
                generalPlanObject.put("nozzle_diameter", rs.getString("nozzle_diameter"));



            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                return generalPlanObject;
            });
        }
        return executor.submit(() -> {

            return generalPlanObject;
        });

    }// Get General plan from  General plan table ****************************** Get General plan from  General plan table   ***************************************


    // Get Tanks plans from  tanks_plan table ****************************** Get Tanks plans from  tanks_plan table  ***************************************
    public Future<List<JSONObject>> getTanksPlans(String general_plan_id) {
        List<JSONObject> tanksPlans = new ArrayList<>();
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql = String.format("SELECT * FROM wash_master.tank_plans  WHERE general_plan_id =\"%s\"", general_plan_id);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                JSONObject tankPlan = new JSONObject();
                tankPlan.put("tankId", rs.getInt("tankId"));
                tankPlan.put("cleaningMethod", rs.getString("cleaningMethod"));
                tankPlan.put("stepsCtr", rs.getInt("stepsCtr"));
                tankPlan.put("tcmIda", rs.getInt("tcmIda"));
                tankPlan.put("tcmIdb", rs.getInt("tcmIdb"));
                tankPlan.put("nextCargo", rs.getString("nextCargo"));
                tankPlan.put("previousCargo", rs.getString("previousCargo"));
                tankPlan.put("tankCoating", rs.getString("tankCoating"));
                tankPlan.put("tankAtmosphere", rs.getString("tankAtmosphere"));
                tankPlan.put("oxygenLevel", rs.getDouble("oxygenLevel"));
                tankPlan.put("tankComments", rs.getString("tankComments"));
                tankPlan.put("hc", rs.getDouble("hc"));
                tanksPlans.add(tankPlan);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                return tanksPlans;
            });
        }
        return executor.submit(() -> {

            return tanksPlans;
        });

    }// Get Tanks plans from  tanks_plan table ****************************** Get Tanks plans from  tanks_plan table  ***************************************

    // Get Tanks plans from  tanks_plan table ****************************** Get Tanks plans from  tanks_plan table  ***************************************
    public Future<List<JSONObject>> getSteps(String general_plan_id) {
        List<JSONObject> stepsList = new ArrayList<>();
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql = String.format("SELECT * FROM wash_master.steps  WHERE general_plan_id =\"%s\"", general_plan_id);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                JSONObject steps = new JSONObject();
                steps.put("tankId", rs.getInt("tankId"));
                steps.put("stepNumber", rs.getInt("stepNumber"));
                steps.put("stepProfile", rs.getInt("stepProfile"));
                steps.put("lWsValue", rs.getInt("lWsValue"));
                steps.put("uWsValue", rs.getInt("uWsValue"));
                steps.put("step_profile_name", rs.getString("step_profile_name"));
                steps.put("washingMedia", rs.getString("washingMedia"));
                steps.put("cleaning_time_in_minutes", rs.getInt("cleaning_time_in_minutes"));
                steps.put("timeForOperation", rs.getInt("timeForOperation"));
                steps.put("speed", rs.getInt("speed"));
                steps.put("pitch", rs.getDouble("pitch"));
                steps.put("rpm", rs.getDouble("rpm"));
                steps.put("bar", rs.getDouble("bar"));
                steps.put("washing_Media_Amount", rs.getDouble("washing_Media_Amount"));
                stepsList.add(steps);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                return stepsList;
            });
        }
        return executor.submit(() -> {

            return stepsList;
        });

    }// Get Tanks plans from  tanks_plan table ****************************** Get Tanks plans from  tanks_plan table  ***************************************


    // Helper methods *************************  Helper methods  ******************************** Helper methods ********************************

    //Get General plans ids *************** Get General plans ids ************************
    public Future<List<JSONObject>> getGeneralPlanIds() {
        List<JSONObject> generalPlansList = new ArrayList<>();

        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            String sql = "SELECT general_plan_id FROM wash_master.general_plan";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                JSONObject generalPlanObject = new JSONObject();
                generalPlanObject.put("general_plan_id", rs.getString("general_plan_id"));

                generalPlansList.add(generalPlanObject);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                System.out.println("Not valid");
                return generalPlansList;
            });
        }
        return executor.submit(() -> {
            System.out.println("General plans Ids has been sent..");
            return generalPlansList;
        });
    }//Get General plans ids *************** Get General plans ids ************************
// *****************************************************************************************************************************************

    // Get general plan Information By Id *************** Get general plan Information By Id ************************
    public Future<JSONObject> getGeneralPlanObject(String general_plan_id) {
        JSONObject generalPlanObject = new JSONObject();
        List<JSONObject> tanksPlans = new ArrayList<>();
        List<JSONObject> stepsList = new ArrayList<>();
        try {
            generalPlanObject = getGeneralPlanInformation(general_plan_id).get();
            if (generalPlanObject.size() == 0) {

            } else {
                tanksPlans = getTanksPlans(general_plan_id).get();
                if (tanksPlans.size() == 0) {
                    System.out.println("No tanks plans..");
                } else {
                    stepsList = getSteps(general_plan_id).get();
                    if (stepsList.size() == 0) {
                        System.out.println("No steps..");
                    } else {
                        for (JSONObject tankPlan : tanksPlans) {
                            List<JSONObject> tankPlanSteps = new ArrayList<>();
                            for (JSONObject step : stepsList) {
                                if (tankPlan.get("tankId").toString().equalsIgnoreCase(step.get("tankId").toString())) {
                                    tankPlanSteps.add(step);

                                }
                            }
                            tankPlan.put("steps",tankPlanSteps);
                        }
                    }

                    generalPlanObject.put("tanks", tanksPlans);
                    //System.out.println(tanksPlans.get(1).get("tankId").toString());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        JSONObject finalGeneralPlanObject = generalPlanObject;
        return executor.submit(() -> {

            return finalGeneralPlanObject;
        });
    }

    // Get general plan Information By Id *************** Get general plan Information By Id ************************

}
