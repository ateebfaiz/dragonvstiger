package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzgn;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzhy;
import com.google.android.gms.measurement.internal.zzid;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
@Deprecated
public class AppMeasurement {
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile AppMeasurement zza;
    private final c zzb;

    @ShowFirstParty
    @KeepForSdk
    public static class ConditionalUserProperty {
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public boolean mActive;
        @ShowFirstParty
        @Keep
        @NonNull
        @KeepForSdk
        public String mAppId;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mCreationTimestamp;
        @NonNull
        @Keep
        public String mExpiredEventName;
        @NonNull
        @Keep
        public Bundle mExpiredEventParams;
        @ShowFirstParty
        @Keep
        @NonNull
        @KeepForSdk
        public String mName;
        @ShowFirstParty
        @Keep
        @NonNull
        @KeepForSdk
        public String mOrigin;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mTimeToLive;
        @NonNull
        @Keep
        public String mTimedOutEventName;
        @NonNull
        @Keep
        public Bundle mTimedOutEventParams;
        @ShowFirstParty
        @Keep
        @NonNull
        @KeepForSdk
        public String mTriggerEventName;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mTriggerTimeout;
        @NonNull
        @Keep
        public String mTriggeredEventName;
        @NonNull
        @Keep
        public Bundle mTriggeredEventParams;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mTriggeredTimestamp;
        @ShowFirstParty
        @Keep
        @NonNull
        @KeepForSdk
        public Object mValue;

        @KeepForSdk
        public ConditionalUserProperty() {
        }

