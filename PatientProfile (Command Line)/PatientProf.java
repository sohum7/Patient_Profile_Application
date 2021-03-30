// Patient Profile class: used to record various patient information, contains medcond class

import java.io.Serializable;
public class PatientProf implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // arguments vvvvvvvvvvvv
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float coPay;
    private String insuType;
    private String patientType;
    private MedCond medCondInfo = new MedCond("", "", "none", "none");
    //arguments ^^^^^^^^^^^^^^^^

    //Constructor vvvvvvvvvvvvv
    public PatientProf(String Adminid, String Firstname, String Lastname, String Address, String Phone, float Copay, String Insutype, String Patienttype, MedCond mdcnd) throws IllegalArgumentException {
        this.updateadminID(Adminid);
        this.updateFirstName(Firstname);
        this.updateLastName(Lastname);
        this.updateAddress(Address);
        this.updatePhone(Phone);
        this.updateCoPay(Copay);
        this.updateInsuType(Insutype);
        this.updatePatientType(Patienttype);
        this.updateMedCondInfo(mdcnd);
    }
    public PatientProf(PatientProf p) throws IllegalArgumentException {
        this.updateadminID(p.getadminID());
        this.updateFirstName(p.getFirstName());
        this.updateLastName(p.getLastName());
        this.updateAddress(p.getAddress());
        this.updatePhone(p.getPhone());
        this.updateCoPay(p.getCoPay());
        this.updateInsuType(p.getInsuType());
        this.updatePatientType(p.getPatientType());
        this.updateMedCondInfo(p.getMedCondInfo());
    }

    //Constructor ^^^^^^^^^^^^^^^^^^^

    //get methods, they print and return their respective values vvvvvvvvvvvvv
    public String getadminID(){
        return this.adminID;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getInsuType(){
        return this.insuType;
    }
    public String getPatientType(){
        return this.patientType;
    }
    public MedCond getMedCondInfo(){
        return this.medCondInfo;
    }
    public float getCoPay(){
        return this.coPay;
    }
    //get methods ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    //update methods, they update their respective values to what is inputed into them vvvvvvvvvvvvvvvvvvvvvv
    public void updateadminID(String n){
        this.adminID = n;
    }
    public void updateFirstName(String n){
        this.firstName = n;
    }
    public void updateLastName(String n){
        this.lastName = n;
    }
    public void updateAddress(String n){
        this.address = n;
    }
    public void updatePhone(String n){
        this.phone = n;
    }
    private boolean checkInsuType(String Insutype) {
        if(Insutype.equalsIgnoreCase("Private") || Insutype.equalsIgnoreCase("Government")) { return true; }
        return false;
    }
    private boolean checkPatientType(String Patienttype) {
        if(Patienttype.equalsIgnoreCase("Senior") || Patienttype.equalsIgnoreCase("Pediatric") || Patienttype.equalsIgnoreCase("Adult")) { return true; }
        return false;
    }
    public void updateInsuType(String n) throws IllegalArgumentException { 
        if(this.checkInsuType(n)) { this.insuType = n; }
        else { throw new IllegalArgumentException(); }
    }
    public void updatePatientType(String n) throws IllegalArgumentException {
        if(this.checkPatientType(n)) { this.patientType = n; }
        else { throw new IllegalArgumentException(); }
    }
    public void updateMedCondInfo(MedCond n){
        this.medCondInfo.updatemdContact(n.getmdContact());
        this.medCondInfo.updatemdPhone(n.getmdPhone());
        this.medCondInfo.updateAlgType(n.getAlgType());
        this.medCondInfo.updateIllType(n.getIllType());
    }
    public void updateCoPay(float n){
        this.coPay = n >= 0F ? n : 0F;
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
