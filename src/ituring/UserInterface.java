/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ituring;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author Michael
 */
class UserInterface implements Runnable  {

    private JFrame frame;
    private ProgramState programState;

    @Override
    public void run()  {
        //create a frame

        frame = new JFrame("ITuring");
        frame.setPreferredSize(new Dimension(1024, 768));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        programState = new ProgramState();

        createComponents(frame.getContentPane(), programState);

        //Once the frame is complete it is being displayed
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container contentPane, ProgramState programState) {
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JLabel rulesLabel = new JLabel("Current Program", SwingConstants.CENTER);
        JLabel outputLabel = new JLabel("Output", SwingConstants.CENTER);

        JTextArea rulesOutput = new JTextArea(programState.getProg() + "");
        rulesOutput.setEnabled(false);
        rulesOutput.setFont(rulesOutput.getFont().deriveFont(18f));

        
        
        JTextArea output = new JTextArea("Initial Band: \n");
        
        output.append(this.programState.getBand().toString());
        

        output.setEnabled(false);
        output.setFont(output.getFont().deriveFont(18f));
        JScrollPane scroll = new JScrollPane(output);

        JButton addRule = new JButton("Add Program Rule");
        JButton confButton = new JButton("Change Start Configuration");
        JButton bandButton = new JButton("Modify Band");
        JButton goButton = new JButton("Run Program");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(rulesLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(outputLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.gridwidth = 1;
        constraints.weightx = 0.9;
        constraints.weighty = 0.9;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(rulesOutput, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.gridwidth = 1;
        constraints.weightx = 0.9;
        constraints.weighty = 0.9;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(scroll, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(addRule, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(confButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(bandButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(goButton, constraints);

        AddButtonEvent addWatch = new AddButtonEvent(programState, rulesOutput);
        addRule.addActionListener(addWatch);

        BandButton bandWatch = new BandButton(programState, output);
        bandButton.addActionListener(bandWatch);

        RunButton runButton = new RunButton(programState, output);
        goButton.addActionListener(runButton);

        ConfButton confEvent = new ConfButton(programState, output);
        confButton.addActionListener(confEvent);

    }

}
