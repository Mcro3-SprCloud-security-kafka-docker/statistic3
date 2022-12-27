package com.viettel.statisticservice.comon;

import com.viettel.statisticservice.service.dto.StatisticDTO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriter {
    public static void writeDataToFile(StatisticDTO statisticDTO) throws IOException {
        File folder = new File("./output");
        if (!folder.exists()) {
            folder.mkdir();
        }

        if (folder.list().length > 10) {
            System.out.println("There are more than 10 files, to much to store, deleting...");

            String[] fileNames = folder.list();
            for (String fileName : fileNames) {
                File fileToDelete = new File(folder, fileName);
                System.out.println("deleting fileName: " + fileName + ": " + fileToDelete.delete());
            }
        }

        String statisticMessage = statisticDTO.toString();
        File dataFile = new File(folder, statisticDTO.getCreateBy() + "-" + System.currentTimeMillis() + ".txt");
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(dataFile);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(statisticMessage);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
