/*
represents a rule for the program of a Turing Machine. Rules consist of the 
following:
    Current State: the machine needs to be in this state for the rule to apply
    Input: the machine needs to read this on the band to apply the rule
    new state: the machine switches into this state when applying the rule
    action: the machine performs this action when applying the rule
 */
package ituring;


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
    
    @Override
    public String toString() {
        return "< " + curState + ", " + input + ", " + newState + ", " + action + ">";
    
    }
    
    
}
