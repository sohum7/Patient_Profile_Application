package PatientProfileDatabase;

////  Patient Profile Database
//    A file will act like a database
//      Data will be collected in an array
//      Once done working with data, store back in file

import listToFile.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;


public abstract class PatientProfDBAbstract<PatientProfDBTEST> {

    // Eliminate comment below upon completion of PatientProf class
    //
    private PatientProfDBTEST[] patientList;
    private String fileName;


    protected final PatientProfDBTEST[] getPatientProfList(){  return this.patientList;  }
    // .....
    public final boolean indexInPatientList(int index) {  return index >= 0 && index < this.patientList.length;  }

    // Basic operations to be run on PatientProf[] array
    //      add a profile
    //      find and/or delete element based on matching adminID and name
    //      return an element of PatientProf[]
    protected final int findPatientIndex(String adminID, String name){ 
        for(int i=0; i<this.patientList.length; i++){  if (this.patientList[i].getadminID().equals(adminID) && this.patientList[i].getFirstName().equals(name)) { return i; }  }
        return -1;
    }
    // NOTE NEEDED protected final PatientProf findProfileByIndex(int index) { if(this.inPatientProfList(index, this.patientList) { return this.patientList[index]; } return new PatientProf(); }
    protected final void addProfile(PatientProfDBTEST patient) { this.patientList.append(patient); }
    protected final boolean deleteProfileByIndex(int index) { this.patientList = ArrayUtils.remove(this.patientList, index); }
    protected final PatientProfDBTEST getProfileByIndex(int index) { return patientList[index]; }

    // To be implemented
    // Check input for these ...
    protected abstract void writeAllPatientProf(String fileName);
    protected abstract void initializeDatabase(String fileNamw);

}

// Inheriting PatientProfDBAbstract for PatientProfDB
public class PatientProfDB extends PatientProfDBAbstract<PatientProfDBTEST> implements Serializable {
    // Basic patient information variables
    //      number of patients
    //      currently working with patient index value for within PatientProf array
    // File which will replace a database for data management
    
    private PatientProfDBTEST[] patientList = null;
    private int numPatient = 0;
    private int currentProfileIndex = 0;
    private String fileName = "";
    private File fileObj = null;

    // PatientProfDB constructor
    public PatientProfDB(String fileName) throws ClassNotFoundException, IOException{
        this.fileObj = storeToFile.storeObject.getFileObject(this.fileName);
        this.fileName = fileName;
        this.patientList = storeToFile.storeObject.<PatientProfDBTEST>fileObjectToObject(fileObj, PatientProfDBTEST.class);
        this.numPatient = this.patientList.length;
    }


    protected void updateNumPatient(){  this.numPatient = super.getPatientProfList().length;  }
    protected PatientProf findProfile(String adminID, String name)
    {
        if(this.numPatient == 0) {  throw new Exception();  }
        int indexProfile = super.findPatientIndex(adminID, name);
        if(indexProfile >= 0) {  return super.getProfileByIndex(indexProfile);  } 
    }
    protected PatientProf findFirstProfile(){
        this.currentProfileIndex = 0;
        if(this.numPatient == 0) {  throw new Exception();  }
        return super.getPatientProfList[this.currentProfileIndex];
    }
    protected PatientProf findNextProfile(){
        if(this.numPatient == 0) {  throw new Exception();  }
        else if(++this.currentProfileIndex < super.getPatientProfList().length) {  return super.getPatientProfList()[this.currentProfileIndex];  }
        else {  return this.findFirstProfile();  }
    }

    protected void insertNewProfile(PatientProf profile){ super.addProfile(profile); this.updateNumPatient();  }
    protected boolean deleteProfile(String adminID, String Name){
        int resIndex = super.findPatientIndex(adminID, Name);
        if(resIndex != -1) {  super.deleteProfileByIndex(resIndex); this.updateNumPatient();  }
        return resIndex != -1;
    }
    protected void writeAllPatientProf(String unknownValue){
        storeToFile.storeObject.objectToFileObject(this.patientList, this.fileObj);
    }
    protected void initializeDatabase(String unknownValue){
        this.patientList = storeToFile.storeObject.fileObjectToObject(this.fileObj, PatientProfDBTEST.class);
    }

 }

