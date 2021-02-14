package mainapp;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class testClass {
    
    public static void main(String[] args) throws DuplicateException, ParseException, FileNotFoundException, Exception {
        
        Scanner scan = new Scanner(System.in);
        
        //Drivers
        
        Driver driv1 = new Driver("Naeem",19,"Male",new SimpleDateFormat("dd/MM/yyyy").parse("10/8/2010"));
        Driver driv2 = new Driver("Khaled",40,"Male",new SimpleDateFormat("dd/MM/yyyy").parse("11/9/2011"));
        Driver driv3 = new Driver("Ahmed",30,"Male",new SimpleDateFormat("dd/MM/yyyy").parse("07/8/2015"));
        Driver driv4 = new Driver("Nesma",70,"female",new SimpleDateFormat("dd/MM/yyyy").parse("07/8/2020"));
        
        
        //Vehicles
//        Vehicle v1 = new Vehicle(1500,driv1);
        
        
        
        //accidents
        
        
        
        //
        
        Date vii = new SimpleDateFormat("dd/MM/yyyy").parse("10/8/2010");
        Date v2 = new SimpleDateFormat("dd/MM/yyyy").parse("11/9/2020");
        Date v3 = new SimpleDateFormat("dd/MM/yyyy").parse("10/7/2014");
        vehicleAccidents va = new vehicleAccidents("Egypt");
        accident acc = new accident();
        
        accident s = new singleVehicleAccident(3,vii,"Highway",2);
        accident r = new rearEndAccident(5,v2,"Highway",4);
        accident h = new headOnAccident(2,v3,"Highway",1);
//        accident r_2 = new rearEndAccident(8,v2,"Highway",2);
        
        
        
        //Methods
        System.out.println("ADDING------------------------------------------------------");
        va.addingAccident(s);
//        va.addingAccident(s);
        va.addingAccident(r);
        va.addingAccident(h);
//        va.addingAccident(r_2);
        System.out.println("COMPARING-------------------------------------------------------");
        va.Comparing();
        System.out.println("\nCHECK MOST FREQUENT ACCIDENT-------------------------------");
        va.check_most();
        System.out.println("PERCENTAGE OF CASUALITIES----------------------------------------------");
        va.percentOfCas();
        
        
        
        //Save
        System.out.println("SAVING_________________________________");
        va.save();
        
        
        
        
        
        //Load
        System.out.println("LOADING---------------------------------------------");
        va.load();
        
        
        
    }
    
    
    
}
