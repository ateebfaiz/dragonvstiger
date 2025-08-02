package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

public final class zzic implements t1 {
    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    @Nullable
    static zzic zza(Context context, String str, Runnable runnable) {
        zzic zzic;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        if (!zzhb.zzb()) {
            synchronized (zzic.class) {
                try {
                    zzic = (zzic) zza.get((Object) null);
                    if (zzic == null) {
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        throw null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzic;
        }
        throw null;
    }

    static synchronized void zzc() {
        synchronized (zzic.class) {
            Map map = zza;
            Iterator it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                SharedPreferences sharedPreferences = ((zzic) it.next()).zzb;
                throw null;
            }
        }
    }

    @Nullable
    public final Object zzb(String str) {
        throw null;
    }
}
