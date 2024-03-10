package com.example.proximitysensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
        SensorManager sm;
        Sensor sensor;
        TextView tv;
        MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.textView);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);// system manager has all the sensors. Here (SensorManager) is used for type casting. cause sm is a object of SystemManager a getSystemService returns Object(which is a parent class of all classes in java), so it need to type caste.
        sensor=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY); // get a particular sensor from sensor manager
        mp=MediaPlayer.create(this,R.raw.siren);
        mp.setLooping(true);

    }

    @Override
    protected void onResume() { // value 5 (fixed for uniformity for all android phones) when no obstraction so distance from proximity sensor. onResume start the sensor(mandatory)
        super.onResume();
        sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);//start the proximity

    }

    @Override
    protected void onPause() { // value 0 when there is an obstraction so distance 0 from sensor. onPause stop the sensor( mandatory)
        super.onPause();
        sm.unregisterListener(this); // stop the proximity


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_PROXIMITY) //for selecting a particular sensor by matching their Type otherwise it'll start all the sensors. for any other sensor only the TYPE_PROXIMITY will change into that sensor (like TYPE_.....).
        {
            tv.setText(event.values[0]+""); //get values of proximity
            if(event.values[0]==0f)
                mp.pause();
            else
                mp.start();
            
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}