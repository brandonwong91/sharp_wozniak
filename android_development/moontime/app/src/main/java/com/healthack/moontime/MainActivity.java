package com.healthack.moontime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick (View v){
        if (v.getId() == R.id.b_first_cycle){
            Intent i = new Intent(MainActivity.this, first_period.class);
            startActivity(i);
        }
        if (v.getId() == R.id.b_predict_cycle){
            Intent i = new Intent(MainActivity.this, predict_cycle.class);
            startActivity(i);
        }

    }
}
