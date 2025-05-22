/*
    Matthew Lorenc - Z1904531
    CSCI 322
    Portfolio 4-1
    Due: 02/18/22
 */
package edu.niu.cs.z1904531.portfolio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    //method that responds to the button click
    public void goBack(View view){
        //go back to the main activity
        finish();
    }//end goBack method
}//end HelpActivity