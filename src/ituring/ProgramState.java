/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ituring;

/**
 *
 * @author Michael
 */
class ProgramState {
    private Band band;
    private Configuration conf;
    private Program prog;
    private String startState;
    private Integer startPos;

    public ProgramState() {
        this.band = new Band();
        this.prog = new Program();
        this.conf = new Configuration("s0", band, 0);
        this.startPos = 0;
        this.startState = "s0";

    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Configuration getConf() {
        return conf;
    }

    public void setConf(Configuration conf) {
        this.conf = conf;
    }

    public Program getProg() {
        return prog;
    }

    public void setProg(Program prog) {
        this.prog = prog;
    }

    public String getStartState() {
        return startState;
    }

    public void setStartState(String startState) {
        this.startState = startState;
    }

    public Integer getStartPos() {
        return startPos;
    }

    public void setStartPos(Integer startPos) {
        this.startPos = startPos;
    }
    
    
    
    
    
    
}
