package com.example.inclass03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    public static String tag="0";
    private static final int REQ_CODE=0x001;
    private ImageView iv_avatar;
    public EditText first_name;
    public EditText last_name;

    private Button save;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQ_CODE&&resultCode==RESULT_OK&&data!=null){
            String gender=data.getExtras().getString(Select_Avatar.GENDER);

            if (gender.equals("female")){
                iv_avatar.setImageDrawable(getDrawable(R.drawable.female));
                tag="1";
            }
            else{
                iv_avatar.setImageDrawable(getDrawable(R.drawable.male));
                tag="2";
            }
        }
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Profile");

        first_name=findViewById(R.id.first_name);
        last_name=findViewById(R.id.last_name);

        first_name.setHint("First Name");
        last_name.setHint("Last Name");

        first_name.addTextChangedListener(loginTextWatcher);
        last_name.addTextChangedListener(loginTextWatcher);

        iv_avatar=findViewById(R.id.iv_avatar);

        iv_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSelectAvatar = new Intent(MainActivity.this, Select_Avatar.class);

                startActivityForResult(toSelectAvatar,REQ_CODE);
            }
        });

        save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f_name = first_name.getText().toString();
                String l_name = last_name.getText().toString();

                if (f_name.equals("")) {
                    first_name.setError("Can't be empty!!");
                    Toast.makeText(MainActivity.this, "Can't be empty!", Toast.LENGTH_SHORT).show();
                } else if (l_name.equals("")) {
                    last_name.setError("Can't be empty!!");
                    Toast.makeText(MainActivity.this, "Can't be empty!", Toast.LENGTH_SHORT).show();
                }
                else if(tag.equals("0")){
                    Toast.makeText(MainActivity.this, "Gender Can't be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent Save = new Intent(MainActivity.this, Display_Profile.class);
                    Save.putExtra("firstname", f_name);
                    Save.putExtra("lastname", l_name);
                    Save.putExtra("tag",tag);
                    //Save.putExtra("gender", (Serializable) iv_avatar);
                    startActivity(Save);
                }
            }
        });
    }
    public TextWatcher loginTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.toString().trim().length()==0){
                save.setEnabled(false);
            }
            else{
                save.setEnabled(true);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
