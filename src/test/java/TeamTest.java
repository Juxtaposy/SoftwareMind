import mind.classes.Person;
import mind.classes.Team;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeamTest {

    public List<Person> generateSimpleTestData() {
        Person testOne = new Person("Test1", 5);
        Person testTwo = new Person("Test2", 8);
        Person testThree = new Person("Test3", 13);

        List<Person> testList = new ArrayList<>();
        testList.add(testOne);
        testList.add(testTwo);
        testList.add(testThree);
        return testList;
    }

    @Test
    public void testAutoIdIncrease(){
        Team team1 = new Team();
        assertEquals(1, team1.getId());
        Team team2 = new Team();
        assertEquals(2, team2.getId());
    }

    @Test
    public void testGetPersonByName(){
        Team team = new Team();
        team.addPerson(new Person("Test", 10));
        assertEquals("Test", team.getPersonByName("Test").getName());
    }

    @Test
    public void testAddPerson(){
        Team team = new Team();
        team.addPerson(new Person("Test", 10));
        assertEquals("Test",team.getPersonByName("Test").getName());
    }

    @Test
    public void testSequentialAddPersonAndAverageCalculation(){
        Team team = new Team();
        team.addPerson(new Person("Test1", 5));
        assertEquals(5, team.getAverageRate(), 0.001);
        team.addPerson(new Person("Test2", 8));
        assertEquals(13.0/2, team.getAverageRate(), 0.001);
        team.addPerson(new Person("Test3", 13));
        assertEquals(26.0/3, team.getAverageRate(), 0.001);
    }

    @Test
    public void testAddPersonsAsList(){
        Team team = new Team(generateSimpleTestData());
        assertEquals(26.0/3, team.getAverageRate(), 0.001);
    }
}
