/*

** PatientProfInterface (Patient Profile Interface) **

Provides a UI for the end consumer (doctors, nurses, etc) to create, read, update, and delete Patient Profiles

private methods:
    private void inputMismatchMessage()
    private void illegalArgumentMessage()
    private void miscExceptionMessage(Exception e)
    private void changeMdContact(PatientProf p)
    private void changeIllType(PatientProf p)
    private void changeAlgType(PatientProf p)
    private void getUserChoice()

protected methods:
    protected void changeAddress(PatientProf p)
    protected void changePhone(PatientProf p)
    protected void changeInsuType(PatientProf p)
    protected void changeCoPay(PatientProf p)
    protected void changePatientType(PatientProf p)
    protected void changeKeyAttributes(PatientProf p)
    protected void deletePatientProf()
    protected PatientProf findPatientProf()
    protected void updatePatientProf()
    protected void displayPatientProf()
    protected void displayPatientProf(PatientProf patient)
    protected void displayMedCond(MedCond mc)
    protected void displayAllPatientProf()
    protected void writeToDB()
    protected void initDB()
    protected void createNewPatientProf()
    protected void createNewPatientProf(PatientProf p)
    protected void createNewMedCond(PatientProf p)

public methods:
    public void setScanner()
    public void newLine()
    public void displayMenuMain()
    public void displayMenuUpdatePatientProf()
    public void displayMenuUpdateMedCond()
    public void displayMenuEnd()
    public String getAdminID()
    public String getLastName()
    public void mapMenuMainToMethod(int optionCode)
    public boolean mapMenuUpdatePatientProfToMethod(PatientProf p, int optionCode)
    public boolean mapMenuUpdateMedCondToMethod(PatientProf p, int optionCode)
    public boolean mapMenuEnd(int optionCode)
    public void startSession()

*/

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.System;

public class PatientProfInterface extends PatientProfInterfaceAbstract{

    // Attributes
    //      Database object to hold data from database. Acts like the messenger to the UI and file
    //      Back Value option will allow user to go back one menu (ex: modifications menu to main menu)
    //      Scanner object to assist in retrieving user input
    private PatientProfDB db = null;
    private static final int backValOption = -1;
    private Scanner sn;

    // Menu Main
    // Basic funcationality of IPS menu
    private static enum menuMain {
        createPatProf       (1, "Enter a new patient profile"),
        deletePatProf       (2, "Delete a patient profile"),
        displayPatProf      (3, "Display patient profile"),
        updatePatProf       (4, "Update patient profile"),
        displayAllPatProfs  (5, "Display all profiles"),
        commitAllPatProfs   (6, "Save all patient profiles"),
        fetchAllPatProfs    (7, "Retrieve all patient profiles"),
        exit                (0, "Exit and save changes");

        final int optionCode;
        final String optionString;

        private menuMain(final int optionCode, final String optionString) {
            this.optionCode = optionCode;
            this.optionString = optionString;
        }
        public final int getOptionCode() {  return this.optionCode;  }
        public final String getOptionString() {  return this.optionString;  }
        public final String toString() {  return "("+this.getOptionCode()+") "+this.getOptionString()+": ";  }
    }
    
    // Menu Update PatientProf
    // Update key PatientProf attributes menu
    private static enum menuUpdatePatientProf {
        address       (1, "Change address"),
        phone         (2, "Change phone number"),
        insuType      (3, "Change insurance type"),
        coPay         (4, "Change copay amount"),
        patientType   (5, "Change patient type");

        private int optionCode;
        private String optionString;

        private menuUpdatePatientProf(int optionCode, String optionString) {
            this.optionCode = optionCode;
            this.optionString = optionString;
        }
        public int getOptionCode() {  return this.optionCode;  }
        public String getOptionString() {  return this.optionString;  }
        public String toString() {  return "("+this.getOptionCode()+") "+this.getOptionString()+": ";  }
    }
    
    // Menu Update MedCond
    // Update key MedCond attributes menu
    private static enum menuUpdateMedCond {
        mdContact      (6, "Change medical contact"),
        mdPhone        (7, "Change medical phone number"),
        illType        (8, "Change illness type"),
        algType        (9, "Change allergy type");

        private final int optionCode;
        private final String optionString;

