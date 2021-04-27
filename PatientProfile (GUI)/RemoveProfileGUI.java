import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

// Remove Profile GUI module
//      Provides a GUI to the 'remove profile' functionality in the GUI module
public class RemoveProfileGUI {
    // Basic attributes
    final int fontSize = 16;
    final String font = "Arial";
    JLabel adminid, lname;
    JTextField tadminid, tlname;

    // 'Remove Profile' form
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
    // 'Remove Profile' form with a predefined layout
    public static void setDefaultLayout(JFrame up, JPanel p){
        // Set default parameters
        up.setTitle("Remove Profile");
        p.setBorder(new EmptyBorder(15, 15, 15, 15));

        GridLayout layout = new GridLayout(0, 2, 2, 2);
        p.setLayout(layout);
    }
    // if 'remove profile' successfully
    public boolean removeProfile(String adminID, String lname){
        return true;
    }
}
