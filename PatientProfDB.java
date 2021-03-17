
////  Patient Profile Database
//    A file will act like a database
//      Data will be collected in an array
//      Once done working with data, store back in file

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//import org.apache.commons.lang3.ArrayUtils;

public abstract class PatientProfDBAbstract {

    // Eliminate comment below upon completion of PatientProf class
    //
    private PatientProf[] patientList;
    private String fileName;


    // NOTE NEEDED protected final PatientProf findProfileByIndex(int index) { if(this.inPatientProfList(index, this.patientList) { return this.patientList[index]; } return new PatientProf(); }
    protected final PatientProf[] getPatientProfList() {  return this.patientList;  }
    protected final PatientProf getPatientProfObjByIndex(int index) {  return this.getPatientProfList()[index];  }

    // .....
    public final boolean indexInPatientList(int index) {  return index >= 0 && index < this.getPatientProfList().length;  }

    // Basic operations to be run on PatientProf[] array
    //      add a profile
    //      find and/or delete element based on matching adminID and name
    //      return an element of PatientProf[]
    protected final int getPatientProfArrIndex(String adminID, String name){ 
        for(int i=0; i<this.getPatientProfList().length; i++){  if (this.getPatientProfList()[i].getadminID().equals(adminID) && this.getPatientProfList()[i].getLastName().equals(name)) { return i; }  }
        return -1;
    }

    // To be implemented
    // Check input for these ...
    protected abstract void writeAllPatientProf(String fileName) throws IOException;
    protected abstract void initializeDatabase(String fileName) throws ClassNotFoundException, IOException;

}

// Inheriting PatientProfDBAbstract for PatientProfDB
public class PatientProfDB extends PatientProfDBAbstract {
    // Basic patient information variables
    //      number of patients
    //      currently working with patient index value for within PatientProf array
    // File which will replace a database for data management
    
    private PatientProf[] patientList;
    private int numPatient;
    private int currentProfileIndex;
    private String fileName;

    // PatientProfDB constructor
    public PatientProfDB(String fileName) throws ClassNotFoundException, IOException {
        this.initializeDatabase(fileName);
        this.updateFileAttribute(fileName);
        this.updateNumPatient();
        this.currentProfileIndex = 0;
    }

    private static final PatientProf[] addObjElement(PatientProf[] arr, PatientProf toAdd) {
        List<PatientProf> listArray = new ArrayList<PatientProf>(Arrays.asList(arr));
        listArray.add(toAdd);
        return listArray.toArray(arr);
    }
    private static final PatientProf[] deleteObjElementByIndex(PatientProf[] arr, int index) {
        List<PatientProf> listArray = new ArrayList<PatientProf>(Arrays.asList(arr));
        listArray.remove(index);
        return listArray.toArray(arr);
    }
    private void updateFileAttribute(String fileName) {  this.fileName = fileName;  }
    private void updateNumPatient() {  this.numPatient = this.patientList.length;  }
    //public void updateCurrentProfIndex(int index) {  this.currentProfileIndex = index;  }
    public int getCurrentProfIndex() {  return this.currentProfileIndex;  }

    protected PatientProf findProfile(String adminID, String name) throws Exception {
        if(this.numPatient == 0) {  throw new Exception("No patient profiles in system");  }

        int indexProfile = this.currentProfileIndex = super.getPatientProfArrIndex(adminID, name);
        if(indexProfile >= 0) {  return super.getPatientProfObjByIndex(indexProfile);  }

        return null;
    }
    ////////
    protected PatientProf[] findProfiles(String adminID) throws Exception {
        if(this.numPatient == 0) {  throw new Exception("No patient profiles in system");  }
        PatientProf[] adminIDPatients = new PatientProf[0];
        for(PatientProf p : this.getPatientProfList()) {  if(p.getadminID().equals(adminID)) { addObjElement(adminIDPatients, p); }  }

        return adminIDPatients;
    }
    ////////

    protected PatientProf findFirstProfile() throws Exception {
        this.currentProfileIndex = 0;
        if(this.numPatient == 0) {  throw new Exception();  }
        return super.getPatientProfObjByIndex(this.currentProfileIndex);
    }
    protected PatientProf findNextProfile() throws Exception {
        if(this.numPatient == 0) {  throw new Exception();  }
        else if(++this.currentProfileIndex < super.getPatientProfList().length) {  return super.getPatientProfObjByIndex(this.currentProfileIndex);  }
        else {  return this.findFirstProfile();  }
    }

    protected void insertNewProfile(PatientProf profile) {  this.patientList = addObjElement(this.patientList, profile); this.updateNumPatient(); this.currentProfileIndex = this.numPatient-1; }
    protected boolean deleteProfile(String adminID, String Name){
        int resIndex = super.getPatientProfArrIndex(adminID, Name);
        if(resIndex != -1) {  this.patientList = deleteObjElementByIndex(this.patientList, resIndex); this.updateNumPatient();  }
        return resIndex != -1;
    }

    // Assignment requires parameter for these, but there is no need for any parameters. Request Professor change it
    protected void writeAllPatientProf() throws IOException {  storeToFile.storeObject.objectToFileObject(this.fileName, this.patientList);  }
    protected void initializeDatabase() throws ClassNotFoundException, IOException {  this.patientList = storeToFile.storeObject.fileObjectToObject(fileName, PatientProf.class);  }

 }

