package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PalpiteActivity extends AppCompatActivity {

    Button btnsalvar,btnrevelar;
    EditText editetextpalpite;
    TextView textViewpalpite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palpite);

        Button btnmenuinicio8 = (Button)findViewById(R.id.btnmenuinicio8);
        btnmenuinicio8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PalpiteActivity.this, MenuActivity.class));
            }
        });

        btnsalvar = findViewById(R.id.btnsalvar);
        btnrevelar = findViewById(R.id.btnrevelar);

        editetextpalpite = findViewById(R.id.editextpalpite);
        textViewpalpite = findViewById(R.id.textViewpalpite);

        editetextpalpite.requestFocus();

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("chaveGeral", MODE_PRIVATE);
                SharedPreferences.Editor editor;
                editor = prefs.edit();
                editor.putString("chavePalpite", editetextpalpite.getText().toString());
                editor.commit();
                Toast.makeText(PalpiteActivity.this, "Salvo", Toast.LENGTH_SHORT).show();
            }
        });
        btnrevelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String palpite;
                SharedPreferences prefs = getSharedPreferences("chaveGeral", MODE_PRIVATE);
                palpite=prefs.getString("chavePalpite", "");
                textViewpalpite.setText("O seu palpite havia sido:"+"\n"+palpite);
            }
        });
    }
}