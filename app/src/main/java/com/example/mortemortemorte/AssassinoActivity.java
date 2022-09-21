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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class AssassinoActivity extends AppCompatActivity {
    private Button btnlanternaassassino;
    private Button btnmatei;
    private TextView txtTempoLanternaA;
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

        btnlanternaassassino.setOnClickListener(new View.OnClickListener(){
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
                            btnlanternaassassino.setText("LANTERNA DES.");
                        }
                        else if (i == 1){
                            flashOn = true;
                            flashLightOn();
                            lanterna = false;
                            btnlanternaassassino.setText("LANTERNA LIG.");
                        }
                        else if (i >= 1 &&  flashOn == false){
                            lanterna = false;
                            txtTempoLanternaA.setText("Somente um uso da lanterna");
                        }
                        else if (i == 2){
                            flashOn = false;
                            flashLightOff();
                            lanterna = false;
                            btnlanternaassassino.setText("LANTERNA DES.");
                        }
                        else{
                            lanterna = false;
                            txtTempoLanternaA.setText("Somente um uso da lanterna");
                        }
                    }
                }, 500);
            }

        });

        btnmatei.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView txtCorpoA = findViewById(R.id.txtCorpoA);
                Corpo++;
                txtCorpoA.setText(Integer.toString(Corpo) + " mortos");

                if(Corpo >= 14){
                    startActivity(new Intent(AssassinoActivity.this, GanhouActivity.class));
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
                            btnlanternaassassino.setText("LANTERNA LIG.");
                        }
                    } else {
                        Toast.makeText(AssassinoActivity.this, "Lanterna não disponível", Toast.LENGTH_LONG).show();
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