import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

// Main Menu GUI module
//      Provides a GUI to the 'Main Menu' funcationality in the GUI module
public class MainMenuGUI {
    // Main attributes
    JRadioButton cp, rp, up, dp, dap;
    ButtonGroup bg;

    // Constructor
    public MainMenuGUI(){ }
    
    // Main menu's GUI
    public void intPatSysMenu(JPanel p){
        JLabel ltitle = new JLabel("Integrated Patient System");
        ltitle.setFont(new Font("Arial", Font.PLAIN, 16));
        ltitle.setHorizontalAlignment(JLabel.CENTER);
        ltitle.setVerticalAlignment(JLabel.CENTER);

        this.cp = new JRadioButton("Create Profile");
        this.rp = new JRadioButton("Remove Profile");
        this.up = new JRadioButton("Update Profile");
        this.dp = new JRadioButton("Display Profile");
        this.dap = new JRadioButton("Display All Profiles");

        this.bg = new ButtonGroup();
        this.bg.add(this.cp); this.bg.add(this.rp); this.bg.add(this.up); this.bg.add(this.dp); this.bg.add(this.dap);
        
        p.add(ltitle);
        p.add(cp); p.add(rp); p.add(up); p.add(dp); p.add(dap);
    }
    // Main menu's GUI with a predefined layout
    public void setDefaultLayout(JFrame mm, JPanel p){
        // Set default parameters
        mm.setTitle("Integrated Patient Systems");
        p.setBorder(new EmptyBorder(15, 15, 15, 15));
        GridLayout layout = new GridLayout(0, 1, 2, 2);
        p.setLayout(layout);

        intPatSysMenu(p);
    }
}
