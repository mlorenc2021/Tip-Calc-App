/*
    Matthew Lorenc - Z1904531
    CSCI 322
    Portfolio 4-1
    Due: 02/18/22

    Description: This is an application designed to act like a tip calculator.
             The user will enter the amount of the bill and a percentage to
             determine the tip amount. As the cost and percentage are being inputted,
             the tip amount and total bill amount will be directly computed and displayed
             in various TextView objects. It will also display a help page that the user
             can scroll through information.
 */
package edu.niu.cs.z1904531.portfolio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TipCalculator tipCalculator;
    public NumberFormat numberFormat;

    private EditText billET, tipPercET;
    private TextView tipTV, totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the variables to the items on the screen
        billET = findViewById(R.id.billEditText);
        tipPercET = findViewById(R.id.tipPercentEditText);

        tipTV = findViewById(R.id.tipTextView);
        totalTV = findViewById(R.id.totalTextView4);

        //create the TipCalculator object
        tipCalculator = new TipCalculator(0.17f, 100.0f);

        //create the NumberFormat object
        numberFormat = NumberFormat.getCurrencyInstance();

        //create a custom textwatcher object
        TextChangeHandler textChangeHandler = new TextChangeHandler();

        //attach the handler
        billET.addTextChangedListener(textChangeHandler);
        tipPercET.addTextChangedListener(textChangeHandler);

    }//end onCreate

    // Public calculate method used to calculate the tip percentage
    public void calculate(){
        String billString = billET.getText().toString(),
                tipPercString = tipPercET.getText().toString();

        //if only one value has been entered, get out of method
        if( billString.matches("") || tipPercString.matches("")){
            return;
        }

        try {
            //get numeric versions of the bill a mount and tip percentage
            float billAmt = Float.parseFloat(billString);
            int tipPercent = Integer.parseInt(tipPercString);

            //set up the TipCalculator object with good values
            tipCalculator.setBill(billAmt);
            tipCalculator.setTip(tipPercent * 0.01f);

            //calculate th tip amount and total bill
            float tip = tipCalculator.calcTip();
            float total = tipCalculator.calcBill();

            //put the formatted amounts into the textViews
            tipTV.setText(numberFormat.format(tip));
            totalTV.setText(numberFormat.format(total));
        }
        catch(NumberFormatException nfe){
            Toast.makeText(this, "Data is invalid", Toast.LENGTH_SHORT).show();
        }
    }//end calculate method

    //custom TextWatcher class
    private class TextChangeHandler implements TextWatcher{
        @Override
        public void afterTextChanged(Editable editable) {
            calculate();
        }//end after method

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }//end before method

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }//end on method
    }//end TextChangeHandler

    //method to handle button click
    public void getHelp(View view){
        Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(helpIntent);
    }//end getHelp method


}//end MainActivity
