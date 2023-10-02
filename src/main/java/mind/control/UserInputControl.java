package mind.control;

import mind.classes.Person;
import mind.classes.Team;
import mind.statistics.Std;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UserInputControl {

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

    public  static int getPersonNumber(int input) {
        if (input == 1) {
            return 3;
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

    public  static int getNumberOfTeams(int input, int numOfPeople) {
        if (input == 1) {
            return 3;
        } else {
            int numOfTeams = 0;
            do {
                System.out.println("Provide number of teams less or equal to number of people: ");
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
                    Scanner scan = new Scanner(System.in);
                    try {
                        rate = scan.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Name has to be a number");
                    }
                } while (rate <= 0.0);

                personList.add(new Person(name, rate));
            }
        }
        return personList;
    }

    public static void displayData(List<Team> teamList){
        for (Team t : teamList) {
            System.out.print("Team no " + t.getId() + " has " + t.getPersonList().size() + " player(s) (");
            for (Person p : t.getPersonList()) {
                System.out.print(p.getName() + ", ");
            }
            System.out.print("). Average rate: " + t.getAverageRate() + "\n");
        }
        System.out.printf(Locale.US, "Teams rate standard deviation: %.2f%n", Std.calculateStd(teamList));
    }
}
