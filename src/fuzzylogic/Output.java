/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

/**
 *
 * @author Husnayain
 */
public class Output {
    String linguistik;
    double value;
    
    public void setValue(double value){
        this.value = value;
    }
    
    public double getValue(double value){
        return this.value;
    }

    @Override
    public String toString() {
        return "Output{" + "linguistik=" + linguistik + ", value=" + value + '}';
    }
    

    
}
