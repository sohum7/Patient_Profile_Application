import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Display Profile GUI module
//      Provides a GUI to the 'Display Profile' functionality in the GUI module
public class DisplayProfileGUI {
    // Basic attributes
    final int fontSize = 16;
    final String font = "Arial";
    JLabel adminid, lname;
    JTextField tadminid, tlname;

    // 'Display Profile' form
    // obtains the adminID and last name of the profile
    public void getAccountInfo(JPanel p){
        this.adminid = new JLabel("Admin ID: ");
        this.adminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.adminid);
        this.tadminid = new JTextField();
        this.tadminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.tadminid);

        this.lname = new JLabel("Last name: ");
        this.lname.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.lname);
        this.tlname = new JTextField();
        this.tlname.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.tlname);
    }
    // 'display profile''s form GUI
    public void displayProfile(JPanel p, PatientProf pat){
        JLabel adminid = new JLabel("Admin ID: ");
        adminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(adminid);
        tadminid = new JTextField(pat.getadminID());
        tadminid.setEditable(false);
        tadminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(tadminid);

        JLabel fname = new JLabel("First name: ");
        fname.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(fname);
        JTextField tfname = new JTextField(pat.getFirstName());
        tfname.setEditable(false);
        tfname.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(tfname);

        JLabel lname = new JLabel("Last name: ");
        lname.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(lname);
        JTextField tlname = new JTextField(pat.getLastName());
        tlname.setEditable(false);
        tlname.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(tlname);

        JLabel addr = new JLabel("Address: ");
        addr.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(addr);
        JTextField taddr = new JTextField(pat.getAddress());
        taddr.setEditable(false);
        taddr.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(taddr);

        JLabel phone = new JLabel("Phone: ");
        phone.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(phone);
        JTextField tphone = new JTextField(pat.getPhone());
        tphone.setEditable(false);
        tphone.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(tphone);

        JLabel copay = new JLabel("Copay: ");
        copay.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(copay);
        JTextField tcopay = new JTextField(Float.toString(pat.getCoPay()));
        tcopay.setEditable(false);
        tcopay.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(tcopay);

        JLabel insutype = new JLabel("Insurance Type: ");
        insutype.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(insutype);
        JTextField tinsutype = new JTextField(pat.getInsuType());
        tinsutype.setEditable(false);
        tinsutype.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(tinsutype);

        JLabel pattype = new JLabel("Patient Type: ");
        pattype.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(pattype);
        JTextField tpattype = new JTextField(pat.getPatientType());
        tpattype.setEditable(false);
        tpattype.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(tpattype);

        
        JLabel mdcontact = new JLabel("Medical Contact: ");
        mdcontact.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(mdcontact);
        JTextField tmdcontact = new JTextField(pat.getMedCondInfo().getmdContact());
        tmdcontact.setEditable(false);
        tmdcontact.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(tmdcontact);

        JLabel mdphone = new JLabel("Medical Phone: ");
        mdphone.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(mdphone);
        JTextField tmdphone = new JTextField(pat.getMedCondInfo().getmdPhone());
        tmdphone.setEditable(false);
        tmdphone.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(tmdphone);

        JLabel algtype = new JLabel("Allergy Type: ");
        algtype.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(algtype);
        JTextField talgtype = new JTextField(pat.getMedCondInfo().getAlgType());
        talgtype.setEditable(false);
        talgtype.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(talgtype);

        JLabel illtype = new JLabel("Illness Type: ");
        illtype.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(illtype);
        JTextField tilltype = new JTextField(pat.getMedCondInfo().getIllType());
        tilltype.setEditable(false);
        tilltype.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(tilltype);
    }
    // 'display profile''s form GUI with a predefined layout
    public static void setDefaultLayout(JFrame cp, JPanel p){
        // Set default parameters
        cp.setTitle("Display Profile");
        p.setBorder(new EmptyBorder(15, 15, 15, 15));

        GridLayout layout = new GridLayout(0, 2, 2, 2);
        p.setLayout(layout);
    }
}
