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
public class Configuration {
    private String state;
    private Band band;
    private Integer position;

    public Configuration(String state, Band band, Integer position) {
        this.state = state;
        this.band = band;
        this.position = position;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

public Boolean equalsConf(Configuration conf) {

    
    if (this.band.compareToBand(conf.getBand()) && this.position.equals(conf.getPosition()) && this.state.equals(conf.getState())) {
        System.out.println("Band 1: " + this.band);
        System.out.println("Band 2: " + conf.getBand());
        System.out.println("");
        System.out.println("Position 1: " + this.position);
        System.out.println("Position 2: " + conf.getPosition());
        System.out.println("");
        System.out.println("Zustand 1: " + this.state);
        System.out.println("Zustand 2: " + conf.getState());
        
        
        return true;
    }
    
    return false;
}

    @Override
    public String toString() {
    return "< " + this.state + " " + this.band + ">";

}
    
    public Configuration CreateCopy() {
        Configuration result = new Configuration(this.state, this.band, this.position);
        return result;
    }
    
    
}
