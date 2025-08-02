package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class AFa1jSDK implements SensorEventListener {
    @NonNull
    private final String AFInAppEventParameterName;
    private final float[][] AFInAppEventType = new float[2][];
    @NonNull
    private final String AFKeystoreWrapper;
    private double AFLogger;
    private long afErrorLog;
    private final int afInfoLog;
    @Nullable
    private Executor afRDLog;
    private final long[] valueOf = new long[2];
    private final int values;

    AFa1jSDK(Sensor sensor) {
        int type = sensor.getType();
        this.values = type;
        String name = sensor.getName();
        String str = "";
        name = name == null ? str : name;
        this.AFKeystoreWrapper = name;
        String vendor = sensor.getVendor();
        str = vendor != null ? vendor : str;
        this.AFInAppEventParameterName = str;
        this.afInfoLog = ((((type + 31) * 31) + name.hashCode()) * 31) + str.hashCode();
    }

    private boolean AFInAppEventParameterName(int i10, @NonNull String str, @NonNull String str2) {
        if (this.values != i10 || !this.AFKeystoreWrapper.equals(str) || !this.AFInAppEventParameterName.equals(str2)) {
            return false;
        }
        return true;
    }

    private static double AFInAppEventType(@NonNull float[] fArr, @NonNull float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d10 = 0.0d;
        for (int i10 = 0; i10 < min; i10++) {
            d10 += StrictMath.pow((double) (fArr[i10] - fArr2[i10]), 2.0d);
        }
        return Math.sqrt(d10);
    }

    private boolean AFKeystoreWrapper() {
        if (this.AFInAppEventType[0] != null) {
            return true;
        }
        return false;
    }

    @NonNull
    private synchronized Executor valueOf() {
        try {
            if (this.afRDLog == null) {
                this.afRDLog = Executors.newSingleThreadExecutor();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afRDLog;
    }

    @NonNull
    private static List<Float> values(@NonNull float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf2 : fArr) {
            arrayList.add(Float.valueOf(valueOf2));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AFa1jSDK)) {
            return false;
        }
        AFa1jSDK aFa1jSDK = (AFa1jSDK) obj;
        return AFInAppEventParameterName(aFa1jSDK.values, aFa1jSDK.AFKeystoreWrapper, aFa1jSDK.AFInAppEventParameterName);
    }

    public final int hashCode() {
        return this.afInfoLog;
    }

    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            valueOf().execute(new b(this, sensorEvent));
        } else {
            values(sensorEvent);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: AFInAppEventType */
    public void values(SensorEvent sensorEvent) {
        long j10 = sensorEvent.timestamp;
        float[] fArr = sensorEvent.values;
        long currentTimeMillis = System.currentTimeMillis();
        float[][] fArr2 = this.AFInAppEventType;
        float[] fArr3 = fArr2[0];
        if (fArr3 == null) {
            fArr2[0] = Arrays.copyOf(fArr, fArr.length);
            this.valueOf[0] = currentTimeMillis;
            return;
        }
        float[] fArr4 = fArr2[1];
        if (fArr4 == null) {
            float[] copyOf = Arrays.copyOf(fArr, fArr.length);
            this.AFInAppEventType[1] = copyOf;
            this.valueOf[1] = currentTimeMillis;
            this.AFLogger = AFInAppEventType(fArr3, copyOf);
        } else if (50000000 <= j10 - this.afErrorLog) {
            this.afErrorLog = j10;
            if (Arrays.equals(fArr4, fArr)) {
                this.valueOf[1] = currentTimeMillis;
                return;
            }
            double AFInAppEventType2 = AFInAppEventType(fArr3, fArr);
            if (AFInAppEventType2 > this.AFLogger) {
                this.AFInAppEventType[1] = Arrays.copyOf(fArr, fArr.length);
                this.valueOf[1] = currentTimeMillis;
                this.AFLogger = AFInAppEventType2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void values(@NonNull Map<AFa1jSDK, Map<String, Object>> map, boolean z10) {
        if (AFKeystoreWrapper()) {
            map.put(this, values());
            if (z10) {
                int length = this.AFInAppEventType.length;
                for (int i10 = 0; i10 < length; i10++) {
                    this.AFInAppEventType[i10] = null;
                }
                int length2 = this.valueOf.length;
                for (int i11 = 0; i11 < length2; i11++) {
                    this.valueOf[i11] = 0;
                }
                this.AFLogger = 0.0d;
                this.afErrorLog = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, values());
        }
    }

    @NonNull
    private Map<String, Object> values() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.values));
        concurrentHashMap.put("sN", this.AFKeystoreWrapper);
        concurrentHashMap.put("sV", this.AFInAppEventParameterName);
        float[] fArr = this.AFInAppEventType[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", values(fArr));
        }
        float[] fArr2 = this.AFInAppEventType[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", values(fArr2));
        }
        return concurrentHashMap;
    }
}
