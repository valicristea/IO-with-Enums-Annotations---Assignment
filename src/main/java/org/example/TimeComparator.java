package org.example;

import java.util.Comparator;

public class TimeComparator implements Comparator <AthleteResult> {

    @Override
    public int compare(AthleteResult athlete1, AthleteResult athlete2) {
        String [] parts1 = athlete1.skiTimeResult.split(":");
        String [] parts2 = athlete2.skiTimeResult.split(":");
        int minutes1 = Integer.parseInt(parts1 [0]);
        int seconds1 = Integer.parseInt(parts1 [1]);
        int minutes2 = Integer.parseInt(parts2 [0]);
        int seconds2 = Integer.parseInt(parts2 [1]);
        if (minutes1 != minutes2){
            return Integer.compare(minutes1, minutes2);
        }else {
            return Integer.compare(seconds1, seconds2);
        }
    }
}
