import mind.classes.Person;
import mind.classes.Team;
import mind.distribution.Distribution;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class DistributionTest {

    /**
     * Generate test data method for Tests.
     */
    public LinkedList<Person> generateTestData(){
        LinkedList<Person> testList = new LinkedList<Person>();
        testList.add(new Person("Five", 7));
        testList.add(new Person("One", 2));
        testList.add(new Person("Seven", 13));
        testList.add(new Person("Two", 3));
        testList.add(new Person("Four", 5));
        testList.add(new Person("Three", 4));
        testList.add(new Person("Six", 8));


        return testList;
    }

    /**
     * Test for correct distribution of Person Objects
     * with predefined data.
     */
    @Test
    public void testDistributePeopleByOne(){

        LinkedList<Person> personList = generateTestData();
        List<Team> teamList = Distribution.distributePeopleByOne(personList, 4);


        String[][] personOrder =
                {
                        {"One", "Seven"},
                        {"Two", "Six"},
                        {"Three", "Five"},
                        {"Four"}
                };

        int i = 0;
        for (Team t: teamList){
            int j = 0;
            for (Person p: t.getPersonList()){
                assertEquals(personOrder[i][j], p.getName());
                j++;
            }
            i++;
        }

    }
}
