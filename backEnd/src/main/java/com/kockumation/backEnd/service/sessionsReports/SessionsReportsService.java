package com.kockumation.backEnd.service.sessionsReports;

import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class SessionsReportsService {

    private ExecutorService executor;

    public SessionsReportsService() {
        executor
                = Executors.newSingleThreadExecutor();
    }


    //Get Report ids *************** Get Report ids ************************
    public Future<List<JSONObject>> getReportsIds() {
        List<JSONObject> reportIdsList = new ArrayList<>();

        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            String sql = "SELECT report_id FROM wash_master.reports";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                JSONObject reportId = new JSONObject();
                reportId.put("report_id", rs.getString("report_id"));

                reportIdsList.add(reportId);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                System.out.println("Not valid");
                return reportIdsList;
            });
        }
        return executor.submit(() -> {
            System.out.println("Reports Ids has been sent..");
            return reportIdsList;
        });
    }//Get Report ids *************** Get Report ids ************************

    //Get Sessions ids *************** Get Sessions ids ************************
    public Future<List<JSONObject>> getSessionsIds() {
        List<JSONObject> sessionsIdsList = new ArrayList<>();

        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            String sql = "SELECT session_id FROM wash_master.sessions";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                JSONObject sessionId = new JSONObject();
                sessionId.put("session_id", rs.getString("session_id"));

                sessionsIdsList.add(sessionId);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                System.out.println("Not valid");
                return sessionsIdsList;
            });
        }
        return executor.submit(() -> {
            System.out.println("Sessions Ids has been sent..");
            return sessionsIdsList;
        });
    }//Get Sessions ids *************** Get Sessions ids ************************

    // Get Report from  Reports table ****************************** Get Report from  Reports table   ***************************************
    public Future<JSONObject> getReport(String report_id) {
        JSONObject reportObject = new JSONObject();
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql = String.format("SELECT * FROM wash_master.reports  WHERE report_id =\"%s\"", report_id);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                reportObject.put("report_id", rs.getString("report_id"));
                reportObject.put("session_id", rs.getString("session_id"));
                reportObject.put("general_plan_id", rs.getString("general_plan_id"));
                reportObject.put("tankId", rs.getInt("tankId"));
                reportObject.put("tcmId", rs.getInt("tcmId"));
                reportObject.put("machineName", rs.getString("machineName"));
                reportObject.put("nozzle_diameter", rs.getDouble("nozzle_diameter"));
                reportObject.put("stepNumber", rs.getInt("stepNumber"));
                reportObject.put("profileNumber", rs.getInt("profileNumber"));
                reportObject.put("lWsValue", rs.getDouble("lWsValue"));
                reportObject.put("uWsValue", rs.getDouble("uWsValue"));
                reportObject.put("nozzle_diameter", rs.getDouble("nozzle_diameter"));
                reportObject.put("report_start_date", rs.getString("report_start_date"));
                reportObject.put("report_end_date", rs.getString("report_end_date"));
                reportObject.put("cycle", rs.getDouble("cycle"));
                reportObject.put("rpm", rs.getDouble("rpm"));
                reportObject.put("speed", rs.getInt("speed"));
                reportObject.put("pitch", rs.getDouble("pitch"));
                reportObject.put("washing_Media_Amount", rs.getDouble("washing_Media_Amount"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                return reportObject;
            });
        }
        return executor.submit(() -> {

            return reportObject;
        });

    }// Get Report from  Reports table ****************************** Get Reports from  Report table   **************************************

    // Get Session from  Sessions table ****************************** Get Session from  Sessions table   ***************************************
    public Future< JSONObject> getSessionById(String session_id) {
        JSONObject sessionObject = new JSONObject();
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql = String.format("SELECT * FROM wash_master.sessions  WHERE session_id =\"%s\"", session_id);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sessionObject.put("session_id", rs.getString("session_id"));
                sessionObject.put("general_plan_id", rs.getString("general_plan_id"));
                sessionObject.put("session_start_date", rs.getString("session_start_date"));
                sessionObject.put("session_end_date", rs.getString("session_end_date"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                return sessionObject;
            });
        }
        return executor.submit(() -> {

            return sessionObject;
        });

    }// Get Session from  Sessions table ****************************** Get Session from  Sessions table   **************************************

    // Get Reports from  reports table ****************************** Get reports from  reports table   ***************************************
    public Future<List<JSONObject>> getReports(String session_id) {
        List<JSONObject> reportsList = new ArrayList<>();
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql = String.format("SELECT * FROM wash_master.reports where session_id =\"%s\"", session_id);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                JSONObject reportObject = new JSONObject();
                reportObject.put("report_id", rs.getString("report_id"));
                reportObject.put("session_id", rs.getString("session_id"));
                reportObject.put("general_plan_id", rs.getString("general_plan_id"));
                reportObject.put("tankId", rs.getInt("tankId"));
                reportObject.put("tcmId", rs.getInt("tcmId"));
                reportObject.put("machineName", rs.getString("machineName"));
                reportObject.put("nozzle_diameter", rs.getDouble("nozzle_diameter"));
                reportObject.put("stepNumber", rs.getInt("stepNumber"));
                reportObject.put("profileNumber", rs.getInt("profileNumber"));
                reportObject.put("lWsValue", rs.getDouble("lWsValue"));
                reportObject.put("uWsValue", rs.getDouble("uWsValue"));
                reportObject.put("nozzle_diameter", rs.getDouble("nozzle_diameter"));
                reportObject.put("report_start_date", rs.getString("report_start_date"));
                reportObject.put("report_end_date", rs.getString("report_end_date"));
                reportObject.put("cycle", rs.getDouble("cycle"));
                reportObject.put("rpm", rs.getDouble("rpm"));
                reportObject.put("speed", rs.getInt("speed"));
                reportObject.put("pitch", rs.getDouble("pitch"));
                reportObject.put("washing_Media_Amount", rs.getDouble("washing_Media_Amount"));

                reportsList.add(reportObject);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {
                return reportsList;
            });
        }
        return executor.submit(() -> {

            return reportsList;
        });

    }// Get Reports from  reports table ****************************** Get reports from  reports table   ***************************************


    public Future<JSONObject> getSessionObject(String session_id) {
        JSONObject sessionObject = new JSONObject();
        JSONObject sessionInfo = new JSONObject();
        List<JSONObject> reportsList = new ArrayList<>();

        try {
            sessionInfo = getSessionById(session_id).get();
            if (sessionInfo.size() > 0){
                sessionObject.put("Session Information",sessionInfo);
                reportsList = getReports(session_id).get();
                   if (reportsList.size() > 0){
                      sessionObject.put("Reports",reportsList);
                   }
            }else {
                System.out.println("No session for session id " + session_id);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Wrong session id.");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        JSONObject finalSessionObject = sessionObject;
        return executor.submit(() -> {

            return finalSessionObject;
        });
    }


}
