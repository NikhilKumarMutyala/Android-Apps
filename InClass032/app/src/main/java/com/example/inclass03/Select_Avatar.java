package com.example.inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Select_Avatar extends AppCompatActivity implements View.OnClickListener{

    public static final String GENDER="gender";
    ImageView iv_male,iv_female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__avatar);

        setTitle("Select Avatar");

        iv_female=findViewById(R.id.iv_female);
        iv_male=findViewById(R.id.iv_male);

        iv_male.setOnClickListener(this);
        iv_female.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==iv_female){
            Intent returnedData = new Intent();
            returnedData.putExtra(GENDER, "female");

            setResult(RESULT_OK,returnedData);

            finish();

        }else if(v==iv_male){
            Intent returnedData = new Intent();
            returnedData.putExtra(GENDER, "male");

            setResult(RESULT_OK,returnedData);

            finish();
        }
    }
}
