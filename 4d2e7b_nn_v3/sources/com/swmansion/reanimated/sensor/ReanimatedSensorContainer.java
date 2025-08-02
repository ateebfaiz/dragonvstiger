package com.swmansion.reanimated.sensor;

import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.swmansion.reanimated.nativeProxy.SensorSetter;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ReanimatedSensorContainer {
    private int nextSensorId = 0;
    private final WeakReference<ReactApplicationContext> reactContext;
    private final HashMap<Integer, ReanimatedSensor> sensors = new HashMap<>();

    public ReanimatedSensorContainer(WeakReference<ReactApplicationContext> weakReference) {
        this.reactContext = weakReference;
    }

    public int registerSensor(ReanimatedSensorType reanimatedSensorType, int i10, SensorSetter sensorSetter) {
        ReanimatedSensor reanimatedSensor = new ReanimatedSensor(this.reactContext, reanimatedSensorType, i10, sensorSetter);
        if (!reanimatedSensor.initialize()) {
            return -1;
        }
        int i11 = this.nextSensorId;
        this.nextSensorId = i11 + 1;
        this.sensors.put(Integer.valueOf(i11), reanimatedSensor);
        return i11;
    }

    public void unregisterSensor(int i10) {
        ReanimatedSensor reanimatedSensor = this.sensors.get(Integer.valueOf(i10));
        if (reanimatedSensor != null) {
            reanimatedSensor.cancel();
            this.sensors.remove(Integer.valueOf(i10));
            return;
        }
        Log.e("Reanimated", "Tried to unregister nonexistent sensor");
    }
}
