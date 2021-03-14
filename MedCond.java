// medcond is a class that is used as an argument of the PatientProf class, containing information such as medical contact info and so on

public class MedCond{
    // arguments  vvvvv
    String mdContact;
    String mdPhone;
    String algType;
    String illType;
    // arguments ^^^^^
    
    //constructor vvvv
    public MedCond(){
        mdContact = "String";
        mdPhone = "String";
        algType = "String";
        illType = "String";
    }
    //constructor ^^^^^^^
    
    //get methods, they print the info required, and return them vvvvvvvvvvvvvv
    public String getmdContact(){
        System.out.println(mdContact);
        return mdContact;
    }
    public String getmdPhone(){
        System.out.println(mdPhone);
        return mdPhone;
    }
    public String getAlgType(){
        System.out.println(algType);
        return algType;
    }
    public String getIllType(){
        System.out.println(illType);
        return illType;
    }
    //get methods, they print the info required, and return them ^^^^^^^^^^^^^
    
    //update methods, they update their respective arguments vvvvvvvvvvvvvvvvv
    public void updatemdContact(String n){
        mdContact = n;
    }
    public void updatemdPhone(String n){
        mdPhone = n;
    }
    public void updateAlgType(String n){
        algType = n;
    }
    public void updateIllType(String n){
        illType = n;
    }
    //update methods, they update their respective arguments  ^^^^^^^^^^^^^^^^^^^^^
    
    
    //test main function
    /*public static void main(String[] args){
        MedCond test = new MedCond();
        test.getAlgType();
        test.getmdContact();
        test.getmdPhone();
        test.getIllType();
        test.updateAlgType("Penniciline");
        test.updateIllType("None");
        test.updatemdContact("Dr.Doctorson");
        test.updatemdPhone("5558763333");
        test.getAlgType();
        test.getmdContact();
        test.getmdPhone();
        test.getIllType();
    }*/
}
