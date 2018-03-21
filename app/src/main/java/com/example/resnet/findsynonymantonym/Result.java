//Victorianna Manocchio
//Assignment 4
//Code for result screen; displays result of the Search function

package com.example.resnet.findsynonymantonym;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        String result = getIntent().getStringExtra("Result");
        TextView tv = (TextView)findViewById(R.id.TFresult);
        tv.setText(result);
    }

    public void onButtonClick(View v){

        if(v.getId() == R.id.bReturn){

            Intent i = new Intent(Result.this, MainActivity.class);
            startActivity(i);
        }
    }
}
