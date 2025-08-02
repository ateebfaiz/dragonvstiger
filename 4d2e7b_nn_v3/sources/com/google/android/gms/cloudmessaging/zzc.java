package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.util.Log;

public final class zzc extends ClassLoader {
    /* access modifiers changed from: protected */
    public final Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
        if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
            return super.loadClass(str, z10);
        }
        if (!Log.isLoggable("CloudMessengerCompat", 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("CloudMessengerCompat", 3))) {
            return zzd.class;
        }
        Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
        return zzd.class;
    }
}
