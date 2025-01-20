package org.example;

import java.util.List;

public class AthleteResult {
    Integer athleteNumber;
    String athleteName;
    String countryCode;
    String skiTimeResult;
    String firstShootingRange;
    String secondShootingRange;
    String thirdShootingRange;

    public AthleteResult(
            Integer athleteNumber,
            String athleteName,
            String countryCode,
            String skiTimeResult,
            String firstShootingRange,
            String secondShootingRange,
            String thirdShootingRange
    ) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    long getPenaltyTime(){
        long penaltyPoints = firstShootingRange.chars().filter(ch -> ch == 'o').count();
        penaltyPoints += secondShootingRange.chars().filter(ch -> ch == 'o').count();
        penaltyPoints += thirdShootingRange.chars().filter(ch -> ch == 'o').count();

        return penaltyPoints * 10;
    }

    public String getFinalResults() {

        List<String> resultTime = List.of(skiTimeResult.split(":"));

        long seconds = Long.parseLong(resultTime.get(1));
        seconds += getPenaltyTime();
        long minutes = Long.parseLong(resultTime.get(0));
        minutes += seconds / 60;
        seconds = seconds % 60;

        String finalResult = "";
        if (minutes == 0) {
            finalResult += "00:";
        } else if (minutes < 10) {
            finalResult += "0" + minutes + ":";
        } else {
            finalResult += minutes + ":";
        }

        if (seconds == 0) {
            finalResult += "00";
        } else if (seconds < 10) {
            finalResult += "0" + seconds;
        } else {
            finalResult += seconds;
        }
        return finalResult;
    }

    @Override
    public String toString() {
        return athleteName + " " + getFinalResults() + " (" + skiTimeResult + " + " + getPenaltyTime() + ")";
    }
}
