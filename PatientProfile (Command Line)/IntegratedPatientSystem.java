import java.io.IOException;

public class IntegratedPatientSystem {
    public static void main(String[] args) throws Exception {
        String file;
        PatientProfInterface ips;

        // Set file name
        file = "testFile.txt";

        // Begin PatientProfInterface session
        try { ips = new PatientProfInterface(file); }
        catch(IOException e) { System.out.println("IPS - File Error"); }
        catch(Exception e)   { System.out.println("IPS - System Error"); }
    }
}