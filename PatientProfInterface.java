import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

////  Patient Profile Interface for admin users
//      Interface will allow admin users (doctors, nurses, etc) to access profile data
public abstract class PatientProfInterfaceAbstract {
    //public abstract PatientProfInterfaceAbstract(String fileName);
    public abstract void getUserChoice();
    public abstract void deletePatientProf();
    public abstract void findPatientProf();
    public abstract void updatePatientProf();
    public abstract void displayPatientProf();
    public abstract void displayAllPatientProf();
    public abstract void writeToDB();
    public abstract void initDB();
    public abstract PatientProf createNewPatientProf();
    public abstract MedCond createNewMedCond();
}

public class PatientProfInterface extends PatientProfInterfaceAbstract{

    private PatientProfDB db = null;
    private final int backValOption = -1;

    private enum menuMain {
        createPatProf       (1, "Enter a new patient profile:"),
        deletePatProf       (2, "Delete a patient profile by last name and adminID"),
        displayPatProf      (3, "Display patient profile by last name and adminID"),
        updatePatProf       (4, "Update patient profile"),
        displayAllPatProfs  (5, "Display all profiles by adminID"),
        commitAllPatProfs   (6, "Save all patient profiles"),
        fetchAllPatProfs    (7, "Retrieve all patient profiles"),
        exit                (0, "Exit");

        private final int optionCode;
        private final String optionString;

        menuMain(int optionCode, String optionString) {
            this.optionCode = optionCode;
            this.optionString = optionString;
        }
        public int getOptionCode() {  return this.optionCode;  }
        public String getOptionString() {  return this.optionString;  }
        public String toString() {  System.out.println("("+this.getOptionCode()+") "+this.getOptionString());  }
    }
    private enum menuUpdatePatientProf {
        address       (1, ),
        phone         (2, ),
        insuType      (3, ),
        coPay         (4, ),
        patientType   (5, );

        private final int optionCode;
        private final String optionString;

        menuUpdatePatientProf(int optionCode, String optionString) {
            this.optionCode = optionCode;
            this.optionString = optionString;
        }
        public int getOptionCode() {  return this.optionCode;  }
        public String getOptionString() {  return this.optionString;  }
        public String toString() {  System.out.println("("+this.getOptionCode()+") "+this.getOptionString());  }
    }
    private enum menuUpdateMedCond {
        mdContact      (6, ),
        mdPhone        (7, ),
        illType        (8, ),
        algType        (9, );

        private final int optionCode;
        private final String optionString;

        menuUpdateMedCond(int optionCode, String optionString) {
            this.optionCode = optionCode;
            this.optionString = optionString;
        }
        public int getOptionCode() {  return this.optionCode;  }
        public String getOptionString() {  return this.optionString;  }
        public String toString() {  System.out.println("("+this.getOptionCode()+") "+this.getOptionString());  }
    }

    public PatientProfInterface(String fileName) throws Exception {
        this.db = new PatientProfDB(fileName);
    }

    private void displayMenuMain() {  for(menuMain op : menuMain.values()) { op.toString(); }  }
    private void displayMenuUpdatePatientProf() {  for(menuUpdatePatientProf op : menuUpdatePatientProf.values()) { op.toString(); }  }
    private void displayMenuUpdateMedCond() {  for(menuUpdateMedCond op : menuUpdateMedCond.values()) { op.toString(); }  }
    private void enterMenuOptionCode() {  System.out.println("Enter a option: ");  }

    private void mapMenuMainToMethod(int optionCode){
        switch(optionCode){
            case menuMain.createPatProf.getOptionCode():      this.createNewPatientProf();  break;
            case menuMain.deletePatProf.getOptionCode():      this.deletePatientProf();     break;
            case menuMain.displayPatProf.getOptionCode():     this.displayPatientProf();    break;
            case menuMain.updatePatProf.getOptionCode():      this.updatePatientProf();     break;
            case menuMain.displayAllPatProfs.getOptionCode(): this.displayAllPatientProf(); break;
            case menuMain.commitAllPatProfs.getOptionCode():  this.writeToDB();             break;
            case menuMain.fetchAllPatProfs.getOptionCode():   this.initDB();                break;
            case menuMain.exit.getOptionCode():                                             break;
            default:                                      System.out.println("Incorrect code was entered. Please try again"); break;
        }
    }
    private boolean mapMenuUpdatePatientProfToMethod(PatientProf p, int optionCode){

        // Make sure PatientProf p isnt passed by value

        switch(optionCode){
            case menuUpdatePatientProf.address.getOptionCode():     this.changeAddress();     return false; break;
            case menuUpdatePatientProf.phone.getOptionCode():       this.changePhone();       return false; break;
            case menuUpdatePatientProf.insuType.getOptionCode():    this.changeInsuType();    return false; break;
            case menuUpdatePatientProf.coPay.getOptionCode():       this.changeCoPay();       return false; break;
            case menuUpdatePatientProf.patientType.getOptionCode(): this.changePatientType(); return false; break;
        }
        return true;
    }
    private void changeAddress() {
    }
    private void changePhone() {
    }
    private void changeInsuType() {
    }
    private void changeCoPay() {
    }
    private void changePatientType() {
    }

