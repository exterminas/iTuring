/*

This class represents the band of a Turing Machine. 
Obviously it is not infinite in one direction. Instead, if the value of a field
is requested, but which has not previously been set, the band will return a 
default value of 0 or 1. 

 */
package ituring;

import java.util.HashMap;


public class Band {

    private HashMap<Integer, String> list;
    private Boolean defaultZero;
    private Integer curPos;

    public Band() {
        this.list = new HashMap<Integer, String>();
        this.defaultZero = true;
        this.curPos = 0;

    }

    public void put(Integer num, String input) {

        if (num >= 0) {

            this.list.put(num, input);
        }
    }

    public String get(Integer num) {
        if (this.list.containsKey(num)) {
            return list.get(num);
        } else {

            if (this.defaultZero) {
                this.list.put(num, "0");
                return list.get(num);
            } else {
                this.put(num, "1");
                return list.get(num);
            }

        }

    }

    @Override
    public String toString() {
        Integer num = 0;
        String result = "";

        if (this.curPos <= 20) {

            while (num <= 20) {

                if (!(num == curPos)) {
                    result = result + " | " + this.get(num);

                    num++;
                } else {
                    result = result + " | " + "<" + this.get(num) + ">";
                    num++;
                }
            }

            result = result + " |...|" + " Current Position: " + curPos;
            return result;

        } else {
            
            num = 1;
            result = "<" + this.get(curPos) + ">";
            
            while (num <= 11) {
                result = this.get(this.curPos-num) + " | " + result + " | " + this.get(this.curPos+num) ;
                num++;
            }
            
            result = "|...| " + result + " |...|" + " Current Position: " + curPos;
            return result;
        }
    }

    public HashMap<Integer, String> getList() {
        return list;
    }

    public void setList(HashMap<Integer, String> list) {
        this.list = list;
    }

    public Boolean compareToBand(Band band2) {
        Integer num = 0;

        while (num < 100) {
            if (!(this.get(num).equals(band2.get(num)))) {

                return false;
            }
            num++;

        }

        return true;
    }

    public Band getCopy() {
        Band newBand = new Band();
        newBand.setList(this.list);
        newBand.setDefaultZero(this.defaultZero);
        newBand.setCurPos(curPos);
        return newBand;

    }

    public Boolean getDefaultZero() {
        return defaultZero;
    }

    public void setDefaultZero(Boolean defaultZero) {
        this.defaultZero = defaultZero;
    }

    public Integer getCurPos() {
        return curPos;
    }

    public void setCurPos(Integer curPos) {
        this.curPos = curPos;
    }

}
