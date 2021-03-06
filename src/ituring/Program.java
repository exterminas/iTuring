/*
Represents the program of a Turing Machine. A program is a list of Rules.
 */
package ituring;

import java.util.ArrayList;


public class Program {

    private ArrayList<Rule> list;

    public Program() {
        this.list = new ArrayList<Rule>();
    }

    public void add(Rule rule) {
        Boolean check = true;

        for (Rule bob : list) {
            if (bob.getCurState().equals(rule.getCurState()) && bob.getInput().equals(rule.getInput())) {
                check = false;
            }

        }

        if (check) {
            list.add(rule);

        } else {
            System.out.println("WARNING: Conflicting Rule detected.");
        }

    }

    public ArrayList<Rule> getList() {
        return list;
    }

    public String toString() {

        if (!this.list.isEmpty()) {

            String result = "";

            for (Rule rule : list) {
                result = result + rule + "\r\n";
            }
            return result;
        }
        
        return "No program rules yet.";

    }

}
