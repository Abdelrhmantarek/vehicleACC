package mainapp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;




public class MainGui extends Application {
    
    
    
    
    @Override
    public void start(Stage myStage) throws Exception {
        
        //design code
        
        //greeting
        Label lb_welcome = new Label("WELCOME TO THE REPROT ");
        Label cont_greeting = new Label("---------------------------------------");
        
        //Country Name
        Label lb_countryName = new Label("\tEnter country name: ");
        TextField tf_countryName = new TextField();
//        Button bt_countryName = new Button("Adding Country");
        
        Label cont_greeting2 = new Label("---------------------------------------");
        
        // Choosing
        Label lb_chooseAcc = new Label("\tChoose an accident to fire:");
        
        ComboBox<String> comboBox_Accidents = new ComboBox<>();
        comboBox_Accidents.getItems().addAll(
                "Single vehicle accident",
                "Rear-end accident",
                "Side-impact accident",
                "Head-on accident"
        );
        comboBox_Accidents.setPromptText("Types:");
        
        
        //get value
//        comboBox.getValue();
        

        Label cont_greeting3 = new Label("---------------------------------------");
        
        
        
        
    
        /********************************************************************/
        
        //PANE
        GridPane gp = new GridPane();
        
        
        //Entering info of the car
        Label lb_info = new Label("    Info about the the Vehicle 🚍");
        
        //Car number
        Label lb_carNumber = new Label("\tEnter car Number:");
        TextField tf_carNumber = new TextField();
        
        //driver name
        Label lb_driverName = new Label("Enter driver Name:");
        TextField tf_driverName = new TextField();
        
        //driver age
        Label lb_driverAge = new Label("\tEnter driver Age:");
        TextField tf_driverAge = new TextField();
        
        //driver gender
        Label lb_driverGender = new Label("Enter driver gender:");
        TextField tf_driverGender = new TextField();
        tf_driverGender.setPromptText(" m or f ");
        
        //driver LicenseIssue Date
        Label lb_licenseIssueDate = new Label("\tEnter driver LicenseIssueDate:");
        TextField tf_licenseIssueDate = new TextField();
        tf_licenseIssueDate.setPromptText("dd/MM/yyyy");
        
        //vehicleAssociated
        Label lb_vehicleAssociated = new Label("vehicleAssociated");
        TextField tf_vehicleAssociated = new TextField();
        
        //NumberOfCasualities
        Label lb_numbOfCas = new Label("\tNumber of Casualities:");
        TextField tf_numbOfCas = new TextField();
        
        //dateAndTime
        Label lb_dateAndTime = new Label("\tdateAndTime:");
        TextField tf_dateAndTime = new TextField();
        tf_dateAndTime.setPromptText("dd/MM/yyyy");
        
        //RoadLocation
        Label lb_roadLoc = new Label("Collision road Location");
        ComboBox<String> comboBox_roadLoc = new ComboBox<>();
        comboBox_roadLoc.getItems().addAll(
                "Urban Area",
                "Highway"
        );
        comboBox_roadLoc.setPromptText("Location:");
        
        /********************************************************************/
        
        
        
        
        
        /******************************************************************/
        
        vehicleAccidents va = new vehicleAccidents(); // Object
        
        /***********************SUBMIT BUTTON*******************************/
        //btn_submit for collecting data
        Button btn_submit = new Button("Add to AccList 👈");
        btn_submit.setOnAction(e->{
            
            //Creating a new vehicle accident
            String CN = tf_countryName.getText();//country
            
            Driver driv = new Driver();
            Vehicle vehi = new Vehicle();
            accident sva = new singleVehicleAccident();
            accident rea = new rearEndAccident();
            accident sia = new sideImpactAccident();
            accident hoa = new headOnAccident();
            va.setCountryName(CN);
            
            String myComboRoadLoc = comboBox_roadLoc.getValue();
            String driverName = tf_driverName.getText();
            int driverAge = Integer.valueOf(tf_driverAge.getText()) ;
            String driverGender = tf_driverGender.getText();
//            new SimpleDateFormat("dd/MM/yyyy").parse("10/8/2010")
            String license = tf_licenseIssueDate.getText(); // String
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date textFieldAsDate1=null;
            
            int vehicleNumber = Integer.valueOf(tf_carNumber.getText());
            int vehicleAssociated = Integer.valueOf(tf_vehicleAssociated.getText());
            int numberOfCasualities = Integer.valueOf(tf_numbOfCas.getText());
            
            
            //DateandTime
            String dateAndTime = tf_dateAndTime.getText();
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date textFieldAsDate2=null;
            
            switch(comboBox_Accidents.getValue()){
                case "Single vehicle accident":
                    
                    vehi.Driver.setDriverName(driverName);
                    vehi.Driver.setDriverAge(driverAge);
                    vehi.Driver.setDriverGender(driverGender);
                    try{
                        textFieldAsDate1 = sdf1.parse(license);
                        vehi.Driver.setLicenseIssueDate(textFieldAsDate1);
                    }catch (Exception pe) {
                        System.out.println("Parsing Exception");
                    }
                    try{
                        textFieldAsDate2 = sdf2.parse(dateAndTime);
                        sva.setDateAndTime(textFieldAsDate2);
                    }catch(Exception pe){
                        System.out.println("Parsing Exception");
                    }
                    
//                    vehi.Driver.setLicenseIssueDate(license);
                    vehi.setVehicleNumber(vehicleNumber);
                    sva.setVehicleAssociated(vehicleAssociated);
                    sva.setNumberOfCasualties(numberOfCasualities);
                    sva.setCollisionRoadLocation(myComboRoadLoc);
                    
                    sva.AddToVehicle(vehi);
                    try{
                        va.addingAccident(sva);
                    }catch(Exception e1){
                        System.out.println("Wrongyyyy");
                    }
                    va.save();
            {
                try {
                    va.load();
                } catch (Exception ex) {
                    System.out.println("File not Found");
                }
            }
                    break;
                case "Rear-end accident":
                    
                    //getTextFields
                    vehi.setVehicleNumber(vehicleNumber);
                    vehi.Driver.setDriverName(driverName);
                    vehi.Driver.setDriverAge(driverAge);       
                    vehi.Driver.setDriverGender(driverGender);
//                    vehi.Driver.setLicenseIssueDate(license);
                    rea.setVehicleAssociated(vehicleAssociated);
                    rea.setNumberOfCasualties(numberOfCasualities);
                    rea.setCollisionRoadLocation(myComboRoadLoc);
                    rea.AddToVehicle(vehi);
            {
                try {
                    //Adding
                    va.addingAccident(rea);
                } catch (Exception ex) {
                    System.out.println("Wrongyyyy");
                }
            }
                    va.save();
                    try {
                    va.load();
                } catch (Exception ex) {
                    System.out.println("File not Found");
                }
                    break;
                case "Side-impact accident":
                    
                    //getTextFields
                    
                    
                    vehi.setVehicleNumber(vehicleNumber);
                    vehi.Driver.setDriverName(driverName);
                    vehi.Driver.setDriverAge(driverAge);       
                    vehi.Driver.setDriverGender(driverGender);
                    
                    try{
                        textFieldAsDate1 = sdf1.parse(license);
                        vehi.Driver.setLicenseIssueDate(textFieldAsDate1);
                    }catch (Exception pe) {
                        System.out.println("Parsing Exception");
                    }
                    try{
                        textFieldAsDate2 = sdf2.parse(dateAndTime);
                        sva.setDateAndTime(textFieldAsDate2);
                    }catch(Exception pe){
                        System.out.println("Parsing Exception");
                    }
//                    vehi.Driver.setLicenseIssueDate(license);
                    sia.setVehicleAssociated(vehicleAssociated);
                    sia.setNumberOfCasualties(numberOfCasualities);
                    sia.setCollisionRoadLocation(myComboRoadLoc);
                    sia.AddToVehicle(vehi);
            {
                try {
                    //Adding
                    va.addingAccident(sia);
                } catch (Exception e1) {
                    System.out.println("Wrongyyyy");
                }
            }
                    va.save();
                    
                    try {
                    va.load();
                } catch (Exception ex) {
                    System.out.println("File not Found");
                }    
                   
                    break;
                case "Head-on accident":
                    
                    //getTextFields
                    vehi.setVehicleNumber(vehicleNumber);
                    vehi.Driver.setDriverName(driverName);
                    vehi.Driver.setDriverAge(driverAge);       
                    vehi.Driver.setDriverGender(driverGender);
                    
                    try{
                        textFieldAsDate1 = sdf1.parse(license);
                        vehi.Driver.setLicenseIssueDate(textFieldAsDate1);
                    }catch (Exception pe) {
                        System.out.println("Parsing Exception");
                    }
                    try{
                        textFieldAsDate2 = sdf2.parse(dateAndTime);
                        sva.setDateAndTime(textFieldAsDate2);
                    }catch(Exception pe){
                        System.out.println("Parsing Exception");
                    }
                    
//                    vehi.Driver.setLicenseIssueDate(license);
                    hoa.setVehicleAssociated(vehicleAssociated);
                    hoa.setNumberOfCasualties(numberOfCasualities);
                    hoa.setCollisionRoadLocation(myComboRoadLoc);
                    
                    
                    hoa.AddToVehicle(vehi);
            {
                try {
                    //Adding
                    va.addingAccident(hoa);
                } catch (Exception ex) {
                    System.out.println("Wrongyyyy");
                }
            }
                    va.save();
                    
                    try {
                    va.load();
                } catch (Exception ex) {
                    System.out.println("File not Found");
                } 
                    
                    break;
                default:
                    System.out.println("Error with cases found");
                }
        
        /***  End SWITICHING  ***/
        });
        
        /***********************SUBMIT BUTTON*******************************/
        
        /*****************Most frequent*****************************/
        
        Button btn_mostFreq = new Button("click to show most frequent accident");
        
        btn_mostFreq.setOnAction(e->{
            TextField tf_mostFreq = new TextField(va.check_most());
            gp.add(tf_mostFreq,1,28);
        });
        
        
        
        
        /*****************Most frequent*************************************/
        
        
        /*****************Comparing*****************************/
        
            Button btn_Comparing = new Button("click to Compare with urbanarea and highway");
            btn_Comparing.setOnAction(e->{
                TextField tf_Compare = new TextField(va.Comparing());
                gp.add(tf_Compare,1,29);
            });
        
        
        
        /*****************Comparing*************************************/
        /******************after2015**********************/
        
        Button btn_after = new Button("Click to display country name and accidents list");
        btn_after.setOnAction(e->{
            TextArea tf_after = new TextArea(va.displayingAfter_License());
            gp.add(tf_after,1,30);
        });
        
        /******************after2015**********************/
        
        /************Display percentage of casualities in accidents involving drivers over age 65******************/
        
        Button btn_CasaulitiesOverAge= new Button("Click to display percentage of casualities");
        btn_CasaulitiesOverAge.setOnAction(e->{
            double per = va.percentOfCas();
            TextField tf_CasaulitiesOverAge = new TextField("Percentage="+per);
            gp.add(tf_CasaulitiesOverAge,1,31);
        });
        
        /************Display percentage of casualities in accidents involving drivers over age 65******************/
        
        /*************Load from file*******************/
        
        Button btn_load = new Button("Load from file");
        btn_load.setOnAction(e->{
            try {
                TextArea tf_load = new TextArea(va.load());
                //Add Loading
                gp.add(tf_load,0,35);
            } catch (Exception ex) {
                System.out.println("File Not Found");;
            }
            
        });
        
        
        /***********Load from file******************/
        
        //greeting
        gp.add(lb_welcome,0,1);//-->column,row
        gp.add(cont_greeting,0,2);
        
        
        //CountryName
        gp.add(lb_countryName,0,3);
        gp.add(tf_countryName,1,3);
        
        gp.add(cont_greeting2,0,5);
        
        // Choosing
        gp.add(lb_chooseAcc,0,7);
        gp.add(comboBox_Accidents,1,7);
        
        gp.add(cont_greeting3,0,10);
        
        //Info details
        gp.add(lb_info,0,11);
        
        //Car number
        gp.add(lb_carNumber,0,14);
        gp.add(tf_carNumber,1,14);
        
        //driver name
        gp.add(lb_driverName,2,14);
        gp.add(tf_driverName,3,14);
        
        //driver age
        gp.add(lb_driverAge,0,15);
        gp.add(tf_driverAge,1,15);
        
        //driver gender
        gp.add(lb_driverGender,2,15);
        gp.add(tf_driverGender,3,15);
                
        //driver LicenseIssue Date
        
        gp.add(lb_licenseIssueDate,0,16);
        gp.add(tf_licenseIssueDate,1,16);
        
        
        // Vehicle associated
        gp.add(lb_vehicleAssociated,2,16);
        gp.add(tf_vehicleAssociated,3,16);
        
        //number of casualities
        gp.add(lb_numbOfCas,0,17);
        gp.add(tf_numbOfCas,1,17);
        //Road Location
        gp.add(lb_roadLoc,2,17);
        gp.add(comboBox_roadLoc,3,17);
        
        //dateAndTime
        gp.add(lb_dateAndTime,0,18);
        gp.add(tf_dateAndTime,1,18);
        
        
        
        gp.setHgap(5);
        gp.setVgap(5);
        
        
        
        //adding btns
        gp.add(btn_submit,1,25);
        gp.add(btn_mostFreq,0,28);
        gp.add(btn_Comparing,0,29);
        gp.add(btn_after, 0, 30);
        gp.add(btn_CasaulitiesOverAge,0,31);
        gp.add(btn_load,0,32);

        
        
        
        //Scene
        Scene myScene = new Scene(gp,1000,700);
        
        
        
        //Stage
        myStage.setScene(myScene);
        myStage.setTitle("Vehicle Accidents report");
        myStage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }

    
}
