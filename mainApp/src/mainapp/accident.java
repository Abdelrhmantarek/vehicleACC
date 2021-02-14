package mainapp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class accident {
    private int numberOfCasualties; // Number of Casualities
    private Date dateAndTime; // date and time
    private String collisionRoadLocation;//urban area , Highway
    private int vehicleAssociated;
    private ArrayList <Vehicle> vehicle = new ArrayList<>(); // ArrayList of vehicle

    
    //Multi-constructor
    public accident(int numberOfCasualties, Date dateAndTime, String collisionRoadLocation, int vehicleAssociated) {
        this.numberOfCasualties = numberOfCasualties;
        this.dateAndTime = dateAndTime;
        this.collisionRoadLocation = collisionRoadLocation;
        this.vehicleAssociated = vehicleAssociated;
    }
    
    //Zero-constructor
    public accident() {
    }
    
    
    
    //getters
    public Date getDateAndTime() {
        return dateAndTime;
    }
    public String getCollisionRoadLocation() {
        return collisionRoadLocation;
    }
    public int getVehicleAssociated() {
        return vehicleAssociated;
    }
    public int getNumberOfCasualties() {
        return numberOfCasualties;
    }
    public ArrayList<Vehicle> getVehicle() {
        return vehicle;
    }
    
    
    //setters
    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setCollisionRoadLocation(String collisionRoadLocation) {
        this.collisionRoadLocation = collisionRoadLocation;
    }
    
    
    public void setVehicle(ArrayList<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }
    
    public void setVehicleAssociated(int vehicleAssociated) {
        this.vehicleAssociated = vehicleAssociated;
    }
    
    public void setNumberOfCasualties(int numberOfCasualties) {
        this.numberOfCasualties = numberOfCasualties;
    }

    //Adding vehicle Info
    public void AddToVehicle(Vehicle v){
        vehicle.add(v);
        System.out.println("Added vehicle successfully");
    }
    
    
    //to string method Printing all data
    @Override
    public String toString(){
        return "\nNumber of Casualities:"+this.numberOfCasualties+"\nvehicle associated:"+this.vehicleAssociated+"\ncollisionRoadLocation:"+this.collisionRoadLocation+"\ndateAndTime:"+this.dateAndTime+"\n"+this.vehicle;
    }
    
    
}