        private menuUpdateMedCond(int optionCode, String optionString) {
            this.optionCode = optionCode;
            this.optionString = optionString;
        }
        public final int getOptionCode() {  return this.optionCode;  }
        public final String getOptionString() {  return this.optionString;  }
        public final String toString() {  return "("+this.getOptionCode()+") "+this.getOptionString()+": ";  }
    }

    // PatientProfInterface constructor
    public PatientProfInterface(String fileName) throws Exception {  this.db = new PatientProfDB(fileName); this.startSession();  }

    // Basic functions
    //      new scanner
    //      print new line
    public void setScanner() {  this.sn = new Scanner(System.in);  }
    public void newLine() {  System.out.println();  }

    // Display menu options
    //      Menu Main
    //      Menu Update PatientProf
    //      Menu Update MedCond
    public void displayMenuMain() {  this.newLine(); for(menuMain op : menuMain.values()) { System.out.println(op); } this.newLine();  }
    public void displayMenuUpdatePatientProf() {  this.newLine(); for(menuUpdatePatientProf op : menuUpdatePatientProf.values()) { System.out.println(op); }  }
    public void displayMenuUpdateMedCond() {  for(menuUpdateMedCond op : menuUpdateMedCond.values()) { System.out.println(op); }  }
    public void displayMenuEnd() {  System.out.println("("+backValOption+") "+"Back"+": "); this.newLine();  }

    // Error messages for appropriate use cases
    private void inputMismatchMessage() {  System.out.println("ERROR - Try again. Input TYPE was invalid.");  }
    private void illegalArgumentMessage() {  System.out.println("ERROR - Try again. Input VALUE was invalid.");  }
    private void miscExceptionMessage(Exception e) {  System.out.println("ERROR - "+"Unknown error" );  /*e.printStackTrace();*/ }
    
    // Common function
    //      Get adminID from user
    //      Get last name from user
    public String getAdminID(){
        System.out.println("Enter your adminID: ");
        return this.sn.nextLine().trim();
    }
    public String getLastName(){
        System.out.println("Enter patient's last name: ");
        return this.sn.nextLine().trim();
    }

    // Map menu main's optionCodes to parameter optionCode
    //      Run function based on user request
    public void mapMenuMainToMethod(int optionCode){
        if(optionCode == menuMain.createPatProf.getOptionCode())           { this.createNewPatientProf(); }
        else if(optionCode == menuMain.deletePatProf.getOptionCode())      { this.deletePatientProf(); }
        else if(optionCode == menuMain.displayPatProf.getOptionCode())     { this.displayPatientProf(); }
        else if(optionCode == menuMain.updatePatProf.getOptionCode())      { this.updatePatientProf();  }
        else if(optionCode == menuMain.displayAllPatProfs.getOptionCode()) { this.displayAllPatientProf(); }
        else if(optionCode == menuMain.commitAllPatProfs.getOptionCode())  { this.writeToDB(); }
        else if(optionCode == menuMain.fetchAllPatProfs.getOptionCode())   { this.initDB(); }
        else if(optionCode == menuMain.exit.getOptionCode())               { this.writeToDB(); }
        else { System.out.println("Incorrect code was entered. Please try again"); }
    }
    
