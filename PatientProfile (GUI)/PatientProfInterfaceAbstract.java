/*

** PatientProfInterfaceAbstract (Patient Profile Interface abstract) **
abstract class

*/


public abstract class PatientProfInterfaceAbstract {
    protected abstract void getUserChoice();
    protected abstract void deletePatientProf();
    protected abstract PatientProf findPatientProf();
    protected abstract void updatePatientProf();
    protected abstract void displayPatientProf();
    protected abstract void displayAllPatientProf();
    protected abstract void writeToDB();
    protected abstract void initDB();
    protected abstract void createNewPatientProf(PatientProf p);
    protected abstract void createNewMedCond(PatientProf p);
}