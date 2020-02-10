package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Second");

        if(getIntent()!=null&&getIntent().getExtras()!=null){

            Person person=getIntent().getExtras().getParcelable(MainActivity.PERSON_KEY);

            Toast.makeText(this,person.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
