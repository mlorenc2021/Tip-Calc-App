/*
    Matthew Lorenc - Z1904531
    CSCI 322
    Portfolio 4-1
    Due: 02/18/22
 */
package edu.niu.cs.z1904531.portfolio2;

public class TipCalculator {
    private float tip, bill;

    public TipCalculator(float newTip, float newBill) {

        setTip(newTip);
        setBill(newBill);
    }//end constructor


    //setters with input validation
    public void setTip(float newTip) {
        tip = 0.0f;
        if (newTip > 0){
            tip = newTip;
        }
    }

    public void setBill(float newBill) {
        bill = 0.0f;
        if (newBill > 0){
            bill = newBill;
        }
    }

    //getters
    public float getTip() {
        return tip;
    }

    public float getBill() {
        return bill;
    }

    //calculate tip amount
    public float calcTip(){
        return bill * tip;
     }

     //calculate total amount
    public float calcBill(){
        return bill + calcTip();
    }


}//end tip calculator
