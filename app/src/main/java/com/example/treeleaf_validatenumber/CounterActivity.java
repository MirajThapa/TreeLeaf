package com.example.treeleaf_validatenumber;

import static com.example.treeleaf_validatenumber.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {
    TextView showMail, showNumber;
    CardView cardView;
    Button plus,minus;
    int number =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_counter);

        showMail = findViewById(id.textViewMail);
        showNumber = findViewById(id.textViewNumber);
        plus = findViewById(id.activity_counter_plus);
        minus = findViewById(id.activity_counter_minus);
        cardView = findViewById(id.numberCardView);


        String mail = getIntent().getStringExtra("MAIL");
        showMail.setText(mail);

        showNumber.setText(String.valueOf(number));



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                showNumber.setText(String.valueOf(number));
                cardView.setBackgroundColor(Color.parseColor("#ECECEC"));
                showNumber.setTextColor(Color.parseColor("#FF000000"));
                minus.setTextColor(Color.parseColor("#FF000000"));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if(number==0){
                    Toast.makeText(CounterActivity.this, "Cannot be in negetive", Toast.LENGTH_SHORT).show();
                    //showNumber.setTextColor(Color.parseColor("#FFFFFFFF"));
                }
                else{
                    number--;
                    showNumber.setText(String.valueOf(number));
                    cardView.setBackgroundColor(Color.parseColor("#FF0000"));
                    showNumber.setTextColor(Color.parseColor("#FFFFFFFF"));
                    if(number==0) {
                        minus.setTextColor(Color.parseColor("#FFFFFFFF"));
                    }
                }
            }
        });

    }
}