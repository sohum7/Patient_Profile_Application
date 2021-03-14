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
        public static File getFileObject(String fileName) {  if(!fileName.equals("")) { return new File(fileName); }
        return null; }

        /*
        public static Object[] fileObjectToObject(File fileObj) throws IOException, ClassNotFoundException {
            List<Object> list = new ArrayList<Object>();
            try{
                FileInputStream fis = new FileInputStream(fileObj);
                ObjectInputStream ois = new ObjectInputStream(fis);
        
                // Read objects
                Object objTemp = null;
                while(!(objTemp = ois.readObject()).equals(null)) {  list.add( objTemp);  }
                
                ois.close();
                fis.close();
            }catch(EOFException eof){
                // Continue and return
            }
            
            
            return list.toArray( new Object[list.size()] );
        }
        */
        @SuppressWarnings("unchecked")
        public static <Type> Type[] fileObjectToObject(File fileObj, Class<Type> cls) throws IOException, ClassNotFoundException {
            List<Type> list = new ArrayList<Type>();
            try{
                FileInputStream fis = new FileInputStream(fileObj);
                ObjectInputStream ois = new ObjectInputStream(fis);
        
                // Read objects
                Object objTemp = null;
                while(!(objTemp = ois.readObject()).equals(null)) {  list.add((Type) objTemp);  }
                
                ois.close();
                fis.close();
            }catch(EOFException eof){
                // Continue and return
            }
            
            return list.toArray( (Type[]) java.lang.reflect.Array.newInstance(cls, list.size()) );
        }
    
        
        public static <Type> void objectToFileObject(Type[] objList, File fileObj) throws IOException {
        
            FileOutputStream fos = new FileOutputStream(fileObj);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        
            for(Type objTemp : objList) {  oos.writeObject(objTemp);  }
        
            oos.close();
            fos.close();
        }
    }
    
}
