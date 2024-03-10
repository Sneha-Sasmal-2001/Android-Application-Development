package com.example.shaketoflash;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    Button b;
    CameraManager cm;
    String cameraId;
    boolean isFlashOn;//for checking if flash is on or off
    SensorManager sm;
    Sensor sensor;
    boolean interval;
    Vibrator vib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        interval=true;
        vib=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        cm = (CameraManager) getSystemService(CAMERA_SERVICE);
        try {
            cameraId = cm.getCameraIdList()[0];//CameraidList gives the list of id of all cameras of phone as an array and use this for selecting a camera id from it. [0] for rear camera and [1] for front camera
        } catch (CameraAccessException e) {
            Toast.makeText(getApplicationContext(), "your camera failed", Toast.LENGTH_SHORT).show();// this exception is for if the camera is not working it can't get the id and the toast will show
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnFlashOnOff();
            }
        });

    }

    private void turnFlashOnOff() {
        try {
            if (!isFlashOn) { //initially false so flash off
                isFlashOn = true;// when flash off makes it on by changing its boolean to true
                cm.setTorchMode(cameraId, isFlashOn);// here setTorchMode asks for two parameter 1. cameraId(to know which camera's flash i want to use cause there can be more than one flash) 2. isFlashOn (to know what to do if we want to on flash or make it off. here it'll return true cause we make it true and then i'll on the flash)
            } else {
                isFlashOn = false;
                cm.setTorchMode(cameraId, isFlashOn);
            }
            vib.vibrate(100);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Torch is failed", Toast.LENGTH_SHORT).show();// this exception is for if the flash is not working it can't access the flash and this toast will show
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);// sensor delay normal normalize the speed of fetching values of sensor
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float accGravity = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

            if (accGravity > 50f && interval) { //if shake reaches 50 so true and interval is also true execute 86 no. line
                Toast.makeText(getApplicationContext(), "shake detected", Toast.LENGTH_SHORT).show();
                turnFlashOnOff();//if flash is off it makes it on
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        interval=true;// after 750 mili seconds interval will be true and then if shake cross 50 and interval true flash will be off if its already on after turnFlashOnOff executes
                    }
                }, 750);// in 750 mili seconds though shake crosses 50 interval will still false
                interval=false;// handler starts and interval is false
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

