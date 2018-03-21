//Victorianna Manocchio
//Assignment 4
//Code for Enter Value Screen; allows user to enter synonym/antonym pairs

package com.example.resnet.findsynonymantonym;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class EnterVal extends Activity{

    SynDBHelper helper = new SynDBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterval);
    }

    public void onButtonSubmitClick(View v){
        if(v.getId() == R.id.bSubmit){

            EditText a = (EditText)findViewById(R.id.TFterm);
            String termstr = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.TFsynant);
            String synstr = b.getText().toString();


            Pair p = new Pair();
            p.setTerm(termstr);
            p.setMatch(synstr);
            helper.insertPair(p);

            Intent i = new Intent(EnterVal.this, MainActivity.class);
            startActivity(i);
        }

    }
}
