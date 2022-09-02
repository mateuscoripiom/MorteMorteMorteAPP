package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MorriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morri);

        Button btnsairjogo = (Button)findViewById(R.id.btnsairjogo);
        btnsairjogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MorriActivity.this, JogoActivity.class));
            }
        });
    }
}