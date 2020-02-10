package com.example.radio_buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg=findViewById(R.id.radiogroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb= findViewById(checkedId);
                Log.d("demo","Checked the " +rb.getText().toString());
            }
        });

        findViewById(R.id.getCheckedColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id= rg.getCheckedRadioButtonId();
                if(id==R.id.blue){
                    Log.d("demo","Checked is blue");
                }
                else if(id==R.id.green){
                    Log.d("demo","Checked is green");
                }
                else if (id==R.id.red){
                    Log.d("demo","Checked is red");
                }
                else if (id==-1){
                    Log.d("demo","Checked is None");
                }
            }
        });
    }

}
