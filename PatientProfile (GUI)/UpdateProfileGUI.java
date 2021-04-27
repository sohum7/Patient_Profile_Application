import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Update Profile GUI module
//      Provides a GUI to the 'Update Profile' functionality in the GUI module
public class UpdateProfileGUI {
    // Basic attributes
    final int fontSize = 16;
    final String font = "Arial";
    JLabel adminid, lname, field, newinfo;
    JTextField tadminid, tlname, tfield, tnewinfo;
    JComboBox<String> fieldb;
    JComboBox<String> changebox;
    String[] fields = {"First Name", "Last Name", "Address", "Phone Number", "Copay", "Insurance Type", "Patient Type", "MD contact", "MD phone", "Allergy Type","Illness Type"};
    
    // Sets the layout for the 'Update profile' GUI
    public static void setDefaultLayout(JFrame up, JPanel p){
        // Set default parameters
        up.setTitle("Update Profile");
        p.setBorder(new EmptyBorder(15, 15, 15, 15));

        GridLayout layout = new GridLayout(0, 2, 2, 2);
        p.setLayout(layout);
    }
    // Obtain profile information such as adminID and last name
    public void whichProfile(JPanel p){
        this.adminid = new JLabel("Admin ID: ");
        this.adminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.adminid);
        this.tadminid = new JTextField();
        this.tadminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.tadminid);

        this.lname = new JLabel("Last Name: ");
        this.lname.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.lname);
        this.tlname = new JTextField();
        this.tlname.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.tlname);

        this.field = new JLabel("Field To Change: ");
        this.field.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.field);
        this.fieldb = new JComboBox(fields);
        this.fieldb.setFont(new Font(font, Font.PLAIN, fontSize));
        this.fieldb.setSelectedIndex(0);
        p.add(this.fieldb);
    }
    // 'Update Profile' second form GUI
    public void updateProfile(JPanel p, PatientProf pat, String toChange, String admn, String lnm){
        this.adminid = new JLabel("Admin ID: ");
        this.adminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.adminid);
        this.tadminid = new JTextField(admn);
        this.tadminid.setFont(new Font(font, Font.PLAIN, fontSize));
        this.tadminid.setEditable(false);
        p.add(this.tadminid);

        this.lname = new JLabel("Last Name: ");
        this.lname.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.lname);
        this.tlname = new JTextField(lnm);
        this.tlname.setFont(new Font(font, Font.PLAIN, fontSize));
        this.tlname.setEditable(false);
        p.add(this.tlname);

        this.field = new JLabel("New "+ toChange +": ");
        this.field.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.field);
        if(toChange.equals("Insurance Type") ||toChange.equals("Patient Type") || toChange.equals("Allergy Type") || toChange.equals("Illness Type")){
            if(toChange.equals("Insurance Type")){
                this.changebox = new JComboBox(PatientProf.getInsuTypes());
            }
            else if(toChange.equals("Patient Type")){
                this.changebox = new JComboBox(PatientProf.getPatTypes());
            }
            else if(toChange.equals("Allergy Type")){
                this.changebox = new JComboBox(MedCond.getAlgTypes());
            }
            else if(toChange.equals("Illness Type")){
                this.changebox = new JComboBox(MedCond.getIllTypes());
            }

            this.changebox.setFont(new Font(font, Font.PLAIN, fontSize));
            this.changebox.setSelectedIndex(0);
            p.add(this.changebox);
        }
        else {
            this.tfield = new JTextField();
            this.tfield.setFont(new Font(font, Font.PLAIN, fontSize));
            p.add(this.tfield);
        }
    }
    // 'Updates Profile' within database
    public static boolean actuallyUpdate(PatientProf pat, String field, String newinfo){
        if(field.equals("First Name")){
            pat.updateFirstName(newinfo);
            return true;
        }
        else if(field.equals("Last Name")){
            pat.updateLastName(newinfo);
            return true;
        }
        else if(field.equals("Address")){
            pat.updateAddress(newinfo);
            return true;
        }
        else if(field.equals("Phone Number")){
            pat.updatePhone(newinfo);
            return true;
        }
        else if(field.equals("Copay")){
            pat.updateCoPay(Float.parseFloat(newinfo));
            return true;
        }
        else if(field.equals("Insurance Type")){
            pat.updateInsuType(newinfo);
            return true;
        }
        else if(field.equals("Patient Type")){
            pat.updatePatientType(newinfo);
            return true;
        }
        else if(field.equals("MD contact")){
            pat.PupdatemdContact(newinfo);
            return true;
        }
        else if(field.equals("MD phone")){
            pat.PupdatemdPhone(newinfo);
            return true;
        }
        else if(field.equals("Allergy Type")){
            pat.PupdatemdAlgType(newinfo);
            return true;
        }
        else if(field.equals("Illness Type")){
            pat.PupdatemdIllType(newinfo);
            return true;
        }
        return false;
    }
}
