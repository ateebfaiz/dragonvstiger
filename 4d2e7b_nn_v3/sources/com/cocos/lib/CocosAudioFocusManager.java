package com.cocos.lib;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.util.Log;

abstract class CocosAudioFocusManager {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f19219a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final AudioManager.OnAudioFocusChangeListener f19220b = new k();

    static boolean g() {
        return f19219a;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void m(int i10) {
        Log.d("CocosAudioFocusManager", "onAudioFocusChange: " + i10 + ", thread: " + Thread.currentThread().getName());
        if (i10 == -1) {
            Log.d("CocosAudioFocusManager", "Pause music by AUDIOFOCUS_LOSS");
            f19219a = true;
            CocosHelper.runOnGameThreadAtForeground(new m());
        } else if (i10 == -2) {
            Log.d("CocosAudioFocusManager", "Pause music by AUDIOFOCUS_LOSS_TRANSILENT");
            f19219a = true;
            CocosHelper.runOnGameThreadAtForeground(new n());
        } else if (i10 == -3) {
            Log.d("CocosAudioFocusManager", "Lower the volume, keep playing by AUDIOFOCUS_LOSS_TRANSILENT_CAN_DUCK");
            f19219a = false;
            CocosHelper.runOnGameThreadAtForeground(new i());
        } else if (i10 == 1) {
            Log.d("CocosAudioFocusManager", "Resume music by AUDIOFOCUS_GAIN");
            f19219a = false;
            CocosHelper.runOnGameThreadAtForeground(new j());
        }
    }

    static void n(Context context) {
        int i10;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (Build.VERSION.SDK_INT >= 26) {
            i10 = audioManager.requestAudioFocus(h.a(3).setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(2).build()).setWillPauseWhenDucked(true).setOnAudioFocusChangeListener(f19220b).build());
        } else {
            i10 = audioManager.requestAudioFocus(f19220b, 3, 3);
        }
        if (i10 == 1) {
            Log.d("CocosAudioFocusManager", "requestAudioFocus succeed");
            f19219a = false;
            CocosHelper.runOnGameThreadAtForeground(new l());
            return;
        }
        Log.e("CocosAudioFocusManager", "requestAudioFocus failed!");
    }

    /* access modifiers changed from: private */
    public static native void nativeSetAudioVolumeFactor(float f10);

    static void o(Context context) {
        if (((AudioManager) context.getSystemService("audio")).abandonAudioFocus(f19220b) == 1) {
            Log.d("CocosAudioFocusManager", "abandonAudioFocus succeed!");
        } else {
            Log.e("CocosAudioFocusManager", "abandonAudioFocus failed!");
        }
    }
}
