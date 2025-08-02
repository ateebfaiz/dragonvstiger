package com.cocos.lib;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class CocosSensorHandler implements SensorEventListener {
    private static final String TAG = "CocosSensorHandler";
    private static boolean mEnableSensor;
    private static CocosSensorHandler mSensorHandler;
    private static float[] sDeviceMotionValues = new float[9];
    private Sensor mAcceleration;
    private Sensor mAccelerationIncludingGravity;
    private final Context mContext;
    private Sensor mGyroscope;
    private int mSamplingPeriodUs = 1;
    private SensorManager mSensorManager;

    public CocosSensorHandler(Context context) {
        this.mContext = context;
        mSensorHandler = this;
    }

    public static float[] getDeviceMotionValue() {
        return sDeviceMotionValues;
    }

    public static void setAccelerometerEnabled(boolean z10) {
        mEnableSensor = z10;
        if (z10) {
            mSensorHandler.enable();
        } else {
            mSensorHandler.disable();
        }
    }

    public static void setAccelerometerInterval(float f10) {
        mSensorHandler.setInterval(f10);
    }

    public void disable() {
        SensorManager sensorManager;
        if (mEnableSensor && (sensorManager = this.mSensorManager) != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public void enable() {
        if (mEnableSensor) {
            if (this.mSensorManager == null) {
                SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
                this.mSensorManager = sensorManager;
                this.mAcceleration = sensorManager.getDefaultSensor(1);
                this.mAccelerationIncludingGravity = this.mSensorManager.getDefaultSensor(10);
                this.mGyroscope = this.mSensorManager.getDefaultSensor(4);
            }
            this.mSensorManager.registerListener(this, this.mAcceleration, this.mSamplingPeriodUs);
            this.mSensorManager.registerListener(this, this.mAccelerationIncludingGravity, this.mSamplingPeriodUs);
            this.mSensorManager.registerListener(this, this.mGyroscope, this.mSamplingPeriodUs);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    public void onPause() {
        disable();
    }

    public void onResume() {
        enable();
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            float[] fArr = sDeviceMotionValues;
            float[] fArr2 = sensorEvent.values;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[2] = -fArr2[2];
        } else if (type == 10) {
            float[] fArr3 = sDeviceMotionValues;
            float[] fArr4 = sensorEvent.values;
            fArr3[3] = fArr4[0];
            fArr3[4] = fArr4[1];
            fArr3[5] = fArr4[2];
        } else if (type == 4) {
            sDeviceMotionValues[6] = (float) Math.toDegrees((double) sensorEvent.values[0]);
            sDeviceMotionValues[7] = (float) Math.toDegrees((double) sensorEvent.values[1]);
            sDeviceMotionValues[8] = (float) Math.toDegrees((double) sensorEvent.values[2]);
        }
    }

    public void setInterval(float f10) {
        this.mSamplingPeriodUs = (int) (f10 * 1000000.0f);
        disable();
        enable();
    }
}
