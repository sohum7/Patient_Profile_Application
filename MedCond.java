// medcond is a class that is used as an argument of the PatientProf class, containing information such as medical contact info and so on

public class MedCond{
    // arguments  vvvvv
    private String mdContact;
    private String mdPhone;
    private String algType;
    private String illType;
    // arguments ^^^^^

    //constructor vvvv
    public MedCond(String MDcontact, String MDphone, String Algtype, String Illtype){
        mdContact = MDcontact;
        mdPhone = MDphone;
        int t = 1;
        try{
            if(Algtype == "none" || Algtype == "food" || Algtype == "medication" || Algtype == "other"){
                algType = Algtype;
            }
            else{
                t = t / 0;}
            }catch(Exception e){
                System.out.println("ERROR: Patient Type must be \"none\", \"food\", \"medication\", or \"other\", SET TO null.");
            }



        try{
            if(Illtype == "none" || Illtype == "CHD" || Illtype == "diabetes" || Illtype == "asthma" || Illtype == "other"){
                illType = Illtype;
            }
            else{
                t = t / 0;}
            }catch(Exception e){
                System.out.println("ERROR: Patient Type must be \"none\", \"CHD\", \"diabetes\", \"asthma\", or \"other\", SET TO null.");
            }

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
        int t = 1;
        try{
            if(n == "none" || n == "food" || n == "medication" || n == "other"){
                algType = n;
            }
            else{
                t = t / 0;}
            }catch(Exception e){
                System.out.println("ERROR: Patient Type must be \"none\", \"food\", \"medication\", or \"other\", NOT UPDATED.");
            }


    }
    public void updateIllType(String n){
        int t = 1;
        try{
            if(n == "none" || n == "CHD" || n == "diabetes" || n == "asthma" || n == "other"){
                illType = n;
            }
            else{
                t = t / 0;}
            }catch(Exception e){
                System.out.println("ERROR: Patient Type must be \"none\", \"CHD\", \"diabetes\", \"asthma\", or \"other\", NOT UPDATED.");
            }


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
