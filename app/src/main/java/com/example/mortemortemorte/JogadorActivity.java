package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JogadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);

        Button btnmorri = (Button)findViewById(R.id.btnmorri);
        btnmorri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(JogadorActivity.this, MorriActivity.class));
            }
        });
    }
}