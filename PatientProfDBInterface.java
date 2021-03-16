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
    private enum menu {
        createPatProf       (1),
        deletePatProf       (2),
        displayPatProf      (3),
        updatePatProf       (4),
        displayAllPatProfs  (5),
        commitAllPatProfs   (6),
        fetchAllPatProfs    (7);

        private final int optionCode;
        private final String optionString;

        menu(int optionCode, String optionString) {
            this.optionCode = optionCode;
            this.optionString = optionString;
        }
        public int getOptionCode() {  return this.optionCode;  }
        public String getOptionString() {  return this.optionString;  }
    }

    public PatientProfInterface(String fileName) throws Exception {
        this.db = new PatientProfDB(fileName);
    }

    private void displayMenuOptions(){
        for(menu op : menu.values()) {  System.out.println(op.getOptionCode() + ". " + op.getOptionString());  }
    }
    private void enterMenuOptionCode() {  System.out.println("Enter a option: ");  }
    private void mapMenuOptionsToMethod(int optionCode){
        switch(optionCode){
            case menu.createPatProf.getOptionCode():      this.createNewPatientProf();  break;
            case menu.deletePatProf.getOptionCode():      this.deletePatientProf();     break;
            case menu.displayPatProf.getOptionCode():     this.displayPatientProf();    break;
            case menu.updatePatProf.getOptionCode():      this.updatePatientProf();     break;
            case menu.displayAllPatProfs.getOptionCode(): this.displayAllPatientProf(); break;
            case menu.commitAllPatProfs.getOptionCode():  this.writeToDB();             break;
            case menu.fetchAllPatProfs.getOptionCode():   this.initDB();                break;
        }
    }
    private Scanner inputScanner() {  return new Scanner(System.in);  }
    public void getUserChoice(){
        this.displayMenuOptions();
        this.enterMenuOptionCode();
        Scanner sn;
        do{
            try{
                sn = inputScanner();
                this.mapMenuOptionsToMethod(sn.nextInt());
            }catch(InputMismatchException e){
                System.out.println();
                continue;
            }catch(IOException e){

            }catch(Exception e){

            }
        }while(true);

        sn.close();
    }

    public void deletePatientProf();
    public void findPatientProf();
    public void updatePatientProf();
    public void displayPatientProf();
    public void displayAllPatientProf();
    public void writeToDB();
    public void initDB();
    public PatientProf createNewPatientProf();
    public MedCond createNewMedCond();



}
