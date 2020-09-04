package com.kockumation.backEnd.controller.excecutionPhase;

import com.kockumation.backEnd.engine.model.Process;
import com.kockumation.backEnd.service.executionPhase.StartStopSessionService;
import com.kockumation.backEnd.service.executionPhase.model.startPreWash.StartPreWash;
import com.kockumation.backEnd.service.executionPhase.model.startWash.StartWash;
import com.kockumation.backEnd.service.executionPhase.model.startWash.StopSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/")
public class StartStopSessionController {


@Autowired
StartStopSessionService startStopSessionService;
    //************************************** Start Wash step Profile 4  ***********************************************************************
    @PostMapping("/startWash")
    public ResponseEntity<String> startWash(@Valid @RequestBody StartWash startWash) {

        ResponseEntity<String> responseEntity = null;

        boolean    WashStarted = false;
        try {
            WashStarted = startStopSessionService.startWash(startWash).get();
          /*  Set<Thread> threads = Thread.getAllStackTraces().keySet();
            System.out.println(threads.size());
            for (Thread t : threads) {
                String name = t.getName();
                Thread.State state = t.getState();
                int priority = t.getPriority();
                String type = t.isDaemon() ? "Daemon" : "Normal";
                System.out.printf("%-20s \t %s \t %d \t %s\n", name, state, priority, type);
            }*/

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (WashStarted) {
            System.out.println();
            System.out.println("Wash operation started successfully..");

            responseEntity = new ResponseEntity<String>(
                    "Wash operation for tank cleaning machine id: "+ startWash.getTcmId()+" started successfully",
                    HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>(
                    "Wash operation for tank cleaning machine id: "+ startWash.getTcmId()+" Not started , failed..",
                    HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    } //************************************** Start Wash step Profile 4   ***********************************************************************


    //************************************** Start Wash step Profile 1,2,3,5,6..  ***********************************************************************
    @PostMapping("/startPreWash")
    public ResponseEntity<String> startPreWash(@Valid @RequestBody StartPreWash startPreWash) {

        ResponseEntity<String> responseEntity = null;

        boolean    sessionStarted = false;
        try {
            sessionStarted = startStopSessionService.startPreWash(startPreWash).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (sessionStarted) {
            System.out.println("Session started successfully..");
            responseEntity = new ResponseEntity<String>(
                    "Pre Wash operation for tank cleaning machine id: "+ startPreWash.getTcmId()+" started successfully",
                    HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>(
                    "Pre Wash operation for tank cleaning machine id: "+ startPreWash.getTcmId()+" Not started , failed..",
                    HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    } //************************************** Start Wash step Profile 1,2,3,5,6..  ***********************************************************************






    //*************************************************************************************************************
    @PostMapping("/stopOrPauseWash")
    public ResponseEntity<String> stopSession(@Valid @RequestBody StopSession stopSession) {
        ResponseEntity<String> responseEntity = null;
        boolean    sessionStarted = false;
        try {
            sessionStarted = startStopSessionService.stopWash(stopSession).get();

        /*    Set<Thread> threads = Thread.getAllStackTraces().keySet();
            System.out.println(threads.size());
            for (Thread t : threads) {
                String name = t.getName();
                Thread.State state = t.getState();
                int priority = t.getPriority();
                String type = t.isDaemon() ? "Daemon" : "Normal";
                System.out.printf("%-20s \t %s \t %d \t %s\n", name, state, priority, type);
            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        if (sessionStarted) {
            System.out.println("Wash Operation stopped successfully..");
            responseEntity = new ResponseEntity<String>(
                    "Wash Operation for tank cleaning machine id: "+stopSession.getTcmId()+" stopped successfully",
                    HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>(
                    "Wash Operation for tank cleaning machine id: "+stopSession.getTcmId()+" Not stopped , failed..",
                    HttpStatus.BAD_REQUEST);
        }


        return responseEntity;
    } // Stop Or Pause Session  ******************** Stop Or Pause Session **************************

    //*************************************************************************************************************
    @PostMapping("/resumeWash")
    public ResponseEntity<String> resumeWash(@Valid @RequestBody StopSession stopSession) {
        ResponseEntity<String> responseEntity = null;
        boolean    sessionResumed = false;
        try {
            sessionResumed = startStopSessionService.resumeWash(stopSession).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        if (sessionResumed) {
            System.out.println();
            System.out.println("Wash Operation resumed...");
            responseEntity = new ResponseEntity<String>(
                    "Wash Operation for tank cleaning machine id: "+stopSession.getTcmId()+" resumed successfully",
                    HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>(
                    "Wash Operation for tank cleaning machine id: "+stopSession.getTcmId()+" Not resumed , failed..",
                    HttpStatus.BAD_REQUEST);
        }


        return responseEntity;
    } // Stop Or Pause Session  ******************** Stop Or Pause Session **************************

    //*************************************************************************************************************
    @PostMapping("/getProcess")
    public ResponseEntity<Process> getProcess(@Valid @RequestBody StopSession stopSession) {
        ResponseEntity<Process> responseEntity = null;
        Process process = new Process();
        boolean    sessionResumed = false;
        try {
            process = startStopSessionService.getProcess(stopSession).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



            responseEntity = new ResponseEntity<Process>(
                    process,
                    HttpStatus.OK);



        return responseEntity;
    } // Stop Or Pause Session  ******************** Stop Or Pause Session **************************


    //*************************************************************************************************************
    @PostMapping("/getSession")
    public ResponseEntity<Process> getSession(@Valid @RequestBody StopSession stopSession) {
        ResponseEntity<Process> responseEntity = null;
        Process process = new Process();
        boolean    sessionResumed = false;
        try {
            process = startStopSessionService.getProcess(stopSession).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



        responseEntity = new ResponseEntity<Process>(
                process,
                HttpStatus.OK);



        return responseEntity;
    } // Stop Or Pause Session  ******************** Stop Or Pause Session **************************


}
