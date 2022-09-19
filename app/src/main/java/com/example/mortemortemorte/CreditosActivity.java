package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CreditosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        TextView txtinstadir = (TextView)findViewById(R.id.txtinstadir);
        TextView txtimdbdir = (TextView)findViewById(R.id.txtimdbdir);
        TextView txtinstaestudio = (TextView)findViewById(R.id.txtinstaestudio);
        TextView txtimdbestudio = (TextView)findViewById(R.id.txtimdbestudio);
        Button btnmenuinicio7 = (Button)findViewById(R.id.btnmenuinicio7);
        Button btnlocal = (Button)findViewById(R.id.btnlocal);

        btnmenuinicio7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(CreditosActivity.this, MenuActivity.class));
            }
        });

        txtinstadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/halinareijn/");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNavegador)));
            }
        });

        txtimdbdir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.imdb.com/name/nm0717603/");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNavegador)));
            }
        });

        txtinstaestudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/a24/");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNavegador)));
            }
        });

        txtimdbestudio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.imdb.com/list/ls064472633/");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNavegador)));
            }
        });
        btnlocal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri location= Uri.parse("geo:0,0?q=48+Haights+Cross+Rd,+Chappaqua");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent );
            }
        });
    }
}