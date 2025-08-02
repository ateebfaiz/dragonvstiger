package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzc;
    @VisibleForTesting
    final AppMeasurementSdk zza;
    @VisibleForTesting
    final Map zzb = new ConcurrentHashMap();

    class a implements AnalyticsConnector.AnalyticsConnectorHandle {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8966a;

        a(String str) {
            this.f8966a = str;
        }

        public void registerEventNames(Set set) {
            if (AnalyticsConnectorImpl.this.zzc(this.f8966a) && this.f8966a.equals(AppMeasurement.FIAM_ORIGIN) && set != null && !set.isEmpty()) {
                ((zza) AnalyticsConnectorImpl.this.zzb.get(this.f8966a)).zzb(set);
            }
        }

        public final void unregister() {
            if (AnalyticsConnectorImpl.this.zzc(this.f8966a)) {
                AnalyticsConnector.AnalyticsConnectorListener zza = ((zza) AnalyticsConnectorImpl.this.zzb.get(this.f8966a)).zza();
                if (zza != null) {
                    zza.onMessageTriggered(0, (Bundle) null);
                }
                AnalyticsConnectorImpl.this.zzb.remove(this.f8966a);
            }
        }

        public void unregisterEventNames() {
            if (AnalyticsConnectorImpl.this.zzc(this.f8966a) && this.f8966a.equals(AppMeasurement.FIAM_ORIGIN)) {
                ((zza) AnalyticsConnectorImpl.this.zzb.get(this.f8966a)).zzc();
            }
        }
    }

    AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.zza = appMeasurementSdk;
    }

    @NonNull
    @KeepForSdk
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    static /* synthetic */ void zza(Event event) {
        boolean z10 = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) Preconditions.checkNotNull(zzc)).zza.zza(z10);
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzc(@NonNull String str) {
        if (str.isEmpty() || !this.zzb.containsKey(str) || this.zzb.get(str) == null) {
            return false;
        }
        return true;
    }

    @KeepForSdk
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (str2 == null || zzc.zzj(str2, bundle)) {
            this.zza.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @WorkerThread
    @NonNull
    @KeepForSdk
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Size(max = 23, min = 1) @NonNull String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle zzb2 : this.zza.getConditionalUserProperties(str, str2)) {
            arrayList.add(zzc.zzb(zzb2));
        }
        return arrayList;
    }

    @WorkerThread
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.zza.getMaxUserProperties(str);
    }

    @WorkerThread
    @NonNull
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z10) {
        return this.zza.getUserProperties((String) null, (String) null, z10);
    }

    @KeepForSdk
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zzl(str) && zzc.zzj(str2, bundle) && zzc.zzh(str, str2, bundle)) {
            zzc.zze(str, str2, bundle);
            this.zza.logEvent(str, str2, bundle);
        }
    }

    @WorkerThread
    @NonNull
    @KeepForSdk
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String str, @NonNull AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzc.zzl(str) || zzc(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.zza;
        if (AppMeasurement.FIAM_ORIGIN.equals(str)) {
            obj = new zze(appMeasurementSdk, analyticsConnectorListener);
        } else if ("clx".equals(str)) {
            obj = new zzg(appMeasurementSdk, analyticsConnectorListener);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        this.zzb.put(str, obj);
        return new a(str);
    }

    @KeepForSdk
    public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzc.zzi(conditionalUserProperty)) {
            this.zza.setConditionalUserProperty(zzc.zza(conditionalUserProperty));
        }
    }

    @KeepForSdk
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        if (zzc.zzl(str) && zzc.zzm(str, str2)) {
            this.zza.setUserProperty(str, str2, obj);
        }
    }

    @NonNull
    @KeepForSdk
    public static AnalyticsConnector getInstance(@NonNull FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @NonNull
    @KeepForSdk
    public static AnalyticsConnector getInstance(@NonNull FirebaseApp firebaseApp, @NonNull Context context, @NonNull Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                try {
                    if (zzc == null) {
                        Bundle bundle = new Bundle(1);
                        if (firebaseApp.isDefaultApp()) {
                            subscriber.subscribe(DataCollectionDefaultChange.class, zza.zza, zzb.zza);
                            bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                        }
                        zzc = new AnalyticsConnectorImpl(zzef.zzg(context, (String) null, (String) null, (String) null, bundle).zzd());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzc;
    }
}
