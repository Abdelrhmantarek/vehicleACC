package mainapp;
public class Vehicle {
    private int vehicleNumber;
    Driver Driver = new Driver(); //Object from driver

    //Multi-constructor
    public Vehicle(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    //Zero-constructor
    public Vehicle() {
    }
    
    //Getters(Accessors)
    public int getVehicleNumber() {
        return vehicleNumber;
    }
    public Driver getDriver() {
        return Driver;
    }
    
    
    //Setters(Mutators)
    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public void setDriver(Driver Driver) {
        this.Driver = Driver;
    }
   
    //to string method Printing all data
    @Override
    public String toString(){
//        return "Vehicle number:"+this.vehicleNumber+Driver.toString();
        return "Vehicle number:"+this.vehicleNumber+"\ndriver name:"+Driver.getDriverName()+"\ndriver age:"+Driver.getDriverAge()+"\ndriver gender:"+Driver.getDriverGender()+"\nlicenseIssueDate:"+Driver.getLicenseIssueDate();
    }
    
    
    
}
