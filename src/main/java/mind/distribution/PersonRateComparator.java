package mind.distribution;

import mind.classes.Person;

import java.util.Comparator;

public class PersonRateComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return Double.compare(firstPerson.getRate(), secondPerson.getRate());
    }
}
