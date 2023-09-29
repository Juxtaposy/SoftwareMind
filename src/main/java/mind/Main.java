package mind;

import mind.classes.Person;
import mind.classes.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int input = 0;
        List<Person> personList = new ArrayList<>();
        List<Team> teamList = new ArrayList<>();

        do {
            System.out.println("Welcome to Balancing Teams console app! \n Choose '1' to continue with predefined data or '2'" +
                    "to provide custom input");
            Scanner scan = new Scanner(System.in);
            try {
                input = scan.nextInt();
            } catch (Exception ignored) {
            }
        } while (input != 1 && input != 2);

        if (input == 1){
            System.out.println("Predefined data contains 6 people divided into 3 teams.");

            personList.add(new Person("Johnny", 8));
            personList.add(new Person("Robbie", 5));
            personList.add(new Person("Juliet", 3));
            personList.add(new Person("Scarlet", 5));
            personList.add(new Person("Jude", 9));
            personList.add(new Person("Deborah", 6));

        }
        else {
            int numOfPeople = 0;
            do {
                System.out.println("Provide number of people: ");
                Scanner scan = new Scanner(System.in);
                try {
                    numOfPeople = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Number has to be an integer");
                }
            } while (numOfPeople <= 1);

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

            for(int i = 1; i <= numOfPeople; i++){
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


    }

}

