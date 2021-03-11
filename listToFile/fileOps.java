package listToFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

public class storeToFile{

    // Requirements:
    //    toString func on obj
    //    class implements Serialize
    
    public File getFileObject(String fileName){  if(!fileName.equals("")) { new File(fileName); } throw new Exception(); }

    public static class storeObject<T>{

        public T[] fileToObject(File f) {


            FileInputStream fis = new FileInputStream(new File(f));
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<T> list = new ArrayList<T>();
    
            // Read objects
            Object objTemp = null;
            while(!(objTemp = ois.readObject()).equals(null)) {  list.add((T) objTemp);  }
            
            ois.close();
            fis.close();
    
            return list.toArray( (T[]) new Object[list.size()] );
        }
    
        // REVISIT THIS
        public void objectToFIle(T[] objList) throws IOException {
    
        FileOutputStream fos = new FileOutputStream(new File(this.fileName));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
    
        for(T objTemp : objList) {  oos.writeObject(objTemp);  }
    
        oos.close();
        fos.close();
        }
    }
}
