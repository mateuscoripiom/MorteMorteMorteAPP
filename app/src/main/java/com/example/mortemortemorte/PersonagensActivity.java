package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PersonagensActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagens);

        Button btnmenuinicio3 = (Button)findViewById(R.id.btnmenuinicio3);
        btnmenuinicio3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PersonagensActivity.this, MenuActivity.class));
            }
        });
    }

    public void envioMail(View view) throws UnsupportedEncodingException {
        String uriText =
                "mailto:mateuscoripiom@gmail.com" +
                        "?subject=" + URLEncoder.encode("Palpite", "utf-8") +
                        "&body=" + URLEncoder.encode("Assassino:", "utf-8");
        Uri uri = Uri.parse(uriText);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(uri);
        startActivity(intent);
    }
}