package mind;

import mind.classes.Person;
import mind.classes.Team;
import mind.control.UserInputControl;
import mind.distribution.Distribution;
import mind.statistics.Std;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int input = UserInputControl.getControlParameter();

        int numOfPeople = UserInputControl.getPersonNumber(input);

        int numOfTeams = UserInputControl.getNumberOfTeams(input, numOfPeople);

        LinkedList<Person> personList = UserInputControl.getPersonData(input, numOfPeople);

        List<Team> teamList = Distribution.distributePeopleByOne(personList, numOfTeams);

        UserInputControl.displayData(teamList);

    }

}

