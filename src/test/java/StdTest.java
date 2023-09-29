import mind.classes.Person;
import mind.classes.Team;
import mind.statistics.Std;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StdTest {
    private List<Team> generateTestData(){
        Team team1 = new Team();
        team1.addPerson(new Person("Jude", 9));
        team1.addPerson(new Person("Juliet", 3));

        Team team2 = new Team();
        team2.addPerson(new Person("Johnny", 8));
        team2.addPerson(new Person("Robbie", 5));

        Team team3 = new Team();
        team3.addPerson(new Person("Deborah", 6));
        team3.addPerson(new Person("Scarlet", 5));

        List<Team> teamList = new ArrayList<>();
        teamList.add(team1);
        teamList.add(team2);
        teamList.add(team3);

        return teamList;
    }
    private final double mean = Std.calculateMean(generateTestData());
    private final List<Double> calculatedDeviations = Std.calculateDeviations(
            mean,
            generateTestData()
    );
    private final double variance = Std.calculateVariance(mean, calculatedDeviations);

    @Test
    public void testCalculateMean(){
        assertEquals(6.0, Std.calculateMean(generateTestData()),0.001);
    }

    @Test
    public void testCalculateDeviations(){

        double[] expectedDeviations = {0.0, 0.25, 0.25};

        for (int i = 0; i <  calculatedDeviations.size(); i++){
            assertEquals(expectedDeviations[i], calculatedDeviations.get(i), 0.001);
        }
    }

    @Test
    public void testCalculateVariance(){
        assertEquals(0.1667, variance, 0.001);
    }

    @Test
    public void testCalculateStd(){
        assertEquals(0.408, Math.sqrt(variance), 0.001);
    }
}
