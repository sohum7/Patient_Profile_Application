/* 

PatientProfDBAbstract (Patient Profile Database abstract)
Abstract class

*/

import java.io.IOException;

public abstract class PatientProfDBAbstract {

    // Required attributes
    //      Stores PatientProf objects in an array
    //      Stores the file name
    protected PatientProf[] patientList;
    protected String fileName;

    // PatientProf constructor
    public PatientProfDBAbstract(String fileName) {  this.updateFileAttribute(fileName);  }

    // true if index value is within range to access element
    protected final boolean indexInPatientList(int index) {  return index >= 0 && index < this.getPatientProfList().length;  }
    
    // update fileName attribute
    protected void updateFileAttribute(String fileName) {  this.fileName = fileName;  }

    // return patientList attribute
    protected final PatientProf[] getPatientProfList() {  return this.patientList;  }
    // return patientList element by index
    protected final PatientProf getPatientProfObjByIndex(int index) {  return this.getPatientProfList()[index];  }

    // return index of element object in patientList which has the matching adminID and last name
    protected final int getPatientProfArrIndex(String adminID, String name){ 
        for(int i=0; i<this.getPatientProfList().length; i++){  if (this.getPatientProfList()[i] != null && this.getPatientProfList()[i].getadminID().equals(adminID) && this.getPatientProfList()[i].getLastName().equals(name)) { return i; }  }
        return -1;
    }

    // return index of first profile that matches the adminID on or after the currentIndex in patientList
    protected final int getNextAdminidProf(String adminID, int startIndex){
        for(int i=startIndex; i<this.getPatientProfList().length; i++){  if (this.getPatientProfList()[i] != null && this.getPatientProfList()[i].getadminID().equals(adminID)) { return i; }  }
        return -1;
    }
    
    // Abstract methods
    protected abstract void writeAllPatientProf() throws IOException;
    protected abstract void initializeDatabase() throws ClassNotFoundException, IOException;

}