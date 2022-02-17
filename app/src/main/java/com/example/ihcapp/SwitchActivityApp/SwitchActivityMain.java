package com.example.ihcapp.SwitchActivityApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ihcapp.R;

public class SwitchActivityMain extends AppCompatActivity {

    TextView inputText;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_main);

        inputText = findViewById(R.id.text_input);
        sendButton = findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchText_i = new Intent(SwitchActivityMain.this, SwitchActivity2.class);
                switchText_i.putExtra("input", inputText.getText().toString());
                startActivity(switchText_i);
            }
        });
    }
}