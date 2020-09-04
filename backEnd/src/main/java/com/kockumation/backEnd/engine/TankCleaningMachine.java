package com.kockumation.backEnd.engine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kockumation.backEnd.engine.model.Process;
import com.kockumation.backEnd.engine.model.TimePeriod;
import com.kockumation.backEnd.service.executionPhase.model.startPreWash.StartPreWash;
import com.kockumation.backEnd.service.executionPhase.model.startWash.StartWash;
import com.kockumation.backEnd.service.planPhaseServices.cargos.GetGeneralPlan;
import com.kockumation.backEnd.service.planPhaseServices.cargos.MachineService;
import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TankCleaningMachine {


    private int tcmID;
    private int tankId;
    private String tankName;

    private int stepNumber;
    private int profileNumber;

    private String general_plan_id;
    private String washingMedia;
    private double cy;
    private double rpm;
    private double bar;
    private int speed;
    private double pitch;
    private TimePeriod elapsedTime;
    private TimePeriod remainingTime;
    private TimePeriod finishTime;

    private double wholeTime;
    private double elapsedTimeMilli;
    private double percentage;
    private String stringPercentage;

    private Process process;
    private int processStatus;

    @NotNull
    @Min(1)
    @Max(1500)
    private int cleaning_time_in_minutes;

    private double lWsValue;
    private double uWsValue;
    private double washingSector;
    boolean runningSession;
    private double currentNozzleAngle;
    private String stringCurrentNozzleAngle;
    private String machineName;
    private String nozzle_diameter;
    private double nozzle_diameter_throughput;
    private double nozzle_diameter_throughput_forTotalTime;
    private Timer timer;
    private String cleaning_machine_name;

    private String session_id;
    private String session_start_date;
    private String session_end_date;
    private String report_id;
    private String report_start_date;
    private String report_end_date;
    private double washing_Media_Amount;

    private ExecutorService executor;


    public TankCleaningMachine() {
        executor
                = Executors.newSingleThreadExecutor();
        process = new Process();

    } // Constructor .. .

    // Insert into sessions table  ****************************** Insert into sessions table   ***************************************
    public Future<Boolean> insertSession() {

        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String query = "INSERT INTO sessions (session_id,general_plan_id,session_start_date,session_end_date) VALUES (?,?,?,?);";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setString(1, session_id);
            preparedStmt.setString(2, general_plan_id);
            preparedStmt.setString(3, session_start_date);
            preparedStmt.setString(4, session_end_date);

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

    } // Insert into sessions table  ****************************** Insert into sessions table   ***************************************

    // Update Sessions table with session_end_date
    private Future<Boolean> updateSessions() {
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            try {
                String updatePontoons = "UPDATE sessions set session_end_date = ? where (session_id = ? );";
                PreparedStatement preparedStmt = conn.prepareStatement(updatePontoons, Statement.RETURN_GENERATED_KEYS);

                try {
                    preparedStmt.setString(1, session_end_date);

                    preparedStmt.setString(2, session_id);

                    int rowAffected = preparedStmt.executeUpdate();
                    preparedStmt.clearParameters();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return executor.submit(() -> {
                        return false;
                    });
                }

            } catch (NullPointerException e) {
                System.out.print("Session not updated");
                return executor.submit(() -> {
                    return false;
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return executor.submit(() -> {
            return true;
        });

    } // Update Sessions table with session_end_date

    // Insert into Reports table  ****************************** Insert into Reports table   ***************************************
    public Future<Boolean> insertReport() {

        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String query = "INSERT INTO reports (report_id,session_id,general_plan_id,tcmId,machineName,nozzle_diameter,tankId,stepNumber,profileNumber,cleaning_time,report_start_date,report_end_date,cycle,rpm,speed,pitch,washing_Media_Amount,uWsValue,lWsValue) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setString(1, report_id);
            preparedStmt.setString(2, session_id);
            preparedStmt.setString(3, general_plan_id);
            preparedStmt.setInt(4, tcmID);
            preparedStmt.setString(5, cleaning_machine_name);
            preparedStmt.setDouble(6, process.getNozzle_diameter());
            preparedStmt.setInt(7, tankId);
            preparedStmt.setInt(8, stepNumber);
            preparedStmt.setInt(9, profileNumber);
            preparedStmt.setString(10, elapsedTime.getTimePeriod());
            preparedStmt.setString(11, report_start_date);
            preparedStmt.setString(12, report_end_date);
            preparedStmt.setDouble(13, cy);
            preparedStmt.setDouble(14, rpm);
            preparedStmt.setInt(15, speed);
            preparedStmt.setDouble(16, pitch);
            preparedStmt.setDouble(17, washing_Media_Amount);
            preparedStmt.setDouble(18, uWsValue);
            preparedStmt.setDouble(19, lWsValue);

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

    } // Insert into Reports table  ****************************** Insert into Reports table   ***************************************

    // Is General Plan Id exists in sessions table ******** Is General Plan Id exists in sessions table  ********************
    public Future<String> isSessionIdExists() {

        String sql = String.format("SELECT session_id FROM sessions  WHERE general_plan_id =\"%s\"", general_plan_id);
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                session_id = rs.getString("session_id");
            } else {
                return executor.submit(() -> {
                    System.out.println("No session exists..");
                    session_id = null;
                    return session_id;
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return executor.submit(() -> {

                return session_id;
            });
        }
        return executor.submit(() -> {

            return session_id;
        });
    } // Is General Plan Id exists in sessions table ******** Is General Plan Id exists in sessions table  ********************

    private void calculateCycle(){
        if (pitch >0 && speed > 0 && washingSector > 0){
            cy  = (cleaning_time_in_minutes * pitch * speed * rpm) / (washingSector * 2);
            System.out.println("Cy is: "+cy);
        }
    }
    // Save Report *****************************  Save Report ******************************************
    private void saveReport() {
        double timeInHours = (double) cleaning_time_in_minutes / 60;
        System.out.println("cleaning time minute: " + cleaning_time_in_minutes);
        System.out.println("time in hours: " + timeInHours);

        timeInHours = roundTowDigits(timeInHours);
        calculateCycle();

        washing_Media_Amount = nozzle_diameter_throughput * (timeInHours);
        washing_Media_Amount = roundTowDigits(washing_Media_Amount);
        System.out.println("washing media.." + washing_Media_Amount);
        try {
            // System.out.println("start report: "+report_start_date);
            session_id = isSessionIdExists().get();
            // System.out.println(session_id);
            if (session_id == null) {
                session_id = report_start_date;
                System.out.println("SEssion: " + session_id);
                System.out.println("report " + report_start_date);
                boolean sessionInserted = insertSession().get();
                if (sessionInserted) {
                    insertReport();
                }

            } else {

                boolean sessionUpdated = updateSessions().get();
                if (sessionUpdated) {
                    insertReport();
                }
            }
            System.out.println("Report saved successfully.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }// Save Report *****************************  Save Report ******************************************


    // Get Current Nozzle Angle **************************************************
    private double getCurrentNa(double elapsedInMinutes) {

        double tna = pitch * rpm * elapsedInMinutes; // Get temperary nozzle angle

        double deNa = Math.floor((tna / washingSector));
        //  System.out.println("Temporary "+tna);
        //  System.out.println("Division " + deNa);
        System.out.println("Accumulated nozzle angle " + tna);


        if (tna <= washingSector) {
            if (tna < washingSector) {
                double na = lWsValue + tna;
                return na;
            } else {
                double na = uWsValue;
                return na;
            }

        } else {

            if (deNa % 2 == 0) {
                double na = lWsValue + tna % washingSector;
                return na;
            } else {
                System.out.println("uWsValue " + uWsValue);
                double na2 = uWsValue - ((lWsValue + tna) % washingSector);
                //   System.out.println("Na is "+na2);
                //   System.out.println("Calculation is "+(lWsValue + tna) % washingSector);

                return na2;
            }

        }


    }// Calculate nozzle angle ********************  Calculate nozzle angle at specific elapsed time *****************************************************


    //// Update Process **************************************  Update Process *************** //////////
    public void updateProcess() {
        process.setTcmId(tcmID);
        process.setFinishTime(finishTime.getTimePeriod());
        process.setElapsedTime(elapsedTime.getTimePeriod());
        process.setRemainingTime(remainingTime.getTimePeriod());
        process.setStepNumber(stepNumber);
        process.setStringCurrentNozzleAngle(stringCurrentNozzleAngle);
        process.setCurrentNozzleAngle(currentNozzleAngle);
        process.setPercentage(percentage);
        process.setStringPercentage(stringPercentage);
        process.setProcessStatus(processStatus);
        process.setProfileNumber(profileNumber);
        double numberOnly = Double.parseDouble(nozzle_diameter.replaceAll("[^0-9]", ""));
        process.setNozzle_diameter(numberOnly);

        process.setNozzle_diameter_throughput(getNozzle_diameter_throughput());

    }//// Update Process **************************************  Update Process *************** //////////


    //// Create new Wash Operation **************************************  Create new Wash Operation *************** //////////
    public void createNewWashOperation(StartWash startWash) {
        if (timer == null) {
            //   System.out.println(nozzle_diameter_throughput);
            //    System.out.println(nozzle_diameter);
            timer = new Timer();

            this.setRunningSession(true);
            elapsedTime = new TimePeriod("Elapsed time");
            remainingTime = new TimePeriod("Remaining time");
            finishTime = new TimePeriod("Finish time");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            report_start_date = LocalDateTime.now(Clock.systemUTC()).format(formatter);
            general_plan_id = startWash.getGeneral_plan_id();
            session_start_date = report_start_date;
            session_id = session_start_date;
            report_id = report_start_date;


            stepNumber = startWash.getStepNumber();
            profileNumber = startWash.getProfileNumber();
            cleaning_time_in_minutes = startWash.getCleaning_time_in_minutes();
            finishTime.setMilliseconds(cleaning_time_in_minutes * 60 * 1000);
            wholeTime = finishTime.getMilliseconds();
            profileNumber = startWash.getProfileNumber();
            lWsValue = startWash.getlWsValue();
            uWsValue = startWash.getuWsValue();
            washingSector = startWash.getuWsValue() - startWash.getlWsValue();
            pitch = startWash.getPitch();
            rpm = startWash.getRpm();
            speed = startWash.getSpeed();

             calculateCycle();
            startWash();
        }
    }//// Create new Wash Operation **************************************  Create new Wash Operation *************** //////////

    //// Create new Pre Wash Operation **************************************  Create new Pre Wash Operation *************** //////////
    public void createNewPreWashOperation(StartPreWash startPreWash) {
        if (timer == null) {

            timer = new Timer();
            //    process = new Process();
            this.setRunningSession(true);
            elapsedTime = new TimePeriod("Elapsed time");
            remainingTime = new TimePeriod("Remaining time");
            finishTime = new TimePeriod("Finish time");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            report_start_date = LocalDateTime.now(Clock.systemUTC()).format(formatter);
            general_plan_id = startPreWash.getGeneral_plan_id();
            session_start_date = report_start_date;
            session_id = session_start_date;
            report_id = report_start_date;

            cleaning_time_in_minutes = startPreWash.getTimeForOperation();
            finishTime.setMilliseconds(cleaning_time_in_minutes * 60 * 1000);
            wholeTime = finishTime.getMilliseconds();
            stepNumber = startPreWash.getProfileNumber();
            profileNumber = startPreWash.getProfileNumber();


            startPreWash();
        }
    }//// Create new Pre Wash Operation **************************************  Create new Pre Wash Operation *************** //////////

    private double roundTowDigits(double value) {

        double roundedValue = Math.round(value * 100.0) / 100.0;
        return roundedValue;
    }

    ////// Reset Values ******************************** Reset Values /////////////////////////////////
    public void resetValues() {
        //   updateProcess();
        timer.cancel();
        timer.purge();
        timer = null;
        elapsedTime = null;
        remainingTime = null;
        finishTime = null;
        wholeTime = 0.0;
        elapsedTimeMilli = 0.0;
        percentage = 0.0;
        session_id = null;
        rpm = 0;
        speed = 0;
        pitch = 0;
        washing_Media_Amount = 0;
        nozzle_diameter_throughput_forTotalTime = 0.0;
    }////// Reset Values ******************************** Reset Values /////////////////////////////////


    /// Stop Wash  ********************** Stop Wash  *****************************
    public boolean stopWash() {
        this.setRunningSession(false);

        return true;
    }/// Stop Wash  ********************** Stop Wash *****************************

    /// Resume Wash  ********************** Resume Wash *****************************
    public boolean resumeWash() {
        this.setRunningSession(true);
        return true;
    }/// Resume Wash ********************** Resume Wash *****************************


    // Start Pre Wash ***************************************** Start Pre Wash ********************************
    public void startPreWash() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (isRunningSession()) {
                    System.out.println();
                    System.out.println("///////////////////////////////////////// Wash Operation Is Running  //////////////////////////////////////////");
                    System.out.println();
                    elapsedTime.setMilliseconds(elapsedTime.getMilliseconds() + 2000L);
                    processStatus = 1;
                    if (finishTime.getMilliseconds() > elapsedTime.getMilliseconds()) {
                        remainingTime.setMilliseconds(finishTime.getMilliseconds() - elapsedTime.getMilliseconds());
                    } else {
                        remainingTime.setMilliseconds(0l);

                    }

                    elapsedTimeMilli = elapsedTime.getMilliseconds();

                    percentage = (elapsedTimeMilli / wholeTime) * 100;
                    percentage = roundTowDigits(percentage);
                    stringPercentage = (int) percentage + " %";
                    //  System.out.println( (2.0 / 10.0));
                    System.out.println("Finish Time is: " + finishTime.getTimePeriod());
                    System.out.println("Elapsed Time is: " + elapsedTime.getTimePeriod());
                    System.out.println("Remaining Time is: " + remainingTime.getTimePeriod());
                    System.out.println("Percentage: " + percentage);
                    if (percentage > 100) {
                        processStatus = 3;
                    }

                    updateProcess();

                } else {
                    if (elapsedTime.getMilliseconds() >= finishTime.getMilliseconds()) {
                        System.out.println();
                        System.out.println("////////////////////////////  Operation finished .....");
                        System.out.println("Finish Time is: " + finishTime.getTimePeriod());
                        System.out.println("Elapsed Time is: " + elapsedTime.getTimePeriod());
                        System.out.println("Remaining Time is: " + remainingTime.getTimePeriod());
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        report_end_date = LocalDateTime.now(Clock.systemUTC()).format(formatter);
                        session_end_date = report_end_date;
                        processStatus = 0;

                        updateProcess();
                        saveReport();
                        resetValues();


                    } else {
                        System.out.println("Wash operation has been paused by the client.....");
                        processStatus = 2;
                        updateProcess();
                    }

                }


            }
        }, 200, 2000);

    } // Start Pre Wash ***************************************** Start Pre Wash ********************************

    // Start Wash ***************************************** Start Wash ********************************
    public void startWash() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (isRunningSession()) {
                    System.out.println();
                    System.out.println("///////////////////////////////////////// Wash Operation Is Running  //////////////////////////////////////////");
                    System.out.println();
                    elapsedTime.setMilliseconds(elapsedTime.getMilliseconds() + 2000L);
                    processStatus = 1;
                    if (finishTime.getMilliseconds() > elapsedTime.getMilliseconds()) {
                        remainingTime.setMilliseconds(finishTime.getMilliseconds() - elapsedTime.getMilliseconds());
                    } else {
                        remainingTime.setMilliseconds(0l);

                    }

                    elapsedTimeMilli = elapsedTime.getMilliseconds();
                    double elapsedTimeMin = (elapsedTimeMilli / 1000) / 60;
                    percentage = (elapsedTimeMilli / wholeTime) * 100;
                    percentage = roundTowDigits(percentage);
                    stringPercentage = (int) percentage + " %";
                    //  System.out.println( (2.0 / 10.0));
                    System.out.println("Finish Time is: " + finishTime.getTimePeriod());
                    System.out.println("Elapsed Time is: " + elapsedTime.getTimePeriod());
                    System.out.println("Remaining Time is: " + remainingTime.getTimePeriod());
                    System.out.println("Percentage: " + percentage);
                    if (percentage > 100) {
                        processStatus = 3;
                    }
                    currentNozzleAngle = getCurrentNa(elapsedTimeMin);
                    currentNozzleAngle = roundTowDigits(currentNozzleAngle);
                    stringCurrentNozzleAngle = roundTowDigits(currentNozzleAngle) + "\u00B0";
                    System.out.println(stringCurrentNozzleAngle);
                    updateProcess();

                } else {
                    if (elapsedTime.getMilliseconds() >= finishTime.getMilliseconds()) {
                        System.out.println();
                        System.out.println("////////////////////////////  Operation finished .....");
                        System.out.println("Finish Time is: " + finishTime.getTimePeriod());
                        System.out.println("Elapsed Time is: " + elapsedTime.getTimePeriod());
                        System.out.println("Remaining Time is: " + remainingTime.getTimePeriod());

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        report_end_date = LocalDateTime.now(Clock.systemUTC()).format(formatter);
                        session_end_date = report_end_date;

                        processStatus = 0;

                        updateProcess();
                        saveReport();
                        resetValues();


                    } else {
                        System.out.println("Wash operation has been paused by the client.....");
                        processStatus = 2;
                        updateProcess();
                    }

                }
                ///


            }
        }, 200, 2000);

    } // Start Wash ***************************************** Start Wash ********************************


    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getNozzle_diameter() {
        return nozzle_diameter;
    }

    public void setNozzle_diameter(String nozzle_diameter) {
        this.nozzle_diameter = nozzle_diameter;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public int getTcmID() {
        return tcmID;
    }

    public void setTcmID(int tcmID) {
        this.tcmID = tcmID;
    }

    public TimePeriod getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(TimePeriod elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public TimePeriod getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(TimePeriod remainingTime) {
        this.remainingTime = remainingTime;
    }

    public TimePeriod getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(TimePeriod finishTime) {
        this.finishTime = finishTime;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getWashingMedia() {
        return washingMedia;
    }

    public void setWashingMedia(String washingMedia) {
        this.washingMedia = washingMedia;
    }

    public double getRpm() {
        return rpm;
    }

    public void setRpm(double rpm) {
        this.rpm = rpm;
    }

    public double getBar() {
        return bar;
    }

    public void setBar(double bar) {
        this.bar = bar;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public int getCleaning_time_in_minutes() {
        return cleaning_time_in_minutes;
    }

    public void setCleaning_time_in_minutes(int cleaning_time_in_minutes) {
        this.cleaning_time_in_minutes = cleaning_time_in_minutes;
    }

    public double getlWsValue() {
        return lWsValue;
    }

    public void setlWsValue(double lWsValue) {
        this.lWsValue = lWsValue;
    }

    public double getuWsValue() {
        return uWsValue;
    }

    public void setuWsValue(double uWsValue) {
        this.uWsValue = uWsValue;
    }

    public boolean isRunningSession() {
        return runningSession;
    }

    public void setRunningSession(boolean runningSession) {
        this.runningSession = runningSession;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        timer = timer;
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public String getTankName() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }

    public double getNozzle_diameter_throughput() {
        return nozzle_diameter_throughput;
    }

    public void setNozzle_diameter_throughput(double nozzle_diameter_throughput) {
        this.nozzle_diameter_throughput = nozzle_diameter_throughput;
    }

    public double getNozzle_diameter_throughput_forTotalTime() {
        return nozzle_diameter_throughput_forTotalTime;
    }

    public void setNozzle_diameter_throughput_forTotalTime(double nozzle_diameter_throughput_forTotalTime) {
        this.nozzle_diameter_throughput_forTotalTime = nozzle_diameter_throughput_forTotalTime;
    }

    public String getCleaning_machine_name() {
        return cleaning_machine_name;
    }

    public void setCleaning_machine_name(String cleaning_machine_name) {
        this.cleaning_machine_name = cleaning_machine_name;
    }

    @Override
    public String toString() {
        return "TankCleaningMachine{" +
                "tcmID=" + tcmID +
                ", tankId=" + tankId +
                ", tankName='" + tankName + '\'' +
                ", stepProfile=" + stepNumber +
                ", step_profile_name='" + profileNumber + '\'' +
                ", washingMedia='" + washingMedia + '\'' +
                ", rpm=" + rpm +
                ", bar=" + bar +
                ", speed=" + speed +
                ", pitch=" + pitch +
                ", elapsedTime=" + elapsedTime +
                ", remainingTime=" + remainingTime +
                ", finishTime=" + finishTime +
                ", wholeTime=" + wholeTime +
                ", elapsedTimeMilli=" + elapsedTimeMilli +
                ", decimalOfPercentage=" + percentage +
                ", percentage='" + percentage + '\'' +
                ", process=" + process +
                ", processStatus=" + processStatus +
                ", cleaning_time_in_minutes=" + cleaning_time_in_minutes +
                ", lWsValue=" + lWsValue +
                ", uWsValue=" + uWsValue +
                ", washingSector=" + washingSector +
                ", runningSession=" + runningSession +
                ", currentNozzleAngle=" + currentNozzleAngle +
                ", stringCurrentNozzleAngle='" + stringCurrentNozzleAngle + '\'' +
                ", timer=" + timer +
                ", executor=" + executor +
                '}';
    }
}
