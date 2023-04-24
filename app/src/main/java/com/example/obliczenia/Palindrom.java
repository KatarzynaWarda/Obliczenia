package com.example.obliczenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrom);

        Button bmi = findViewById(R.id.btnBmi);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(Palindrom.this, BMI.class);
                startActivity(intencja);
            }
        });

        Button delta = findViewById(R.id.btnDelta);
        delta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(Palindrom.this,Delta.class);
                startActivity(intencja);
            }
        });

        Button temperature = findViewById(R.id.btnTemp);
        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(Palindrom.this, Temperature.class);
                startActivity(intencja);
            }
        });

        Button sprawdz = findViewById(R.id.btnSprawdz);
        sprawdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                czyPalindrom();
            }
        });
    }

    public void czyPalindrom() {
        EditText slowo = findViewById(R.id.slowo);
        String palindrom = slowo.getText().toString().toLowerCase();
        TextView wyswietl = findViewById(R.id.wyswietl);
        for (int j = 0; j < palindrom.length(); j++) {
            if (palindrom.charAt(j) != palindrom.charAt(palindrom.length() - 1 - j)) {
                wyswietl.setText("podane słowo nie jest palindromem");
                break;
            }
            if (j == palindrom.length() - 1) {
                wyswietl.setText("podane słowo palindromem");
            }
        }
    }

}