package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

@KeepForSdk
public class Storage {
    private static final Lock zaa = new ReentrantLock();
    @Nullable
    private static Storage zab;
    private final Lock zac = new ReentrantLock();
    private final SharedPreferences zad;

    @VisibleForTesting
    Storage(Context context) {
        this.zad = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @NonNull
    @KeepForSdk
    public static Storage getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        Lock lock = zaa;
        lock.lock();
        try {
            if (zab == null) {
                zab = new Storage(context.getApplicationContext());
            }
            Storage storage = zab;
            lock.unlock();
            return storage;
        } catch (Throwable th) {
            zaa.unlock();
            throw th;
        }
    }

    private static final String zae(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(":");
        sb2.append(str2);
        return sb2.toString();
    }

    @KeepForSdk
    public void clear() {
        this.zac.lock();
        try {
            this.zad.edit().clear().apply();
        } finally {
            this.zac.unlock();
        }
    }

    @KeepForSdk
    @Nullable
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String zaa2;
        String zaa3 = zaa("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(zaa3) || (zaa2 = zaa(zae("googleSignInAccount", zaa3))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zab(zaa2);
        } catch (JSONException unused) {
            return null;
        }
    }

    @KeepForSdk
    @Nullable
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        String zaa2;
        String zaa3 = zaa("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(zaa3) || (zaa2 = zaa(zae("googleSignInOptions", zaa3))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zab(zaa2);
        } catch (JSONException unused) {
            return null;
        }
    }

    @KeepForSdk
    @Nullable
    public String getSavedRefreshToken() {
        return zaa("refreshToken");
    }

    @KeepForSdk
    public void saveDefaultGoogleSignInAccount(@NonNull GoogleSignInAccount googleSignInAccount, @NonNull GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        zad("defaultGoogleSignInAccount", googleSignInAccount.zac());
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String zac2 = googleSignInAccount.zac();
        zad(zae("googleSignInAccount", zac2), googleSignInAccount.zad());
        zad(zae("googleSignInOptions", zac2), googleSignInOptions.zaf());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zaa(@NonNull String str) {
        this.zac.lock();
        try {
            return this.zad.getString(str, (String) null);
        } finally {
            this.zac.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final void zab(@NonNull String str) {
        this.zac.lock();
        try {
            this.zad.edit().remove(str).apply();
        } finally {
            this.zac.unlock();
        }
    }

    public final void zac() {
        String zaa2 = zaa("defaultGoogleSignInAccount");
        zab("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(zaa2)) {
            zab(zae("googleSignInAccount", zaa2));
            zab(zae("googleSignInOptions", zaa2));
        }
    }

    /* access modifiers changed from: protected */
    public final void zad(@NonNull String str, @NonNull String str2) {
        this.zac.lock();
        try {
            this.zad.edit().putString(str, str2).apply();
        } finally {
            this.zac.unlock();
        }
    }
}
