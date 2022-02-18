package com.example.ihcapp.SwitchActivityApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ihcapp.R;

import java.text.MessageFormat;
import java.util.Objects;

public class SwitchActivity2 extends AppCompatActivity {

    TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch2);
        Objects.requireNonNull(getSupportActionBar()).setTitle("IHC App - Troca Atividades 2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        outputText = findViewById(R.id.output_text);
        String inputText = getIntent().getStringExtra("input");
        outputText.setText(MessageFormat.format("Mensagem digitada:\n{0}", inputText));
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