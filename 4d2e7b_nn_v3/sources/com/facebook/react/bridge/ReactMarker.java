package com.facebook.react.bridge;

import android.os.SystemClock;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import d6.a;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

@a
public class ReactMarker {
    private static final List<FabricMarkerListener> sFabricMarkerListeners = new CopyOnWriteArrayList();
    private static final List<MarkerListener> sListeners = new CopyOnWriteArrayList();
    private static Queue<ReactMarkerRecord> sNativeReactMarkerQueue = new ConcurrentLinkedQueue();

    public interface FabricMarkerListener {
        void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i10, long j10);

        void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i10, long j10, int i11);
    }

    public interface MarkerListener {
        void logMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i10);
    }

    private static class ReactMarkerRecord {
        private final String mMarkerName;
        private final long mMarkerTime;

        public ReactMarkerRecord(String str, long j10) {
            this.mMarkerName = str;
            this.mMarkerTime = j10;
        }

        public String getMarkerName() {
            return this.mMarkerName;
        }

        public long getMarkerTime() {
            return this.mMarkerTime;
        }
    }

    @a
    public static void addFabricListener(FabricMarkerListener fabricMarkerListener) {
        List<FabricMarkerListener> list = sFabricMarkerListeners;
        if (!list.contains(fabricMarkerListener)) {
            list.add(fabricMarkerListener);
        }
    }

    @a
    public static void addListener(MarkerListener markerListener) {
        List<MarkerListener> list = sListeners;
        if (!list.contains(markerListener)) {
            list.add(markerListener);
        }
    }

    @a
    public static void clearFabricMarkerListeners() {
        sFabricMarkerListeners.clear();
    }

    @a
    public static void clearMarkerListeners() {
        sListeners.clear();
    }

    @a
    public static void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i10, long j10, int i11) {
        for (FabricMarkerListener logFabricMarker : sFabricMarkerListeners) {
            logFabricMarker.logFabricMarker(reactMarkerConstants, str, i10, j10, i11);
        }
    }

    @a
    public static void logMarker(String str) {
        logMarker(str, (String) null);
    }

    @a
    private static native void nativeLogMarker(String str, long j10);

    @a
    private static void notifyNativeMarker(ReactMarkerConstants reactMarkerConstants, @Nullable Long l10) {
        if (reactMarkerConstants.hasMatchingNameMarker()) {
            if (l10 == null) {
                l10 = Long.valueOf(SystemClock.uptimeMillis());
            }
            if (ReactBridge.isInitialized()) {
                nativeLogMarker(reactMarkerConstants.name(), l10.longValue());
                while (true) {
                    ReactMarkerRecord poll = sNativeReactMarkerQueue.poll();
                    if (poll != null) {
                        nativeLogMarker(poll.getMarkerName(), poll.getMarkerTime());
                    } else {
                        return;
                    }
                }
            } else {
                sNativeReactMarkerQueue.add(new ReactMarkerRecord(reactMarkerConstants.name(), l10.longValue()));
            }
        }
    }

    @a
    public static void removeFabricListener(FabricMarkerListener fabricMarkerListener) {
        sFabricMarkerListeners.remove(fabricMarkerListener);
    }

    @a
    public static void removeListener(MarkerListener markerListener) {
        sListeners.remove(markerListener);
    }

    @a
    public static void logMarker(String str, int i10) {
        logMarker(str, (String) null, i10);
    }

    @a
    public static void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i10, long j10) {
        for (FabricMarkerListener logFabricMarker : sFabricMarkerListeners) {
            logFabricMarker.logFabricMarker(reactMarkerConstants, str, i10, j10, 0);
        }
    }

    @a
    public static void logMarker(String str, @Nullable String str2) {
        logMarker(str, str2, 0);
    }

    @a
    public static void logMarker(String str, @Nullable String str2, int i10) {
        logMarker(ReactMarkerConstants.valueOf(str), str2, i10);
    }

    @a
    public static void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i10) {
        logFabricMarker(reactMarkerConstants, str, i10, SystemClock.uptimeMillis(), 0);
    }

    @a
    public static void logMarker(ReactMarkerConstants reactMarkerConstants) {
        logMarker(reactMarkerConstants, (String) null, 0);
    }

    @a
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, int i10) {
        logMarker(reactMarkerConstants, (String) null, i10);
    }

    @a
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str) {
        logMarker(reactMarkerConstants, str, 0);
    }

    @a
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, long j10) {
        logMarker(reactMarkerConstants, (String) null, 0, Long.valueOf(j10));
    }

    @AnyThread
    @a
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i10) {
        logMarker(reactMarkerConstants, str, i10, (Long) null);
    }

    @AnyThread
    @a
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i10, @Nullable Long l10) {
        logFabricMarker(reactMarkerConstants, str, i10);
        for (MarkerListener logMarker : sListeners) {
            logMarker.logMarker(reactMarkerConstants, str, i10);
        }
        notifyNativeMarker(reactMarkerConstants, l10);
    }
}
