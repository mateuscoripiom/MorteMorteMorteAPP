package com.example.mortemortemorte;

import static java.lang.Integer.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class SorteioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);

        Button btnmenuinicio5 = (Button)findViewById(R.id.btnmenuinicio5);
        btnmenuinicio5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(SorteioActivity.this, MenuActivity.class));
            }
        });

        EditText editJogadores = findViewById(R.id.editJogadores);

        Button btnsortear = (Button) findViewById(R.id.btnsortear);
        btnsortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int f = 0;
                int jogadores = Integer.parseInt(editJogadores.getText().toString());
                if (jogadores >= 5 && jogadores <= 15) {
                    Random rand = new Random();
                    int det = rand.nextInt(jogadores);
                    det += 1;
                    f++;
                    if (f != det) {
                        Toast.makeText(SorteioActivity.this, "Jogador", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SorteioActivity.this, "Assassino", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(SorteioActivity.this, "O mínimo de jogadores são 5 e o máximo 15", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}