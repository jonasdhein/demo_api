package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text, text2;
    Button button;
    EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        city = findViewById(R.id.txtCity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClimaTask clima = new ClimaTask(text2);
                clima.execute(city.getText().toString().toLowerCase());

            }
        });



    }
}
