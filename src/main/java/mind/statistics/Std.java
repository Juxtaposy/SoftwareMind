package mind.statistics;

import mind.classes.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Std {

    public static double calculateMean(List<Team> teamList){
        return teamList.stream()
                .reduce(0.0, (subSum, team) -> subSum + team.getAverageRate(), Double::sum)
                / teamList.size();
    }

    public static List<Double> calculateDeviations(double mean, List<Team> teamList){

        return teamList
                .stream()
                .map(t -> Math.pow(t.getAverageRate() - mean, 2))
                .collect(Collectors.toList());

    }

    public static double calculateVariance(double mean, List<Double> deviations){
        return deviations.stream().reduce(0.0, Double::sum)
                / deviations.size();
    }
    public static double calculateStd(List<Team> teamList){
        double mean = calculateMean(teamList);
        List<Double> deviations = calculateDeviations(mean, teamList);
        double variance = calculateVariance(mean, deviations);

        return Math.sqrt(variance);
    }
}
