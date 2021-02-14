package mainapp;

import java.util.Date;

public class headOnAccident extends accident {
    
    //counter
    private static int counter =0;

    //Multi-constructor
    public headOnAccident(int numberOfCasualties, Date dateAndTime, String collisionRoadLocation, int vehicleAssociated) {
        super(numberOfCasualties, dateAndTime, collisionRoadLocation, vehicleAssociated);
        counter++;
    }
    

    //Zero-constructor
    public headOnAccident() {
        counter++;
    }
    
    //to string method Printing all data
    @Override
    public String toString(){
        return super.toString();
    }
    
}
