package PatientProfileDatabase;

import java.io.Serializable;

public class PatientProfDBTEST implements Serializable{
    public String name;
    public PatientProfDBTEST(String name) {
        this.name = name;
    }
    public String toString(){
        return name;
    }
}