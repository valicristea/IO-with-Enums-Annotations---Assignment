package org.example;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String csvFile = "path/to/your/file.csv";
        String line;
        String csvSplitBy = ",";
        List<AthleteResult> athletes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                AthleteResult athleteResult = new AthleteResult(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        values[5],
                        values[6]
                );
                athletes.add(athleteResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(athletes, new TimeComparator());


    }
}