    private boolean mapMenuUpdateMedCondToMethod(PatientProf p, int optionCode){

        // Make sure PatientProf p isnt passed by value

        switch(optionCode){
            case menuUpdateMedCond.mdContact.getOptionCode(): this.changeMdContact(); return false; break;
            case menuUpdateMedCond.mdPhone.getOptionCode():   this.changeMdPhone();   return false; break;
            case menuUpdateMedCond.illType.getOptionCode():   this.changeIllType();   return false; break;
            case menuUpdateMedCond.algType.getOptionCode():   this.changeAlgType();   return false; break;
            }
        return true;
    }
    private void changeMdContact() {
    }
    private void changeMdPhone() {
    }
    private void changeIllType() {
    }
    private void changeAlgType() {
    }

    private boolean mapMenuEnd(int optionCode){

        // Make sure PatientProf p isnt passed by value

        switch(optionCode){
            case backValOption: return false;
            default:            System.out.println("Incorrect code was entered. Please try again");
        }
        return true;
    }

    public void changeKeyAtttributes(PatientProf p){
        int optionCode;
        whilFfe(true){


            if(this.mapMenuUpdatePatientProfToMethod(p, optionCode)){
                if(this.mapMenuUpdateMedCondToMethod(p, optionCode)){
                    if(!this.mapMenuEnd(optionCode)){
                        break;
                    }
                }
            }


        }




    }
    

    private Scanner inputScanner() {  return new Scanner(System.in);  }

    public void getUserChoice(){
        
        Scanner sn = null;
        int userSelection = 0;
        do{
            this.displayMenuMain();

            try{
                this.enterMenuOptionCode();
                if(sn == null) {  sn = inputScanner();  }

                userSelection = sn.nextInt();
                sn.close();

                this.mapMenuOptionsToMethod(userSelection);
            }catch(InputMismatchException e){
                sn.close();
                System.out.println("Please check your input");

                //while(sn.hasNextLine()) {  sn.nextLine();  }
                //while(sn.hasNext()){ sn.next(); }
            }catch(IOException e){
                System.out.println("I/O Error");
            }catch(Exception e){
                System.out.println("Error" + e);
            }
        }while(userSelection != menuMain.exit.getOptionCode());

        if(sn != null) {  sn.close();  }
    }

    public void getUserChoicePatientProf(){

        Scanner sn = null;
        int userSelection = 0;

    }

    public void deletePatientProf(){

        Scanner sn = null;
        try{
            if(sn == null) {  sn = inputScanner();  }
            System.out.println("Enter your adminID: ");
            String adminID = sn.nextLine();
            System.out.println("Enter patient's last name: ");
            String name = sn.nextLine();
            String adminID = sn.nextLine();

            //db function
            if(this.db.deleteProfile(adminID, name)) {  System.out.println("SUCCESS - Deleted "+name+"'s patient profile");  }
            else {  System.out.println("FAILED - Unable to delete "+name+"'s patient profile");  }
        }catch(InputMismatchException e){
            sn.close();
            System.out.println("Please check your input");

            //while(sn.hasNextLine()) {  sn.nextLine();  }
            //while(sn.hasNext()){ sn.next(); }
        }catch(IOException e){
            System.out.println("ERROR - I/O Error");
        }catch(Exception e){
            System.out.println("ERROR - Unable to delete Patient Profile");
        }

        if(sn != null) {  sn.close();  }
    }
    
    public void findPatientProf(){

        Scanner sn = null;
        try{
            if(sn == null) {  sn = inputScanner();  }
            System.out.println("Enter your adminID: ");
            String adminID = sn.nextLine();
            System.out.println("Enter patient's last name: ");
            String name = sn.nextLine();

            if(this.db.findProfile(adminID, name) != null) {  System.out.println("SUCCESS - "+name+"'s patient profile found successfully");  }
            else {  System.out.println("FAILED - Unable to locate "+name+"'s patient profile");  }
        }catch(IOException e){
            System.out.println("ERROR - I/O Error");
        }catch(Exception e){
            System.out.println("ERROR - Patient Profile does not exist or incorrect");
        }

        if(sn != null) {  sn.close();  }
    }

