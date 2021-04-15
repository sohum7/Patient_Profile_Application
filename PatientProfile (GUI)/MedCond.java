// medcond is a class that is used as an argument of the PatientProf class, containing information such as medical contact info and so on
import java.io.Serializable;
public class MedCond implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4361645060520838501L;
    // arguments  vvvvv
    private String mdContact;
    private String mdPhone;
    private String algType;
    private String illType;

    private static String[] algTypes = { "none", "CHD", "diabetes", "asthma", "other" };
    private static String[] illTypes = { "none", "food", "medication", "other" };
    // arguments ^^^^^

    //constructor vvvv
    public MedCond(String MDcontact, String MDphone, String Algtype, String Illtype) throws IllegalArgumentException {
        this.updatemdContact(MDcontact);
        this.updatemdPhone(MDphone);
        this.updateAlgType(Algtype);
        this.updateIllType(Illtype);
        }

    //constructor ^^^^^^^

    //other get methods
    public static String[] getAlgTypes(){
        return algTypes;
    }
    public static String[] getIllTypes(){
        return illTypes;
    }

    //get methods, they print the info required, and return them vvvvvvvvvvvvvv
    public String getmdContact(){
        return this.mdContact;
    }
    public String getmdPhone(){
        return this.mdPhone;
    }
    public String getAlgType(){
        return this.algType;
    }
    public String getIllType(){
        return this.illType;
    }
    //get methods, they print the info required, and return them ^^^^^^^^^^^^^

    //update methods, they update their respective arguments vvvvvvvvvvvvvvvvv
    public void updatemdContact(String n){
        this.mdContact = n;
    }
    public void updatemdPhone(String n){
        this.mdPhone = n;
    }
    private static boolean checkIllType(String Illtype){
        for(String illtype : getIllTypes()) { if(Illtype.equalsIgnoreCase(illtype)) { return true; } }
        return false;
    }
    private static boolean checkAlgType(String Algtype){
        for(String algtype : getAlgTypes()) { if(Algtype.equalsIgnoreCase(algtype)) { return true; } }
        return false;
    }
    public void updateAlgType(String n) throws IllegalArgumentException {
        if(checkAlgType(n)) { this.algType = n; }
        else { throw new IllegalArgumentException(); }
    }
    public void updateIllType(String n) throws IllegalArgumentException {
        if(checkIllType(n)) { this.illType = n; }
        else { throw new IllegalArgumentException(); }
    }
    //update methods, they update their respective arguments  ^^^^^^^^^^^^^^^^^^^^^


    //test main function
    /*public static void main(String[] args){
        MedCond test = new MedCond("Dr.Winslow", "8884445555", "none", "none");
        test.getAlgType();
        test.getmdContact();
        test.getmdPhone();
        test.getIllType();
        test.updateAlgType("medication");
        test.updateIllType("None");
        test.updatemdContact("Dr.Doctorson");
        test.updatemdPhone("5558763333");
        test.getAlgType();
        test.getmdContact();
        test.getmdPhone();
        test.getIllType();
    }*/
}
