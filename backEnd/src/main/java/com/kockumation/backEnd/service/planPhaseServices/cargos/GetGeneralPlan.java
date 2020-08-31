package com.kockumation.backEnd.service.planPhaseServices.cargos;

import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GetGeneralPlan {

    private ExecutorService executor;

    public GetGeneralPlan() {
        executor = Executors.newSingleThreadExecutor();
    }

    // Helper methods *************************  Helper methods  ******************************** Helper methods ********************************

    // Is General plan id valid  **************************  Is General plan id valid ************************************************
    public Future<Boolean> isGeneralPlanIdValid(String general_plan_id) {

        String pattern = "^((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])\\s(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(general_plan_id.toLowerCase());
        boolean isGeneralPlanIdValid = m.matches();


        return executor.submit(() -> {
            return isGeneralPlanIdValid;
        });
    }  // Is General plan id valid  **************************  Is General plan id valid ************************************************

    //Is General plan id exists in DB ******** Is General plan id exists in DB ********************
    public Future<Boolean> isIsGeneralPlanExists(String general_plan_id) {

        String sql = String.format("SELECT * from general_plan   WHERE general_plan_id =\"%s\"", general_plan_id);
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
    } // Is General plan id exists in DB ************ Is General plan id exists in DB  ********************


    // Get General plan from  General plan table ****************************** Get General plan from  General plan table   ***************************************
    public Future<JSONObject> getGeneralPlanInformation(String general_plan_id) {
        JSONObject generalPlanObject = new JSONObject();
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql = String.format("SELECT * FROM wash_master.general_plan gp  WHERE general_plan_id =\"%s\"", general_plan_id);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                generalPlanObject.put("general_plan_id", rs.getString("general_plan_id"));
                generalPlanObject.put("vesselName", rs.getString("vesselName"));
                generalPlanObject.put("planID", rs.getString("planID"));
                generalPlanObject.put("voyageId", rs.getString("voyageId"));
                generalPlanObject.put("nextLoadPort", rs.getString("nextLoadPort"));
                generalPlanObject.put("sequenceOfWashing", rs.getString("sequenceOfWashing"));
                generalPlanObject.put("positionOfTankCleaning", rs.getString("positionOfTankCleaning"));
                generalPlanObject.put("manualLocation", rs.getString("manualLocation"));
                generalPlanObject.put("genInfoDate", rs.getString("genInfoDate"));
                generalPlanObject.put("genInfoTime", rs.getString("genInfoTime"));
                generalPlanObject.put("machineName", rs.getString("machineName"));
                generalPlanObject.put("nozzle_diameter", rs.getString("nozzle_diameter"));
                generalPlanObject.put("userName", rs.getString("userName"));


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
                tankPlan.put("cleaningMethod2", rs.getInt("cleaningMethod2"));
                tankPlan.put("nextMarpol", rs.getString("nextMarpol"));
                tankPlan.put("previousMarpol", rs.getString("previousMarpol"));
                tankPlan.put("stepsCtr", rs.getInt("stepsCtr"));
                tankPlan.put("tcmIda", rs.getInt("tcmIda"));
                tankPlan.put("tcmIdb", rs.getInt("tcmIdb"));
                tankPlan.put("nextCargo", rs.getString("nextCargo"));
                tankPlan.put("previousCargo", rs.getString("previousCargo"));
                tankPlan.put("numberOfMachines", rs.getInt("numberOfMachines"));
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
                steps.put("washingMedia", rs.getInt("washingMedia"));
                steps.put("cleaning_time_in_minutes", rs.getInt("cleaning_time_in_minutes"));
                steps.put("timeForOperation", rs.getInt("timeForOperation"));
                steps.put("speed", rs.getInt("speed"));
                steps.put("pitch", rs.getDouble("pitch"));
                steps.put("rpm", rs.getDouble("rpm"));
                steps.put("bar", rs.getDouble("bar"));
                steps.put("washing_Media_Amount", rs.getDouble("washing_Media_Amount"));
                steps.put("washingMedia2", rs.getInt("washingMedia2"));
                steps.put("comments", rs.getString("comments"));

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
        JSONObject generalInfo = new JSONObject();
        List<JSONObject> tanksPlans = new ArrayList<>();
        List<JSONObject> stepsList = new ArrayList<>();

        try {
            boolean isGeneralPlanIdValid = isGeneralPlanIdValid(general_plan_id).get();

            if (isGeneralPlanIdValid) {

                generalInfo = getGeneralPlanInformation(general_plan_id).get();
                if (generalInfo.size() == 0) {
                    System.out.println("No General plan with this id..");
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
                                tankPlan.put("steps", tankPlanSteps);
                            }
                        }
                        generalPlanObject.put("generalInfo",generalInfo);
                        generalPlanObject.put("tanks",tanksPlans);

                        //System.out.println(tanksPlans.get(1).get("tankId").toString());
                    }
                }

            } else {
                System.out.println("General plan id not valid format...");
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
