package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
public class Logger {
    private final String zza;
    private final String zzb;
    private final GmsLogger zzc;
    private final int zzd;

    @KeepForSdk
    public Logger(@NonNull String str, @NonNull String... strArr) {
        String str2;
        if (r0 == 0) {
            str2 = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str3 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str3);
            }
            sb2.append("] ");
            str2 = sb2.toString();
        }
        this.zzb = str2;
        this.zza = str;
        this.zzc = new GmsLogger(str);
        int i10 = 2;
        while (i10 <= 7 && !Log.isLoggable(this.zza, i10)) {
            i10++;
        }
        this.zzd = i10;
    }

    @KeepForSdk
    public void d(@NonNull String str, @NonNull Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.zza, format(str, objArr));
        }
    }

    @KeepForSdk
    public void e(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        Log.e(this.zza, format(str, objArr), th);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public String format(@NonNull String str, @NonNull Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }

    @NonNull
    @KeepForSdk
    public String getTag() {
        return this.zza;
    }

    @KeepForSdk
    public void i(@NonNull String str, @NonNull Object... objArr) {
        Log.i(this.zza, format(str, objArr));
    }

    @KeepForSdk
    public boolean isLoggable(int i10) {
        return this.zzd <= i10;
    }

    @KeepForSdk
    public void v(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr), th);
        }
    }

    @KeepForSdk
    public void w(@NonNull String str, @NonNull Object... objArr) {
        Log.w(this.zza, format(str, objArr));
    }

    @KeepForSdk
    public void wtf(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        Log.wtf(this.zza, format(str, objArr), th);
    }

    @KeepForSdk
    public void e(@NonNull String str, @NonNull Object... objArr) {
        Log.e(this.zza, format(str, objArr));
    }

    @KeepForSdk
    public void wtf(@NonNull Throwable th) {
        Log.wtf(this.zza, th);
    }

    @KeepForSdk
    public void v(@NonNull String str, @NonNull Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr));
        }
    }
}
