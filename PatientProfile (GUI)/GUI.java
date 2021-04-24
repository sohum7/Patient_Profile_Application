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
    RemoveProfileGUI rpg;
    UpdateProfileGUI upg;
    DisplayProfileGUI dpg;
    DisplayAllProfilesGUI dapg;
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
        this.rpg       = new RemoveProfileGUI();
        this.upg       = new UpdateProfileGUI();
        this.dpg      = new DisplayProfileGUI();
        this.dapg = new DisplayAllProfilesGUI();
    }

    public void mainMenu(){
        this.f.remove(this.p);
        this.p = new JPanel();

        this.mmg.setDefaultLayout(this.f, this.p);
        select(this, this.f, this.p);
        this.f.setContentPane(this.p);
        this.f.setSize(300, 400);
        this.f.setVisible(true);

        setFrame(this.f);
    }
    public void createProfile(){
        this.f.remove(this.p);
        this.p = new JPanel();

        this.cpg.setDefaultLayout(f, p);
        cpSubmit(this, this.f, this.p);
        backToMain(this, this.f, this.p);
        this.f.setContentPane(this.p);
        this.f.setSize(300, 400);
        this.f.setVisible(true);

        setFrame(this.f);
    }
    public void createProfileSubmit(PatientProf pat){
        if(this.db.insertNewProfile(pat)){
            // Success - Display some success dialog box
            JOptionPane.showMessageDialog(new JFrame(), "Successfully created profile");
            try { this.db.writeAllPatientProf(); }
            catch (IOException e) { JOptionPane.showMessageDialog(new JFrame(), "Database error"); }
            this.mainMenu();
        } else {
            // Error - Display some error dialog box
            JOptionPane.showMessageDialog(new JFrame(), "Unable to create profile");
        }
    }
    public void displayProfile(){
        this.f.remove(this.p);
        this.p = new JPanel();
        DisplayProfileGUI.setDefaultLayout(this.f, this.p);
        
        this.dpg.getAccountInfo(p);
        dpSubmit(this, this.f, this.p, 0);
        backToMain(this, this.f, this.p);

        this.f.setContentPane(this.p);
        this.f.setSize(300, 400);
        this.f.setVisible(true);

        setFrame(this.f);
    }

    public void displayProfileSubmit(){
        PatientProf pat = null;

        try{ pat = this.db.findProfile(this.dpg.tadminid.getText(), this.dpg.tlname.getText()); }
        catch(Exception e2){ /*  */ }

        if(pat != null){
            // Success - Display some success dialog box
            this.f.remove(this.p);
            this.p = new JPanel();
            DisplayProfileGUI.setDefaultLayout(this.f, this.p);

            this.dpg.displayProfile(p, pat);
            backToMain(this, this.f, this.p);
            this.f.setContentPane(this.p);
            this.f.setSize(300, 400);
            this.f.setVisible(true);

            setFrame(this.f);
        } else {
            // Error - Display some error dialog box
            displayProfileError(0);
            //backToMain(this, this.f, this.p);
        }
    }
    public void removeProfile(){
        this.f.remove(this.p);
        this.p = new JPanel();
        RemoveProfileGUI.setDefaultLayout(this.f, this.p);

        this.rpg.getAccountInfo(p);
        rpProfileSubmit(this, this.f, this.p);
        backToMain(this, this.f, this.p);

        this.f.setContentPane(this.p);
        this.f.setSize(300, 400);
        this.f.setVisible(true);

        setFrame(this.f);
    }

    public void rpProfileSubmit(GUI g, JFrame f, JPanel p){
        JButton submitForm = new JButton("Submit");
        submitForm.setFont(new Font("Arial", Font.PLAIN, 16));
        submitForm.setHorizontalAlignment(JLabel.CENTER);
        submitForm.setVerticalAlignment(JLabel.CENTER);
        submitForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(g.rpg.adminid.getText());
                //System.out.println(g.rpg.lname.getText());
                if(g.db.deleteProfile(g.rpg.tadminid.getText(), g.rpg.tlname.getText())){
                    JOptionPane.showMessageDialog(new JFrame(), "Successfully removed profile");

                    g.mainMenu();
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "ERROR: Could not remove profile");

                    g.mainMenu();
                }
            }
        });
        p.add(submitForm);
    }
    public void updateProfileSubmit(){
        PatientProf pat = null;

        try{ pat = this.db.findProfile(this.upg.tadminid.getText(), this.upg.tlname.getText());
        } catch(Exception e2){

        }
        if(pat != null){
            //System.out.println("What?");
            this.f.remove(this.p);
            this.p = new JPanel();

            this.upg.setDefaultLayout(this.f, this.p);
            this.upg.updateProfile(this.p,pat, (String)this.upg.fieldb.getSelectedItem(),this.upg.tadminid.getText(), this.upg.tlname.getText());
            updateFieldSubmit(this, this.f, this.p, pat,(String)this.upg.fieldb.getSelectedItem(), this.upg);
            backToMain(this, this.f, this.p);
            this.f.setContentPane(this.p);
            this.f.setSize(300, 400);
            this.f.setVisible(true);

        }
        else{
            displayProfileError(0);
        }
    }
    public void updateFieldSubmit(GUI g, JFrame f, JPanel p, PatientProf pat, String toChange, UpdateProfileGUI u){
        JButton submitForm = new JButton("Update");
        submitForm.setFont(new Font("Arial", Font.PLAIN, 16));
        submitForm.setHorizontalAlignment(JLabel.CENTER);
        submitForm.setVerticalAlignment(JLabel.CENTER);
        submitForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(toChange.equals("Insurance Type") ||toChange.equals("Patient Type") || toChange.equals("Allergy Type") || toChange.equals("Illness Type")){
                    if(UpdateProfileGUI.actuallyUpdate(pat, toChange, (String)g.upg.changebox.getSelectedItem())){
                        // Success - Display some success dialog box
                        JOptionPane.showMessageDialog(new JFrame(), "Successfully updated profile");

                        g.mainMenu();
                    }
                    else{
                        // Error - Display some error dialog box
                        JOptionPane.showMessageDialog(new JFrame(), "Unable to update profile");
                    }
                }
                else{
                    if(g.upg.actuallyUpdate(pat, toChange, g.upg.tfield.getText())){
                        // Success - Display some success dialog box
                        JOptionPane.showMessageDialog(new JFrame(), "Successfully updated profile");

                        g.mainMenu();
                    }
                    else {
                        // Error - Display some error dialog box
                        JOptionPane.showMessageDialog(new JFrame(), "Unable to update profile");
                    }
                }
            }
        });
        p.add(submitForm);


    }
    public void displayAllProfiles(){
        // obtain user info
        // add submit button
        this.f.remove(this.p);
        this.p = new JPanel();
        DisplayProfileGUI.setDefaultLayout(this.f, this.p);
        
        this.dapg.getAccountInfo(this.p);
        dpSubmit(this, this.f, this.p, 1);
        backToMain(this, this.f, this.p);

        this.f.setContentPane(this.p);
        this.f.setSize(300, 400);
        this.f.setVisible(true);
        setFrame(this.f);

    }
    public void updateProfile(){
        this.f.remove(this.p);
        this.p = new JPanel();

        this.upg.setDefaultLayout(this.f, this.p);
        this.upg.whichProfile(this.p);
        upSubmit(this, this.f, this.p);
        backToMain(this, this.f, this.p);

        this.f.setContentPane(this.p);
        this.f.setSize(300, 400);
        this.f.setVisible(true);
        setFrame(this.f);


    }
    public void displayAllProfilesSubmit(boolean first){
        // if profile exists for the adminID
        //      display first profile
        //      add next button
        //          check if another profile exists ...
        // else profile does not exist for the adminID
        //      display error message window

        PatientProf pat = null;

        if(first){ pat = this.db.findFirstProfile(this.dapg.tadminid.getText()); }
        else{ pat = this.db.findNextProfile(); }
        
        if(pat != null){
            this.f.remove(this.p);
            this.p = new JPanel();
            DisplayProfileGUI.setDefaultLayout(this.f, this.p);

            this.dpg.displayProfile(this.p, pat);
            dpNext(this, this.f, this.p);

            this.f.setContentPane(this.p);
            this.f.setSize(300, 400);
            this.f.setVisible(true);
            setFrame(this.f);
        } else {
            if(first){ displayProfileError(0); }
            else{
                displayProfileError(1);
                this.mainMenu();
            }
        }
    }
    /*
    public void displayAllProfilesNext(){
        //  if another profiles exists
        //      display it
        //      add next button
        //  else
        //      let user know there are no more profiles
        this.f.remove(this.p);
        this.p = new JPanel();
        DisplayProfileGUI.setDefaultLayout(this.f, this.p);

        PatientProf pat = null;
        
        // db next profile function goes here

        this.f.setContentPane(this.p);
        this.f.setSize(300, 400);
        this.f.setVisible(true);
        setFrame(this.f);

    }
    */
    public static void displayProfileError(int type){
        String toPrint = "Error";
        if(type == 0){ toPrint = "Unable to locate Patient Profile"; }
        else if(type == 1) { toPrint = "No more profiles for current Admin user"; }
        JOptionPane.showMessageDialog(new JFrame(), toPrint);
    }
    public static void setFrame(JFrame f){
        //f.removeAll();
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
            public void actionPerformed(ActionEvent e) { g.mainMenu(); }
        });
        p.add(backForm);
    }
    public static void dpNext(GUI g, JFrame f, JPanel p){
        JButton nextForm = new JButton("Next");
        nextForm.setFont(new Font("Arial", Font.PLAIN, 16));
        nextForm.setHorizontalAlignment(JLabel.CENTER);
        nextForm.setVerticalAlignment(JLabel.CENTER);
        nextForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { g.displayAllProfilesSubmit(false); }
        });
        p.add(nextForm);

    }

    public static void dpSubmit(GUI g, JFrame f, JPanel p, int funcCallType){
        JButton submitForm = new JButton("Submit");
        submitForm.setFont(new Font("Arial", Font.PLAIN, 16));
        submitForm.setHorizontalAlignment(JLabel.CENTER);
        submitForm.setVerticalAlignment(JLabel.CENTER);
        submitForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { if(funcCallType == 0) { g.displayProfileSubmit(); }
                                                         else if(funcCallType == 1) { g.displayAllProfilesSubmit(true); }  }
        });
        p.add(submitForm);
    }
    public static void upSubmit(GUI g, JFrame f, JPanel p){
        JButton submitForm = new JButton("Find");
        submitForm.setFont(new Font("Arial", Font.PLAIN, 16));
        submitForm.setHorizontalAlignment(JLabel.CENTER);
        submitForm.setVerticalAlignment(JLabel.CENTER);
        submitForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { g.updateProfileSubmit();
            }
        });
        p.add(submitForm);
    }
    public static void cpSubmit(GUI g, JFrame f, JPanel p){
        JButton submitForm = new JButton("Submit");
        submitForm.setFont(new Font("Arial", Font.PLAIN, 16));
        submitForm.setHorizontalAlignment(JLabel.CENTER);
        submitForm.setVerticalAlignment(JLabel.CENTER);
        submitForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { g.createProfileSubmit(g.cpg.createPatientProfile()); }
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
                if(g.mmg.cp.isSelected()){
                    g.createProfile();
                } else if(g.mmg.rp.isSelected()){
                    g.removeProfile();
                } else if(g.mmg.up.isSelected()){
                    g.updateProfile();
                } else if(g.mmg.dp.isSelected()){
                    g.displayProfile();
                } else if(g.mmg.dap.isSelected()){
                    g.displayAllProfiles();
                }
                
            }
        });
        p.add(select);
    }

    public void actionPerformed(ActionEvent e){ /* Action to be performed once event has occurred */ }
    
    public static void main(String[] args){

        STATE = states.MM;

        try{
            GUI ips = new GUI();
            ips.mainMenu();

        }catch(Exception e){

        }
    }
}