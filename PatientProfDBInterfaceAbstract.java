//test

public class MedCond{
    String mdContact;
    String mdPhone;
    String algType;
    String illType;
    public MedCond(){
        self.mdContact = "String";
        self.mdPhone = "String";
        self.algType = "String";
        self.illType = "String";
    }
    public static String getmdContact(){
        System.out.println(self.mdContact);
        return self.mdContact;
    }
    public static String getmdPhone(){
        System.out.println(self.mdPhone);
        return self.mdPhone;
    }
    public static String getAlgType(){
        System.out.println(self.algType);
        return self.algType;
    }
    public static String getIllType(){
        System.out.println(self.illType);
        return self.illType;
    }

    public static void updatemdContact(String n){
        self.mdContact = n;
    }
    public static void updatemdPhone(String n){
        self.mdPhone = n;
    }
    public static void updateAlgType(String n){
        self.algType = n;
    }
    public static void updateIllType(String n){
        self.illType = n;
    }
}

public class PatientProf(){
    /*
    Name
    address
    phone number
    patient catagory
    insurance information
    */
    String adminID;
    String firstName;
    String lastName;
    String address;
    String phone;
    float coPay;
    String insuType;
    String patientType;
    MedCond medCondInfo;

    public PatientProf(){
        self.adminID = "String";
        self.firstName = "String";
        self.lastName = "String";
        self.address = "String";
        self.phone = "String";
        self.coPay = 0.0;
        self.insuType = "String";
        self.patientType = "String";
        self.medCondInfo = new MedCond();
    }

    public static String getadminID(){
        System.out.println(self.adminID);
        return self.adminID;
    }
    public static String getFirstName(){
        System.out.println(self.firstName);
        return self.firstName;
    }
    public static String getLastName(){
        System.out.println(self.lastName);
        return self.lastName;
    }
    public static String getAddress(){
        System.out.println(self.address);
        return self.address;
    }
    public static String getPhone(){
        System.out.println(self.phone);
        return self.phone;
    }
    public static String getInsuType(){
        System.out.println(self.insuType);
        return self.insuType;
    }
    public static String getPatientType(){
        System.out.println(self.patientType);
        return self.patientType;
    }
    public static String getMedCondInfo(){
        System.out.println(self.medCondInfo);
        return self.medCondInfo;
    }
    public static float getCoPay(){
        System.out.println(self.coPay);
        return self.coPay;
    }

    public static void updateadminID(String n){
        self.adminID = n
    }
    public static void updateFirstName(String n){
        self.firstName = n
    }
    public static void updateLastName(String n){
        self.lastName = n
    }
    public static void updateAddress(String n){
        self.address = n
    }
    public static void updatePhone(String n){
        self.phone = n
    }
    public static void updateInsuType(String n){
        self.insuType = n
    }
    public static void updatePatientType(String n){
        self.patientType = n
    }
    public static void updateMedCondInfo(MedCond n){
        self.medCondInfo = n
    }
    public static void updateCoPay(float n){
        self.coPay = n
    }

}

public abstract PatientProfDBInterfaceAbstract(){
  
}

public PatientProfDBInterface(){
  
}


