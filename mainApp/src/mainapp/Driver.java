package mainapp;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Driver {
    private String driverName;
    private int driverAge;
    private String driverGender;
    private Date licenseIssueDate;

    //Multi-constructor
    public Driver(String driverName, int driverAge, String driverGender, Date licenseIssueDate) {
        this.driverName = driverName;
        this.driverAge = driverAge;
        this.driverGender = driverGender;
        this.licenseIssueDate = licenseIssueDate;
    }

    //Zero-constructor
    public Driver() {
    }

    //Getters(Accessors)
    public String getDriverName() {
        return driverName;
    }
    public int getDriverAge() {
        return driverAge;
    }
    public String getDriverGender() {
        return driverGender;
    }
    public Date getLicenseIssueDate() {
        return licenseIssueDate;
    }
    

    //Setters(Mutators)
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }
    public void setDriverGender(String driverGender) {
        this.driverGender = driverGender;
    }
    public void setLicenseIssueDate(Date licenseIssueDate) {
        this.licenseIssueDate = licenseIssueDate;
    }
    
    
    //to string method Printing all data
    @Override
    public String toString(){
        return "\ndriverName:"+this.driverName+"\ndriverAge:"+this.driverAge+"\ndriverGender:"+this.getDriverGender()+"\nlicenseIssueDate:"+this.licenseIssueDate;
    }
//    
    
}
