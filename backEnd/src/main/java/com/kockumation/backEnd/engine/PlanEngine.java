package com.kockumation.backEnd.engine;

import com.kockumation.backEnd.engine.dataBase.InitiateDataBase;
import com.kockumation.backEnd.utilities.TankInfo;

import java.util.concurrent.ExecutionException;

public class PlanEngine {


    InitiateDataBase initiateDataBase;

    public PlanEngine() {
        initiateDataBase = new InitiateDataBase();

    }
      public void planEngine(){
       //   System.out.println("My Name is planEngine:- " + Thread.currentThread().getName());
          boolean checkDataInDB = false;
          boolean tanksInfoInserted = false;
          try {
              boolean getListTanksInformation;
             getListTanksInformation = initiateDataBase.getListOfTanksInfo().get();
              if (getListTanksInformation){
                   checkDataInDB = initiateDataBase.checkIfDataExists().get();

              }else {
                  System.out.println("Something wrong..");
              }


              if (checkDataInDB){
              tanksInfoInserted = initiateDataBase.updateTanksInfoTable().get();

              }else {
               tanksInfoInserted = initiateDataBase.insertTanksInfoTable().get();

              }
                if (tanksInfoInserted){
                    System.out.println("Tanks info inserted...");
                }
          } catch (InterruptedException e) {
              e.printStackTrace();
          } catch (ExecutionException e) {
              e.printStackTrace();
          }






    } // planEngine method




}// Class PlanEngine
