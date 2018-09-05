/*
This class checks the inputs for potential new rules and adds them to 
the program
 */
package ituring;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Michael
 */
public class AddRuleEvent implements ActionListener {

    private ProgramState programState;
    private JLabel output;
    private JTextArea input;
    private JTextArea inState;
    private JTextArea goToState;
    private JTextArea action;
    private JTextArea rulesOutput;

    public AddRuleEvent(ProgramState programState, JLabel output, JTextArea input, JTextArea inState, JTextArea goToState, JTextArea action, JTextArea rulesOutput) {
        this.programState = programState;
        this.output = output;
        this.input = input;
        this.inState = inState;
        this.goToState = goToState;
        this.action = action;
        this.rulesOutput = rulesOutput;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.output.setText("Please enter a rule.");

        sanitizeInputs();

        if (checkInput()) {

            if (checkProgram()) {

                Rule rule = new Rule(inState.getText(), input.getText(), goToState.getText(), action.getText());
                programState.getProg().add(rule);
                this.output.setText("Added rule: " + rule);

                rulesOutput.setText(programState.getProg() + "");
                rulesOutput.update(rulesOutput.getGraphics());
            }
            
            else {this.output.setText("This rule conflicts with the existing program!");}

        }

    }

    public Boolean checkInput() {
        if (this.input.getText().equals(" ") || this.input.getText().equals("")) {
            this.output.setText("Please enter a proper rule");

            return false;

        }

        if (this.inState.getText().equals(" ") || this.inState.getText().equals("")) {
            this.output.setText("Please enter a proper rule.");
            return false;

        }

        if (this.goToState.getText().equals(" ") || this.goToState.getText().equals("")) {
            this.output.setText("Please enter a proper rule.");
            return false;

        }

        if (this.action.getText().equals(" ") || this.action.getText().equals("")) {
            this.output.setText("Please enter a proper rule.");
            return false;

        }

        if (!(this.action.getText().equals("L") || this.action.getText().equals("R") || this.action.getText().equals("0") || this.action.getText().equals("1"))) {
            this.output.setText("Please enter a valid action command.");
            System.out.println("action command stimmt nicht");
            return false;

        }

        if (!(this.input.getText().equals("1") || this.input.getText().equals("0"))) {
            this.output.setText("Please enter a valid input.");
            System.out.println("input stimmt nicht");
            return false;

        }

        return true;
    }

    private void sanitizeInputs() {
        deleteBlanks(input);
        deleteBlanks(inState);
        deleteBlanks(goToState);
        deleteBlanks(action);

    }

    private void deleteBlanks(JTextArea input) {
        input.setText(removeBlanks(input.getText()));

    }

    private String removeBlanks(String text) {

        System.out.println("removing blanks");

        if (text.substring(text.length() - 1).equals(" ")) {
            System.out.println("leerzeichen am Ende");
            return removeBlanks(text.substring(0, text.length() - 1));
        } else if (text.substring(0, 1).equals(" ")) {
            return removeBlanks(text.substring(1, text.length()));
        } else {
            return text;
        }

    }

    private boolean checkProgram() {
        for (Rule rule : this.programState.getProg().getList()) {
            if (rule.getInput().equals(this.input.getText()) && rule.getCurState().equals(this.inState.getText())) {
                System.out.println("add button detected conflicting rule");
                return false;
                
            
            }
        
        
        }
        
        
        return true;
    }

}
