package com.example.mortemortemorte;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class SorteioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);


        Button btnmenuinicio5 = (Button) findViewById(R.id.btnmenuinicio5);
        btnmenuinicio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SorteioActivity.this, MenuActivity.class));
            }
        });

        Button btnsortear = (Button) findViewById(R.id.btnsortear);
        EditText editJogadores = findViewById(R.id.editJogadores);

        btnsortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jogadores = parseInt(editJogadores.getText().toString());
                int f = 0;
                int a = 0;
                if (jogadores >= 5 && jogadores <= 15) {
                    boolean ultimoJogador = true;
                    Random rand = new Random();
                    int det = rand.nextInt(jogadores - 1) + 1;
                    f++;
                    int p = jogadores;
                    if (f != det) {
                        Toast.makeText(SorteioActivity.this, "Jogador", Toast.LENGTH_SHORT).show();
                    }
                    if (f == det) {
                        a = 1;
                        ultimoJogador = false;
                        Toast.makeText(SorteioActivity.this, "Assassino", Toast.LENGTH_SHORT).show();
                    }
                    if (a > 1) {
                        Toast.makeText(SorteioActivity.this, "Jogador", Toast.LENGTH_SHORT).show();
                    }
                    if (f == p && ultimoJogador == true) {
                        Toast.makeText(SorteioActivity.this, "Assassino", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(SorteioActivity.this, "Mínimo de jogadores 5, máximo 15", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}