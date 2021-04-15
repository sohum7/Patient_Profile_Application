import java.awt.Font;
import javax.swing.*;

public class DisplayAllProfilesGUI {
    final int fontSize = 16;
    final String font = "Arial";
    JLabel adminid;
    JTextField tadminid;

    public void getAccountInfo(JPanel p){
        this.adminid = new JLabel("Admin ID: ");
        this.adminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.adminid);
        this.tadminid = new JTextField();
        this.tadminid.setFont(new Font(font, Font.PLAIN, fontSize));
        p.add(this.tadminid);
    }
}
