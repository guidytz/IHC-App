package com.example.ihcapp.SumApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ihcapp.R;

import java.text.MessageFormat;

public class SumApp extends AppCompatActivity {

    TextView firstNumber;
    TextView secondNumber;

    Button sum;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_app);

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        sum = findViewById(R.id.sum_buttom);
        result = findViewById(R.id.result);

        sum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int first = Integer.parseInt(firstNumber.getText().toString());
                int second = Integer.parseInt(secondNumber.getText().toString());

                int res = first + second;
                result.setText(MessageFormat.format("Result: {0}", res));
            }
        });
    }
}