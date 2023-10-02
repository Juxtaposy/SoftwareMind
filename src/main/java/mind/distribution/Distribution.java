package mind.distribution;

import mind.classes.Person;
import mind.classes.Team;

import java.util.*;

public class Distribution {
    public static List<Team> distributePeopleByOne(LinkedList<Person> personList, int numberOfTeams) {
        personList.sort(new PersonRateComparator());
        Deque<Person> personDeque = new LinkedList<>(personList);
        List<Team> teamList = createTeams(numberOfTeams);

        boolean order = true;
        while (!personDeque.isEmpty()){
            for (int i = 0; i < numberOfTeams; i++){
                try {
                    if (order) {
                        teamList.get(i).addPerson(personDeque.pollFirst());
                    } else {
                        teamList.get(i).addPerson(personDeque.pollLast());
                    }
                }
                catch (NullPointerException e){
                    break;
                }
            }
            order = !order;
        }

        return teamList;
    }

    private static List<Team> createTeams(int numberOfTeams){
        List<Team> teamList = new ArrayList<>();
        for (int i = 0; i < numberOfTeams; i++){
            teamList.add(new Team());
        }
        return teamList;
    }
}