    // Map Menu Update PatientProf to parameter optionCode
    //      Run and pass parameter p to appropriate function based on user request
    public boolean mapMenuUpdatePatientProfToMethod(PatientProf p, int optionCode) throws IllegalArgumentException {
        // Make sure PatientProf p isnt passed by value
        
        if(optionCode >= menuUpdatePatientProf.address.getOptionCode() && optionCode <= menuUpdatePatientProf.patientType.getOptionCode()) {
            if(optionCode == menuUpdatePatientProf.address.getOptionCode())           { this.changeAddress(p); }
            else if(optionCode == menuUpdatePatientProf.phone.getOptionCode())        { this.changePhone(p); }
            else if(optionCode == menuUpdatePatientProf.insuType.getOptionCode())     { this.changeInsuType(p); }
            else if(optionCode == menuUpdatePatientProf.coPay.getOptionCode())        { this.changeCoPay(p);  }
            else if(optionCode == menuUpdatePatientProf.patientType.getOptionCode())  { this.changePatientType(p); }
            return false;
        }
        return true;
    }
    // Change PatientProf p's address
    protected void changeAddress(PatientProf p) {
        System.out.println("Enter a address: ");
        this.setScanner();
        p.updateAddress(this.sn.nextLine().trim());
    }
    // Change PatientProf p's phone
    protected void changePhone(PatientProf p) {
        System.out.println("Enter a phone number: ");
        this.setScanner();
        p.updatePhone(this.sn.nextLine().trim());
    }
    // Change PatientProf p's insurance type
    protected void changeInsuType(PatientProf p) {
        System.out.println("Enter an insurance type: ");
        this.setScanner();
        while(true) {
            try{ p.updateInsuType(this.sn.nextLine().trim()); break; } 
            catch (IllegalArgumentException e){ this.illegalArgumentMessage(); }
        }
    }
    // Change PatientProf p's copay amount
    protected void changeCoPay(PatientProf p) {
        System.out.println("Enter a copay amount ");
        while(true) {
            try{ this.setScanner(); p.updateCoPay(this.sn.nextFloat()); this.sn.nextLine(); break; } 
            catch (InputMismatchException e){ this.sn.nextLine(); this.inputMismatchMessage(); } 
        }
    }
    // Change PatientProf p's patient type
    protected void changePatientType(PatientProf p) {
        System.out.println("Enter a patient type: ");
        this.setScanner();

        while(true) {
            try{ p.updatePatientType(this.sn.nextLine().trim()); break; } 
            catch (IllegalArgumentException e){  this.illegalArgumentMessage();  }
        }
    }


    // Map Menu Update MedCond to parameter optionCode
    //      Run and pass parameter p to appropriate function based on user request
    public boolean mapMenuUpdateMedCondToMethod(PatientProf p, int optionCode) throws IllegalArgumentException {
        // Make sure PatientProf p isnt passed by value
        if(optionCode >= menuUpdateMedCond.mdContact.getOptionCode() && optionCode <= menuUpdateMedCond.algType.getOptionCode()) {
            if(optionCode == menuUpdateMedCond.mdContact.getOptionCode())    { this.changeMdContact(p); }
            else if(optionCode == menuUpdateMedCond.mdPhone.getOptionCode()) { this.changeMdPhone(p); }
            else if(optionCode == menuUpdateMedCond.illType.getOptionCode()) { this.changeIllType(p); }
            else if(optionCode == menuUpdateMedCond.algType.getOptionCode()) { this.changeAlgType(p); }
            return false;
        }
        return true;
    }
    // Change PatientProf p's mdContact
    private void changeMdContact(PatientProf p) {
        System.out.println("Enter a medical contact: ");
        this.setScanner();
        
        p.getMedCondInfo().updatemdContact(this.sn.nextLine().trim());
    }
    // Change PatientProf p's mdPhone number
    private void changeMdPhone(PatientProf p) {
        System.out.println("Enter a medical contact phone number: ");
        this.setScanner();
        
        p.getMedCondInfo().updatemdPhone(this.sn.nextLine().trim());
    }
    // Change PatientProf p's illness type
    private void changeIllType(PatientProf p) {
        System.out.println("Enter an illness type: ");
        this.setScanner();

        while(true) {
            try{ p.getMedCondInfo().updateIllType(this.sn.nextLine().trim()); break; } 
            catch (IllegalArgumentException e){  this.illegalArgumentMessage();  }
        }
    }
    // Change PatientProf p's allergy type
    private void changeAlgType(PatientProf p) {
        System.out.println("Enter an allergy type: ");
        this.setScanner();

        while(true) {
            try{ p.getMedCondInfo().updateAlgType(this.sn.nextLine().trim()); break; } 
            catch (IllegalArgumentException e){  this.illegalArgumentMessage();  }
        }
    }

    // Map Menu End
    //      Either go back a menu
    //      Or user enters a new optionCode
    public boolean mapMenuEnd(int optionCode){
        // Make sure PatientProf p isnt passed by value
        switch(optionCode){
            case backValOption: return false;
            default:            System.out.println("Incorrect code was entered. Please try again");
        }
        return true;
    }