        @VisibleForTesting
        ConditionalUserProperty(@NonNull Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            Class<String> cls = String.class;
            this.mAppId = (String) zzgn.zza(bundle, Constant.PARAM_APP_ID, cls, (Object) null);
            this.mOrigin = (String) zzgn.zza(bundle, "origin", cls, (Object) null);
            this.mName = (String) zzgn.zza(bundle, "name", cls, (Object) null);
            this.mValue = zzgn.zza(bundle, "value", Object.class, (Object) null);
            this.mTriggerEventName = (String) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, cls, (Object) null);
            Class<Long> cls2 = Long.class;
            this.mTriggerTimeout = ((Long) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cls2, 0L)).longValue();
            this.mTimedOutEventName = (String) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, cls, (Object) null);
            Class<Bundle> cls3 = Bundle.class;
            this.mTimedOutEventParams = (Bundle) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, cls3, (Object) null);
            this.mTriggeredEventName = (String) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, cls, (Object) null);
            this.mTriggeredEventParams = (Bundle) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, cls3, (Object) null);
            this.mTimeToLive = ((Long) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cls2, 0L)).longValue();
            this.mExpiredEventName = (String) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, cls, (Object) null);
            this.mExpiredEventParams = (Bundle) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, cls3, (Object) null);
            this.mActive = ((Boolean) zzgn.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, cls2, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, cls2, 0L)).longValue();
        }

        @KeepForSdk
        public ConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                Object zza = zzid.zza(obj);
                this.mValue = zza;
                if (zza == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            Bundle bundle = conditionalUserProperty.mTimedOutEventParams;
            if (bundle != null) {
                this.mTimedOutEventParams = new Bundle(bundle);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            Bundle bundle2 = conditionalUserProperty.mTriggeredEventParams;
            if (bundle2 != null) {
                this.mTriggeredEventParams = new Bundle(bundle2);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            Bundle bundle3 = conditionalUserProperty.mExpiredEventParams;
            if (bundle3 != null) {
                this.mExpiredEventParams = new Bundle(bundle3);
            }
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zzgr {
        @WorkerThread
        @ShowFirstParty
        @KeepForSdk
        void interceptEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j10);
    }

    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzgs {
        @WorkerThread
        @ShowFirstParty
        @KeepForSdk
        void onEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j10);
    }

    public AppMeasurement(zzfr zzfr) {
        this.zzb = new a(zzfr);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @com.google.android.gms.common.internal.ShowFirstParty
    @androidx.annotation.Keep
    @androidx.annotation.RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.measurement.AppMeasurement getInstance(@androidx.annotation.NonNull android.content.Context r17) {
        /*
            r0 = r17
            r1 = 1
            r2 = 0
            r3 = 2
            com.google.android.gms.measurement.AppMeasurement r4 = zza
            if (r4 != 0) goto L_0x005d
            java.lang.Class<com.google.android.gms.measurement.AppMeasurement> r4 = com.google.android.gms.measurement.AppMeasurement.class
            monitor-enter(r4)
            com.google.android.gms.measurement.AppMeasurement r5 = zza     // Catch:{ all -> 0x0030 }
            if (r5 != 0) goto L_0x0059
            r5 = 0
            java.lang.Class<com.google.firebase.analytics.FirebaseAnalytics> r6 = com.google.firebase.analytics.FirebaseAnalytics.class
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.Class<android.content.Context> r8 = android.content.Context.class
            r7[r2] = r8     // Catch:{  }
            java.lang.Class<android.os.Bundle> r8 = android.os.Bundle.class
            r7[r1] = r8     // Catch:{  }
            java.lang.String r8 = "getScionFrontendApiImplementation"
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r8, r7)     // Catch:{  }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{  }
            r3[r2] = r0     // Catch:{  }
            r3[r1] = r5     // Catch:{  }
            java.lang.Object r1 = r6.invoke(r5, r3)     // Catch:{  }
            com.google.android.gms.measurement.internal.zzhy r1 = (com.google.android.gms.measurement.internal.zzhy) r1     // Catch:{  }
            goto L_0x0033
        L_0x0030:
            r0 = move-exception
            goto L_0x005b
        L_0x0032:
            r1 = r5
        L_0x0033:
            if (r1 == 0) goto L_0x003d
            com.google.android.gms.measurement.AppMeasurement r0 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x0030 }
            r0.<init>((com.google.android.gms.measurement.internal.zzhy) r1)     // Catch:{ all -> 0x0030 }
            zza = r0     // Catch:{ all -> 0x0030 }
            goto L_0x0059
        L_0x003d:
            com.google.android.gms.internal.measurement.zzcl r1 = new com.google.android.gms.internal.measurement.zzcl     // Catch:{ all -> 0x0030 }
            r15 = 0
            r16 = 0
            r7 = 0
            r9 = 0
            r11 = 1
            r12 = 0
            r13 = 0
            r14 = 0
            r6 = r1
            r6.<init>(r7, r9, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0030 }
            com.google.android.gms.measurement.internal.zzfr r0 = com.google.android.gms.measurement.internal.zzfr.zzp(r0, r1, r5)     // Catch:{ all -> 0x0030 }
            com.google.android.gms.measurement.AppMeasurement r1 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x0030 }
            r1.<init>((com.google.android.gms.measurement.internal.zzfr) r0)     // Catch:{ all -> 0x0030 }
            zza = r1     // Catch:{ all -> 0x0030 }
        L_0x0059:
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            goto L_0x005d
        L_0x005b:
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            throw r0
        L_0x005d:
            com.google.android.gms.measurement.AppMeasurement r0 = zza
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.getInstance(android.content.Context):com.google.android.gms.measurement.AppMeasurement");
    }

    @Keep
    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zzb.zzp(str);
    }

    @ShowFirstParty
    @KeepForSdk
    @Keep
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.zzb.zzq(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zzb.zzr(str);
    }

    @Keep
    public long generateEventId() {
        return this.zzb.zzb();
    }

    @NonNull
    @Keep
    public String getAppInstanceId() {
        return this.zzb.zzh();
    }

    @NonNull
    @KeepForSdk
    public Boolean getBoolean() {
        return this.zzb.a();
    }

    @WorkerThread
    @ShowFirstParty
    @Keep
    @NonNull
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Size(max = 23, min = 1) @NonNull String str2) {
        int i10;
        List<Bundle> zzm = this.zzb.zzm(str, str2);
        if (zzm == null) {
            i10 = 0;
        } else {
            i10 = zzm.size();
        }
        ArrayList arrayList = new ArrayList(i10);
        for (Bundle conditionalUserProperty : zzm) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    @NonNull
    @Keep
    public String getCurrentScreenClass() {
        return this.zzb.zzi();
    }

    @NonNull
    @Keep
    public String getCurrentScreenName() {
        return this.zzb.zzj();
    }

    @NonNull
    @KeepForSdk
    public Double getDouble() {
        return this.zzb.b();
    }

    @NonNull
    @Keep
    public String getGmpAppId() {
        return this.zzb.zzk();
    }

    @NonNull
    @KeepForSdk
    public Integer getInteger() {
        return this.zzb.c();
    }

    @NonNull
    @KeepForSdk
    public Long getLong() {
        return this.zzb.d();
    }

    @WorkerThread
    @ShowFirstParty
    @Keep
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.zzb.zza(str);
    }

    @NonNull
    @KeepForSdk
    public String getString() {
        return this.zzb.e();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @Keep
    @NonNull
    @VisibleForTesting
    public Map<String, Object> getUserProperties(@NonNull String str, @Size(max = 24, min = 1) @NonNull String str2, boolean z10) {
        return this.zzb.zzo(str, str2, z10);
    }

    @ShowFirstParty
    @Keep
    public void logEventInternal(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.zzb.zzs(str, str2, bundle);
    }

    @ShowFirstParty
    @KeepForSdk
    public void logEventInternalNoInterceptor(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j10) {
        this.zzb.zzt(str, str2, bundle, j10);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.zzb.zzu(onEventListener);
    }

    @ShowFirstParty
    @KeepForSdk
    @Keep
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        c cVar = this.zzb;
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString(Constant.PARAM_APP_ID, str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            zzgn.zzb(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str4);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.mTriggeredTimestamp);
        cVar.zzv(bundle);
    }

    @WorkerThread
    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(@NonNull EventInterceptor eventInterceptor) {
        this.zzb.zzw(eventInterceptor);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.zzb.zzx(onEventListener);
    }

    public AppMeasurement(zzhy zzhy) {
        this.zzb = new b(zzhy);
    }

    @WorkerThread
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z10) {
        return this.zzb.f(z10);
    }
}
