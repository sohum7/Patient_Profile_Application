////  Patient Profile Database
//    A file will act like a database
//      Data will be collected in an array
//      Once done working with data, store back in file

import listToFile.*;
import java.util.*;
import java.io.Serializable;


public abstract class PatientProfDBAbstract<patientClass> {

    // Eliminate comment below upon completion of PatientProf class
    //
    private patientClass[] patientList = null;
    private String fileName = "";
    private storeToFile.storeObject<patientClass> fileObj = null;

    // PatientProfDB constructor
    public PatientProfDBAbstract() {  this("");  }
    // PatientProfDB constructor
    public PatientProfDBAbstract(String fileName){
        this.fileObj = storeToFile.storeObject<patientClass>(fileName);
        this.fileName = fileName;
        this.patientList = this.fileObj.getFileToObject();
    }

    protected final patientClass[] getPatientProfList(){
        return this.patientList;

    }
    // .....
    public final boolean indexInPatientList(int index) {  return index >= 0 && index < this.profileList.length;  }

    // Basic operations to be run on PatientProf[] array
    //      add a profile
    //      find and/or delete element based on matching adminID and name
    //      return an element of PatientProf[]
    protected final int findPatientIndexByIDAndName(String adminID, String name){ 
        int i = 0;
        while (i < this.patientList.length()){
            if (this.patientList[i].getadminID().equals(adminID) && this.patientList[i].getFirstName().equals(name)) { return i; }
            i++;
        }
        return -1;
    }
    // NOTE NEEDED protected final PatientProf findProfileByIndex(int index) { if(this.inPatientProfList(index, this.patientList) { return this.patientList[index]; } return new PatientProf(); }
    protected final void addProfile(patientClass patient) { this.patientList.append(patient); }
    protected final boolean deleteProfileByIndex(int index) { this.patientList = ArrayUtils.remove(this.patientList, index); }
    protected final patientClass getProfileByIndex(int index) { return patientList[index]; }

    // To be implemented
    // Check input for these ...
    protected abstract writeAllPatientProf(String fileName){

    }
    protected abstract initializeDatabase(String fileNamw){

    }

}

// Inheriting PatientProfDBAbstract for PatientProfDB
 public class PatientProfDB extends PatientProfDBAbstract<PatientProf> implements Serializable {
    // Basic patient information variables
    //      number of patients
    //      currently working with patient index value for within PatientProf array
    // File which will replace a database for data management
    private PatientProf[] patientList = null;
    private int numPatient = 0;
    private String fileName = "";
    private fileOps fileObj = null;
    private int currentProfileIndex = 0;

    public PatientProfDB(){ this(""); }
    public PatientProfDB(String fileName){ super(fileName); }

    protected void updateNumPatient(){  this.numPatient = super.getPatientProfList().length;  }
    protected PatientProf findProfile(String adminID, String name)
    {
        if(this.numPatient == 0) {  throw new Exception();  }
        int indexProfile = findProfIndexByIDAndName(adminID, name);
        if(indexProfile >= 0) {  return super.getProfileByIndex(indexProfile);  } 
    }
    protected PatientProf findFirstProfile(){
        currentProfileIndex = 0;
        if(this.numPatient == 0) {  throw new Exception();  }
        return super.getPatientProfList[0];
    }
    protected PatientProf findNextProfile(){
        if(super.getPatientProfList().length == 0) {  throw new Exception();  }
        else if(++this.currentProfileIndex < super.getPatientProfList().length) {  return super.getPatientProfList()[this.currentProfileIndex];  }
        else {  return this.findFirstProfile();  }
    }

    protected void insertNewProfile(PatientProf profile){ super.addProfile(profile); this.updateNumPatient();  }
    protected boolean deleteProfile(String adminID, String Name){
        int resIndex = super.findProfIndexByIDAndName(adminID, Name);
        if(resIndex != -1) {  super.deleteProfileByIndex(resIndex); this.updateNumPatient();  }
        return resIndex != -1;
    }
    protected void writeAllPatientProf(String unknownValue){
        setObjectToFIle
    }
    protected void initializeDatabase(String unknownValue){
        throw new NotImplementedException();
    }

 }

