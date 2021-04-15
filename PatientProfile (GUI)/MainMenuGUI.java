import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class MainMenuGUI {
    JRadioButton cp, rp, up, dp, dap;
    ButtonGroup bg;

    public MainMenuGUI(){

    }
    
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
    public void setDefaultLayout(JFrame mm, JPanel p){
        // Set default parameters
        mm.setTitle("Integrated Patient Systems");
        p.setBorder(new EmptyBorder(15, 15, 15, 15));
        GridLayout layout = new GridLayout(0, 1, 2, 2);
        p.setLayout(layout);

        intPatSysMenu(p);
    }
    public void actionPerformed(ActionEvent e){
        // Action to be performed once event has occurred
        /*
        if(e.getSource() == this.select){
            if(this.cp.isSelected()){
                GUI.setState(GUI.states.CP_CLEARED);
            }
            if(this.rp.isSelected()){
                GUI.setState(GUI.states.RP_CLEARED);
            }
            if(this.up.isSelected()){
                GUI.setState(GUI.states.UP_CLEARED);
            }
            if(this.dp.isSelected()){
                GUI.setState(GUI.states.DP_CLEARED);
            }
            if(this.dap.isSelected()){
                GUI.setState(GUI.states.DAP_CLEARED);
            }
        }
        */
    }
}
