package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegrasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regras);

        Button btniniciarjogo = (Button)findViewById(R.id.btniniciarjogo);
        btniniciarjogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(RegrasActivity.this, JogoActivity.class));
            }
        });
        Button btnpularregras = (Button)findViewById(R.id.btnpularregras);
        btnpularregras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(RegrasActivity.this, JogoActivity.class));
            }
        });
        Button btnmenuinicio6 = (Button)findViewById(R.id.btnmenuinicio6);
        btnmenuinicio6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(RegrasActivity.this, MenuActivity.class));
            }
        });
    }
}