package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class InicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgfundo = findViewById(R.id.imgfundo);
        Switch swtreveal = findViewById(R.id.swtreveal);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView10 = findViewById(R.id.textView10);
        TextView textView8 = findViewById(R.id.textView8);
        Button btncinema = findViewById(R.id.btncinema);
        ImageView imageView = findViewById(R.id.imageView);
        TextView textView9 = findViewById(R.id.textView9);

        swtreveal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    textView2.setVisibility(View.VISIBLE);
                    btncinema.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                    textView10.setVisibility(View.VISIBLE);
                    textView8.setVisibility(View.VISIBLE);
                    textView9.setVisibility(View.VISIBLE);
                }
                else{
                    textView2.setVisibility(View.INVISIBLE);
                    textView9.setVisibility(View.INVISIBLE);
                    textView10.setVisibility(View.INVISIBLE);
                    textView8.setVisibility(View.INVISIBLE);
                    btncinema.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });

        btncinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                String query = "Cinemas próximos a mim";
                intent.putExtra(SearchManager.QUERY, query);
                startActivity(intent);
            }
        });

        Button btnmenuinicio = (Button)findViewById(R.id.btnmenuinicio);
        btnmenuinicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(InicialActivity.this, MenuActivity.class));
            }
        });


    }
}