import java.awt.Font;
import javax.swing.*;

// Display All Profiles GUI module
//      Provides a GUI to the 'Display All Profiles' functionality in the GUI module
public class DisplayAllProfilesGUI {
    // Basic attributes
    final int fontSize = 16;
    final String font = "Arial";
    JLabel adminid;
    JTextField tadminid;

    // 'Display All Profiles' form
    // obtains the adminID of the profiles
    public void getAccountInfo(JPanel p){
        this.adminid = new JLabel("Admin ID: ");
        this.adminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.adminid);
        this.tadminid = new JTextField();
        this.tadminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.tadminid);
    }
}
