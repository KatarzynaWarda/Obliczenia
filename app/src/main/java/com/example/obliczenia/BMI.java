package com.example.obliczenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    double bmi = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        Button delta = findViewById(R.id.btnDelta);
        delta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(BMI.this,Delta.class);
                startActivity(intencja);
            }
        });

        Button temperature = findViewById(R.id.btnTemp);
        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(BMI.this, Temperature.class);
                startActivity(intencja);
            }
        });

        Button oblicz = findViewById(R.id.btnOblicz);
        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obliczBMI();
            }
        });

        Button palindrom = findViewById(R.id.btnPalindrom);
        palindrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(BMI.this, Palindrom.class);
                startActivity(intencja);
            }
        });
    }

    public void obliczBMI() {
        EditText masa = findViewById(R.id.masa);
        double podanaMasa = Double.parseDouble(masa.getText().toString());

        EditText wzrost = findViewById(R.id.wzrost);
        double podanyWzrost = Double.parseDouble(wzrost.getText().toString());

        if(masa == null || wzrost == null)
            return;
        bmi = Math.round(podanaMasa / ((podanyWzrost/100) * (podanyWzrost/100)));
        pokazEtykiety();
    }

    public void pokazEtykiety() {
        TextView wynik = findViewById(R.id.wynik);
        wynik.setText(Double.toString(bmi));
        interpretacjaWyniku();
    }

    public void interpretacjaWyniku() {
        TextView przedzial = findViewById(R.id.przedzial);
        if (bmi < 16.0){
            przedzial.setText("Wygłodzenie");
            przedzial.setTextColor(Color.BLUE);
        }
        else if (bmi < 16.9){
            przedzial.setText("Wychudzenie");
            przedzial.setTextColor(Color.BLUE);
        }
        else if (bmi < 18.5){
            przedzial.setText("Niedowaga");
            przedzial.setTextColor(Color.BLUE);
        }
        else if (bmi < 24.9){
            przedzial.setText("Waga prawidłowa");
            przedzial.setTextColor(Color.GREEN);
        }
        else if (bmi < 29.9){
            przedzial.setText("Nadwaga");
            przedzial.setTextColor(Color.RED);
        }
        else if (bmi < 34.9){
            przedzial.setText("Otyłość I stopnia");
            przedzial.setTextColor(Color.RED);
        }
        else if (bmi < 39.9){
            przedzial.setText("Otyłość II stopnia");
            przedzial.setTextColor(Color.RED);
        }
        else {
            przedzial.setText("Otyłość III stopnia");
            przedzial.setTextColor(Color.RED);
        }
    }
}