    public void updatePatientProf(){

        Scanner sn = null;

        try{
            if(sn == null) {  sn = inputScanner();  }
            System.out.println("Enter your adminID: ");
            String adminID = sn.nextLine();
            System.out.println("Enter patient's last name: ");
            String name = sn.nextLine();
            PatientProf patient = this.db.findProfile(adminID, name);
            int patientProfIndex = this.db.getCurrentProfIndex();

            

            if(patient != null && patientProfIndex != -1) {  System.out.println("SUCCESS - "+name+"'s patient profile found successfully"); this.displayPatientProf(patient); }
            else {  System.out.println("FAILED - Unable to locate "+name+"'s patient profile");  }
        }catch(IOException e){
            System.out.println("ERROR - I/O Error");
        }catch(Exception e){
            System.out.println("ERROR - Patient Profile does not exist or incorrect AdminID");
        }

        if(sn != null) {  sn.close();  }
    }

    public void displayPatientProf(PatientProf patient){
        System.out.println("AdminID:               "+patient.getadminID());
        System.out.println("Name:                  "+patient.getFirstName()+" "+patient.getLastName());
        System.out.println("Address:               "+patient.getAddress());
        System.out.println("Phone:                 "+patient.getadminID());
        System.out.println("Copay:                 "+patient.getCoPay());
        System.out.println("Insurance Type:        "+patient.getInsuType());
        System.out.println("Patient Type:          "+patient.getPatientType());
        this.displayMedCond(patient.getMedCondInfo());
    }
    private void displayMedCond(MedCond mc){
        System.out.println("Medical Contact:       "+mc.getmdContact());
        System.out.println("Medical Contact Phone: "+mc.getmdPhone());
        System.out.println("Allergy Type:          "+mc.getAlgType());
        System.out.println("Illness Type:          "+mc.getIllType());
    }
    public void displayAllPatientProf(){

        Scanner sn = null;

        try{
            System.out.println("AdminID: ");
            String adminID = sn.nextLine();

            for(PatientProf p : this.db.findProfiles(adminID)){  this.displayPatientProf(p);  }
        }catch(IOException e){
            System.out.println("Error - I/O Error");
        }catch(Exception e){
            System.out.println("Error - Patient Profile does not exist");
        }

    }

    public void writeToDB(){
        try{
            this.db.writeAllPatientProf();
        }catch(Exception e){
            System.out.println("Error - something is wrong");
        }
    }

    public void initDB(){
        try{
            this.db.initializeDatabase();
        }catch(Exception e){
            System.out.println("Error - something is wrong");
        }
    }

    public PatientProf createNewPatientProf(){

        Scanner sn = null;

        try{
            sn = inputScanner();

            System.out.println("AdminID: ");
            String adminID = sn.nextLine();
            System.out.println("First name: ");
            String firstName = sn.nextLine();
            System.out.println("Last name: ");
            String lastName = sn.nextLine();
            System.out.println("Address: ");
            String address = sn.nextLine();
            System.out.println("Phone: ");
            String phone = sn.nextLine();
            System.out.println("Copay: ");
            float coPay = sn.nextFloat();
            System.out.println("Insurance Type: ");
            String insuType = sn.nextLine();
            System.out.println("Patient Type: ");
            String patientType = sn.nextLine();
            MedCond mc = createNewMedCond();

            if(mc == null) {  throw new Exception();  }

            return new PatientProf(adminID, firstName, lastName, address, phone, coPay, insuType, patientType, mc);

        }catch(IOException e){
            System.out.println("Error - I/O Error");
        }catch(Exception e){
            System.out.println("Error - Please check your input");
        }

        if(sn != null) {  sn.close();  }

        return null;
    }

    public MedCond createNewMedCond(){

        Scanner sn = null;

        try{

            sn = inputScanner();
            System.out.println("Medical Contact: ");
            String mdContact = sn.nextLine();
            System.out.println("Medical Contact Phone: ");
            String mdPhone = sn.nextLine();
            System.out.println("Allergy Type: ");
            String algType = sn.nextLine();
            System.out.println("Illness Type: ");
            String illType = sn.nextLine();

            return new MedCond(mdContact, mdPhone, algType, illType);

        }catch(IOException e){
            System.out.println("Error - I/O Error");
        }catch(Exception e){
            System.out.println("Error - Please check your input");
        }

        if(sn != null) {  sn.close();  }

        return null;
    }

}