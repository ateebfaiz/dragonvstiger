package com.appsflyer.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AFa1dSDK {
    private static final BitSet AFLogger;
    @VisibleForTesting
    private static volatile AFa1dSDK afDebugLog;
    final Runnable AFInAppEventParameterName;
    boolean AFInAppEventType;
    final Handler AFKeystoreWrapper;
    private long AFLogger$LogLevel;
    /* access modifiers changed from: private */
    public int AFVersionDeclaration;
    /* access modifiers changed from: private */
    public final Map<AFa1jSDK, Map<String, Object>> afErrorLog;
    /* access modifiers changed from: private */
    public final SensorManager afErrorLogForExcManagerOnly;
    /* access modifiers changed from: private */
    public final Map<AFa1jSDK, AFa1jSDK> afInfoLog;
    final Runnable afRDLog;
    /* access modifiers changed from: private */
    public boolean afWarnLog;
    /* access modifiers changed from: private */
    public final Runnable getLevel;
    final Object valueOf = new Object();
    final Runnable values;

    static {
        BitSet bitSet = new BitSet(6);
        AFLogger = bitSet;
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    private AFa1dSDK(@NonNull SensorManager sensorManager, Handler handler) {
        BitSet bitSet = AFLogger;
        this.afInfoLog = new HashMap(bitSet.size());
        this.afErrorLog = new ConcurrentHashMap(bitSet.size());
        this.values = new Runnable() {
            public final void run() {
                synchronized (AFa1dSDK.this.valueOf) {
                    AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                    aFa1dSDK.AFKeystoreWrapper.post(new Runnable() {
                        public final void run() {
                            try {
                                for (Sensor next : AFa1dSDK.this.afErrorLogForExcManagerOnly.getSensorList(-1)) {
                                    if (AFa1dSDK.values(next.getType())) {
                                        AFa1jSDK aFa1jSDK = new AFa1jSDK(next);
                                        if (!AFa1dSDK.this.afInfoLog.containsKey(aFa1jSDK)) {
                                            AFa1dSDK.this.afInfoLog.put(aFa1jSDK, aFa1jSDK);
                                        }
                                        AFa1dSDK.this.afErrorLogForExcManagerOnly.registerListener((SensorEventListener) AFa1dSDK.this.afInfoLog.get(aFa1jSDK), next, 0, AFa1dSDK.this.AFKeystoreWrapper);
                                    }
                                }
                            } catch (Throwable th) {
                                AFLogger.afErrorLogForExcManagerOnly("registerListeners error", th);
                            }
                            boolean unused = AFa1dSDK.this.afWarnLog = true;
                        }
                    });
                    AFa1dSDK aFa1dSDK2 = AFa1dSDK.this;
                    aFa1dSDK2.AFKeystoreWrapper.postDelayed(aFa1dSDK2.getLevel, 100);
                    AFa1dSDK.this.AFInAppEventType = true;
                }
            }
        };
        this.AFInAppEventParameterName = new Runnable() {
            public final void run() {
                synchronized (AFa1dSDK.this.valueOf) {
                    AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                    aFa1dSDK.AFKeystoreWrapper.post(new Runnable() {
                        public final void run() {
                            try {
                                if (!AFa1dSDK.this.afInfoLog.isEmpty()) {
                                    for (AFa1jSDK aFa1jSDK : AFa1dSDK.this.afInfoLog.values()) {
                                        AFa1dSDK.this.afErrorLogForExcManagerOnly.unregisterListener(aFa1jSDK);
                                        aFa1jSDK.values(AFa1dSDK.this.afErrorLog, true);
                                    }
                                }
                            } catch (Throwable th) {
                                AFLogger.afErrorLogForExcManagerOnly("error while unregistering listeners", th);
                            }
                            int unused = AFa1dSDK.this.AFVersionDeclaration = 0;
                            boolean unused2 = AFa1dSDK.this.afWarnLog = false;
                        }
                    });
                }
            }
        };
        this.afRDLog = new Runnable() {
            public final void run() {
                synchronized (AFa1dSDK.this.valueOf) {
                    try {
                        AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                        if (aFa1dSDK.AFInAppEventType) {
                            aFa1dSDK.AFKeystoreWrapper.removeCallbacks(aFa1dSDK.values);
                            AFa1dSDK aFa1dSDK2 = AFa1dSDK.this;
                            aFa1dSDK2.AFKeystoreWrapper.removeCallbacks(aFa1dSDK2.AFInAppEventParameterName);
                            AFa1dSDK aFa1dSDK3 = AFa1dSDK.this;
                            aFa1dSDK3.AFKeystoreWrapper.post(new Runnable() {
                                public final void run() {
                                    try {
                                        if (!AFa1dSDK.this.afInfoLog.isEmpty()) {
                                            for (AFa1jSDK aFa1jSDK : AFa1dSDK.this.afInfoLog.values()) {
                                                AFa1dSDK.this.afErrorLogForExcManagerOnly.unregisterListener(aFa1jSDK);
                                                aFa1jSDK.values(AFa1dSDK.this.afErrorLog, true);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        AFLogger.afErrorLogForExcManagerOnly("error while unregistering listeners", th);
                                    }
                                    int unused = AFa1dSDK.this.AFVersionDeclaration = 0;
                                    boolean unused2 = AFa1dSDK.this.afWarnLog = false;
                                }
                            });
                            AFa1dSDK.this.AFInAppEventType = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.AFVersionDeclaration = 1;
        this.AFLogger$LogLevel = 0;
        this.getLevel = new Runnable() {
            public final void run() {
                synchronized (AFa1dSDK.this.valueOf) {
                    try {
                        if (AFa1dSDK.this.AFVersionDeclaration == 0) {
                            int unused = AFa1dSDK.this.AFVersionDeclaration = 1;
                        }
                        AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                        aFa1dSDK.AFKeystoreWrapper.postDelayed(aFa1dSDK.AFInAppEventParameterName, ((long) aFa1dSDK.AFVersionDeclaration) * 500);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.afErrorLogForExcManagerOnly = sensorManager;
        this.AFKeystoreWrapper = handler;
    }

    @NonNull
    private List<Map<String, Object>> valueOf() {
        synchronized (this.valueOf) {
            try {
                if (!this.afInfoLog.isEmpty() && this.afWarnLog) {
                    for (AFa1jSDK values2 : this.afInfoLog.values()) {
                        values2.values(this.afErrorLog, false);
                    }
                }
                if (this.afErrorLog.isEmpty()) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                    return copyOnWriteArrayList;
                }
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.afErrorLog.values());
                return copyOnWriteArrayList2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean values(int i10) {
        return i10 >= 0 && AFLogger.get(i10);
    }

    private static AFa1dSDK AFInAppEventParameterName(SensorManager sensorManager, Handler handler) {
        if (afDebugLog == null) {
            synchronized (AFa1dSDK.class) {
                try {
                    if (afDebugLog == null) {
                        afDebugLog = new AFa1dSDK(sensorManager, handler);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return afDebugLog;
    }

    static AFa1dSDK AFInAppEventType(Context context) {
        if (afDebugLog != null) {
            return afDebugLog;
        }
        HandlerThread handlerThread = new HandlerThread("internal");
        handlerThread.start();
        return AFInAppEventParameterName((SensorManager) context.getApplicationContext().getSystemService("sensor"), new Handler(handlerThread.getLooper()));
    }

    /* access modifiers changed from: package-private */
    public final List<Map<String, Object>> AFKeystoreWrapper() {
        for (AFa1jSDK values2 : this.afInfoLog.values()) {
            values2.values(this.afErrorLog, true);
        }
        Map<AFa1jSDK, Map<String, Object>> map = this.afErrorLog;
        if (map == null || map.isEmpty()) {
            return new CopyOnWriteArrayList(Collections.emptyList());
        }
        return new CopyOnWriteArrayList(this.afErrorLog.values());
    }

    /* access modifiers changed from: package-private */
    public final Map<String, Object> AFInAppEventParameterName() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        List<Map<String, Object>> valueOf2 = valueOf();
        if (!valueOf2.isEmpty()) {
            concurrentHashMap.put("sensors", valueOf2);
        } else {
            List<Map<String, Object>> AFKeystoreWrapper2 = AFKeystoreWrapper();
            if (!AFKeystoreWrapper2.isEmpty()) {
                concurrentHashMap.put("sensors", AFKeystoreWrapper2);
            }
        }
        return concurrentHashMap;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void AFInAppEventType() {
        this.AFKeystoreWrapper.post(this.afRDLog);
    }
}
