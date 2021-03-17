
import listToFile.*;
//import PatientProfileDatabase.*;

import java.io.File;
import java.io.IOException;

public class testFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        File fileObj = storeToFile.storeObject.getFileObject("testFile.txt");
        //storeToFile.storeObject.objectToFileObject(temp, fileObj);
        PatientProfDBTEST t1 = new PatientProfDBTEST("hello,");
        PatientProfDBTEST t2 = new PatientProfDBTEST("world");
        PatientProfDBTEST[] temp3 = new PatientProfDBTEST[2];
        temp3[0] = t1;
        temp3[1] = t2;

        storeToFile.storeObject.<PatientProfDBTEST>objectToFileObject(temp3, fileObj);

        PatientProfDBTEST[] temp4 = storeToFile.storeObject.<PatientProfDBTEST>fileObjectToObject(fileObj, PatientProfDBTEST.class);
        System.out.println(temp4.getClass());
        for(int i = 0; i < temp4.length; i++){
            System.out.println(temp4[i].name);
        }
    }
}
