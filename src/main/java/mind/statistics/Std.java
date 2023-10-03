package mind.statistics;

import mind.classes.Team;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class with static methods for calculating
 * standard deviation of Teams
 */
public class Std {

    /**
     * Method to calculate mean of Teams
     * @param teamList - List of Team objects
     * @return double - mean value of Teams
     */
    public static double calculateMean(List<Team> teamList){
        return teamList.stream()
                .reduce(0.0, (subSum, team) -> subSum + team.getAverageRate(), Double::sum)
                / teamList.size();
    }

    /**
     * Method to calculate deviation of each Team
     * @param mean - Mean value
     * @param teamList - List of Team objects
     * @return List<Double> - list of deviation values of Teams
     */
    public static List<Double> calculateDeviations(double mean, List<Team> teamList){

        return teamList
                .stream()
                .map(t -> Math.pow(t.getAverageRate() - mean, 2))
                .collect(Collectors.toList());

    }

    /**
     * Method to calculate variance of Teams
     * @param mean - Mean value
     * @param deviations - list of deviation values of Teams
     * @return double - variance of Teams
     */
    public static double calculateVariance(double mean, List<Double> deviations){
        return deviations.stream().reduce(0.0, Double::sum)
                / deviations.size();
    }

    /**
     * Method to calculate standard deviation of Teams
     * @param teamList - List of Team objects
     * @return double - standard deviation of Teams
     */
    public static double calculateStd(List<Team> teamList){
        double mean = calculateMean(teamList);
        List<Double> deviations = calculateDeviations(mean, teamList);
        double variance = calculateVariance(mean, deviations);
        return Math.sqrt(variance);
    }
}
