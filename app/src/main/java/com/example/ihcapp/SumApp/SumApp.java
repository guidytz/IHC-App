package com.example.ihcapp.SumApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.ihcapp.R;

import java.text.MessageFormat;
import java.util.Objects;

public class SumApp extends AppCompatActivity {

    TextView firstNumber;
    TextView secondNumber;

    Button sum;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_app);
        Objects.requireNonNull(getSupportActionBar()).setTitle("IHC App - Soma");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        sum = findViewById(R.id.sum_buttom);
        result = findViewById(R.id.result);

        sum.setOnClickListener(view -> {
            try {
                int first = Integer.parseInt(firstNumber.getText().toString());
                int second = Integer.parseInt(secondNumber.getText().toString());
                int res = first + second;
                result.setText(MessageFormat.format("Resultado: {0}", res));
            } catch (NumberFormatException nfe) {
                Log.w("SUM_WARN", "Tried to sum inputs different than number!");
            }
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