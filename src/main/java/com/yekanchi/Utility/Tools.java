package com.yekanchi.Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tools {
    /**
     * Write a New Line To Log File
     *
     * @param log The {@code String} to be loged.
     */
    public static void Log(String log) {
        try {
            File file = new File("./log.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write("\n" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " : "
                    + log);
            fr.close();
        } catch (IOException e) {
            ELog(e);
        }
    }

    /**
     * Write a New Line To Log File
     *
     * @param exception The {@code IOException} to be Loged.
     */
    public static void ELog(IOException exception) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./exclog.txt"));
            writer.write(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " : "
                    + exception.getStackTrace());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}