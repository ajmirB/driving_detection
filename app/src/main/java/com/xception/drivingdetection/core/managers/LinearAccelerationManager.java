package com.xception.drivingdetection.core.managers;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import io.reactivex.Observable;

public class LinearAccelerationManager {

    // Manager of all sensors in the device
    private SensorManager mSensorManager;

    // Linear acceleration sensor
    private Sensor mSensor;

    // Listener on sensor linear acceleration events
    private SensorEventListener mSensorEventListener;

    public LinearAccelerationManager(Context context) {
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
    }

    /**
     * @return an observable which deliver the current acceleration in m/s²
     */
    public Observable<Integer> getCurrentAcceleration() {
        return Observable.<Integer>create(emitter -> {
                    mSensorEventListener = new SensorEventListener() {
                        @Override
                        public void onSensorChanged(SensorEvent sensorEvent) {
                            Integer acceleration = (int) Math.sqrt(Math.pow(sensorEvent.values[0], 2) + Math.pow(sensorEvent.values[1], 2) +Math.pow(sensorEvent.values[2], 2));
                            emitter.onNext(acceleration);
                        }

                        @Override
                        public void onAccuracyChanged(Sensor sensor, int i) {
                        }
                    };

                    // Register on the linear acceleration changed
                    mSensorManager.registerListener(
                            mSensorEventListener,
                            mSensor,
                            SensorManager.SENSOR_DELAY_NORMAL);
                })
                // When the observable is destroyed, we stop listening in sensor events
                .doOnDispose(() -> mSensorManager.unregisterListener(mSensorEventListener));
    }
}
