package com.konyadonat.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.konyadonat.thesis.user.Exception.NameTooShortException;
import com.konyadonat.thesis.user.Exception.PasswordAgainNotTheSameException;
import com.konyadonat.thesis.user.User;

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


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (password != passwordAgain) {
                        throw new PasswordAgainNotTheSameException("A jelszó és a jelszó újra nem egyezik!");
                    }
                    User temp = new User.UserBuilder()
                            .setEmail(email.getText().toString())
                            .setPassword(password.getText().toString())
                            .setName(name.getText().toString())
                            .getUser();
                } catch (NameTooShortException e) {
                    Toast.makeText(RegisterActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){
                    Toast.makeText(RegisterActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}