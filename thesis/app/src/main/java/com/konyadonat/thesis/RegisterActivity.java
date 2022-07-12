package com.konyadonat.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.konyadonat.thesis.user.Exception.EmailEmptyException;
import com.konyadonat.thesis.user.Exception.EmailInvalidException;
import com.konyadonat.thesis.user.Exception.EmailNullException;
import com.konyadonat.thesis.user.Exception.NameEmptyException;
import com.konyadonat.thesis.user.Exception.NameNullException;
import com.konyadonat.thesis.user.Exception.NameTooShortException;
import com.konyadonat.thesis.user.Exception.PasswordAgainNotTheSameException;
import com.konyadonat.thesis.user.Exception.PasswordEmptyException;
import com.konyadonat.thesis.user.Exception.PasswordNullException;
import com.konyadonat.thesis.user.Exception.PasswordTooShortException;
import com.konyadonat.thesis.user.Exception.TermsOfUseNotAcceptedException;
import com.konyadonat.thesis.user.User;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Objects.requireNonNull(getSupportActionBar()).hide();
        EditText email = findViewById(R.id.editTextTextEmailAddress2);
        EditText password = findViewById(R.id.editTextTextPassword2);
        EditText passwordAgain = findViewById(R.id.editTextTextPassword3);
        EditText name = findViewById(R.id.editTextTextPersonName);
        Button register = findViewById(R.id.btn_registerInReigsterActivity);
        Button back = findViewById(R.id.btn_backToLoginInRegister);
        Switch termsOfUse = findViewById(R.id.switch1);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //TODO FINISH VALIDATION
                    if (!(password.getText().toString().equals(passwordAgain.getText().toString()))) {
                        throw new PasswordAgainNotTheSameException("A jelszó és a jelszó újra nem egyezik!");
                    }
                    //TODO Check if the email is correct
                    //TODO Make a new editText with emailAgain
                    //TODO Password validation

                    //If one/more of the data is incorrect, it throws exception
                    //TODO In User.java make validation in the builder
                    User temp = new User.UserBuilder()
                            .setEmail(email.getText().toString())
                            .setPassword(password.getText().toString())
                            .setName(name.getText().toString())
                            .getUser();
                    if (!termsOfUse.isChecked()) {
                        throw new TermsOfUseNotAcceptedException("Fogadja el a felhasználói feltételeket!");
                    }
                } catch (NameTooShortException | NameEmptyException  | NameNullException |
                        EmailEmptyException | EmailInvalidException | EmailNullException | PasswordEmptyException |
                        PasswordNullException | PasswordTooShortException | TermsOfUseNotAcceptedException e) {
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                } catch (Exception e){
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
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