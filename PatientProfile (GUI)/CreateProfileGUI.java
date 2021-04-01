import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreateProfileGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    public static class createProfile{
        MedCond mc = new MedCond("", "", "none", "none");
        PatientProf p = new PatientProf("", "", "", "", "", 0, "Private", "Adult", mc);
        public static void createPatientProf(Frame cp){
            final int fontSize = 12;
            int deltaY = 20;
            int y = 20;
            int x = 10;
            int xWidth = 100;
            int yWidth = 30;

            JLabel adminid = new JLabel("AdminID: ");
            adminid.setFont(new Font("Arial", Font.PLAIN, fontSize));
            adminid.setSize(xWidth, yWidth);
            adminid.setLocation(x, y+=deltaY);
            cp.add(adminid);

            JLabel fname = new JLabel("First name: ");
            fname.setFont(new Font("Arial", Font.PLAIN, fontSize));
            fname.setSize(xWidth, yWidth);
            fname.setLocation(x, y+=deltaY);
            cp.add(fname);

            JLabel lname = new JLabel("Last name: ");
            lname.setFont(new Font("Arial", Font.PLAIN, fontSize));
            lname.setSize(xWidth, yWidth);
            lname.setLocation(x, y+=deltaY);
            cp.add(lname);

            JLabel addr = new JLabel("Address: ");
            addr.setFont(new Font("Arial", Font.PLAIN, fontSize));
            addr.setSize(xWidth, yWidth);
            addr.setLocation(x, y+=deltaY);
            cp.add(addr);

            JLabel phone = new JLabel("Phone: ");
            phone.setFont(new Font("Arial", Font.PLAIN, fontSize));
            phone.setSize(xWidth, yWidth);
            phone.setLocation(x, y+=deltaY);
            cp.add(phone);

            JLabel copay = new JLabel("Copay: ");
            copay.setFont(new Font("Arial", Font.PLAIN, fontSize));
            copay.setSize(xWidth, yWidth);
            copay.setLocation(x, y+=deltaY);
            cp.add(copay);

            JLabel insutype = new JLabel("Insurance Type: ");
            insutype.setFont(new Font("Arial", Font.PLAIN, fontSize));
            insutype.setSize(xWidth, yWidth);
            insutype.setLocation(x, y+=deltaY);
            cp.add(insutype);

            JLabel pattype = new JLabel("Patient Type: ");
            pattype.setFont(new Font("Arial", Font.PLAIN, fontSize));
            pattype.setSize(xWidth, yWidth);
            pattype.setLocation(x, y+=deltaY);
            cp.add(pattype);

        }
        public static void createMedCond(Frame cp){
            final int fontSize = 12;
            int deltaY = 20;
            int y = 20;
            int x = 10;
            int xWidth = 100;
            int yWidth = 30;


            JLabel mdContact = new JLabel("AdminID: ");
            mdContact.setFont(new Font("Arial", Font.PLAIN, fontSize));
            mdContact.setSize(xWidth, yWidth);
            mdContact.setLocation(x, y+=deltaY);
            cp.add(mdContact);

            JLabel mdPhone = new JLabel("First name: ");
            mdPhone.setFont(new Font("Arial", Font.PLAIN, fontSize));
            mdPhone.setSize(xWidth, yWidth);
            mdPhone.setLocation(x, y+=deltaY);
            cp.add(mdPhone);

            JLabel algType = new JLabel("Last name: ");
            algType.setFont(new Font("Arial", Font.PLAIN, fontSize));
            algType.setSize(xWidth, yWidth);
            algType.setLocation(x, y+=deltaY);
            cp.add(algType);

            JLabel illType = new JLabel("Address: ");
            illType.setFont(new Font("Arial", Font.PLAIN, fontSize));
            illType.setSize(xWidth, yWidth);
            illType.setLocation(x, y+=deltaY);
            cp.add(illType);

        }
        public static void setDefaultLayout(){
            // Set default parameters
            Frame cp  = new Frame("Create Profile");

            createPatientProf(cp);
            createMedCond(cp);
            
            cp.setSize(800, 800);
            cp.setLayout(null);
            cp.setVisible(true);
        }
        public void changeLayout(){
            // Clear any parameters

        }
        

    }
    public class cpActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            // Action to be performed once event has occurred

        }
    }
    public static void main(String[] args){
        createProfile.setDefaultLayout();
    }
}
