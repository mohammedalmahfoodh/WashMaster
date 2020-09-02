package com.kockumation.backEnd.service.executionPhase;

import com.kockumation.backEnd.Global.DB;
import com.kockumation.backEnd.engine.TankCleaningMachine;
import com.kockumation.backEnd.engine.model.Process;
import com.kockumation.backEnd.service.executionPhase.model.startPreWash.StartPreWash;
import com.kockumation.backEnd.service.executionPhase.model.startWash.StartWash;
import com.kockumation.backEnd.service.executionPhase.model.startWash.StopSession;
import com.kockumation.backEnd.service.planPhaseServices.cargos.GetGeneralPlan;
import com.kockumation.backEnd.service.planPhaseServices.cargos.MachineService;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.machine.MachinePostObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class StartStopSessionService {

    @Autowired
    GetGeneralPlan generalPlan;
    @Autowired
    MachineService  machineService;

    private ExecutorService executor;

    public StartStopSessionService() {
        executor
                = Executors.newSingleThreadExecutor();
    }

    // ********************************************* Helper Methods  *****************************************************


    // Is Tcm Map available  **************************  Is Tcm Map available ************************************************
    private boolean isTcmMapAvailable(int tcmId) {

        if (DB.tcmMap.size() > 0) {
            if (DB.tcmMap.containsKey(tcmId)) {

                TankCleaningMachine tankCleaningMachine = DB.tcmMap.get(tcmId);

                if (!tankCleaningMachine.isRunningSession() && tankCleaningMachine.getTimer() == null) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    } // Is Tcm Map available  **************************  Is Tcm Map available ************************************************

    public Future<Boolean> canStartWashOrNot(StartWash startWash) {

        boolean isGeneralPlanIdValid = false;
        boolean isTcmMapAvailable = false;
        boolean isGeneralPlanIdExists = false;
        try {
            isGeneralPlanIdValid = generalPlan.isGeneralPlanIdValid(startWash.getGeneral_plan_id()).get();

            if (isGeneralPlanIdValid) {
                isTcmMapAvailable = isTcmMapAvailable(startWash.getTcmId());

                if (isTcmMapAvailable) {
                    isGeneralPlanIdExists = generalPlan.isIsGeneralPlanExists(startWash.getGeneral_plan_id()).get();
                    if (isGeneralPlanIdExists) {
                        return executor.submit(() -> {
                            return true;
                        });
                    } else {
                        return executor.submit(() -> {
                            return false;
                        });
                    }

                } else {

                    return executor.submit(() -> {
                        return false;
                    });
                }


            } else {
                return executor.submit(() -> {
                    return false;
                });
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        boolean finalIsGeneralPlanIdValid = isGeneralPlanIdValid;
        return executor.submit(() -> {
            return finalIsGeneralPlanIdValid;
        });
    }

    public Future<Boolean> canStartWashOrNot(StartPreWash startPreWash) {

        boolean isGeneralPlanIdValid = false;
        boolean isTcmMapAvailable = false;
        boolean isGeneralPlanIdExists = false;
        try {
            isGeneralPlanIdValid = generalPlan.isGeneralPlanIdValid(startPreWash.getGeneral_plan_id()).get();

            if (isGeneralPlanIdValid) {
                isTcmMapAvailable = isTcmMapAvailable(startPreWash.getTcmId());

                if (isTcmMapAvailable) {
                    isGeneralPlanIdExists = generalPlan.isIsGeneralPlanExists(startPreWash.getGeneral_plan_id()).get();
                    if (isGeneralPlanIdExists) {
                        return executor.submit(() -> {
                            return true;
                        });
                    } else {
                        return executor.submit(() -> {
                            return false;
                        });
                    }

                } else {

                    return executor.submit(() -> {
                        return false;
                    });
                }


            } else {
                return executor.submit(() -> {
                    return false;
                });
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        boolean finalIsGeneralPlanIdValid = isGeneralPlanIdValid;
        return executor.submit(() -> {
            return finalIsGeneralPlanIdValid;
        });
    }

    // Can stop the process or not ******************* Can stop the process or not ************************
    private boolean canStopOrNot(int tcmId) {

        if (DB.tcmMap.size() > 0) {
            if (DB.tcmMap.containsKey(tcmId)) {

                TankCleaningMachine tankCleaningMachine = DB.tcmMap.get(tcmId);

                if (tankCleaningMachine.isRunningSession()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    } // Can stop the process or not ******************* Can stop the process or not ************************


    // Can Resume the process or not ******************* Can Resume the process or not ************************
    private boolean canResumeOrNot(int tcmId) {

        if (DB.tcmMap.size() > 0) {
            if (DB.tcmMap.containsKey(tcmId)) {

                TankCleaningMachine tankCleaningMachine = DB.tcmMap.get(tcmId);

                if (!tankCleaningMachine.isRunningSession() && tankCleaningMachine.getTimer() != null) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    } // Can Resume the process or not ******************* Can Resume the process or not ************************


    // ********************************************* Helper Methods  *****************************************************

    // ********************************************************* Start Wash ****************************************************
    public Future<Boolean> startWash(StartWash startWash) {
        boolean canStartWashOrNot = false;
        try {
            canStartWashOrNot = canStartWashOrNot(startWash).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (canStartWashOrNot) {
            TankCleaningMachine tankCleaningMachine = DB.tcmMap.get(startWash.getTcmId());
            JSONObject washing_capacity = new JSONObject();
            MachinePostObject machinePostObject = new MachinePostObject();
            machinePostObject.setBar(startWash.getBar());
            machinePostObject.setMachineName(tankCleaningMachine.getMachineName());
          //  System.out.println(machinePostObject);
            try {
                washing_capacity = machineService.getCapacityDataForBar(machinePostObject).get();

                //System.out.println(washing_capacity);
                double nozzleDiameterTh = (double) washing_capacity.get(tankCleaningMachine.getNozzle_diameter());
                tankCleaningMachine.setNozzle_diameter_throughput(nozzleDiameterTh);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            tankCleaningMachine.createNewWashOperation(startWash);

            return executor.submit(() -> {

                return true;
            });
        } else {
            return executor.submit(() -> {

                return false;
            });
        }


    } // ********************************************************* Start Wash ****************************************************

    // ********************************************************* Stop Wash ****************************************************
    public Future<Boolean> stopWash(StopSession stopSession) {
        int tcmId = stopSession.getTcmId();

        if (canStopOrNot(tcmId)) {
            TankCleaningMachine tankCleaningMachine = DB.tcmMap.get(tcmId);
            tankCleaningMachine.stopWash();
            // System.out.println("My Name is Service:- " + Thread.currentThread().getName());
            return executor.submit(() -> {
                return true;
            });
        } else {
            return executor.submit(() -> {

                return false;
            });
        }

    } // ********************************************************* Stop Wash ****************************************************

    // ********************************************************* Resume Wash ****************************************************
    public Future<Boolean> resumeWash(StopSession stopSession) {
        int tcmId = stopSession.getTcmId();

        if (canResumeOrNot(tcmId)) {
            TankCleaningMachine tankCleaningMachine = DB.tcmMap.get(tcmId);
            tankCleaningMachine.resumeWash();
            // System.out.println("My Name is Service:- " + Thread.currentThread().getName());

            return executor.submit(() -> {

                return true;
            });
        } else {
            return executor.submit(() -> {

                return false;
            });
        }


    } // ********************************************************* Resume Wash ****************************************************

    // ********************************************************* Resume Wash ****************************************************
    public Future<Process> getProcess(StopSession stopSession) {
        int tcmId = stopSession.getTcmId();
  Process process = new Process();

        if (DB.tcmMap.size() > 0) {
            if (DB.tcmMap.containsKey(tcmId)) {

                TankCleaningMachine tankCleaningMachine = DB.tcmMap.get(tcmId);
                process = tankCleaningMachine.getProcess();
             Process   finalProcess = process;
                return executor.submit(() -> {

                    return finalProcess;
                });

            }else {
                Process   finalProcess = process;
                return executor.submit(() -> {

                    return finalProcess;
                });
            }

        }else {
            Process   finalProcess = process;
            return executor.submit(() -> {

                return finalProcess;
            });
        }



    } // ********************************************************* Resume Wash ****************************************************

// ********************************************************* Start Pre Wash ****************************************************
    public Future<Boolean> startPreWash(StartPreWash startPreWash) {
        boolean canStartWashOrNot = false;
        try {
            canStartWashOrNot = canStartWashOrNot(startPreWash).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (canStartWashOrNot) {

            TankCleaningMachine tankCleaningMachine = DB.tcmMap.get(startPreWash.getTcmId());
            tankCleaningMachine.createNewPreWashOperation(startPreWash);

            return executor.submit(() -> {

                return true;
            });
        } else {
            return executor.submit(() -> {

                return false;
            });
        }


    } // ********************************************************* Start Pre Wash ****************************************************

}
