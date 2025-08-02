package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@DynamiteApi
public class AppMeasurementDynamiteService extends zzcb {
    @VisibleForTesting
    zzfr zza = null;
    @GuardedBy("listenerMap")
    private final Map zzb = new ArrayMap();

    @EnsuresNonNull({"scion"})
    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(zzcf zzcf, String str) {
        zzb();
        this.zza.zzv().zzV(zzcf, str);
    }

    public void beginAdUnitExposure(@NonNull String str, long j10) throws RemoteException {
        zzb();
        this.zza.zzd().zzd(str, j10);
    }

    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        zzb();
        this.zza.zzq().zzA(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j10) throws RemoteException {
        zzb();
        this.zza.zzq().zzU((Boolean) null);
    }

    public void endAdUnitExposure(@NonNull String str, long j10) throws RemoteException {
        zzb();
        this.zza.zzd().zze(str, j10);
    }

    public void generateEventId(zzcf zzcf) throws RemoteException {
        zzb();
        long zzq = this.zza.zzv().zzq();
        zzb();
        this.zza.zzv().zzU(zzcf, zzq);
    }

    public void getAppInstanceId(zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new z1(this, zzcf));
    }

    public void getCachedAppInstanceId(zzcf zzcf) throws RemoteException {
        zzb();
        zzc(zzcf, this.zza.zzq().zzo());
    }

    public void getConditionalUserProperties(String str, String str2, zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new g4(this, zzcf, str, str2));
    }

    public void getCurrentScreenClass(zzcf zzcf) throws RemoteException {
        zzb();
        zzc(zzcf, this.zza.zzq().zzp());
    }

    public void getCurrentScreenName(zzcf zzcf) throws RemoteException {
        zzb();
        zzc(zzcf, this.zza.zzq().zzq());
    }

    public void getGmpAppId(zzcf zzcf) throws RemoteException {
        String str;
        zzb();
        zzhx zzq = this.zza.zzq();
        if (zzq.zzt.zzw() != null) {
            str = zzq.zzt.zzw();
        } else {
            try {
                str = zzid.zzc(zzq.zzt.zzau(), "google_app_id", zzq.zzt.zzz());
            } catch (IllegalStateException e10) {
                zzq.zzt.zzay().zzd().zzb("getGoogleAppId failed with exception", e10);
                str = null;
            }
        }
        zzc(zzcf, str);
    }

    public void getMaxUserProperties(String str, zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzq().zzh(str);
        zzb();
        this.zza.zzv().zzT(zzcf, 25);
    }

    public void getSessionId(zzcf zzcf) throws RemoteException {
        zzb();
        zzhx zzq = this.zza.zzq();
        zzq.zzt.zzaz().zzp(new n1(zzq, zzcf));
    }

    public void getTestFlag(zzcf zzcf, int i10) throws RemoteException {
        zzb();
        if (i10 == 0) {
            this.zza.zzv().zzV(zzcf, this.zza.zzq().zzr());
        } else if (i10 == 1) {
            this.zza.zzv().zzU(zzcf, this.zza.zzq().zzm().longValue());
        } else if (i10 == 2) {
            zzlb zzv = this.zza.zzv();
            double doubleValue = this.zza.zzq().zzj().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzcf.zze(bundle);
            } catch (RemoteException e10) {
                zzv.zzt.zzay().zzk().zzb("Error returning double value to wrapper", e10);
            }
        } else if (i10 == 3) {
            this.zza.zzv().zzT(zzcf, this.zza.zzq().zzl().intValue());
        } else if (i10 == 4) {
            this.zza.zzv().zzP(zzcf, this.zza.zzq().zzi().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z10, zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new o3(this, zzcf, str, str2, z10));
    }

    public void initForTests(@NonNull Map map) throws RemoteException {
        zzb();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzcl zzcl, long j10) throws RemoteException {
        zzfr zzfr = this.zza;
        if (zzfr == null) {
            this.zza = zzfr.zzp((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzcl, Long.valueOf(j10));
        } else {
            zzfr.zzay().zzk().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new h4(this, zzcf));
    }

    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z10, boolean z11, long j10) throws RemoteException {
        zzb();
        this.zza.zzq().zzE(str, str2, bundle, z10, z11, j10);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcf, long j10) throws RemoteException {
        Bundle bundle2;
        zzb();
        Preconditions.checkNotEmpty(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.zza.zzaz().zzp(new v2(this, zzcf, new zzaw(str2, new zzau(bundle), "app", j10), str));
    }

    public void logHealthData(int i10, @NonNull String str, @NonNull IObjectWrapper iObjectWrapper, @NonNull IObjectWrapper iObjectWrapper2, @NonNull IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zzb();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzay().zzt(i10, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(@NonNull IObjectWrapper iObjectWrapper, @NonNull Bundle bundle, long j10) throws RemoteException {
        zzb();
        y1 y1Var = this.zza.zzq().zza;
        if (y1Var != null) {
            this.zza.zzq().zzB();
            y1Var.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(@NonNull IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        zzb();
        y1 y1Var = this.zza.zzq().zza;
        if (y1Var != null) {
            this.zza.zzq().zzB();
            y1Var.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(@NonNull IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        zzb();
        y1 y1Var = this.zza.zzq().zza;
        if (y1Var != null) {
            this.zza.zzq().zzB();
            y1Var.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(@NonNull IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        zzb();
        y1 y1Var = this.zza.zzq().zza;
        if (y1Var != null) {
            this.zza.zzq().zzB();
            y1Var.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcf zzcf, long j10) throws RemoteException {
        zzb();
        y1 y1Var = this.zza.zzq().zza;
        Bundle bundle = new Bundle();
        if (y1Var != null) {
            this.zza.zzq().zzB();
            y1Var.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.zza.zzay().zzk().zzb("Error returning bundle value to wrapper", e10);
        }
    }

    public void onActivityStarted(@NonNull IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzB();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void onActivityStopped(@NonNull IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzB();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void performAction(Bundle bundle, zzcf zzcf, long j10) throws RemoteException {
        zzb();
        zzcf.zze((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzci zzci) throws RemoteException {
        zzgs zzgs;
        zzb();
        synchronized (this.zzb) {
            try {
                zzgs = (zzgs) this.zzb.get(Integer.valueOf(zzci.zzd()));
                if (zzgs == null) {
                    zzgs = new j4(this, zzci);
                    this.zzb.put(Integer.valueOf(zzci.zzd()), zzgs);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.zza.zzq().zzJ(zzgs);
    }

    public void resetAnalyticsData(long j10) throws RemoteException {
        zzb();
        this.zza.zzq().zzK(j10);
    }

    public void setConditionalUserProperty(@NonNull Bundle bundle, long j10) throws RemoteException {
        zzb();
        if (bundle == null) {
            this.zza.zzay().zzd().zza("Conditional user property must not be null");
        } else {
            this.zza.zzq().zzQ(bundle, j10);
        }
    }

    public void setConsent(@NonNull Bundle bundle, long j10) throws RemoteException {
        zzb();
        zzhx zzq = this.zza.zzq();
        zzq.zzt.zzaz().zzq(new zzgv(zzq, bundle, j10));
    }

    public void setConsentThirdParty(@NonNull Bundle bundle, long j10) throws RemoteException {
        zzb();
        this.zza.zzq().zzR(bundle, -20, j10);
    }

    public void setCurrentScreen(@NonNull IObjectWrapper iObjectWrapper, @NonNull String str, @NonNull String str2, long j10) throws RemoteException {
        zzb();
        this.zza.zzs().zzw((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z10) throws RemoteException {
        zzb();
        zzhx zzq = this.zza.zzq();
        zzq.zza();
        zzq.zzt.zzaz().zzp(new w1(zzq, z10));
    }

    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        Bundle bundle2;
        zzb();
        zzhx zzq = this.zza.zzq();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzq.zzt.zzaz().zzp(new zzgw(zzq, bundle2));
    }

    public void setEventInterceptor(zzci zzci) throws RemoteException {
        zzb();
        i4 i4Var = new i4(this, zzci);
        if (this.zza.zzaz().zzs()) {
            this.zza.zzq().zzT(i4Var);
        } else {
            this.zza.zzaz().zzp(new e4(this, i4Var));
        }
    }

    public void setInstanceIdProvider(zzck zzck) throws RemoteException {
        zzb();
    }

    public void setMeasurementEnabled(boolean z10, long j10) throws RemoteException {
        zzb();
        this.zza.zzq().zzU(Boolean.valueOf(z10));
    }

    public void setMinimumSessionDuration(long j10) throws RemoteException {
        zzb();
    }

    public void setSessionTimeoutDuration(long j10) throws RemoteException {
        zzb();
        zzhx zzq = this.zza.zzq();
        zzq.zzt.zzaz().zzp(new d1(zzq, j10));
    }

    public void setUserId(@NonNull String str, long j10) throws RemoteException {
        zzb();
        zzhx zzq = this.zza.zzq();
        if (str == null || !TextUtils.isEmpty(str)) {
            zzq.zzt.zzaz().zzp(new zzgx(zzq, str));
            zzq.zzX((String) null, "_id", str, true, j10);
            return;
        }
        zzq.zzt.zzay().zzk().zza("User ID must be non-empty or null");
    }

    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull IObjectWrapper iObjectWrapper, boolean z10, long j10) throws RemoteException {
        zzb();
        this.zza.zzq().zzX(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z10, j10);
    }

    public void unregisterOnMeasurementEventListener(zzci zzci) throws RemoteException {
        zzgs zzgs;
        zzb();
        synchronized (this.zzb) {
            zzgs = (zzgs) this.zzb.remove(Integer.valueOf(zzci.zzd()));
        }
        if (zzgs == null) {
            zzgs = new j4(this, zzci);
        }
        this.zza.zzq().zzZ(zzgs);
    }
}
