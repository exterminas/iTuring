/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ituring;

import javax.swing.SwingUtilities;

/**
 *
 * @author Michabook
 */
public class ITuring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
        
        
        
        
        //Program prog = new Program();
        
       // prog.add(new Rule("s0", "0", "s0", "R"));
       // prog.add(new Rule("s0", "1", "s1", "R"));
       // prog.add(new Rule("s1", "0", "s2", "1"));
       // prog.add(new Rule("s1", "1", "s1", "R"));
       // prog.add(new Rule("s2", "0", "s3", "R"));
       // prog.add(new Rule("s2", "1", "s2", "L"));
        
       // TuringMachine machine = new TuringMachine(prog);
        
       // Band band = new Band();
       // band.put(4, "1");
       // band.put(5, "1");
       // band.put(6, "1");
       // band.put(7, "1");
        
       // Configuration conf = new Configuration("s0", band, 2);
        
       // machine.runToEnd(conf);
        
    }
    
}
