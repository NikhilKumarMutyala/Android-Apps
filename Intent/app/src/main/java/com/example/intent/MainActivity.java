package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static String NAME_KEY="NAME";
    static String AGE_KEY="AGE";
    static String USER_KEY="USER";
    static String PERSON_KEY="PERSON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Main");


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);

               intent.putExtra(PERSON_KEY,new Person("Smith",25.5,"Charlotte"));

                startActivity(intent);
            }
        });
    }
}
