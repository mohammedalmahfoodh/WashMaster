package com.kockumation.backEnd.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class TanksConfig {
    public static String getTanksConfigString() {
        File file = null;

        // Locate the json file from current folder\config
        // String fileLocation = FilePath.getCurrentDirPath()+"\\config\\Tanks_configs.json";
        String fileLocation = "C:\\Program Files (x86)\\Kockum Sonics\\WashMaster-backEnd\\config\\Tanks_configs.json";

        file = new File(fileLocation);

//Read File Content
        String content = null;
        try {
            content = new String(Files.readAllBytes(file.toPath()));

            //  System.out.println(content);

        } catch (IOException e) {
            //    e.printStackTrace();
            Scanner in = new Scanner(System.in);
            System.out.println("******************************************** OOPS **********************************************************");
            System.out.println("No config file please place it inside config folder inside the root folder and restart ");

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


        }
        // System.out.println(content);
        return content;
    }


}
