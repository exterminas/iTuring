/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ituring;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;

/**
 *
 * @author Michabook
 */
public class TuringMachine {

    private Program program;

    public TuringMachine(Program program) {
        this.program = program;
    }

    public void addToProgram(Rule rule) {
        this.program.add(rule);
    }

    public Configuration run(Configuration config, JTextArea display) {
        Configuration newConfig = config.CreateCopy();

        Boolean foundARule = false;

        for (Rule rule : program.getList()) {
            if (rule.matchesConfig(config)) {
                foundARule = true;
                display.append("\n\n" + rule);

                if (rule.getAction().equals("1")) {
                    Band newBand = config.getBand().getCopy();
                    newBand.put(config.getPosition(), "1");

                    newConfig.setBand(newBand);
                    newConfig.setState(rule.getNewState());
                   display.append("\n\n" + "Next Configuration: ");
                   display.append("\n\n" + newConfig);

                    return newConfig;

                } else if (rule.getAction().equals("0")) {
                    Band newBand = config.getBand().getCopy();
                    newBand.put(config.getPosition(), "0");

                    newConfig.setBand(newBand);
                    newConfig.setState(rule.getNewState());
                    display.append("\n\n" + "Next Configuration: ");
                    display.append("\n\n" + newConfig);
                    return newConfig;

                } else if (rule.getAction().equals("R")) {

                    newConfig.setPosition(config.getPosition() + 1);
                    newConfig.setState(rule.getNewState());

                    Band newBand = config.getBand().getCopy();
                    newBand.setCurPos(newBand.getCurPos() + 1);
                    newConfig.setBand(newBand);

                    display.append("\n\n" + "Next Configuration: ");
                    display.append("\n\n" + newConfig);
                    return newConfig;

                } else if (rule.getAction().equals("L")) {
                    if (!config.getPosition().equals(0)) {

                        newConfig.setPosition(config.getPosition() - 1);
                        newConfig.setState(rule.getNewState());

                        Band newBand = config.getBand().getCopy();
                        newBand.setCurPos(newBand.getCurPos() - 1);
                        newConfig.setBand(newBand);

                        display.append("\n\n" + "Next Configuration: ");
                        display.append("\n\n" + newConfig);
                        return newConfig;

                    }

                }

            }

        }

        if (!foundARule) {
            System.out.println("No more rules fit.");
            return config;

        }

        display.append("\n\n" + "Next Configuration: ");
        display.append("\n\n" + newConfig);
        return newConfig;
    }

    public void runToEnd(Configuration conf, JTextArea display) {
        display.append("\n\n" + "Start Configuration: ");
        display.append("\n\n" + conf);
        Configuration start = conf;
        Configuration next = this.run(conf, display);
        Configuration cur = next;
        Integer count = 0;

        while (!(start.equalsConf(next)) && count < 100) {

            count++;
            start = next;
            next = run(start, display);
            cur = next;
        }

        if (count >= 100) {
            display.append("\n\n" + "WARNING: OVER HUNDERD STEPS. MOST LIKELY INFINITE LOOP");
            display.append("\n\n" + "Last Configuration:");
            display.append("\n\n" + cur);

        }

        if (start.equalsConf(next)) {
            display.append("\n\n" + "End Configuration:");
            display.append("\n\n" + cur);

        }

    }


}
