package com.example.obliczenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Delta extends AppCompatActivity {

    String pierwiastki = "";
    String delta = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delta);

        Button bmi = findViewById(R.id.btnBmi);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(Delta.this, BMI.class);
                startActivity(intencja);
            }
        });

        Button temperature = findViewById(R.id.btnTemp);
        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(Delta.this, Temperature.class);
                startActivity(intencja);
            }
        });
        Button btnWyznacz = findViewById(R.id.btnWyznacz);
        btnWyznacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wyznaczPierwiastki();
            }
        });

        Button palindrom = findViewById(R.id.btnPalindrom);
        palindrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(Delta.this, Palindrom.class);
                startActivity(intencja);
            }
        });
    }

    private void wyznaczPierwiastki() {
        EditText parametrA = findViewById(R.id.parametrA);
        double a = Double.parseDouble(parametrA.getText().toString());
        EditText parametrB = findViewById(R.id.parametrB);
        double b = Double.parseDouble(parametrB.getText().toString());
        EditText parametrC = findViewById(R.id.parametrC);
        double c = Double.parseDouble(parametrC.getText().toString());

        double delta = Math.pow(b,2.0) - 4 * a * c;
        if (delta < 0.0) {
            pierwiastki = "brak pierwiastków";

        }
        else if (delta == 0.0) {
            double pierw0 = (-b) /(2 * a);
            pierwiastki = "x0 = " + pierw0;
        }
        else {
            double pierw1 = (-b - Math.sqrt(delta)) / 2 * a;
            double pierw2 = (-b +  Math.sqrt(delta)) / 2 * a;
            pierwiastki = "x1 = " + pierw1 + " \nx2 = " + pierw2;
        }
        TextView d = findViewById(R.id.delta);
        d.setText("delta: " + delta);
        TextView p = findViewById(R.id.pierwiastki);
        p.setText(pierwiastki);
    }
}