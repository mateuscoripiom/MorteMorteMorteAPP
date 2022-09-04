package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AssassinoActivity extends AppCompatActivity {
    private Button btnlanternaassassino;
    private Button btnmatei;
    private TextView txtTempoLanternaA;

    boolean hasCameraFlash = false;
    boolean flashOn = false;
    int Corpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assassino);

        txtTempoLanternaA = findViewById(R.id.txtTempoLanternaA);

        Button btndescoberto = (Button)findViewById(R.id.btndescoberto);
        btndescoberto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(AssassinoActivity.this, DescobertoActivity.class));
            }
        });

        btnlanternaassassino = findViewById(R.id.btnlanternaassassino);
        btnmatei = findViewById(R.id.btnmatei);
        hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        long start = System.currentTimeMillis();
        long end = start + 20 * 1000;

        btnlanternaassassino.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(hasCameraFlash){
                    if(flashOn){
                        flashOn = false;
                        flashLightOff();
                    }
                    else while (System.currentTimeMillis() < end){
                        flashOn = true;
                        flashLightOn();
                    }
                }
                else{
                    Toast.makeText(AssassinoActivity.this, "Lanterna não disponível", Toast.LENGTH_LONG).show();
                }
                btnlanternaassassino.setClickable(false);
                flashLightOff();
                txtTempoLanternaA.setText("Tempo de lanterna esgotado");
            }

        });

        btnmatei.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView txtCorpoA = findViewById(R.id.txtCorpoA);
                Corpo++;
                txtCorpoA.setText(Integer.toString(Corpo) + " mortos");

                if(Corpo >= 10){
                    startActivity(new Intent(AssassinoActivity.this, GanhouActivity.class));
                }
                else{
                }
            }
        });

    }
    private void flashLightOn(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
        }
        catch(CameraAccessException e){
            Log.e("Problema na câmera", "Não é possível ligar a lanterna");
        }
    }

    private void flashLightOff(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
        }
        catch(CameraAccessException e){
            Log.e("Problema na câmera", "Não é possível ligar a lanterna");
        }
    }
}