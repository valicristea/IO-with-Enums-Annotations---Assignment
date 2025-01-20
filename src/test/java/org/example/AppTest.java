package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class AppTest {
    @Test
    public void testParseCSV() {
        String csvContent = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";
        CSVParserMock parser = new CSVParserMock();
        List<AthleteResult> athletes = parser.parse(csvContent);
        Assert.assertEquals(3, athletes.size());
        AthleteResult firstAthlete = athletes.get(0);
        Assert.assertEquals(11, firstAthlete.athleteNumber);
        Assert.assertEquals("Umar Jorgson", firstAthlete.athleteName);
        Assert.assertEquals("SK", firstAthlete.countryCode);
        Assert.assertEquals("30:27", firstAthlete.skiTimeResult);
        Assert.assertEquals("xxxox", firstAthlete.firstShootingRange);
        Assert.assertEquals("xxxxx",firstAthlete.secondShootingRange);
        Assert.assertEquals("xxoxo",firstAthlete.thirdShootingRange);

        Assert.assertEquals(30, firstAthlete.getPenaltyTime());
        Assert.assertEquals("30:57", firstAthlete.getFinalResults());
        athletes.sort(new TimeComparator());
        AthleteResult winner = athletes.get(0);
        AthleteResult runnerUp = athletes.get(1);
        AthleteResult thirdPlace = athletes.get(2);
        Assert.assertEquals(27,winner.athleteNumber);
        Assert.assertEquals(1, runnerUp.athleteNumber);
        Assert.assertEquals(11, thirdPlace.athleteNumber);
    }
}