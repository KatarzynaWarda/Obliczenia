package com.example.obliczenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bmi = findViewById(R.id.btnBmi);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(MainActivity.this, BMI.class);
                startActivity(intencja);
            }
        });

        Button delta = findViewById(R.id.btnDelta);
        delta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(MainActivity.this,Delta.class);
                startActivity(intencja);
            }
        });

        Button temperature = findViewById(R.id.btnTemp);
        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(MainActivity.this, Temperature.class);
                startActivity(intencja);
            }
        });
    }


}