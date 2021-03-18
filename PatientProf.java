// Patient Profile class: used to record various patient information, contains medcond class


/*public abstract PatientProfAbstract(){
  // To be implemented
}*/

import java.io.Serializable; public class PatientProf implements Serializable{
    // arguments vvvvvvvvvvvv
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float coPay;
    private String insuType;
    private String patientType;
    private MedCond medCondInfo;
    //arguments ^^^^^^^^^^^^^^^^

    //Constructor vvvvvvvvvvvvv
    public PatientProf(String Adminid, String Firstname, String Lastname, String Address, String Phone, float Copay, String Insutype, String Patienttype, MedCond mdcnd) {
        adminID = Adminid;
        firstName = Firstname;
        lastName = Lastname;
        address = Address;
        phone = Phone;
        coPay = Copay;
        int t = 1;
        try{
            if(Insutype == "Private" || Insutype == "Government"){
                insuType = Insutype;
            }
            else{
                t = t / 0;}
            }catch(Exception e){
                System.out.println("ERROR: Insurance Type must be either \"Private\" or \"Government\", SET TO null.");
            }


        try{
            if(Patienttype == "Senior" || Patienttype == "Pediatric" || Patienttype == "Adult"){
                patientType = Patienttype;
            }
            else{
                t = t / 0;}
            }catch(Exception e){
                System.out.println("ERROR: Patient Type must be \"Senior\", \"Pediatric\", or \"Adult\", SET TO null.");
            }


        medCondInfo = mdcnd;
    }
    //Constructor ^^^^^^^^^^^^^^^^^^^

    //get methods, they print and return their respective values vvvvvvvvvvvvv
    public String getadminID(){
        System.out.println(adminID);
        return adminID;
    }
    public String getFirstName(){
        System.out.println(firstName);
        return firstName;
    }
    public String getLastName(){
        System.out.println(lastName);
        return lastName;
    }
    public String getAddress(){
        System.out.println(address);
        return address;
    }
    public String getPhone(){
        System.out.println(phone);
        return phone;
    }
    public String getInsuType(){
        System.out.println(insuType);
        return insuType;
    }
    public String getPatientType(){
        System.out.println(patientType);
        return patientType;
    }
    public void getMedCondInfo(){
        medCondInfo.getAlgType();
        medCondInfo.getmdContact();
        medCondInfo.getmdPhone();
        medCondInfo.getIllType();
    }
    public float getCoPay(){
        System.out.println(coPay);
        return coPay;
    }
    //get methods ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    //update methods, they update their respective values to what is inputed into them vvvvvvvvvvvvvvvvvvvvvv
    public void updateadminID(String n){
        adminID = n;
    }
    public void updateFirstName(String n){
        firstName = n;
    }
    public void updateLastName(String n){
        lastName = n;
    }
    public void updateAddress(String n){
        address = n;
    }
    public void updatePhone(String n){
        phone = n;
    }
    public void updateInsuType(String n){
        int t = 1;
        try{
            if(n == "Private" || n == "Government"){
                insuType = n;
            }
            else{
                t = t / 0;}
            }catch(Exception e){
                System.out.println("ERROR: Insurance Type must be either \"Private\" or \"Government\", NOT UPDATED.");
            }

        }


    public void updatePatientType(String n){
        int t = 1;
        try{
            if(n == "Senior" || n == "Pediatric" || n == "Adult"){
                patientType = n;
            }
            else{
                t = t / 0;}
            }catch(Exception e){
                System.out.println("ERROR: Patient Type must be \"Senior\", \"Pediatric\", or \"Adult\", NOT UPDATED.");
            }


    }
    public void updateMedCondInfo(MedCond n){
        medCondInfo = n;
    }
    public void updateCoPay(float n){
        coPay = n;
    }
    // update methods ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


    //test main function:
        /*public static void main(String[] args){
            MedCond innertest = new MedCond("Dr.Winslow", "8884445555", "none", "none");
            PatientProf test = new PatientProf("tyl100", "Pablo", "Digman", "123 Four Street", "8881112223", 20, "Government", "This Guy", innertest);
            test.getAddress();
            test.getadminID();
            test.getMedCondInfo();
            test.getFirstName();
            test.getLastName();
            test.getPatientType();
            test.getPhone();
            test.getInsuType();
            test.getCoPay();

            test.updateAddress("444 Location Drive");
            test.updateadminID("Admin Cordiroy");
            MedCond anotherone = new MedCond("Dr.Peterson", "134567222", "other", "other");
            anotherone.updateAlgType("Penniciline");
            anotherone.updateIllType("None");
            anotherone.updatemdContact("Dr.Doctorson");
            anotherone.updatemdPhone("5558763333");
            test.updateMedCondInfo(anotherone);
            test.updateFirstName("Billy");
            test.updateLastName("Bob");
            test.updatePatientType("adult");
            test.updatePhone("1234567");
            test.updateInsuType("FULL");
            test.updateCoPay(500);
            System.out.println("Changaronies:");
            test.getAddress();
            test.getadminID();
            test.getMedCondInfo();
            test.getFirstName();
            test.getLastName();
            test.getPatientType();
            test.getPhone();
            test.getInsuType();
            test.getCoPay();
        }*/
}
