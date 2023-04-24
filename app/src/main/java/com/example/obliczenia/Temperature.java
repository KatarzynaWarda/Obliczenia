package com.example.obliczenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Temperature extends AppCompatActivity {

    String changed = "";
    Spinner spSelected;
    Spinner spChanged;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        Button bmi = findViewById(R.id.btnBmi);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(Temperature.this, BMI.class);
                startActivity(intencja);
            }
        });

        Button delta = findViewById(R.id.btnDelta);
        delta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(Temperature.this, Delta.class);
                startActivity(intencja);
            }
        });

        Button palindrom = findViewById(R.id.btnPalindrom);
        palindrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(Temperature.this, Palindrom.class);
                startActivity(intencja);
            }
        });

        String[] temp = {"°C", "°F", "K"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSelected = findViewById(R.id.spSelected);
        spChanged = findViewById(R.id.spChanged);
        spSelected.setAdapter(adapter);
        spChanged.setAdapter(adapter);

        Button btnWyznacz = findViewById(R.id.btnWyznacz);
        btnWyznacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wyznaczTemperature();
            }
        });

    }

    public void wyznaczTemperature() {
        EditText etSelected = findViewById(R.id.etSelected);
        if (etSelected.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "uzupełnij pole", Toast.LENGTH_SHORT).show();
        }
        else {
            double selected = Double.parseDouble(etSelected.getText().toString());
            if (spSelected.getSelectedItem() == "°C" && spChanged.getSelectedItem() == "°F") {
                double value = (((selected * 9) / 5) + 32);
                changed = Double.toString(value);
            } else if (spSelected.getSelectedItem() == "°C" && spChanged.getSelectedItem() == "K") {
                double value = selected + 273.15;
                changed = Double.toString(value);
            } else if (spSelected.getSelectedItem() == "K" && spChanged.getSelectedItem() == "°F") {
                double value = ((selected * 1.8) - 459.67);
                changed = Double.toString(value);
            } else if (spSelected.getSelectedItem() == "K" && spChanged.getSelectedItem() == "°C") {
                double value = selected - 273.15;
                changed = Double.toString(value);
            } else if (spSelected.getSelectedItem() == "°F" && spChanged.getSelectedItem() == "°C") {
                double value = ((selected - 32.0) / 1.8);
                changed = Double.toString(value);
            } else if (spSelected.getSelectedItem() == "°F" && spChanged.getSelectedItem() == "K") {
                double value = ((selected + 459.67) * 5.0 / 9.0);
                changed = Double.toString(value);
            } else {
                changed = etSelected.getText().toString();
            }
            TextView tvChanged = findViewById(R.id.tvChanged);
            tvChanged.setText(changed);
        }
    }
}