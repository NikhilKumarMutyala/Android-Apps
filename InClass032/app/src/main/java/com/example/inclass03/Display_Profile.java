package com.example.inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Display_Profile extends AppCompatActivity {

    public Button edit;
    private ImageView gender;

    private TextView DisplayName;
    private TextView display;
    String fname;
    String lname;
    //String name;
    String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__profile);

        setTitle("Display Profile");

        //if(getIntent()  != null && getIntent().getExtras() != null){

             fname = getIntent().getStringExtra("firstname");
             lname = getIntent().getStringExtra("lastname");
             tag=getIntent().getStringExtra("tag");
             //name=fname+" "+lname;
        //}

        edit=findViewById(R.id.edit);
        gender=findViewById(R.id.gender);
        DisplayName=findViewById(R.id.DisplayName);
        display=findViewById(R.id.display);

        DisplayName.setText("Name: "+ fname+" "+lname);
        if (tag.equals("1")){
            gender.setImageDrawable(getDrawable(R.drawable.female));
            display.setText("FEMALE");
        }
        else if(tag.equals("2")){
            gender.setImageDrawable(getDrawable(R.drawable.male));
            display.setText("MALE");
        }

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
