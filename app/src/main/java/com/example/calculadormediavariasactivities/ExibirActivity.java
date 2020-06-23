package com.example.calculadormediavariasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ExibirActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);

        TextView lbNomeValor = findViewById(R.id.lbNomeValor);
        TextView lbNota1Valor = findViewById(R.id.lbNota1Valor);
        TextView lbNota2Valor = findViewById(R.id.lbNota2Valor);
        TextView lbMediaValor = findViewById(R.id.lbMediaValor);

        lbNomeValor.setText(getIntent().getStringExtra("nome"));
        lbNota1Valor.setText(getIntent().getStringExtra("nota1"));
        lbNota2Valor.setText(getIntent().getStringExtra("nota2"));
        lbMediaValor.setText(getIntent().getStringExtra("media"));
    }
}
