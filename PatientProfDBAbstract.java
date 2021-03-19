////  Patient Profile Database
//    A file will act like a database
//      Data will be collected in an array
//      Once done working with data, store back in file
import java.io.IOException;

public abstract class PatientProfDBAbstract {

    // Eliminate comment below upon completion of PatientProf class
    //
    protected PatientProf[] patientList;
    protected String fileName;

    public PatientProfDBAbstract(String fileName) {  this.updateFileAttribute(fileName);  }

    protected void updateFileAttribute(String fileName) {  this.fileName = fileName;  }


    // NOTE NEEDED protected final PatientProf findProfileByIndex(int index) { if(this.inPatientProfList(index, this.patientList) { return this.patientList[index]; } return new PatientProf(); }
    protected final PatientProf[] getPatientProfList() {  return this.patientList;  }
    protected final PatientProf getPatientProfObjByIndex(int index) {  return this.getPatientProfList()[index];  }

    // .....
    public final boolean indexInPatientList(int index) {  return index >= 0 && index < this.getPatientProfList().length;  }

    protected final int getPatientProfArrIndex(String adminID, String name){ 
        for(int i=0; i<this.getPatientProfList().length; i++){  if (this.getPatientProfList()[i].getadminID().equals(adminID) && this.getPatientProfList()[i].getLastName().equals(name)) { return i; }  }
        return -1;
    }

    protected abstract void writeAllPatientProf() throws IOException;
    protected abstract void initializeDatabase() throws ClassNotFoundException, IOException;

}