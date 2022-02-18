package com.example.ihcapp.SwitchActivityApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.ihcapp.R;

import java.util.Objects;

public class SwitchActivityMain extends AppCompatActivity {

    TextView inputText;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("IHC App - Troca Atividades");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputText = findViewById(R.id.text_input);
        sendButton = findViewById(R.id.send_button);

        sendButton.setOnClickListener(view -> {
            Intent switchText_i = new Intent(SwitchActivityMain.this, SwitchActivity2.class);
            switchText_i.putExtra("input", inputText.getText().toString());
            startActivity(switchText_i);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}