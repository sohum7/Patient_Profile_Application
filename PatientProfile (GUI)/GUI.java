import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

//// GUI ////
// Main module for the Integreated Patient System to run with an added GUI
public class GUI{
    // Main attributes
    PatientProfDB db;
    JFrame f;
    JPanel p;
    MainMenuGUI mmg;
    CreateProfileGUI cpg;
    RemoveProfileGUI rpg;
    UpdateProfileGUI upg;
    DisplayProfileGUI dpg;
    DisplayAllProfilesGUI dapg;

    // GUI constructor
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

    // Displays the 'main menu'
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
    // Displays the 'create profile' form
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
    // 'create profile' post submit click
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
    // 'display's porfile' form - only 1 profile
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
    // 'display's porfile' post submit click
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
            // Error
            displayProfileError(0);
        }
    }
    // 'removes profile' form
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
    // 'removes profile' post submit click
    public void rpProfileSubmit(GUI g, JFrame f, JPanel p){
        JButton submitForm = new JButton("Submit");
        submitForm.setFont(new Font("Arial", Font.PLAIN, 16));
        submitForm.setHorizontalAlignment(JLabel.CENTER);
        submitForm.setVerticalAlignment(JLabel.CENTER);
        submitForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(g.db.deleteProfile(g.rpg.tadminid.getText(), g.rpg.tlname.getText())){
                    JOptionPane.showMessageDialog(new JFrame(), "Successfully removed profile");
                    try { g.db.writeAllPatientProf(); }
                    catch (IOException e2) { JOptionPane.showMessageDialog(new JFrame(), "Database error"); }
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
    // 'update profiles' first form
    public void updateProfileSubmit(){
        PatientProf pat = null;

        try{ pat = this.db.findProfile(this.upg.tadminid.getText(), this.upg.tlname.getText());
        } catch(Exception e2){ }

        if(pat != null){
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
    // 'update profiles' second form
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
                        try { g.db.writeAllPatientProf(); }
                        catch (IOException e2) { JOptionPane.showMessageDialog(new JFrame(), "Database error"); }
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
    // 'display all profiles' form
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
    // 'update profiles' post submit click
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
    // 'display all profiles' post submit click
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
    // If there is a 'display profile' or 'display all profiles' ERROR display error message
    public static void displayProfileError(int type){
        String toPrint = "Error";
        if(type == 0){ toPrint = "Unable to locate Patient Profile"; }
        else if(type == 1) { toPrint = "No more profiles for current Admin user"; }
        JOptionPane.showMessageDialog(new JFrame(), toPrint);
    }
    // Removes all contents of the specified JFrame
    public static void setFrame(JFrame f){
        //f.removeAll();
        f.revalidate();
        f.repaint();
    }
    // Button to return to back to the 'main menu'
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
    // Button to display the next profile in 'display all profiles'
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
    // Button to display the contents of 'display profile' and 'display all profiles'
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
    // Button to display second 'update profiles' form
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
    // Button to display 'create profile' form
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
    // Button to choose main funcationality of program
    //      Create Profile
    //      Remove Profile
    //      Update Profile
    //      Display Profiles
    //      Display All Profiles
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
    
    // Main function for the GUI
    // Instantiates the GUI class and begins the session
    //      beginning at the Main Menu
    // Error otherwise
    public static void main(String[] args){
        try{
            GUI ips = new GUI();
            ips.mainMenu();

        }catch(Exception e){
            System.out.println("Error.\nPlease check your settings, files, and file structure and try again.");
        }
    }
}