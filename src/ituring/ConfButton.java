/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class ConfButton implements ActionListener {

    private ProgramState programState;
    private JFrame frame;
    private JTextArea band;

    public ConfButton(ProgramState programState, JTextArea band) {
        this.programState = programState;
        this.band = band;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame = new JFrame("ITuring");
        frame.setPreferredSize(new Dimension(512, 384));
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container contentPane) {
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JLabel positionLabel = new JLabel("Start Position:");
        JLabel stateLabel = new JLabel("Start State:");

        JTextArea positionArea = new JTextArea("Enter a Position");
        JTextArea stateArea = new JTextArea("Enter a State");


        JLabel outputLabel = new JLabel("Please enter parameters");

        JButton changeConf = new JButton("Change Start Configuration");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(positionLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(positionArea, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(stateLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(stateArea, constraints);

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
        contentPane.add(changeConf, constraints);
        
        ChangeConfEvent confEvent = new ChangeConfEvent(this.programState, stateArea, positionArea, outputLabel, band);
        changeConf.addActionListener(confEvent);

    }

}
