/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ituring;

/**
 *
 * @author Michabook
 */
public class Rule {
    private String curState;
    private String input;
    private String newState;
    private String action;

    public Rule(String curState, String input, String newState, String action) {
        this.curState = curState;
        this.input = input;
        this.newState = newState;
        this.action = action;
    }

    public String getCurState() {
        return curState;
    }

    public void setCurState(String curState) {
        this.curState = curState;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    public Boolean matchesConfig(Configuration config) {
        if (this.curState.equals(config.getState()) && this.input.equals(config.getBand().get(config.getPosition()))) {
           // System.out.println("");
           // System.out.println("Rule:" + this + "matches" + config + "; since " + this.input + " is the same as " + config.getBand().get(config.getPosition()) + " and " + curState + " equals " + config.getState() );
            return true;
        }
    
        return false;
    }
    
    public String toString() {
        return "< " + curState + ", " + input + ", " + newState + ", " + action + ">";
    
    }
    
    
}
