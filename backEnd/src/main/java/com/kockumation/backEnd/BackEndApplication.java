package com.kockumation.backEnd;

import com.kockumation.backEnd.Global.DB;
import com.kockumation.backEnd.engine.PlanEngine;
import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class BackEndApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BackEndApplication.class, args);

        System.out.println("listening on port " + 3003);
        boolean checkDataBase = true;
        PlanEngine planEngine = new PlanEngine();

        try {

            while (checkDataBase) {
                try (Connection conn = MySQLJDBCUtil.getConnection()) {
                    checkDataBase = false;
                    System.out.println(String.format("Connected to database %s " + "successfully.", conn.getCatalog()));
                    planEngine.planEngine();

                } catch (SQLException ex) {
                    //System.out.println(ex.getMessage());
                    switch (ex.getErrorCode()) {
                        case 1049:
                            System.out.println("Please install database ship_master_java.");
                            break;
                        case 1045:
                            System.out.println("Please change database user to root and password to tyfon");
                            break;
                    }
                    try {
                        Thread.sleep(4000);
                        checkDataBase = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } // while (checkDataBase)


        } catch (Exception e) {
            Scanner in = new Scanner(System.in);
            System.out.println("**************************************************** OOPS **********************************************************");
            System.out.println("Error... , Please restart the app.");
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

        } // Catch

    } // Main


} // Class
