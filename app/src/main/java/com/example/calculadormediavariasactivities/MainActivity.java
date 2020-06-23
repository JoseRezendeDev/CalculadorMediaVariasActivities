package com.example.calculadormediavariasactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    private TextView lbNota1Valor;
    private TextView lbNota2Valor;
    private String nome;
    private Double nota1;
    private Double nota2;
    private Double media;
    private Button btnDigitar;
    private Button btnExibir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        lbNota1Valor = findViewById(R.id.lbNota1Valor);
        lbNota2Valor = findViewById(R.id.lbNota2Valor);
        btnDigitar = findViewById(R.id.btnDigitar);
        btnExibir = findViewById(R.id.btnExibir);

        btnDigitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DigitarActivity.class);
                intent.putExtra("nome", txtNome.getText().toString());
                startActivityForResult(intent, 1);
            }
        });

        btnExibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExibirActivity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("nota1", nota1.toString());
                intent.putExtra("nota2", nota2.toString());
                intent.putExtra("media", media.toString());
                startActivity(intent);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            txtNome.setText(data.getStringExtra("nome"));
            nome = data.getStringExtra("nome");
            nota1 = Double.parseDouble(data.getStringExtra("nota1"));
            nota2 = Double.parseDouble(data.getStringExtra("nota2"));
            media = (nota1 + nota2) / 2;
            lbNota1Valor.setText(nota1.toString());
            lbNota2Valor.setText(nota2.toString());
        }
    }
}
