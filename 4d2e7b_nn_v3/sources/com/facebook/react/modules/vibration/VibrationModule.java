package com.facebook.react.modules.vibration;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import c7.d;
import com.facebook.fbreact.specs.NativeVibrationSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import kotlin.jvm.internal.m;
import s6.a;

@SuppressLint({"MissingPermission"})
@a(name = "Vibration")
public final class VibrationModule extends NativeVibrationSpec {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VibrationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
    }

    private final Vibrator getVibrator() {
        if (Build.VERSION.SDK_INT < 31) {
            return (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        }
        VibratorManager a10 = d.a(getReactApplicationContext().getSystemService("vibrator_manager"));
        if (a10 != null) {
            return a10.getDefaultVibrator();
        }
        return null;
    }

    public void cancel() {
        Vibrator vibrator = getVibrator();
        if (vibrator != null) {
            vibrator.cancel();
        }
    }

    public void vibrate(double d10) {
        int i10 = (int) d10;
        Vibrator vibrator = getVibrator();
        if (vibrator != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot((long) i10, -1));
            } else {
                vibrator.vibrate((long) i10);
            }
        }
    }

    public void vibrateByPattern(ReadableArray readableArray, double d10) {
        m.f(readableArray, "pattern");
        int i10 = (int) d10;
        Vibrator vibrator = getVibrator();
        if (vibrator != null) {
            long[] jArr = new long[readableArray.size()];
            int size = readableArray.size();
            for (int i11 = 0; i11 < size; i11++) {
                jArr[i11] = (long) readableArray.getInt(i11);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createWaveform(jArr, i10));
            } else {
                vibrator.vibrate(jArr, i10);
            }
        }
    }
}
