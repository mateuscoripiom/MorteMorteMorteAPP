package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JogadorActivity extends AppCompatActivity{

    private Button btnlanternajogador;
    private Button btnecontrei;
    private TextView txtTempoLanterna;
    private SensorManager mSensorManager;
    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;

    boolean hasCameraFlash = false;
    boolean flashOn = false;
    boolean lanterna = true;
    int Corpo;
    int i;

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

        btnlanternajogador.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run(){
                        if (i == 1 && flashOn == true){
                            flashOn = false;
                            flashLightOff();
                            lanterna = false;
                            btnlanternajogador.setText("LANTERNA DES.");
                        }
                        else if (i == 1){
                            flashOn = true;
                            flashLightOn();
                            lanterna = false;
                            btnlanternajogador.setText("LANTERNA LIG.");
                        }
                        else if (i >= 1 &&  flashOn == false){
                            lanterna = false;
                            txtTempoLanterna.setText("Somente um uso da lanterna");
                        }
                        else if (i == 2){
                            flashOn = false;
                            flashLightOff();
                            lanterna = false;
                            btnlanternajogador.setText("LANTERNA DES.");
                        }
                        else{
                            lanterna = false;
                            txtTempoLanterna.setText("Somente um uso da lanterna");
                        }
                    }
                }, 500);
            }
        });

        btnecontrei.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView txtCorpo = findViewById(R.id.txtCorpo);
                    Corpo++;
                    txtCorpo.setText(Integer.toString(Corpo) + " corpos encontrados");

                    if(Corpo >= 14){
                        startActivity(new Intent(JogadorActivity.this, PerdeuActivity.class));
                    }
                    else{
                    }
            }
        });

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        SensorEventListener mSensorListener = null;
        Objects.requireNonNull(mSensorManager).registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
                SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 10f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
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

    private final SensorEventListener mSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta;
            if(lanterna = true && i<1) {
                if (mAccel > 12) {
                    if (hasCameraFlash) {
                        if (flashOn) {
                        } else {
                            flashOn = true;
                            flashLightOn();
                            btnlanternajogador.setText("LANTERNA LIG.");
                        }
                    } else {
                        Toast.makeText(JogadorActivity.this, "Lanterna não disponível", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onResume() {
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
                SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }
    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
    }

}