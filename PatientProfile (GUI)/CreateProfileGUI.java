import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CreateProfileGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    public static class createProfile{
        MedCond mc = new MedCond("", "", "none", "none");
        PatientProf p = new PatientProf("", "", "", "", "", 0, "Private", "Adult", mc);

        public static void createPatientProf(JPanel cp){
            final int fontSize = 16;
            int deltaY = 20;
            int y = 20;
            int x = 10;
            int xWidth = 100;
            int yWidth = 30;
            int txWidth = 100;
            int tyWidth = 20;
            int colSpace = 120;
            String font = "Arial";

            // CHECK THESE
            String[] insuTypes = { "Private", "Government" };
            String[] patTypes = { "Adult", "Senior", "Pediatric1234" };
            

            JLabel adminid = new JLabel("Admin ID: ");
            adminid.setFont(new Font(font, Font.PLAIN, fontSize));
            //adminid.setSize(xWidth, yWidth);
            //adminid.setLocation(x, y);
            cp.add(adminid);
            JTextField tadminid = new JTextField();
            tadminid.setFont(new Font(font, Font.PLAIN, fontSize));
            //tadminid.setSize(txWidth, tyWidth);
            //tadminid.setLocation(x+colSpace, y); y+=deltaY;
            cp.add(tadminid);

            JLabel fname = new JLabel("First name: ");
            fname.setFont(new Font(font, Font.PLAIN, fontSize));
            //fname.setSize(xWidth, yWidth);
            //fname.setLocation(x, y);
            cp.add(fname);
            JTextField tfname = new JTextField();
            tfname.setFont(new Font(font, Font.PLAIN, fontSize));
            //tfname.setSize(txWidth, tyWidth);
            //tfname.setLocation(x+colSpace, y); y+=deltaY;
            cp.add(tfname);

            JLabel lname = new JLabel("Last name: ");
            lname.setFont(new Font(font, Font.PLAIN, fontSize));
            //lname.setSize(xWidth, yWidth);
            //lname.setLocation(x, y);
            cp.add(lname);
            JTextField tlname = new JTextField();
            tlname.setFont(new Font(font, Font.PLAIN, fontSize));
            //tlname.setSize(txWidth, tyWidth);
            //tlname.setLocation(x+colSpace, y); y+=deltaY;
            cp.add(tlname);

            JLabel addr = new JLabel("Address: ");
            addr.setFont(new Font(font, Font.PLAIN, fontSize));
            //addr.setSize(xWidth, yWidth);
            //addr.setLocation(x, y);
            cp.add(addr);
            JTextField taddr = new JTextField();
            taddr.setFont(new Font(font, Font.PLAIN, fontSize));
            //taddr.setSize(txWidth, tyWidth);
            //taddr.setLocation(x+colSpace, y); y+=deltaY;
            cp.add(taddr);

            JLabel phone = new JLabel("Phone: ");
            phone.setFont(new Font(font, Font.PLAIN, fontSize));
            //phone.setSize(xWidth, yWidth);
            //phone.setLocation(x, y);
            cp.add(phone);
            JTextField tphone = new JTextField();
            tphone.setFont(new Font(font, Font.PLAIN, fontSize));
            //tphone.setSize(txWidth, tyWidth);
            //tphone.setLocation(x+colSpace, y); y+=deltaY;
            cp.add(tphone);

            JLabel copay = new JLabel("Copay: ");
            copay.setFont(new Font(font, Font.PLAIN, fontSize));
            //copay.setSize(xWidth, yWidth);
            //copay.setLocation(x, y);
            cp.add(copay);
            JTextField tcopay = new JTextField();
            tcopay.setFont(new Font(font, Font.PLAIN, fontSize));
            //tcopay.setSize(txWidth, tyWidth);
            //tcopay.setLocation(x+colSpace, y); y+=deltaY;
            cp.add(tcopay);

            JLabel insutype = new JLabel("Insurance Type: ");
            insutype.setFont(new Font(font, Font.PLAIN, fontSize));
            //insutype.setSize(xWidth, yWidth);
            //insutype.setLocation(x, y);
            cp.add(insutype);
            JComboBox tinsutype = new JComboBox(insuTypes);
            tinsutype.setFont(new Font(font, Font.PLAIN, fontSize));
            //tinsutype.setSize(txWidth, tyWidth);
            //tinsutype.setLocation(x+colSpace, y); y+=deltaY;
            tinsutype.setSelectedIndex(0);
            //tinsutype.addActionListener(this);
            cp.add(tinsutype);

            JLabel pattype = new JLabel("Patient Type: ");
            pattype.setFont(new Font(font, Font.PLAIN, fontSize));
            //pattype.setSize(xWidth, yWidth);
            //pattype.setLocation(x, y);
            cp.add(pattype);
            JComboBox tpattype = new JComboBox(patTypes);
            tpattype.setFont(new Font(font, Font.PLAIN, fontSize));
            //tpattype.setSize(txWidth, tyWidth);
            //tpattype.setLocation(x+colSpace, y); y+=deltaY;
            tpattype.setSelectedIndex(0);
            //tpattype.addActionListener(this);
            cp.add(tpattype);


        }
        public static void createMedCond(JFrame cp){
            final int fontSize = 12;
            int deltaY = 20;
            int y = 20;
            int x = 10;
            int xWidth = 100;
            int yWidth = 30;

            /*
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
            */

        }
        public static void back(JPanel cp){
            JButton backForm = new JButton("Back/Cancel");
            backForm.setFont(new Font("Arial", Font.PLAIN, 15));
            //submitForm.setSize(100, 20);
            //submitForm.setLocation(100, 250);
            //submitForm.addActionListener(this);
            cp.add(backForm);
        }
        public static void submit(JPanel cp){
            JButton submitForm = new JButton("Submit");
            submitForm.setFont(new Font("Arial", Font.PLAIN, 15));
            //submitForm.setSize(100, 20);
            //submitForm.setLocation(100, 250);
            //submitForm.addActionListener(this);
            cp.add(submitForm);
        }
        public static void setDefaultLayout(){
            // Set default parameters
            JFrame cp  = new JFrame("Create Profile");
            
            /*
            JLabel title = new JLabel("asdf");
            title.setFont(new Font("Arial", Font.PLAIN, 15));
            title.setHorizontalAlignment(JLabel.CENTER);
            title.setVerticalAlignment(JLabel.CENTER);
            cp.add(title);
            */

            JPanel p = new JPanel();
            GridLayout layout = new GridLayout(0, 2, 2, 2);
            p.setBorder(new EmptyBorder(15, 15, 15, 15));
            p.setLayout(layout);
            createPatientProf(p);
            cp.add(p);
            

            //createPatientProf(cp);
            //createMedCond(cp);
            back(p);
            submit(p);
            
            cp.setSize(300, 400);
            //cp.setLayout(null);
            cp.setVisible(true);
            cp.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
