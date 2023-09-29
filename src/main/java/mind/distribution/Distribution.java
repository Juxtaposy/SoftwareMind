package mind.distribution;

import mind.classes.Person;
import mind.classes.Team;

import java.util.List;

public interface Distribution {
    List<Team> distributePeople(List<Person> personList);
}
