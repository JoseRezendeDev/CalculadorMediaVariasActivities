package com.example.calculadormediavariasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DigitarActivity extends AppCompatActivity {

    private TextView txtNota1;
    private TextView txtNota2;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digitar);

        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        btnOK = findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.putExtra("nota1", txtNota1.getText().toString());
                intent.putExtra("nota2", txtNota2.getText().toString());
                intent.putExtra("nome", getIntent().getStringExtra("nome"));

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
