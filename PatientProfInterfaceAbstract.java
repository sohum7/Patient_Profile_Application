////  Patient Profile Interface for admin users
//      Interface will allow admin users (doctors, nurses, etc) to access profile data
public abstract class PatientProfInterfaceAbstract {
    //public abstract PatientProfInterfaceAbstract(String fileName);
    public abstract void getUserChoice();
    public abstract void deletePatientProf();
    public abstract PatientProf findPatientProf();
    public abstract void updatePatientProf();
    public abstract void displayPatientProf();
    public abstract void displayAllPatientProf();
    public abstract void writeToDB();
    public abstract void initDB();
    public abstract PatientProf createNewPatientProf();
    public abstract MedCond createNewMedCond();
}