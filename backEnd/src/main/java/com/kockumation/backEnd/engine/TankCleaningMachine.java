package com.kockumation.backEnd.engine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kockumation.backEnd.engine.model.Process;
import com.kockumation.backEnd.engine.model.TimePeriod;
import com.kockumation.backEnd.service.executionPhase.model.startPreWash.StartPreWash;
import com.kockumation.backEnd.service.executionPhase.model.startWash.StartWash;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TankCleaningMachine {


    @Min(1)
    @Max(55)
    private int tcmID;

    private int tankId;
    private String tankName;

    @NotNull
    @Min(1)
    @Max(15)
    private int stepProfile;


    private String step_profile_name;
    private String washingMedia;
    private double rpm;
    private double bar;
    private double speed;
    private double pitch;
    private TimePeriod elapsedTime;
    private TimePeriod remainingTime;
    private TimePeriod finishTime;

    private double wholeTime;
    private double elapsedTimeMilli;
    private double decimalOfPercentage;
    private String percentage;
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

    private Timer timer;

    private ExecutorService executor;

    public TankCleaningMachine() {
        executor
                = Executors.newSingleThreadExecutor();
    }

    private double getCurrentNa(double elapsedInMinutes) {

        double tna = pitch * rpm * elapsedInMinutes; // Get temperary nozlle angle

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
                System.out.println("uWsValue "+uWsValue);
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
        process.setStep_profile_name(step_profile_name);
        process.setStringCurrentNozzleAngle(stringCurrentNozzleAngle);
        process.setPercentage(percentage);
        process.setDecimalOfPercentage(decimalOfPercentage);
        process.setProcessStatus(processStatus);
        process.setStep_profile_name(step_profile_name);

    }//// Update Process **************************************  Update Process *************** //////////


    //// Create new Wash Operation **************************************  Create new Wash Operation *************** //////////
    public void createNewWashOperation(StartWash startWash) {
        if (timer == null) {
            timer = new Timer();
            process = new Process();
            this.setRunningSession(true);
            elapsedTime = new TimePeriod("Elapsed time");
            remainingTime = new TimePeriod("Remaining time");
            finishTime = new TimePeriod("Finish time");

            cleaning_time_in_minutes = startWash.getCleaning_time_in_minutes();
            finishTime.setMilliseconds(cleaning_time_in_minutes * 60 * 1000);
            wholeTime = finishTime.getMilliseconds();
            step_profile_name = startWash.getStep_profile_name();
            lWsValue = startWash.getlWsValue();
            uWsValue = startWash.getuWsValue();
            washingSector = startWash.getuWsValue() - startWash.getlWsValue();
            pitch = startWash.getPitch();
            rpm = startWash.getRpm();


            startWash();
        }
    }//// Create new Wash Operation **************************************  Create new Wash Operation *************** //////////

    //// Create new Pre Wash Operation **************************************  Create new Pre Wash Operation *************** //////////
    public void createNewPreWashOperation(StartPreWash startPreWash) {
        if (timer == null) {
            timer = new Timer();
            process = new Process();
            this.setRunningSession(true);
            elapsedTime = new TimePeriod("Elapsed time");
            remainingTime = new TimePeriod("Remaining time");
            finishTime = new TimePeriod("Finish time");

            cleaning_time_in_minutes = startPreWash.getTimeForOperation();
            finishTime.setMilliseconds(cleaning_time_in_minutes * 60 * 1000);
            wholeTime = finishTime.getMilliseconds();
            step_profile_name = startPreWash.getStep_profile_name();



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
        decimalOfPercentage = 0.0;
        percentage = null;


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
                    double elapsedTimeMin = (elapsedTimeMilli /1000) /60 ;
                    decimalOfPercentage = roundTowDigits((elapsedTimeMilli / wholeTime));
                    decimalOfPercentage = decimalOfPercentage * 100;
                    percentage = (int) decimalOfPercentage + " %";
                    //  System.out.println( (2.0 / 10.0));
                    System.out.println("Finish Time is: " + finishTime.getTimePeriod());
                    System.out.println("Elapsed Time is: " + elapsedTime.getTimePeriod());
                    System.out.println("Remaining Time is: " + remainingTime.getTimePeriod());
                    System.out.println("Percentage: " + percentage);
                    if (decimalOfPercentage > 100) {
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
                        processStatus = 0;
                        updateProcess();
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
                    double elapsedTimeMin = (elapsedTimeMilli /1000) /60 ;
                    decimalOfPercentage = roundTowDigits((elapsedTimeMilli / wholeTime));
                    decimalOfPercentage = decimalOfPercentage * 100;
                    percentage = (int) decimalOfPercentage + " %";
                    //  System.out.println( (2.0 / 10.0));
                    System.out.println("Finish Time is: " + finishTime.getTimePeriod());
                    System.out.println("Elapsed Time is: " + elapsedTime.getTimePeriod());
                    System.out.println("Remaining Time is: " + remainingTime.getTimePeriod());
                    System.out.println("Percentage: " + percentage);
                    if (decimalOfPercentage > 100) {
                        processStatus = 3;
                    }
                    currentNozzleAngle = getCurrentNa(elapsedTimeMin);
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
                        processStatus = 0;
                        updateProcess();
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

    public int getStepProfile() {
        return stepProfile;
    }

    public void setStepProfile(int stepProfile) {
        this.stepProfile = stepProfile;
    }

    public String getStep_profile_name() {
        return step_profile_name;
    }

    public void setStep_profile_name(String step_profile_name) {
        this.step_profile_name = step_profile_name;
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

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
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


    @Override
    public String toString() {
        return "TankCleaningMachine{" +
                "tcmID=" + tcmID +
                ", tankId=" + tankId +
                ", tankName='" + tankName + '\'' +
                ", stepProfile=" + stepProfile +
                ", step_profile_name='" + step_profile_name + '\'' +
                ", washingMedia='" + washingMedia + '\'' +
                ", rpm=" + rpm +
                ", bar=" + bar +
                ", speed=" + speed +
                ", pitch=" + pitch +
                ", cleaning_time_in_minutes=" + cleaning_time_in_minutes +
                ", lWsValue=" + lWsValue +
                ", uWsValue=" + uWsValue +
                ", runningSession=" + runningSession +
                ", executor=" + executor +
                '}';
    }
}
