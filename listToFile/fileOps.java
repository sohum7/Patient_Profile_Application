package listToFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class fileOps<T> {
    private String fileName;
    private File fileObject;

    public fileOps(){  this("");  }

    public fileOps(String fileName) {  this.openFile(fileName);  }

    public void setAttributes(File fileObj, String fileName) {
        this.fileObject = fileObj;
        this.fileName = fileName;
    }

    private void setDefaultAttributes() {  this.setAttributes(null, "");  }
    private void setDefaultAttributes(String fileName) {
        if(!fileName.equals("")) 
        {  this.setAttributes(new File(fileName), fileName);  }
    }

    // Basic file operations and storing of file objects
    //      get file name
    //      get file object
    //      open file
    protected String getFileName() {  return this.fileName;  }
    protected File getFileObject() {  return this.fileObject;  }
    protected void openFile(String fileName){  this.setDefaultAttributes(fileName);  }

    // Requirements:
    //    toString func on obj
    //    class implements Serialize
    protected T[] getFileToObject() {
        FileInputStream fis = new FileInputStream(new File(this.fileName));
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<T> list = new ArrayList<T>();

        // Read objects
        T objTemp = null;

        // REVISIT THIS
        while(!(objTemp = (T) ois.readObject()).equals(null)) {  list.add(objTemp);  }
        
        ois.close();
        fis.close();

        // REVISIT THIS
        // return (T[]) list.toArray();
        return list.toArray();
    }
    protected void setObjectToFIle(Object[] objList) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(this.fileName));
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for(Object objTemp : objList) {  oos.writeObject(objTemp);  }

        oos.close();
        fos.close();
    }
}
