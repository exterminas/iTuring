/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ituring;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Michael
 */
public class ChangeConfEvent implements ActionListener {

    private ProgramState state;
    private JTextArea stateInput;
    private JTextArea posInput;
    private JLabel output;
    private JTextArea band;

    public ChangeConfEvent(ProgramState state, JTextArea stateInput, JTextArea posInput, JLabel output, JTextArea band) {
        this.state = state;
        this.stateInput = stateInput;
        this.posInput = posInput;
        this.output = output;
        this.band = band;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (fieldsNotEmpty() && fieldsSane()) {
            this.state.getConf().setPosition(Integer.parseInt(posInput.getText()));
            this.state.getConf().setState(stateInput.getText());
            
            state.setStartPos(Integer.parseInt(posInput.getText()));
            state.setStartState(stateInput.getText());
            state.getBand().setCurPos(Integer.parseInt(posInput.getText()));
            band.append("\n + Current Band: \n" + state.getBand());
            
            this.output.setText("Start Configuration changed succesfully!");
        } else {
            this.output.setText("Please enter a proper state and position!");
        }
    }

    private boolean fieldsNotEmpty() {
        if (this.stateInput.getText().equals("") || this.stateInput.getText().equals(" ")) {
            return false;
        }

        if (this.posInput.getText().equals("") || this.posInput.getText().equals(" ")) {
            return false;
        }
        
        return true;
    }

    private boolean fieldsSane() {
        
        //Pattern num = Pattern.compile("[\\d]*");
        
        if (this.posInput.getText().matches("[\\d]*")) {
            System.out.println("input is proper number");
            return true;
        } else {
            this.output.setText("Please enter a correct starting position!");
            return false;
        }
        
        
        
    }

}
