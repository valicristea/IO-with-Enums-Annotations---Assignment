package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is created to define the parse method of CSV file, containing the results our application.
 */
public class CSVParser {
    public List<AthleteResult> parse(File file) {
        String line;
        String csvSplitBy = ",";
        List<AthleteResult> athletes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
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
        return athletes;
    }
}