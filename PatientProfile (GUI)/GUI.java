import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GUI{
    PatientProfDB db;
    JFrame f;
    JPanel p;
    MainMenuGUI mmg;
    CreateProfileGUI cpg       = new CreateProfileGUI();
    //RemoveProfileGUI dpg       = new RemoveProfileGUI();
    //UpdateProfileGUI upg       = new UpdateProfileGUI();
    //DisplayProfileGUI dpg      = new DisplayProfileGUI();
    //DisplayAllProfilesGUI dapg = new DisplayAllProfilesGUI();
    static states STATE = null;
    static enum states { MM, CP, RP, UP, DP, DAP,
        CP_DATA, CP_SUMBIT_SUCCESS, CP_SUBMIT_ERROR,
        RP_DATA, RP_SUMBIT_SUCCESS, RP_SUBMIT_ERROR,
        UP_DATA, UP_DISPLAY_PROF, UP_SUBMIT_ERROR,
        DP_DATA, DP_DISPLAY_PROF, DP_SUBMIT_ERROR,
        DAP_DATA, DP_DISPLAY_ALL_PROFS, DAP_SUBMIT_ERROR };

    static states getState(){ return STATE; }
    static void setState(states s){ STATE = s; }

    public GUI() throws ClassNotFoundException, IOException{
        this.db = new PatientProfDB("testFile2.txt");
        this.p = new JPanel();
        this.f = new JFrame();
        this.f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.mmg            = new MainMenuGUI();
        this.cpg       = new CreateProfileGUI();
        //this.dpg       = new RemoveProfileGUI();
        //this.upg       = new UpdateProfileGUI();
        //this.dpg      = new DisplayProfileGUI();
        //this.dapg = new DisplayAllProfilesGUI();
    }

    public void mainMenu(){
        this.f.remove(this.p);
        this.p = new JPanel();

        this.mmg.setDefaultLayout(this.f, this.p);
        select(this, this.f, this.p);
        this.f.setContentPane(this.p);
        this.f.setSize(300, 400);
        this.f.setVisible(true);

        this.f.revalidate();
        this.f.repaint();
    }
    public void createProfile(){
        this.f.remove(this.p);
        this.p = new JPanel();

        this.cpg.setDefaultLayout(f, p);
        cpSubmit(this, this.f, this.p);
        this.f.setContentPane(this.p);
        this.f.setSize(300, 400);
        this.f.setVisible(true);

        this.f.revalidate();
        this.f.repaint();
    }
    public void createProfileSubmit(PatientProf pat){
        if(this.db.insertNewProfile(pat)){
            // Success - Display some success dialog box
        } else {
            // Error - Display some error dialog box
        }
    }

    public static void clearFrame(JFrame f){
        f.removeAll();
        f.revalidate();
        f.repaint();
    }
    public static void backToMain(GUI g, JFrame f, JPanel p){
        JButton backForm = new JButton("Back/Cancel");
        backForm.setFont(new Font("Arial", Font.PLAIN, 16));
        backForm.setHorizontalAlignment(JLabel.CENTER);
        backForm.setVerticalAlignment(JLabel.CENTER);
        backForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.mainMenu();
            }
        });
        p.add(backForm);
    }
    public static void cpSubmit(GUI g, JFrame f, JPanel p){
        JButton submitForm = new JButton("Submit");
        submitForm.setFont(new Font("Arial", Font.PLAIN, 16));
        submitForm.setHorizontalAlignment(JLabel.CENTER);
        submitForm.setVerticalAlignment(JLabel.CENTER);
        submitForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // some db function
                g.createProfileSubmit(g.cpg.createPatientProf());
            }
        });
        p.add(submitForm);
    }
    public static void select(GUI g, JFrame f, JPanel p){
        JButton select = new JButton("Select");
        select.setFont(new Font("Arial", Font.PLAIN, 16));
        select.setHorizontalAlignment(JLabel.CENTER);
        select.setVerticalAlignment(JLabel.CENTER);
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // some db function
                if(g.mmg.cp.isSelected()){
                    g.createProfile();
                } else if(g.mmg.rp.isSelected()){
                    //removeProfile(f, p, (RemoveProfileGUI) funcList[2]);
                } else if(g.mmg.up.isSelected()){
                    //updateProfile(f, p, (UpdateProfileGUI) funcList[3]);
                } else if(g.mmg.dp.isSelected()){
                    //displayProfile(f, p, (displayProfileGUI) funcList[4]);
                } else if(g.mmg.dap.isSelected()){
                    //displayAllProfiles(f, p, (displayAllProfilesGUI) funcList[5]);
                }
                
            }
        });
        p.add(select);
    }

    public void actionPerformed(ActionEvent e){
        // Action to be performed once event has occurred

    }
    
    public static void main(String[] args){

        STATE = states.MM;
        
        //while(true){
            try{
                GUI ips = new GUI();
                ips.mainMenu();

            }catch(Exception e){

            }
        //}
    }
}