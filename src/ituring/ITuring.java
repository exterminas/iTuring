//This program displays Turing Machines and their programs and executes them 
//step by step. The formating of the program rules is based off a course script
//at the EMU Greifswald


package ituring;

import javax.swing.SwingUtilities;


public class ITuring {


    public static void main(String[] args) {
        
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
        
        
    }
    
}
