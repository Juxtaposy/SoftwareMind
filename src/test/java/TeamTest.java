import mind.classes.Person;
import mind.classes.Team;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Basic tests for Team class
 */
public class TeamTest {

    /**
     * Method for test data generation
     */
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

    /**
     * This method test auto ID increment.
     * Creates two instances of the Team class
     * and checks if the ID properly increases.
     * This way test is resistant to different
     * order of tests calling, which creates more
     * Team instances each with individual ID.
     */
    @Test
    public void testAutoIdIncrease(){
        Team team1 = new Team();
        Team team2 = new Team();
        assertEquals(team1.getId() + 1, team2.getId());
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

    /**
     * Test for calculating average rate of Team after
     * sequential addition of Person objects
     */
    @Test
    public void testSequentialAddPersonAndAverageRateCalculation(){
        Team team = new Team();
        team.addPerson(new Person("Test1", 5));
        assertEquals(5, team.getAverageRate(), 0.001);
        team.addPerson(new Person("Test2", 8));
        assertEquals(13.0/2, team.getAverageRate(), 0.001);
        team.addPerson(new Person("Test3", 13));
        assertEquals(26.0/3, team.getAverageRate(), 0.001);
    }

    /**
     * Test for correct average rate calculation when
     * list of Person objects is provided as input
     */
    @Test
    public void testAddPersonsAsListAndAverageRateCalculation(){
        Team team = new Team(generateSimpleTestData());
        assertEquals(26.0/3, team.getAverageRate(), 0.001);
    }
}
