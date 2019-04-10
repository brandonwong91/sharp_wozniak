package com.healthack.moontime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class predict_cycle extends Activity{
    EditText pc_last_period, pc_period_duration, pc_cycle_duration , pc_weight, pc_height;
    Switch pc_sw_temp;
    Button pc_button;
    int cycle_duration, period_duration;
    float weight, height, bmi;
    Boolean temp;
    String last_period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.predict_cycle);

        //predict_cycle variables will be pc_*
        pc_last_period = (EditText) findViewById(R.id.input_last_period);
        pc_period_duration = (EditText) findViewById(R.id.input_period_duration);
        pc_cycle_duration = (EditText) findViewById(R.id.input_cycle_duration);
        pc_weight = (EditText) findViewById(R.id.input_pc_weight);
        pc_height = (EditText) findViewById(R.id.input_pc_height);
        pc_sw_temp = (Switch) findViewById(R.id.sw_temp);
        pc_button = (Button) findViewById(R.id.b_predict_symptom);

        pc_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                last_period = pc_last_period.getText().toString();
                period_duration = Integer.valueOf(pc_period_duration.getText().toString());
                cycle_duration = Integer.valueOf(pc_cycle_duration.getText().toString());
                weight = Float.valueOf(pc_weight.getText().toString());
                height = Float.valueOf(pc_height.getText().toString());
                bmi = weight / (height * height) ;
                temp = pc_sw_temp.isChecked();
                showToast(String.format("BMI = %.2f \n" +
                        "Feeling Warm = %s", bmi, temp));



            }
        });
        //Python py = Python.Instance();
        /*
        Python py = Python.getInstance();
        PyObject mod = py.getModule("mod");


        // If the function expects an iterable, Java arrays can be passed directly.
        mod.callAttr("f", new String[] {"one", "two", "three"});

        // If the function expects a dict, it can be created as follows.
        PyObject builtins = py.getBuiltins();
        PyObject d = builtins.callAttr("dict");
        d.callAttr("__setitem__", 1, "a");
        d.callAttr("__setitem__", 2, "b");
        mod.callAttr("f", d); */
    }

    private void showToast(String text) {
        Toast.makeText(predict_cycle.this,text, Toast.LENGTH_SHORT).show();
    }
}
