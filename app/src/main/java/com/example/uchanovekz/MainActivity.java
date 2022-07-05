package com.example.uchanovekz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btngomenu;
    EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btngomenu =  findViewById(R.id.btngomenu);
    }
    public void goMenu(View view) {
        String emailToText = email.getText().toString();
        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
        } else if (emailToText.isEmpty()){
            email.setError("Введи Email");
            return;
        } else {
            email.setError("Введите правильный Email!");
            return;
        }

        if(TextUtils.isEmpty(password.getText().toString()))
        {
            password.setError("Введите password");
            return;
        }
        Intent activityNow = new Intent(MainActivity.this, Menu.class);
        startActivity(activityNow);
    }
    public void GoRestration(View view) {
        Intent activityNow2 = new Intent(MainActivity.this, Registration.class);
        startActivity(activityNow2);
    }
}