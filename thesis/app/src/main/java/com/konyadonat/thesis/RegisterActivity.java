package com.konyadonat.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText email = findViewById(R.id.editTextTextEmailAddress2);
        EditText password = findViewById(R.id.editTextTextPassword2);
        EditText passwordAgain = findViewById(R.id.editTextTextPassword3);
        EditText name = findViewById(R.id.editTextTextPersonName);
        Button register = findViewById(R.id.btn_registerInReigsterActivity);
        Button back = findViewById(R.id.btn_backToLoginInRegister);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}