//Victoria Manocchio
//Assignment 4
//Main Activity of App, code for welcome screen

package com.example.resnet.findsynonymantonym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SynDBHelper helper = new SynDBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEnterValuesClick(View v){

        if(v.getId() == R.id.bEnterValues){

            Intent i = new Intent(MainActivity.this, EnterVal.class);
            startActivity(i);
        }

    }

    public void onSearchClick(View v){

        if(v.getId() == R.id.bSynAnt){

            EditText a = (EditText)findViewById(R.id.TFword);
            String str = a.getText().toString();

            String res = helper.searchTerm(str);

            Intent i = new Intent(MainActivity.this, Result.class);
            i.putExtra("Result", res);
            startActivity(i);
        }
    }



}
