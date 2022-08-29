package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ConhecaActivity extends AppCompatActivity {
    private RadioGroup RGposter;
    private ImageView poster;
    private Integer []photos = {R.drawable.posterconheca, R.drawable.bodies_bodies_bodies_scaledptbr};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button btntrailer = (Button) findViewById(R.id.btntrailer);
        Button btnmenuinicio2 = (Button)findViewById(R.id.btnmenuinicio2);
        btnmenuinicio2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(ConhecaActivity.this, MenuActivity.class));
            }
        });

        ImageView poster = findViewById(R.id.poster);
        RadioButton RBposter = findViewById(R.id.RBposter1);
        RadioButton RBposter2 = findViewById(R.id.RBposter2);

        RadioGroup RGposter = findViewById(R.id.RGposter);

        RGposter.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup RGposter, int checkedId) {
                if(checkedId == R.id.RBposter2){
                    poster.setImageDrawable(getDrawable(R.drawable.posterptbr));
                }
                else if(checkedId == R.id.RBposter1){
                    poster.setImageDrawable(getDrawable(R.drawable.bodies_bodies_bodies_scaledptbr));
                }
            }
        });

        btntrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=Dpx-VDeTlZU");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNavegador)));
            }
        });
    }
}