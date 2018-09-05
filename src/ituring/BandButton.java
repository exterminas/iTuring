/*
This class is for the button to open the GUI window that's used to customize the
band. 
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
public class BandButton implements ActionListener {

    private ProgramState programState;
    private JTextArea bandOutput;
    private Boolean windowOpen;
    private JFrame frame;

    public BandButton(ProgramState programState, JTextArea bandOutput) {
        this.programState = programState;
        this.bandOutput = bandOutput;

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

        JLabel defaultLabel = new JLabel("Default entry:");
        JLabel exceptionLabel = new JLabel("Exceptions:");

        JTextArea defaultArea = new JTextArea(1, 1);
        defaultArea.setColumns(0);
        defaultArea.setLineWrap(true);
        defaultArea.setWrapStyleWord(true);
        
        JTextArea exceptionArea = new JTextArea(1, 1);
        exceptionArea.setColumns(0);
        exceptionArea.setLineWrap(true);
        exceptionArea.setWrapStyleWord(true);


        JLabel outputLabel = new JLabel("Please enter parameters");

        JButton changeBand = new JButton("Change Band");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(defaultLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(defaultArea, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(exceptionLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        contentPane.add(exceptionArea, constraints);

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
        contentPane.add(changeBand, constraints);
        
        ChangeBandEvent bandEv = new ChangeBandEvent(programState, defaultArea, bandOutput, exceptionArea, outputLabel);
        changeBand.addActionListener(bandEv);

    }
}
