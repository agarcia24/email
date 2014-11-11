/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package optimizar;

/**
 *
 * @author lgarcia
 */
public class impuesto {
    String state;
    double rate, amt, base, points;
    public double calculate() {
        double calc;
        if ("TEXAS".equals(state)) {
            rate = 10;
            amt = base*rate;
            calc = 2.0*amt + base*1.05;
        } else if (("OHIO".equals(state)) || ("MAINE".equals(state))) {
            if ("OHIO".equals(state)) {
                rate = 12;
            } else {
                rate = 13;
            }
            amt = 0.9*base*rate;
            calc = 2.0*amt + base*1.05;
        }
        else {
            rate = 9;
            amt = base;
            calc = 2.0*amt + base*1.05;
        }
        return calc;
    }
    
}
