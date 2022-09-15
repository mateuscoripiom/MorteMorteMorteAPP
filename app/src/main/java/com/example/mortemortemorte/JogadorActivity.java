package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class JogadorActivity extends AppCompatActivity {

    private Button btnlanternajogador;
    private Button btnecontrei;
    private TextView txtTempoLanterna;

    boolean hasCameraFlash = false;
    boolean flashOn = false;
    int Corpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);

        txtTempoLanterna = findViewById(R.id.txtTempoLanterna);

        Button btnmorri = (Button)findViewById(R.id.btnmorri);
        btnmorri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(JogadorActivity.this, MorriActivity.class));
            }
        });

        btnlanternajogador = findViewById(R.id.btnlanternajogador);
        btnecontrei = findViewById(R.id.btnecontrei);
        hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        long start = System.currentTimeMillis();
        long end = start + 20 * 1000;

        btnlanternajogador.setOnClickListener(new View.OnClickListener(){
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
                        Toast.makeText(JogadorActivity.this, "Lanterna não disponível", Toast.LENGTH_LONG).show();
                    }
                    btnlanternajogador.setClickable(false);
                    flashLightOff();
                    txtTempoLanterna.setText("Tempo de lanterna esgotado");
                }

        });

        btnecontrei.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView txtCorpo = findViewById(R.id.txtCorpo);
                EditText editJogadores = findViewById(R.id.editJogadores);
                int jog = Integer.parseInt(editJogadores.getText().toString());
                    Corpo++;
                    txtCorpo.setText(Integer.toString(Corpo) + " corpos encontrados");

                    if(Corpo >= jog){
                        startActivity(new Intent(JogadorActivity.this, PerdeuActivity.class));
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