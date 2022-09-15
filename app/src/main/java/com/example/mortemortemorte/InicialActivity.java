package com.example.mortemortemorte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class InicialActivity extends AppCompatActivity {

    FusedLocationProviderClient fusedLocationClient;

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
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

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

        getLocation();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 10){
            if(grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLocation();
            }
            else{
                {
                    Toast.makeText(InicialActivity.this, "Permissão de localização negada.",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void getLocation(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
        }
        else{
            requestPermission();
        }
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 10);
    }
}