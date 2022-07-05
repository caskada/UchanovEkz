package com.example.uchanovekz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText email, password, reppassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        reppassword = findViewById(R.id.repeatpassword);
    }
    public void goMenu(View view) {
        String emailToText = email.getText().toString();
        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {

        } else if (emailToText.isEmpty()){
            email.setError("Введи Email");
            return;
        } else {
            email.setError("Введите правильный Email");
            return;
        }
        if(TextUtils.isEmpty(password.getText().toString()))
        {
            password.setError("Введите password");
            return;
        }
        if(TextUtils.isEmpty(reppassword.getText().toString()))
        {
            reppassword.setError("Введите пароль повторно");
            return;
        }
        if(password.getText().toString().equals(reppassword.getText().toString())){
            Toast.makeText(getApplicationContext(), "Регистрация прошла успешно",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Пароли не совпадают",
                    Toast.LENGTH_LONG).show();
            return;
        }

        Intent startact1 = new Intent(Registration.this, Menu.class);
        startActivity(startact1);
    }
    public void goAuth(View view) { // Переход на активность авторизации
        Intent startact2 = new Intent(Registration.this, MainActivity.class);
        startActivity(startact2);
    }
}