package com.swmansion.reanimated.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import com.swmansion.reanimated.nativeProxy.SensorSetter;

public class ReanimatedSensorListener implements SensorEventListener {
    private final Display display;
    private final double interval;
    private double lastRead = ((double) System.currentTimeMillis());
    private float[] orientation = new float[3];
    private float[] quaternion = new float[4];
    private float[] rotation = new float[9];
    private SensorSetter setter;

    ReanimatedSensorListener(SensorSetter sensorSetter, double d10, Display display2) {
        this.setter = sensorSetter;
        this.interval = d10;
        this.display = display2;
    }

    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        int i10;
        double currentTimeMillis = (double) System.currentTimeMillis();
        if (currentTimeMillis - this.lastRead >= this.interval) {
            int type = sensorEvent.sensor.getType();
            this.lastRead = currentTimeMillis;
            int rotation2 = this.display.getRotation();
            if (rotation2 == 1) {
                i10 = 90;
            } else if (rotation2 == 2) {
                i10 = 180;
            } else if (rotation2 != 3) {
                i10 = 0;
            } else {
                i10 = 270;
            }
            if (type == 2 || type == 4) {
                float[] fArr = sensorEvent.values;
                this.setter.sensorSetter(new float[]{fArr[0], fArr[1], fArr[2]}, i10);
                return;
            }
            switch (type) {
                case 9:
                case 10:
                    float[] fArr2 = sensorEvent.values;
                    this.setter.sensorSetter(new float[]{-fArr2[0], -fArr2[1], -fArr2[2]}, i10);
                    return;
                case 11:
                    SensorManager.getQuaternionFromVector(this.quaternion, sensorEvent.values);
                    SensorManager.getRotationMatrixFromVector(this.rotation, sensorEvent.values);
                    SensorManager.getOrientation(this.rotation, this.orientation);
                    float[] fArr3 = this.quaternion;
                    float f10 = fArr3[1];
                    float f11 = fArr3[3];
                    float f12 = fArr3[0];
                    float[] fArr4 = this.orientation;
                    this.setter.sensorSetter(new float[]{f10, f11, -fArr3[2], f12, -fArr4[0], -fArr4[1], fArr4[2]}, i10);
                    return;
                default:
                    throw new IllegalArgumentException("[Reanimated] Unknown sensor type.");
            }
        }
    }
}
