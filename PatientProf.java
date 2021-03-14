// Patient Profile class: used to record various patient information, contains medcond class


/*public abstract PatientProfAbstract(){
  // To be implemented
}*/

public class PatientProf{
    // arguments vvvvvvvvvvvv
    String adminID;
    String firstName;
    String lastName;
    String address;
    String phone;
    float coPay;
    String insuType;
    String patientType;
    MedCond medCondInfo;
    //arguments ^^^^^^^^^^^^^^^^
    
    //Constructor vvvvvvvvvvvvv
    public PatientProf() {
        adminID = "String";
        firstName = "String";
        lastName = "String";
        address = "String";
        phone = "String";
        coPay = 0;
        insuType = "String";
        patientType = "String";
        medCondInfo = new MedCond();
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
            insuType = n;
        }
        public void updatePatientType(String n){
            patientType = n;
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
            PatientProf test = new PatientProf();
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
            MedCond anotherone = new MedCond();
            anotherone.updateAlgType("Penniciline");
            anotherone.updateIllType("None");
            anotherone.updatemdContact("Dr.Doctorson");
            anotherone.updatemdPhone("5558763333");
            test.updateMedCondInfo(anotherone);
            test.updateFirstName("Billy");
            test.updateLastName("Bob");
            test.updatePatientType("Paying");
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
