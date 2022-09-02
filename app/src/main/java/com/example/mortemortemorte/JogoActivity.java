package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        Button btnassassino = (Button)findViewById(R.id.btnassassino);
        btnassassino.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(JogoActivity.this, AssassinoActivity.class));
            }
        });
        Button btnjogador = (Button)findViewById(R.id.btnjogador);
        btnjogador.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(JogoActivity.this, JogadorActivity.class));
            }
        });
        Button btnmenuinicio4 = (Button)findViewById(R.id.btnmenuinicio4);
        btnmenuinicio4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(JogoActivity.this, MenuActivity.class));
            }
        });
    }
}