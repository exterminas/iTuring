/*
Implements the run button and allows it to execute and display the Turing
Machine as defined by the user.
 */
package ituring;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;


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