    // Change key PatientProf's attributes
    //          PatientProfs - to be changed attributes: address, phone, insurance type, patient type
    //          PatientProfs MedCond - to be changed attributes: medical name, medical phone, illness type, allergy type
    protected void changeKeyAttributes(PatientProf p) throws IllegalArgumentException {

        int optionCode;

        try{
            while(true){
                this.displayMenuUpdatePatientProf();
                this.displayMenuUpdateMedCond();
                this.displayMenuEnd();

                this.setScanner();
                optionCode = this.sn.nextInt();

                if(this.mapMenuUpdatePatientProfToMethod(p, optionCode)){ if(this.mapMenuUpdateMedCondToMethod(p, optionCode)){ if(!this.mapMenuEnd(optionCode)){
                            break;
                } } }
            }
        }catch (IllegalArgumentException e){  this.illegalArgumentMessage();
        }catch (InputMismatchException e){  this.inputMismatchMessage();
        }catch(Exception e){  this.miscExceptionMessage(e);
        }
    }

    // Delete a PatientProf if one exists and matching adminID and last name is provided
    protected void deletePatientProf(){
        try{
            this.setScanner();

            String adminID = this.getAdminID();
            String lastName = this.getLastName();

            if(this.db.deleteProfile(adminID, lastName)) {  System.out.println("SUCCESS - Deleted "+lastName+"'s patient profile");  }
            else {  System.out.println("FAILED - Unable to delete "+lastName+"'s patient profile");  }
        }catch(InputMismatchException e){  this.inputMismatchMessage();
        }catch(Exception e){  System.out.println("ERROR - Unable to delete Patient Profile");
        }
    }   
    // Find a PatientProf if one exists and matching adminID and last name is provided
    protected PatientProf findPatientProf(){
        try{
            this.setScanner();
            String adminID = this.getAdminID();
            String lastName = this.getLastName();

            PatientProf p = this.db.findProfile(adminID, lastName);

            if(p != null) {  this.displayPatientProf(p); return p;
            } else {  System.out.println("FAILED - Unable to locate "+lastName+"'s patient profile");  }
        }catch(NullPointerException npe){  System.out.println("SUCCESS - No profiles found, but no errors either");
        }catch(IOException e){  System.out.println("ERROR - I/O Error");
        }catch(Exception e){  this.miscExceptionMessage(e);
        } return null;
    }
    // Update a PatientProf if one exists and matching adminID and last name is provided
    //         Refer to function changeKeyAttributes for more information on changable attributes
    protected void updatePatientProf(){
        try{
            PatientProf patient = this.findPatientProf();

            if(patient != null) { this.changeKeyAttributes(patient); }
        }catch(Exception e){  this.miscExceptionMessage(e);
        }
    }
    
    // Display PatientProf's contents if profile exists
    protected void displayPatientProf() {
        PatientProf p = this.findPatientProf();
        if(p != null) {  this.displayPatientProf(p);  }
    }
    // Display PatientProf's contents of parameter patient
    protected void displayPatientProf(PatientProf patient){
        System.out.println("\n˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅ ˅\n");
        System.out.println("AdminID:               "+patient.getadminID());
        System.out.println("Name:                  "+patient.getFirstName()+" "+patient.getLastName());
        System.out.println("Address:               "+patient.getAddress());
        System.out.println("Phone:                 "+patient.getPhone());
        System.out.println("Copay:                 "+patient.getCoPay());
        System.out.println("Insurance Type:        "+patient.getInsuType());
        System.out.println("Patient Type:          "+patient.getPatientType());
        this.displayMedCond(patient.getMedCondInfo());
        System.out.println("\n^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^\n");
    }
    // Display PatientProf's MedCond contents of parameter mc
    protected void displayMedCond(MedCond mc){
        System.out.println("Medical Contact:       "+mc.getmdContact());
        System.out.println("Medical Contact Phone: "+mc.getmdPhone());
        System.out.println("Allergy Type:          "+mc.getAlgType());
        System.out.println("Illness Type:          "+mc.getIllType());
    }
    // Display all PatientProf's created by an admin with his/her adminID
    protected void displayAllPatientProf(){
        try{
            this.setScanner();

            String adminID = this.getAdminID();

            PatientProf[] ptemp = this.db.findProfiles(adminID);
            if(ptemp.length == 0) {  System.out.println("SUCCESS - No profiles created by "+adminID+"");  }
            for(PatientProf p : this.db.findProfiles(adminID)){  this.displayPatientProf(p);  }
        }catch(NullPointerException npe){  System.out.println("SUCCESS - No profiles found, but no errors either");
        }catch(IOException e){  System.out.println("ERROR - I/O Error");
        }catch(Exception e){  this.miscExceptionMessage(e);
        }
    }

