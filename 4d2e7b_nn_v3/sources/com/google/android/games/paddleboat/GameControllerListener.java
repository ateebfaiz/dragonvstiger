package com.google.android.games.paddleboat;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.lights.Light;
import android.hardware.lights.LightState;
import android.hardware.lights.LightsManager;
import android.hardware.lights.LightsRequest;
import android.os.Build;
import android.util.Log;
import android.view.InputDevice;
import java.util.Iterator;

public class GameControllerListener {
    private static final String TAG = "GameControllerListener";
    private Sensor accelerometer;
    private a accelerometerListener;
    /* access modifiers changed from: private */
    public final GameControllerManager gameControllerManager;
    private Sensor gyroscope;
    private b gyroscopeListener;
    private InputDevice inputDevice;
    private int inputDeviceFlags;
    /* access modifiers changed from: private */
    public int inputDeviceId;
    @GuardedBy("mLightLock")
    private LightsManager lightsManager;
    private LightsManager.LightsSession lightsSession;
    private final Object mLightLock = new Object();
    private final Object mSensorLock = new Object();
    private boolean reportMotionEvents;
    @GuardedBy("mSensorLock")
    private SensorManager sensorManager;

    class a implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        private final Sensor f6605a;

        a(Sensor sensor) {
            this.f6605a = sensor;
        }

        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor = this.f6605a;
            if (sensor != null) {
                synchronized (sensor) {
                    try {
                        if (sensorEvent.sensor == this.f6605a) {
                            GameControllerManager access$100 = GameControllerListener.this.gameControllerManager;
                            int access$000 = GameControllerListener.this.inputDeviceId;
                            long j10 = sensorEvent.timestamp;
                            float[] fArr = sensorEvent.values;
                            access$100.onMotionData(access$000, 0, j10, fArr[0], fArr[1], fArr[2]);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    class b implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        private final Sensor f6607a;

        b(Sensor sensor) {
            this.f6607a = sensor;
        }

        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor = this.f6607a;
            if (sensor != null) {
                synchronized (sensor) {
                    try {
                        if (sensorEvent.sensor == this.f6607a) {
                            GameControllerManager access$100 = GameControllerListener.this.gameControllerManager;
                            int access$000 = GameControllerListener.this.inputDeviceId;
                            long j10 = sensorEvent.timestamp;
                            float[] fArr = sensorEvent.values;
                            access$100.onMotionData(access$000, 1, j10, fArr[0], fArr[1], fArr[2]);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public GameControllerListener(GameControllerManager gameControllerManager2, InputDevice inputDevice2, int i10, boolean z10) {
        this.gameControllerManager = gameControllerManager2;
        this.inputDevice = inputDevice2;
        this.inputDeviceFlags = i10;
        this.inputDeviceId = inputDevice2.getId();
        this.reportMotionEvents = z10;
        this.lightsManager = null;
        this.lightsSession = null;
        this.accelerometer = null;
        this.accelerometerListener = null;
        this.gyroscope = null;
        this.gyroscopeListener = null;
        this.sensorManager = null;
        configureMotion();
    }

    private void configureLights() {
        if (Build.VERSION.SDK_INT >= 31 && (this.inputDeviceFlags & 50331648) != 0) {
            synchronized (this.mLightLock) {
                Log.d(TAG, "configureLights");
                LightsManager a10 = this.inputDevice.getLightsManager();
                this.lightsManager = a10;
                this.lightsSession = a10.openSession();
            }
        }
    }

    private void configureMotion() {
        if (Build.VERSION.SDK_INT >= 31 && this.reportMotionEvents) {
            synchronized (this.mSensorLock) {
                try {
                    SensorManager a10 = this.inputDevice.getSensorManager();
                    this.sensorManager = a10;
                    if ((this.inputDeviceFlags & 12582912) != 0) {
                        Sensor defaultSensor = a10.getDefaultSensor(1);
                        this.accelerometer = defaultSensor;
                        if (defaultSensor != null) {
                            if (this.gameControllerManager.getPrintControllerInfo()) {
                                printSensorInformation(this.accelerometer, "accelerometer");
                            }
                            this.accelerometerListener = new a(this.accelerometer);
                            Log.d(TAG, "registering listener for accelerometer");
                            this.sensorManager.registerListener(this.accelerometerListener, this.accelerometer, 1);
                        }
                        Sensor defaultSensor2 = this.sensorManager.getDefaultSensor(4);
                        this.gyroscope = defaultSensor2;
                        if (defaultSensor2 != null) {
                            if (this.gameControllerManager.getPrintControllerInfo()) {
                                printSensorInformation(this.gyroscope, "gyroscope");
                            }
                            this.gyroscopeListener = new b(this.gyroscope);
                            Log.d(TAG, "registering listener for gyroscope");
                            this.sensorManager.registerListener(this.gyroscopeListener, this.gyroscope, 1);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void printSensorInformation(Sensor sensor, String str) {
        Log.d(TAG, "Registering listener for " + str);
        Log.d(TAG, "Begin sensor information -----------------------------");
        int i10 = Build.VERSION.SDK_INT;
        Log.d(TAG, "getFifoMaxEventCount: " + sensor.getFifoMaxEventCount());
        Log.d(TAG, "getFifoReservedEventCount: " + sensor.getFifoReservedEventCount());
        if (i10 >= 26) {
            Log.d(TAG, "getHighestDirectReportRateLevel: " + sensor.getHighestDirectReportRateLevel());
        }
        if (i10 >= 24) {
            Log.d(TAG, "getId: " + sensor.getId());
        }
        Log.d(TAG, "getMaxDelay: " + sensor.getMaxDelay());
        Log.d(TAG, "getMaximumRange: " + sensor.getMaximumRange());
        Log.d(TAG, "getMinDelay: " + sensor.getMinDelay());
        Log.d(TAG, "getName: " + sensor.getName());
        Log.d(TAG, "getPower: " + sensor.getPower());
        Log.d(TAG, "getReportingMode: " + sensor.getReportingMode());
        Log.d(TAG, "getVendor: " + sensor.getVendor());
        Log.d(TAG, "getVersion: " + sensor.getVersion());
        if (i10 >= 24) {
            Log.d(TAG, "isAdditionalInfoSupported: " + sensor.isAdditionalInfoSupported());
        }
        if (i10 >= 26) {
            boolean a10 = sensor.isDirectChannelTypeSupported(1);
            boolean a11 = sensor.isDirectChannelTypeSupported(2);
            Log.d(TAG, "DirectChannel Memory File: " + a10);
            Log.d(TAG, "DirectChannel Hardware Buffer: " + a11);
        }
        Log.d(TAG, "End sensor information -------------------------------");
    }

    public void resetListener(InputDevice inputDevice2, int i10) {
        shutdownListener();
        this.inputDevice = inputDevice2;
        this.inputDeviceFlags = i10;
        this.inputDeviceId = inputDevice2.getId();
        configureMotion();
    }

    public void setLight(int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 31) {
            synchronized (this.mLightLock) {
                try {
                    if (this.lightsManager == null) {
                        configureLights();
                    }
                    LightsManager lightsManager2 = this.lightsManager;
                    if (lightsManager2 != null) {
                        Iterator it = lightsManager2.getLights().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Light a10 = r.a(it.next());
                            if (i10 != 0 || a10.getType() != 10002) {
                                if (i10 == 1 && a10.hasRgbControl()) {
                                    m.a();
                                    LightState.Builder a11 = j.a();
                                    LightState.Builder unused = a11.setColor(i11);
                                    n.a();
                                    LightsRequest.Builder a12 = k.a();
                                    LightsRequest.Builder unused2 = a12.addLight(a10, a11.build());
                                    this.lightsSession.requestLights(a12.build());
                                    break;
                                }
                            } else {
                                m.a();
                                LightState.Builder a13 = j.a();
                                LightState.Builder unused3 = a13.setPlayerId(i11);
                                n.a();
                                LightsRequest.Builder a14 = k.a();
                                LightsRequest.Builder unused4 = a14.addLight(a10, a13.build());
                                this.lightsSession.requestLights(a14.build());
                                break;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void setReportMotionEvents() {
        this.reportMotionEvents = true;
        configureMotion();
    }

    public void shutdownListener() {
        if (Build.VERSION.SDK_INT >= 31) {
            Log.d(TAG, "shutdownListener");
            synchronized (this.mLightLock) {
                try {
                    LightsManager.LightsSession lightsSession2 = this.lightsSession;
                    if (lightsSession2 != null) {
                        lightsSession2.close();
                    }
                    this.lightsSession = null;
                    this.lightsManager = null;
                } finally {
                    while (true) {
                    }
                }
            }
            synchronized (this.mSensorLock) {
                try {
                    SensorManager sensorManager2 = this.sensorManager;
                    if (sensorManager2 != null) {
                        a aVar = this.accelerometerListener;
                        if (aVar != null) {
                            sensorManager2.unregisterListener(aVar);
                            this.accelerometerListener = null;
                        }
                        b bVar = this.gyroscopeListener;
                        if (bVar != null) {
                            this.sensorManager.unregisterListener(bVar);
                            this.gyroscopeListener = null;
                        }
                    }
                    this.accelerometer = null;
                    this.gyroscope = null;
                    this.sensorManager = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.inputDeviceFlags = 0;
        this.inputDevice = null;
    }
}
