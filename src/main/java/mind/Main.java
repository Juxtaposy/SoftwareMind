package mind;

import mind.classes.Person;
import mind.classes.Team;
import mind.control.UserInputControl;
import mind.distribution.Distribution;

import java.util.LinkedList;
import java.util.List;


public class Main {
    /**
     * Main function to run the application.
     * Prompts  user for various inputs and calculates
     * even distribution of players among chosen
     * number of teams. Displays teams composition,
     * average rate of each team and teams
     * rate standard deviation.
     * @param args - not implemented
     */
    public static void main(String[] args) {

        // Decide between provided and custom data from user
        int input = UserInputControl.getControlParameter();

        // Get total number of players
        int numOfPeople = UserInputControl.getNumberOfPeople(input);

        // Get number of teams to distribute players in to
        int numOfTeams = UserInputControl.getNumberOfTeams(input, numOfPeople);

        // Acquire detailed information about each player
        LinkedList<Person> personList = UserInputControl.getPersonData(input, numOfPeople);

        // Distribute players between the teams - main logic of the program
        List<Team> teamList = Distribution.distributePeopleByOne(personList, numOfTeams);

        // Display data in correct format
        UserInputControl.displayData(teamList);

    }

}

