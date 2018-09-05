/*
This class is for the button that opens the window to enter new program rules
 */
package ituring;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Michael
 */
public class AddButtonEvent implements ActionListener {

    private ProgramState programState;
    private JTextArea rulesOutput;
    private Boolean windowOpen;
    private JFrame frame;

    public AddButtonEvent(ProgramState programState, JTextArea rulesOutput) {
        this.programState = programState;
        this.rulesOutput = rulesOutput;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame = new JFrame("ITuring");
        frame.setPreferredSize(new Dimension(600, 384));
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container contentPane) {

        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JLabel inputLabel = new JLabel("Input:");
        JLabel inStateLabel = new JLabel("In State:");
        JLabel goToStateLabel = new JLabel("Go to State:");
        JLabel actionLabel = new JLabel("Action:");

        JTextArea inputArea = new JTextArea(1, 1);
        JTextArea inStateArea = new JTextArea(1,1);
        JTextArea goToStateArea = new JTextArea(1, 1);
        JTextArea actionArea = new JTextArea(1, 1);
        
        textConfig(inputArea);
        textConfig(inStateArea);
        textConfig(goToStateArea);
        textConfig(actionArea);

        JLabel outputLabel = new JLabel("Please enter a rule");

        JButton addRule = new JButton("Add Rule");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(inputLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(inputArea, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(inStateLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(inStateArea, constraints);

        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(goToStateLabel, constraints);

        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(goToStateArea, constraints);

        constraints.gridx = 6;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(actionLabel, constraints);

        constraints.gridx = 7;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(actionArea, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 8;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(outputLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 8;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(addRule, constraints);

        AddRuleEvent add = new AddRuleEvent(programState, outputLabel, inputArea, inStateArea, goToStateArea, actionArea, rulesOutput);
        addRule.addActionListener(add);

    }

    private void textConfig(JTextArea area) {
        area.setColumns(0);
        area.setRows(0);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        
    }

}
