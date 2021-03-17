package listToFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.List;
import java.util.ArrayList;

public class storeToFile{

    // Requirements:
    //    class implements Serialize
    
    
    public static class storeObject{
        public static File getFileObject(String fileName) throws IOException {  if(!fileName.equals("")) { return new File(fileName); }
        throw new IOException(); }

        @SuppressWarnings("unchecked")
        public static <Type> Type[] fileObjectToObject(String fileName, Class<Type> cls) throws IOException, ClassNotFoundException {
            File fileObj = getFileObject(fileName);
            List<Type> list = new ArrayList<Type>();
            try{
                FileInputStream fis = new FileInputStream(fileObj);
                ObjectInputStream ois = new ObjectInputStream(fis);
        
                // Read objects
                Object objTemp = null;
                while(!(objTemp = ois.readObject()).equals(null)) {  list.add((Type) objTemp);  }
                
                ois.close();
                fis.close();
            }
            catch(EOFException eof){  /* Continue and return  */  }

            
            return list.toArray( (Type[]) java.lang.reflect.Array.newInstance(cls, list.size()) );
        }
    
        public static <Type> void objectToFileObject(String fileName, Type[] objList) throws IOException {
            File fileObj = getFileObject(fileName);
            FileOutputStream fos = new FileOutputStream(fileObj);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        
            for(Type objTemp : objList) {  oos.writeObject(objTemp);  }
        
            oos.close();
            fos.close();
        }
    }
    
}
