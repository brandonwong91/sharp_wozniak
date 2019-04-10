package com.healthack.moontime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class first_period extends Activity{
    int age;
    float weight, height, bmi;
    EditText fp_age, fp_weight, fp_height;
    TextView fp_predicted_date;
    Button fp_button;
    String predicted_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_period);

        //first_period variables will be fp_*
        fp_age = (EditText) findViewById(R.id.input_age);
        fp_weight = (EditText) findViewById(R.id.input_weight);
        fp_height = (EditText) findViewById(R.id.input_height);
        fp_predicted_date = (TextView) findViewById(R.id.text_predicted_date);
        fp_button = (Button) findViewById(R.id.b_predict_first_cycle);

        fp_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                age = Integer.valueOf(fp_age.getText().toString());
                weight = Float.valueOf(fp_weight.getText().toString());
                height = Float.valueOf(fp_height.getText().toString());
                bmi = weight / height / height ;

                showToast("BMI = " + String.valueOf(bmi));
                predicted_date = "None";
                fp_predicted_date.setText("Predicted Period Date : " + predicted_date);
            }
        });
    }

    private void showToast(String text) {
        Toast.makeText(first_period.this,text, Toast.LENGTH_SHORT).show();
    }

}
