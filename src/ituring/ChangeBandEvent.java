/*
This class checks inputs for potential changes to the band and executes them.
 */
package ituring;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Michael
 */
public class ChangeBandEvent implements ActionListener {

    private ProgramState state;
    private JTextArea inputDefault;
    private JTextArea bandOutput;
    private JTextArea inputExceptions;
    private JLabel messageOutput;

    public ChangeBandEvent(ProgramState state, JTextArea inputDefault, JTextArea bandOutput, JTextArea inputExceptions, JLabel messageOutput) {
        this.inputDefault = inputDefault;
        this.bandOutput = bandOutput;
        this.inputExceptions = inputExceptions;
        this.messageOutput = messageOutput;
        this.state = state;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        sanitizeInputs();
        checkInputs();
        resetBand();
        modifyBand();
        modifyDisplay();

    }

    private void sanitizeInputs() {
        deleteBlanks(inputDefault);
        deleteBlanks(inputExceptions);
    }

    private void deleteBlanks(JTextArea input) {
        input.setText(removeBlanks(input.getText()));

    }

    private String removeBlanks(String text) {

        System.out.println("removing blanks");

        if (text.length() > 1) {
            if (text.substring(text.length() - 1).equals(" ")) {
                // System.out.println("leerzeichen am Ende");
                return removeBlanks(text.substring(0, text.length() - 1));
            } else if (text.substring(0, 1).equals(" ")) {
                return removeBlanks(text.substring(1, text.length()));
            } else {
                return text;
            }
        }
        return text;
    }

    private void checkInputs() {
        if (checkDefault()) {
            if (checkExceptions()) {

            }

        } else {
            this.messageOutput.setText("Please enter 0 or 1 as default entry of the band.");

        }

    }

    private Boolean checkDefault() {
        if (!(this.inputDefault.getText().equals("0") || this.inputDefault.getText().equals("1"))) {
            return false;
        }

        return true;

    }

    private boolean checkExceptions() {
        Pattern pattern = Pattern.compile("[[0123456789]* ]*");
        Matcher m = pattern.matcher(this.inputExceptions.getText());

        if (m.matches()) {
            System.out.println("Input Exceptions is nur eine Sequenz aus Zahlen");

            return true;

        }

        System.out.println("Input Exceptions is falsch");
        return false;
    }

    private void modifyBand() {

        //modify the default entry of the band
        if (this.inputDefault.getText().equals("0")) {
            state.getBand().setDefaultZero(true);
        } else if (this.inputDefault.getText().equals("1")) {
            state.getBand().setDefaultZero(false);
        }

        //read input as integers
        ArrayList<Integer> fields = new ArrayList<Integer>();
        String[] parts = this.inputExceptions.getText().split(" ");

        for (String part : parts) {
            fields.add(Integer.parseInt(part));
        }

        for (Integer field : fields) {

            if (this.state.getBand().getDefaultZero()) {
                this.state.getBand().put(field, "1");
            } else if (!this.state.getBand().getDefaultZero()) {
                this.state.getBand().put(field, "0");
            }
        }

    }

    private void modifyDisplay() {
        this.bandOutput.setText(this.state.getBand().toString());
    }

    private void resetBand() {
        this.state.setBand(new Band());
    }

    
    
}
