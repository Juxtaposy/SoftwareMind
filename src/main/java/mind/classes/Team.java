package mind.classes;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private static long idCounter = 1;

    private long id;
    private List<Person> personList;
    private double avarageRate;

    public Team(){
        this.id = idCounter;
        this.personList = new ArrayList<>();
        this.avarageRate = 0;
        idCounter++;
    }
}
