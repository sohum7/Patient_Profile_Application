import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Create Profile GUI module
//      Provides a GUI to the 'create profile' funcationality in the GUI module
public class CreateProfileGUI {

    // Basic attributes
    JLabel adminid,fname,lname,addr,phone,copay,insutype,pattype;
    JLabel mdcontact,mdphone,algtype,illtype;

    JTextField tadminid,tfname,tlname,taddr,tphone,tcopay;
    JComboBox<String> tinsutype,tpattype;
    JTextField tmdcontact,tmdphone;
    JComboBox<String> talgtype,tilltype;

    JButton backForm, submitForm;

    // Styling attributes
    final int fontSize = 16;
    final String font = "Arial";
    int deltaY = 20;
    int y = 20;
    int x = 10;
    int xWidth = 100;
    int yWidth = 30;
    int txWidth = 100;
    int tyWidth = 20;
    int colSpace = 120;

    // Constructor
    // Left empty
    public CreateProfileGUI(){ }
    // 'create profile' Patient Profile form GUI
    public void createPatientProf(JPanel cp){

        this.adminid = new JLabel("Admin ID: ");
        this.adminid.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.adminid);
        tadminid = new JTextField();
        this.tadminid.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.tadminid);

        this.fname = new JLabel("First name: ");
        this.fname.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.fname);
        this.tfname = new JTextField();
        this.tfname.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.tfname);

        this.lname = new JLabel("Last name: ");
        this.lname.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.lname);
        this.tlname = new JTextField();
        this.tlname.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.tlname);

        this.addr = new JLabel("Address: ");
        this.addr.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.addr);
        this.taddr = new JTextField();
        this.taddr.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.taddr);

        this.phone = new JLabel("Phone: ");
        this.phone.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.phone);
        this.tphone = new JTextField();
        this.tphone.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.tphone);

        this.copay = new JLabel("Copay: ");
        this.copay.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.copay);
        this.tcopay = new JTextField();
        this.tcopay.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.tcopay);

        this.insutype = new JLabel("Insurance Type: ");
        this.insutype.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.insutype);
        this.tinsutype = new JComboBox(PatientProf.getInsuTypes());
        this.tinsutype.setFont(new Font(font, Font.PLAIN, fontSize));
        this.tinsutype.setSelectedIndex(0);
        cp.add(this.tinsutype);

        this.pattype = new JLabel("Patient Type: ");
        this.pattype.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.pattype);
        this.tpattype = new JComboBox(PatientProf.getPatTypes());
        this.tpattype.setFont(new Font(font, Font.PLAIN, fontSize));
        this.tpattype.setSelectedIndex(0);
        cp.add(this.tpattype);

    }
    // 'create profile' Medical Conditions form GUI
    public void createMedCond(JPanel cp){

        this.mdcontact = new JLabel("Medical Contact: ");
        this.mdcontact.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.mdcontact);
        this.tmdcontact = new JTextField();
        this.tmdcontact.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.tmdcontact);

        this.mdphone = new JLabel("Medical Phone: ");
        this.mdphone.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.mdphone);
        this.tmdphone = new JTextField();
        this.tmdphone.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.tmdphone);

        this.algtype = new JLabel("Allergy Type: ");
        this.algtype.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.algtype);
        this.talgtype = new JComboBox(MedCond.getAlgTypes());
        this.talgtype.setFont(new Font(font, Font.PLAIN, fontSize));
        this.talgtype.setSelectedIndex(0);
        cp.add(this.talgtype);

        this.illtype = new JLabel("Illness Type: ");
        this.illtype.setFont(new Font(font, Font.PLAIN, fontSize));
        cp.add(this.illtype);
        this.tilltype = new JComboBox(MedCond.getIllTypes());
        this.tilltype.setFont(new Font(font, Font.PLAIN, fontSize));
        this.tilltype.setSelectedIndex(0);
        cp.add(this.tilltype);
    }
    // Set the default form layout for 'create profile'
    public void setDefaultLayout(JFrame cp, JPanel p){
        // Set default parameters
        cp.setTitle("Create Profile");
        p.setBorder(new EmptyBorder(15, 15, 15, 15));

        GridLayout layout = new GridLayout(0, 2, 2, 2);
        p.setLayout(layout);

        createPatientProf(p);
        createMedCond(p);
    }
    // Returns an instance of the PatientProf module
    public PatientProf createPatientProfile(){
        return new PatientProf(this.tadminid.getText(), this.tfname.getText(), this.tlname.getText(), this.taddr.getText(),
        this.tphone.getText(), Float.parseFloat(this.tcopay.getText()), (String) this.tinsutype.getSelectedItem(), (String) this.tpattype.getSelectedItem(),
        new MedCond(this.tmdcontact.getText(), this.tmdphone.getText(), (String) this.talgtype.getSelectedItem(), (String) this.tilltype.getSelectedItem()) );
    }
}
