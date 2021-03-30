/*

** PatientProfDB (Patient Profile Database) **

Stores in memory a list of Patient Profiles objects

private methods:
    private static final PatientProf[] - addObjElement(PatientProf[] arr, PatientProf toAdd)
    private static final PatientProf[] - deleteObjElement(PatientProf[] arr, int toRemove)
    private void - updateNumPatient()

protected methods
    protected int - getCurrentProfIndex()
    protected PatientProf - findProfile(String adminID, String name)
    protected PatientProf[] - findProfiles(String adminID)
    protected PatientProf - findFirstProfile()
    protected PatientProf - findNextProfile()
    protected boolean - insertNewProfile(PatientProf profile)
    protected boolean - deleteProfile(String adminID, String Name)
    protected void - writeAllPatientProf()
    protected void - initializeDatabase()

*/

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// Inheriting PatientProfDBAbstract for PatientProfDB
public class PatientProfDB extends PatientProfDBAbstract {
    // Basic patient information variables
    //      number of patients
    //      currently working with patient index value for within PatientProf array
    // File which will replace a database for data management/storage
    
    private int numPatient;
    private int currentProfileIndex;

    // PatientProfDB constructor
    // Accepts a filename
    // Initializes the database by retrieving PatientProfs in file filename
    // Other default values
    public PatientProfDB(String fileName) throws ClassNotFoundException, IOException {
        super(fileName);
        this.initializeDatabase();
        this.updateNumPatient();
        this.currentProfileIndex = -1;
    }
    
    // Allows array of type PatientProf to add objects of type PatientProf
    // Static method
    private static final PatientProf[] addObjElement(PatientProf[] arr, PatientProf toAdd) {
        List<PatientProf> listArray = new ArrayList<PatientProf>(Arrays.asList(arr));
        listArray.add(toAdd);
        return listArray.toArray(arr);
    }
    // Allows array of type PatientProf to add objects of type PatientProf
    // Static method
    private static final PatientProf[] deleteObjElement(PatientProf[] arr, int toRemove) {
        List<PatientProf> listArray = new ArrayList<PatientProf>(Arrays.asList(arr));
        listArray.remove(toRemove);
        return listArray.toArray(arr);
    }

    // Update numPatients
    private void updateNumPatient() {  this.numPatient = this.patientList.length;  }
    // Get current profile index value
    protected int getCurrentProfIndex() {  return this.currentProfileIndex;  }

    // Find and return profile by adminID and last name (unique)
    protected PatientProf findProfile(String adminID, String name) throws Exception {
        if(this.numPatient == 0) {  throw new Exception("No patient profiles in system");  }
        int indexProfile = this.currentProfileIndex = this.getPatientProfArrIndex(adminID, name);
        if(indexProfile >= 0) {  return this.getPatientProfObjByIndex(indexProfile);  }

        return null;
    }
    
    // Find and return profiles by adminID
    protected PatientProf[] findProfiles(String adminID) throws Exception {
        if(this.numPatient == 0) {  throw new Exception("No patient profiles in system");  }
        PatientProf[] adminIDPatients = new PatientProf[0];
        for(PatientProf p : this.getPatientProfList()) {  if(p != null && p.getadminID().equals(adminID)) { adminIDPatients = addObjElement(adminIDPatients, p); }  }

        return adminIDPatients;
    }

    // Find and return first profile in database file
    protected PatientProf findFirstProfile() throws Exception {
        this.currentProfileIndex = 0;
        if(this.numPatient == 0) {  throw new Exception();  }
        return this.getPatientProfObjByIndex(this.currentProfileIndex);
    }
    // Find and return next (using currentProfIndex) profile in database file
    protected PatientProf findNextProfile() throws Exception {
        if(this.numPatient == 0) {  throw new Exception();  }
        else if(++this.currentProfileIndex < this.getPatientProfList().length) {  return this.getPatientProfObjByIndex(this.currentProfileIndex);  }
        else {  return this.findFirstProfile();  }
    }

    // Insert patient profile into patientList
    // If input profile matches another profile, in terms of adminID and lastName, in patientList
    // Then the profile will not be added
    protected boolean insertNewProfile(PatientProf profile) {
        int resIndex = this.getPatientProfArrIndex(profile.getadminID(), profile.getLastName());
        if(resIndex == -1) { this.patientList = addObjElement(this.patientList, profile); this.updateNumPatient(); this.currentProfileIndex = this.numPatient-1; }
        return resIndex == -1;
    }
    // Delete profile, in terms of adminID and lastName, if one exists
    protected boolean deleteProfile(String adminID, String Name){
        int resIndex = this.getPatientProfArrIndex(adminID, Name);
        if(resIndex != -1) { this.patientList = deleteObjElement(this.patientList, resIndex); this.updateNumPatient(); }
        return resIndex != -1;
    }

    // Assignment requires parameter for these, but there is no need for any parameter
    // Write all profiles in memory to database file
    // Read all profiles into an array/memory, namely patientList, from database file
    protected void writeAllPatientProf() throws IOException {  storeToFile.storeObject.objectToFileObject(this.fileName, this.patientList);  }
    protected void initializeDatabase() throws ClassNotFoundException, IOException {  this.patientList = storeToFile.storeObject.fileObjectToObject(this.fileName, PatientProf.class);  }
 }

