package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Handler;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzaq extends y0 {
    private long zza;
    private String zzb;
    private AccountManager zzc;
    private Boolean zzd;
    private long zze;

    zzaq(zzfr zzfr) {
        super(zzfr);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final long zza() {
        zzg();
        return this.zze;
    }

    public final long zzb() {
        zzu();
        return this.zza;
    }

    public final String zzc() {
        zzu();
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzd() {
        zzg();
        this.zzd = null;
        this.zze = 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zze() {
        zzg();
        long currentTimeMillis = this.zzt.zzav().currentTimeMillis();
        if (currentTimeMillis - this.zze > 86400000) {
            this.zzd = null;
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(this.zzt.zzau(), "android.permission.GET_ACCOUNTS") != 0) {
            this.zzt.zzay().zzm().zza("Permission error checking for dasher/unicorn accounts");
            this.zze = currentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        }
        if (this.zzc == null) {
            this.zzc = AccountManager.get(this.zzt.zzau());
        }
        try {
            Account[] result = this.zzc.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
            if (result == null || result.length <= 0) {
                Account[] result2 = this.zzc.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.zzd = Boolean.TRUE;
                    this.zze = currentTimeMillis;
                    return true;
                }
                this.zze = currentTimeMillis;
                this.zzd = Boolean.FALSE;
                return false;
            }
            this.zzd = Boolean.TRUE;
            this.zze = currentTimeMillis;
            return true;
        } catch (AuthenticatorException e10) {
            e = e10;
            this.zzt.zzay().zzh().zzb("Exception checking account types", e);
            this.zze = currentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        } catch (IOException e11) {
            e = e11;
            this.zzt.zzay().zzh().zzb("Exception checking account types", e);
            this.zze = currentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        } catch (OperationCanceledException e12) {
            e = e12;
            this.zzt.zzay().zzh().zzb("Exception checking account types", e);
            this.zze = currentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        Calendar instance = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.zzb = lowerCase + "-" + lowerCase2;
        return false;
    }
}
