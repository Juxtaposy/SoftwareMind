package mind.classes;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private static long idCounter = 1;

    private final long id;
    private final List<Person> personList;
    private double averageRate;

    public Team(){
        this.id = idCounter;
        this.personList = new ArrayList<>();
        this.averageRate = 0;
        idCounter++;
    }

    public Team(List<Person> personList){
        this.id = idCounter;
        this.personList = personList;
        updateAverageRate();
        idCounter++;
    }

    public long getId(){
        return this.id;
    }

    public double getAverageRate(){
        return averageRate;
    }

    public Person getPersonByName(String name){
        return personList.stream().filter(person -> name.equals(person.getName()))
                .findAny()
                .orElse(null);
    }

    private void updateAverageRate(){
        averageRate = personList.stream()
                .reduce(0.0, (partialSum, person) -> partialSum + person.getRate(), Double::sum)
                /personList.size();
    }
    public void addPerson(Person person){
        personList.add(person);
        updateAverageRate();
    }

}
