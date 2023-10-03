package mind.classes;

/**
 * Person class.
 */
public class Person {

    /**
     * Fields
     */
    private String name;
    private double rate;

    /**
     * Constructor
     * @param name - name of a Person
     * @param rate - rate of a Person
     */
    public Person(String name, double rate){
        this.name = name;
        this.rate = rate;
    }

    /**
     * Getters for fields
     */
    public String getName(){
        return this.name;
    }

    public double getRate(){
        return this.rate;
    }

    /**
     * Setters for fields
     */
    public void setName(String newName){
        this.name = newName;
    }

    public void setRate(double newRate){
        this.rate = newRate;
    }
}
