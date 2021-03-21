
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


// Inheriting PatientProfDBAbstract for PatientProfDB
public class PatientProfDB extends PatientProfDBAbstract {
    // Basic patient information variables
    //      number of patients
    //      currently working with patient index value for within PatientProf array
    // File which will replace a database for data management
    
    private int numPatient;
    private int currentProfileIndex;

    // PatientProfDB constructor
    public PatientProfDB(String fileName) throws ClassNotFoundException, IOException {
        super(fileName);
        this.initializeDatabase();
        this.updateNumPatient();
        this.currentProfileIndex = -1;
    }
    
    private static final PatientProf[] addObjElement(PatientProf[] arr, PatientProf toAdd) {
        List<PatientProf> listArray = new ArrayList<PatientProf>(Arrays.asList(arr));
        listArray.add(toAdd);
        return listArray.toArray(arr);
    }
    private static final PatientProf[] deleteObjElement(PatientProf[] arr, int toRemove) {
        List<PatientProf> listArray = new ArrayList<PatientProf>(Arrays.asList(arr));
        listArray.remove(toRemove);
        return listArray.toArray(arr);
    }

    private void updateNumPatient() {  this.numPatient = this.patientList.length;  }
    //public void updateCurrentProfIndex(int index) {  this.currentProfileIndex = index;  }
    public int getCurrentProfIndex() {  return this.currentProfileIndex;  }

    protected PatientProf findProfile(String adminID, String name) throws Exception {
        if(this.numPatient == 0) {  throw new Exception("No patient profiles in system");  }
        int indexProfile = this.currentProfileIndex = this.getPatientProfArrIndex(adminID, name);
        if(indexProfile >= 0) {  return this.getPatientProfObjByIndex(indexProfile);  }

        return null;
    }
    ////////
    protected PatientProf[] findProfiles(String adminID) throws Exception {
        if(this.numPatient == 0) {  throw new Exception("No patient profiles in system");  }
        PatientProf[] adminIDPatients = new PatientProf[0];
        for(PatientProf p : this.getPatientProfList()) {  if(p != null && p.getadminID().equals(adminID)) { adminIDPatients = addObjElement(adminIDPatients, p); }  }

        return adminIDPatients;
    }
    ////////

    protected PatientProf findFirstProfile() throws Exception {
        this.currentProfileIndex = 0;
        if(this.numPatient == 0) {  throw new Exception();  }
        return this.getPatientProfObjByIndex(this.currentProfileIndex);
    }
    protected PatientProf findNextProfile() throws Exception {
        if(this.numPatient == 0) {  throw new Exception();  }
        else if(++this.currentProfileIndex < this.getPatientProfList().length) {  return this.getPatientProfObjByIndex(this.currentProfileIndex);  }
        else {  return this.findFirstProfile();  }
    }

    protected boolean insertNewProfile(PatientProf profile) {
        int resIndex = this.getPatientProfArrIndex(profile.getadminID(), profile.getLastName());
        if(resIndex == -1) { this.patientList = addObjElement(this.patientList, profile); this.updateNumPatient(); this.currentProfileIndex = this.numPatient-1; }
        return resIndex == -1;
    }
    protected boolean deleteProfile(String adminID, String Name){
        int resIndex = this.getPatientProfArrIndex(adminID, Name);
        if(resIndex != -1) { this.patientList = deleteObjElement(this.patientList, resIndex); this.updateNumPatient(); }
        return resIndex != -1;
    }

    // Assignment requires parameter for these, but there is no need for any parameters. 
    protected void writeAllPatientProf() throws IOException {  storeToFile.storeObject.objectToFileObject(this.fileName, this.patientList);  }
    protected void initializeDatabase() throws ClassNotFoundException, IOException {  this.patientList = storeToFile.storeObject.fileObjectToObject(this.fileName, PatientProf.class);  }
 }

