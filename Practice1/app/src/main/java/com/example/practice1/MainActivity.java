package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.example.practice1.R.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main1);

        Button btn=findViewById(R.id.button_Cancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("demo","Cancel Button Clicked!!");
            }
        });
        findViewById(id.button_OK).setOnClickListener(this);
        findViewById(id.Other_Cancel).setOnClickListener(this);

    }
    public void otherButtonClicked(View view){
        Log.d("demo","Other Button Clicked!!");
    }

    @Override
    public void onClick(View v) {

        if(v.getId()== id.Other_Cancel){
            Log.d("demo","Other cancel Button Clicked!!");
        }
        else if(v.getId()==id.button_OK){
            Log.d("demo","Ok Button Clicked!!");
        }
    }
}