    // Write all profiles in memory to database
    protected void writeToDB(){
        try{  this.db.writeAllPatientProf(); System.out.println("SUCCESS - written to database file");  }
        catch(Exception e){  System.out.println("ERROR - unable to write to database file");  }
    }
    // Read all profiles into an array/memory from database
    protected void initDB(){
        try{  this.db.initializeDatabase(); System.out.println("SUCCESS - retrieved from database file");  }
        catch(Exception e){  System.out.println("ERROR - unable to open file");  }
    }

    // Create a new PatientProf object and add to database
    protected void createNewPatientProf(){
        MedCond mc = new MedCond("", "", "none", "none");
        PatientProf p = new PatientProf("", "", "", "", "", 0, "Private", "Adult", mc);
        this.createNewPatientProf(p);
        if(p != null){
            if(this.db.insertNewProfile(p)) {  System.out.println("SUCCESS - Patient profile created");  } 
            else { System.out.println("ERROR - Unable to create Patient Profile"); System.out.println("ERROR - (AdminID, lastName) pair MAY already exist"); }
        }
        p = null;
    }
    // Create a new PatientProf object and add to database
    //      User input is required
    protected void createNewPatientProf(PatientProf p){
        try{
            this.setScanner();

            while(true) { try{ p.updateadminID(this.getAdminID()); break; }catch(IllegalArgumentException e){ this.illegalArgumentMessage(); } }
            
            while(true) { try{
                System.out.println("Enter First name: ");
                p.updateFirstName(this.sn.nextLine().trim());
                break;
            }catch(IllegalArgumentException e){ this.illegalArgumentMessage(); } }

            p.updateLastName(this.getLastName());

            while(true) { try{
                System.out.println("Enter an Address: ");
                p.updateAddress(this.sn.nextLine().trim());
                break;
           }catch(IllegalArgumentException e){ this.illegalArgumentMessage(); } }

            this.changePhone(p);

            this.changeCoPay(p);

            this.changeInsuType(p);

            this.changePatientType(p);

            this.createNewMedCond(p);
            
        }catch(IllegalArgumentException e){  this.illegalArgumentMessage();
        }catch(InputMismatchException e){  this.inputMismatchMessage();
        }catch(Exception e){  this.miscExceptionMessage(e);
        }
    }
    // Create a new MedCond Object
    //      User input is required
    protected void createNewMedCond(PatientProf p){

        try{
            this.setScanner();

            System.out.println("Medical Contact: ");
            String c = this.sn.nextLine().trim();

            System.out.println("Medical Contact Phone: ");
            String ph = this.sn.nextLine().trim();

            String a, i;
            System.out.println("Allergy Type: ");
            while(true) { try{
                a = this.sn.nextLine().trim();
                p.getMedCondInfo().updateAlgType(a);
                break;
           }catch(IllegalArgumentException e){ this.illegalArgumentMessage(); } }
           System.out.println("Illness Type: ");
           while(true) { try{
                i = this.sn.nextLine().trim();
                p.getMedCondInfo().updateIllType(i);
                break;
           }catch(IllegalArgumentException e){ this.illegalArgumentMessage(); } }
            
            p.updateMedCondInfo(new MedCond(c, ph, a, i));

            //return new MedCond(mdContact, mdPhone, algType, illType);
        }catch(IllegalArgumentException e){  this.illegalArgumentMessage();
        }catch(InputMismatchException e){  this.inputMismatchMessage();
        }catch(Exception e){  this.miscExceptionMessage(e);
        }
    }

    // Menu function running from start to end of application (until closed)
    // In charge of running Menu option functions
    protected void getUserChoice(){
        int userSelection = 0;
        System.out.println("\n********    Welcome to the IPS    ********\n");

        do{
            this.displayMenuMain();

            try{
                this.setScanner();
                System.out.println("Enter an option: ");
                userSelection = this.sn.nextInt(); this.sn.nextLine();

                this.mapMenuMainToMethod(userSelection);
            }catch(InputMismatchException e){  this.inputMismatchMessage();
            }catch(Exception e){  this.miscExceptionMessage(e);
            }
        }while(userSelection != menuMain.exit.getOptionCode());

        System.out.println("\n********         Goodbye          ********\n");
        System.exit(0);

        if(this.sn != null) {  this.sn.close();  }
    }
    // public identifier for getUserChoice()
    public void startSession(){ this.getUserChoice(); }
}
