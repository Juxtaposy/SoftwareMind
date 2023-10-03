package mind.distribution;

import mind.classes.Person;
import mind.classes.Team;

import java.util.*;

/**
 * Class implementing algorithm for People
 * distribution among number of Teams.
 */
public class Distribution {

    /**
     * Method to distribute People one by one.
     * This algorithm works in sequence.
     * Sorts Person objects according to rate fields.
     * Distributes People one by one starting from beginning,
     * numberOfTeams amount of times, then shifts the distribution
     * to go from the end of the list. Repeats back-and-forth
     * until all Person objects are inserted into a specific Team.
     * @param personList - List of Person objects to distribute
     * @param numberOfTeams - Number of Teams to distribute People between
     * @return - List of Team objects with evenly distributed People objects
     */
    public static List<Team> distributePeopleByOne(LinkedList<Person> personList, int numberOfTeams) {
        // Sort Person objects
        personList.sort(new PersonRateComparator());

        // Create Deque for better access time of objects.
        Deque<Person> personDeque = new LinkedList<>(personList);

        // Create required amount of Teams
        List<Team> teamList = createTeams(numberOfTeams);

        // Distribute Person objects
        boolean order = true;
        while (!personDeque.isEmpty()){
            for (int i = 0; i < numberOfTeams; i++){
                if (!personDeque.isEmpty()) {
                        if (order) {
                            teamList.get(i).addPerson(personDeque.pollFirst());
                        } else {
                            teamList.get(i).addPerson(personDeque.pollLast());
                        }
                }
            }
            order = !order;
        }

        // Return List of Teams
        return teamList;
    }

    /**
     * Method to create number of Teams specified by the user
     * @param numberOfTeams - number of new Team objects
     * @return - List of Team objects
     */
    private static List<Team> createTeams(int numberOfTeams){
        List<Team> teamList = new ArrayList<>();
        for (int i = 0; i < numberOfTeams; i++){
            teamList.add(new Team());
        }
        return teamList;
    }
}
