package com.example.ihcapp.SwitchActivityApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ihcapp.R;

public class SwitchActivity2 extends AppCompatActivity {

    TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch2);
        outputText = findViewById(R.id.output_text);
        String inputText = getIntent().getStringExtra("input");
        outputText.setText("Typed message:\n" + inputText);
    }
}