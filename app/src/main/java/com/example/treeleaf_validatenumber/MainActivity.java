package com.example.treeleaf_validatenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.exitTextMail);
        button = findViewById(R.id.mainLoginButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMail(email);
            }
        });
    }

    // metdod to check the mail
    private boolean checkMail(EditText email){
        String emailInput = email.getText().toString();

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            Toast.makeText(MainActivity.this, "Logged in by "+emailInput, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            intent.putExtra("MAIL",emailInput);
            startActivity(intent);

            return true;
        } else {
            Toast.makeText(MainActivity.this, "Invalid Input Mail", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}