package mainapp;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class vehicleAccidents {
    private static String countryName; // Country Name
    public ArrayList<accident> accidents = new ArrayList<>(); // ArrayList of Accidents

    //Multi-constructor
    public vehicleAccidents(String countryName) {
        this.countryName = countryName;
    }

    //Zero-constructor
    public vehicleAccidents() {
    }
    
    //getters
    public String getCountryName() {
        return countryName;
    }
    public ArrayList<accident> getAccidents() {
        return accidents;
    }

    
    //setters
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public void setAccidents(ArrayList<accident> accidents) {
        this.accidents = accidents;
    }
    
    /****************Adding a reported accident type to the list of accidents if is not already in the accidents list**************/    
    public boolean accChecker(accident acc){
        boolean myFlag = true;
        for(accident acci: accidents){
            if(acci.getDateAndTime().equals(acc.getDateAndTime()) && acci.getCollisionRoadLocation().equals(acc.getCollisionRoadLocation())){
                   myFlag=false; 
            }
        }
        return myFlag;
    }
    public void addingAccident(accident a) throws DuplicateException{
        String msg="";
        if(accChecker(a)){
            accidents.add(a);
            System.out.println("Added successs");
        }else{
            throw new DuplicateException("Accident is already there");
        }
    }
    /****************Adding a reported accident type to the list of accidents if is not already in the accidents list**************/
    
    /******************after2015**********************/
    public String displayingAfter_License(){
        int i=0;
        String s = "";
        s+=this.getCountryName()+"\n"; // Countryname,name,
        for(accident a: accidents){
//            s+=a.getVehicle().+"\n"; //????
              s+=a.toString();
            for(Vehicle v: a.getVehicle()){
                if(v.getDriver().getLicenseIssueDate().getYear()>115){
//                    s+=/*" Driver: "+v.getDriver().getDriverName()+" license year: "+v.getDriver().getLicenseIssueDate()+"\n"
//                            + v.getDriver() ;*/
                     s+=v.toString();
                }
            }
        }
        System.out.println(i);
        return s;
    }
    /******************after2015***********************/
    
    /************Display percentage of casualities in accidents involving drivers over age 65*********/
    public double percentOfCas(){
        double percent=0.0;
        int total=0;
        int counter=0;
        if(!accidents.isEmpty()){
            for(accident a : accidents){
                total+=a.getNumberOfCasualties();
                for(Vehicle v: a.getVehicle()){
                    if(v.getDriver().getDriverAge()>65){
                        counter++;
                    }
                }
            }
        }
        percent = ((double) counter/total)*100;
        System.out.println(percent);
        return percent;
    }
    /************Display percentage of casualities in accidents involving drivers over age 65*********/
    
    /***************method to save data vehicle data structure in txt file***************************/
    public void save(){
        try{
                File f = new File("vehicleAccData.txt");
                PrintWriter pw = new PrintWriter(f);
                pw.write("Country:"+this.countryName);
                pw.println(getAccidents());
//                pw.println(accident.);
                pw.close();
                System.out.println("Country:"+this.countryName+"\n");
                System.out.println(getAccidents());
            }catch(FileNotFoundException e){
            System.out.println("Error has been occured ->"+e.getMessage());
        }
    }
 
    /***************method to save data vehicle data structure in txt file***************************/
    
    /***************method to get data from txt file***************************/
    public String load() throws Exception{
        String data = "";
        try{Scanner input = new Scanner(new File("vehicleAccData.txt"));
        while(input.hasNext()){
            data+=input.nextLine()+"\n";
        }
        input.close();
        }catch(FileNotFoundException e){
               System.out.println("file not found");
        }
        System.out.println(data);
        return data;
    }
    
   /***************method to get data from txt file***************************/
    
//    
//    /***************check most frequent Accident***************************/
    public String check_most(){
        int singleVehicle=0,rearEnd=0,sideImpact=0,headOn=0;
        for(accident a: accidents){
           int s = (a instanceof singleVehicleAccident)? singleVehicle++: (a instanceof rearEndAccident) ? rearEnd++ : (a instanceof sideImpactAccident) ? sideImpact++ : headOn++;
        }
        System.out.println("singleVehicle: "+singleVehicle+"\nrearEnd: "+rearEnd+"\nsideImpact: "+sideImpact+"\nheadOn: "+headOn);
        return "singleVehicle: "+singleVehicle+"\nrearEnd: "+rearEnd+"\nsideImpact: "+sideImpact+"\nheadOn: "+headOn;
    }
//    
//    /***************check most frequent Accident***************************/
    
    
    
    /************Method to compare highway within urban area*******************/
    public String Comparing() {
            String comparing="";
            int Highway =0, urbanArea=0;
            if(!accidents.isEmpty()){
                for(accident accidenty : accidents) {
                    if(accidenty.getCollisionRoadLocation().equals("Highway")) {
			        Highway++;
                    }else if(accidenty.getCollisionRoadLocation().equals("Urban Area")) {
                                urbanArea++;
                    }	
	    }
           }
            if(Highway>urbanArea){
                comparing="highway= "+Highway+" > urban area= "+urbanArea;
            }else if(Highway<urbanArea){
                comparing="highway= "+Highway+"< urbanArea="+urbanArea;
            }else{
                comparing = "UrbanArea="+urbanArea+" = Highway="+Highway;
            }
            System.out.println(comparing);
            return comparing;
//            System.out.println("Highway :"+Highway+"\tUrban Area:"+urbanArea);
//            return "Highway :"+Highway+"\tUrban Area:"+urbanArea;
    }
    /************Method to compare highway within urban area*******************/
    
}