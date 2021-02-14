package mainapp;

import java.util.Date;

public class sideImpactAccident extends accident {
    
    //counter
    private static int counter =0;

    //Multi-constructor
    public sideImpactAccident(int numberOfCasualties, Date dateAndTime, String collisionRoadLocation, int vehicleAssociated) {
        super(numberOfCasualties, dateAndTime, collisionRoadLocation, vehicleAssociated);
        counter++;
    }
    
    //Zero-constructor
    public sideImpactAccident() {
        counter++;
    }
    
    //Getters(Accessors)
    public static int getCounter() {
        return counter;
    }

    //Setters(Mutators)
    public static void setCounter(int counter) {
        sideImpactAccident.counter = counter;
    }
    
    
    
    //to string method Printing all data
    @Override
    public String toString(){
        return super.toString();
    }
    
}
