package mind.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Team class.
*/
public class Team {

    /**
     * Fields
     */
    private static long idCounter = 1;
    private final long id;
    private final List<Person> personList;
    private double averageRate;

    /**
     * No @param constructor - creates empty Team
     * with idCounter as ID and averageRate = 0
     */
    public Team(){
        this.id = idCounter;
        this.personList = new ArrayList<>();
        this.averageRate = 0;
        idCounter++;
    }

    /**
     * Single @param constructor which accepts
     * list of Person object to fill Team composition.
     * Automatically sets ID and calculates averageRate.
     * @param personList - List<Person> list
     */
    public Team(List<Person> personList){
        this.id = idCounter;
        this.personList = personList;
        idCounter++;
        updateAverageRate();
    }

    /**
     * Getters
     */
    public long getId(){
        return this.id;
    }

    public double getAverageRate(){
        return averageRate;
    }

    public List<Person> getPersonList(){
        return personList;
    }

    /**
     * Getter to get first Person object which matches
     * specified Person name
     * @param name - String of name to look for in Team
     * @return Person object or null if not found
     */
    public Person getPersonByName(String name){
        return personList.stream().filter(person -> name.equals(person.getName()))
                .findAny()
                .orElse(null);
    }

    /**
     * Method to automatically update average rate
     * of Team when new Person object is added/removed.
     */
    private void updateAverageRate(){
        averageRate = personList.stream()
                .reduce(0.0, (partialSum, person) -> partialSum + person.getRate(), Double::sum)
                /personList.size();
    }

    /**
     * Method to add Person to the Team
     * @param person - Person object
     */
    public void addPerson(Person person){
        personList.add(person);
        updateAverageRate();
    }

}
