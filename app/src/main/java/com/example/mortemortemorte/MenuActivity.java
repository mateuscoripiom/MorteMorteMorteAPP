package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnvoltarinicio = (Button)findViewById(R.id.btnvoltarinicio);
        btnvoltarinicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuActivity.this, InicialActivity.class));
            }
        });

        Button btnvoltarconheca = (Button)findViewById(R.id.btnvoltarconheca);
        btnvoltarconheca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuActivity.this, ConhecaActivity.class));
            }
        });

        Button btnvoltarpersonagens = (Button)findViewById(R.id.btnvoltarpersonagens);
        btnvoltarpersonagens.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuActivity.this, PersonagensActivity.class));
            }
        });

        Button btnjogo = (Button)findViewById(R.id.btnjogo);
        btnjogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuActivity.this, RegrasActivity.class));
            }
        });

        Button btnsorteio = (Button)findViewById(R.id.btnsorteio);
        btnsorteio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuActivity.this, SorteioActivity.class));
            }
        });

        Button btncreditos = (Button)findViewById(R.id.btncreditos);
        btncreditos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuActivity.this, CreditosActivity.class));
            }
        });

        Button btnpalpite = (Button)findViewById(R.id.btnpalpite);
        btnpalpite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuActivity.this, PalpiteActivity.class));
            }
        });

        Button btncritica = (Button)findViewById(R.id.btncritica);
        btncritica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuActivity.this, CriticaActivity.class));
            }
        });
    }
}