import mind.classes.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    public Person generateTestPerson(){
        return new Person("Test", 10);
    }
    @Test
    public void testGetPerson(){
        assertEquals("Test", generateTestPerson().getName());
    }

    @Test
    public void testGetRate(){
        assertEquals(10.0, generateTestPerson().getRate(), 0.001);
    }

    @Test
    public void testSetName(){
        Person person = generateTestPerson();
        person.setName("NewName");
        assertEquals("NewName", person.getName());
    }

    @Test
    public void testSetRate(){
        Person person = generateTestPerson();
        person.setRate(15);
        assertEquals(15.0, person.getRate(), 0.001);
    }
}
