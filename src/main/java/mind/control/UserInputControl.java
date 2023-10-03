package mind.control;

import mind.classes.Person;
import mind.classes.Team;
import mind.statistics.Std;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Class to control user input in the program.
 */
public class UserInputControl {

    /**
     * Method which controls the program flow. If user chooses '1',
     * program will use predefined data. If user chooses '2',
     * program will ask the user to input custom data.
     *
     * @return - control value for other methods
     */
    public static int getControlParameter() {
        int input = 0;
        do {
            System.out.println("Welcome to Balancing Teams console app! \n Choose '1' to continue with predefined data or '2' " +
                    "to provide custom input.");
            Scanner scan = new Scanner(System.in);
            try {
                input = scan.nextInt();
            } catch (Exception ignored) {
            }
        } while (input != 1 && input != 2);

        return input;
    }

    /**
     * Method which gets number of People objects which will be used in the program.
     * @param input - program control value
     * @return int - number of Person objects
     */
    public  static int getNumberOfPeople(int input) {
        if (input == 1) {
            return 6;
        }
        else {
            int numOfPeople = 0;
            do {
                System.out.println("Provide number of people greater than 1: ");
                Scanner scan = new Scanner(System.in);
                try {
                    numOfPeople = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Number has to be an integer");
                }
            } while (numOfPeople <= 1);
            return numOfPeople;
        }
    }

    /**
     * Method which gets number of Team objects which will be used in the program.
     * @param input - program control value
     * @param numOfPeople - number of People objects
     * @return int - number of Teams which cannot be larger than numOfPeople
     * and smaller than 1.
     */
    public  static int getNumberOfTeams(int input, int numOfPeople) {
        if (input == 1) {
            return 3;
        } else {
            int numOfTeams = 0;
            do {
                System.out.println("Provide number of teams less or equal to number of people (" + numOfPeople + "): ");
                Scanner scan = new Scanner(System.in);
                try {
                    numOfTeams = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Number has to be an integer");
                }
            } while (numOfTeams < 1 || numOfTeams > numOfPeople);

            return numOfTeams;
        }

    }

    /**
     * Method to get detailed information about Person objects from the user
     * @param input - program control value
     * @param numOfPeople - number of People objects
     * @return - Linked List of Person objects containing data.
     */
    public  static LinkedList<Person> getPersonData(int input, int numOfPeople) {
        LinkedList<Person> personList = new LinkedList<>();
        if (input == 1){
            personList.add(new Person("Johnny", 8));
            personList.add(new Person("Robbie", 5));
            personList.add(new Person("Juliet", 3));
            personList.add(new Person("Scarlet", 5));
            personList.add(new Person("Jude", 9));
            personList.add(new Person("Deborah", 6));
        }
        else {
            for (int i = 1; i <= numOfPeople; i++) {
                System.out.printf("Person %d name: ", i);
                String name = "";
                do {
                    Scanner scan = new Scanner(System.in);
                    try {
                        name = scan.nextLine();
                    } catch (Exception e) {
                        System.out.println("Name has to be a string");
                    }
                } while (name.isEmpty());

                System.out.printf("Person %d rate: ", i);
                double rate = 0.0;
                do {
                    Scanner scan = new Scanner(System.in).useLocale(Locale.US);
                    try {
                        rate = scan.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Rate has to be a number");
                    }
                } while (rate <= 0.0);
                personList.add(new Person(name, rate));
            }
        }
        return personList;
    }

    /**
     * Method to display formatted data in console
     * @param teamList - List of Teams to display data from.
     */
    public static void displayData(List<Team> teamList){
        StringBuilder displayResult = new StringBuilder();
        for (Team t : teamList) {
            displayResult
                    .append("Team no ")
                    .append(t.getId())
                    .append(" has ")
                    .append(t.getPersonList().size()).append(" players(s) (");
            for (Person p : t.getPersonList()) {
                displayResult
                        .append(p.getName())
                        .append(", ");
            }
            displayResult.delete(displayResult.length() - 2, displayResult.length());
            displayResult
                    .append("). Average rate: ")
                    .append(String.format(Locale.US, "%.1f", t.getAverageRate()))
                    .append( "\n");
        }
        System.out.print(displayResult);
        System.out.printf(Locale.US, "Teams rate standard deviation: %.2f%n", Std.calculateStd(teamList));
    }
}
