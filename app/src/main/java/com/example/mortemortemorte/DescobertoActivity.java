package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DescobertoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descoberto);

        Button btnsairjogo = (Button)findViewById(R.id.btnsairjogo);
        btnsairjogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(DescobertoActivity.this, JogoActivity.class));
            }
        });
    }
}