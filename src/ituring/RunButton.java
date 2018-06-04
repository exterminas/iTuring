/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ituring;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

/**
 *
 * @author Michael
 */
public class RunButton implements ActionListener {
    private ProgramState state;
    private JTextArea output;
    

    public RunButton(ProgramState state, JTextArea output) {
        this.state = state;
        this.output = output;
    }


    
    
            
    @Override
    public void actionPerformed(ActionEvent ae) {
       if (hasProgram()) {
           TuringMachine machine = new TuringMachine(this.state.getProg());
           Configuration conf = new Configuration(this.state.getStartState(), this.state.getBand(), this.state.getStartPos());
           
           System.out.println(conf);
           
           machine.runToEnd(conf, output);
           
       } else {
           printNoProgramError();
       }
    }

    private boolean hasProgram() {
        if (state.getProg().getList().isEmpty()) {
            return false;
        }
        
        return true;
    }

    private void printNoProgramError() {
        this.output.setText(this.output.getText() + "\n\n ERROR: Please enter at least one program rule before running.");
    }

 
    
}
