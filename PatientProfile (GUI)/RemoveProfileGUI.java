import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RemoveProfileGUI {
    final int fontSize = 16;
    final String font = "Arial";
    JLabel adminid, lname;
    JTextField tadminid, tlname;

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
    public static void setDefaultLayout(JFrame up, JPanel p){
        // Set default parameters
        up.setTitle("Update Profile");
        p.setBorder(new EmptyBorder(15, 15, 15, 15));

        GridLayout layout = new GridLayout(0, 2, 2, 2);
        p.setLayout(layout);
    }

    public boolean removeProfile(String adminID, String lname){
        return true;
    }
}
