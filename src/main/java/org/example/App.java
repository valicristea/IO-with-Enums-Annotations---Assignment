package org.example;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
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
        String csvFile = "C:\\Users\\Vali\\Desktop\\AthleteResults.csv";
        CSVParser parser = new CSVParser();
        List<AthleteResult> athletes = parser.parse(new File(csvFile));
        athletes.sort(new TimeComparator());
        System.out.println("Winner - " + athletes.get(0));
        System.out.println("Runner-up - " + athletes.get(1));
        System.out.println("Third Place - " + athletes.get(2));

    }
}
