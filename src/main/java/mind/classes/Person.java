package mind.classes;

public class Person {

    private String name;
    private double rate;

    public Person(String name, double rate){
        this.name = name;
        this.rate = rate;
    }

    public String getName(){
        return this.name;
    }

    public double getRate(){
        return this.rate;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setRate(double newRate){
        this.rate = newRate;
    }
}
