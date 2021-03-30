/*

** storeToFIle (Store to File) **

Read and write objects, which implements serializable, to a file

public class storeToFile
    public static class storeObject
        public static File getFileObject(String fileName)
        public static <Type> Type[] fileObjectToObject(String fileName, Class<Type> cls)
        public static <Type> boolean objectToFileObject(String fileName, Type[] objList)

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class storeToFile{
    public static class storeObject{
        // Get File object of the parameter file name
        public static File getFileObject(String fileName) throws IOException {  if(!fileName.isBlank()) { return new File(fileName); }
        throw new IOException(); }

        // Copy objects from file to array
        // Open and read file -> convert stream to object of chosen Type -> return array of objects
        @SuppressWarnings("unchecked")
        public static <Type> Type[] fileObjectToObject(String fileName, Class<Type> cls) throws IOException, ClassNotFoundException {
            File fileObj = getFileObject(fileName);
            List<Type> list = new ArrayList<Type>();
            try(FileInputStream fis = new FileInputStream(fileObj)){
                ObjectInputStream ois = new ObjectInputStream(fis);
        
                // Read objects
                Type objTemp = null;
                while(!(objTemp = (Type) ois.readObject()).equals(null)) {  list.add(objTemp);  }
                
                ois.close();
                fis.close();
            }
            catch(FileNotFoundException e){  /* .............  */  }
            catch(EOFException eof){  /* Continue and return  */  }
            catch(Exception e){  /* .............  */  }

            return list.toArray( (Type[]) java.lang.reflect.Array.newInstance(cls, list.size()) );
        }
    
        // Overwrite objects in file from array
        // Open file -> overwrite file with objects from array -> return true if function executes as intended
        public static <Type> boolean objectToFileObject(String fileName, Type[] objList) throws IOException {
            File fileObj = getFileObject(fileName);

            try(FileOutputStream fos = new FileOutputStream(fileObj)){
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        
                for(Type objTemp : objList) {  oos.writeObject(objTemp);  }
            
                oos.close();
                fos.close();
                return true;
            }
            catch(FileNotFoundException e){  System.out.println("FNF"); e.printStackTrace();/* .............  */  }
            catch(EOFException eof){  System.out.println("EOF"); eof.printStackTrace();/* Continue and return  */  }
            catch(Exception e){  System.out.println("E"); e.printStackTrace();/* .............  */  }

            return false;
        }
    }
}
