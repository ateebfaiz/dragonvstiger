package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgs;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
public class AppMeasurementSdk {
    private final zzef zza;

    @KeepForSdk
    public static final class ConditionalUserProperty {
        @NonNull
        @KeepForSdk
        public static final String ACTIVE = "active";
        @NonNull
        @KeepForSdk
        public static final String CREATION_TIMESTAMP = "creation_timestamp";
        @NonNull
        @KeepForSdk
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";
        @NonNull
        @KeepForSdk
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
        @NonNull
        @KeepForSdk
        public static final String NAME = "name";
        @NonNull
        @KeepForSdk
        public static final String ORIGIN = "origin";
        @NonNull
        @KeepForSdk
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
        @NonNull
        @KeepForSdk
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
        @NonNull
        @KeepForSdk
        public static final String TIME_TO_LIVE = "time_to_live";
        @NonNull
        @KeepForSdk
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
        @NonNull
        @KeepForSdk
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
        @NonNull
        @KeepForSdk
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
        @NonNull
        @KeepForSdk
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
        @NonNull
        @KeepForSdk
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";
        @NonNull
        @KeepForSdk
        public static final String VALUE = "value";

        private ConditionalUserProperty() {
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

    public AppMeasurementSdk(zzef zzef) {
        this.zza = zzef;
    }

    @ShowFirstParty
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @NonNull
    @KeepForSdk
    public static AppMeasurementSdk getInstance(@NonNull Context context) {
        return zzef.zzg(context, (String) null, (String) null, (String) null, (Bundle) null).zzd();
    }

    @KeepForSdk
    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zza.zzv(str);
    }

    @KeepForSdk
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.zza.zzw(str, str2, bundle);
    }

    @KeepForSdk
    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zza.zzx(str);
    }

    @KeepForSdk
    public long generateEventId() {
        return this.zza.zzb();
    }

    @KeepForSdk
    @Nullable
    public String getAppIdOrigin() {
        return this.zza.zzk();
    }

    @KeepForSdk
    @Nullable
    public String getAppInstanceId() {
        return this.zza.zzm();
    }

    @WorkerThread
    @NonNull
    @KeepForSdk
    public List<Bundle> getConditionalUserProperties(@Nullable String str, @Size(max = 23, min = 1) @Nullable String str2) {
        return this.zza.zzq(str, str2);
    }

    @KeepForSdk
    @Nullable
    public String getCurrentScreenClass() {
        return this.zza.zzn();
    }

    @KeepForSdk
    @Nullable
    public String getCurrentScreenName() {
        return this.zza.zzo();
    }

    @KeepForSdk
    @Nullable
    public String getGmpAppId() {
        return this.zza.zzp();
    }

    @WorkerThread
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.zza.zza(str);
    }

    @WorkerThread
    @NonNull
    @KeepForSdk
    public Map<String, Object> getUserProperties(@Nullable String str, @Size(max = 24, min = 1) @Nullable String str2, boolean z10) {
        return this.zza.zzr(str, str2, z10);
    }

    @KeepForSdk
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.zza.zzz(str, str2, bundle);
    }

    @KeepForSdk
    public void logEventNoInterceptor(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j10) {
        this.zza.zzA(str, str2, bundle, j10);
    }

    @KeepForSdk
    @Nullable
    public void performAction(@NonNull Bundle bundle) {
        this.zza.zzc(bundle, false);
    }

    @KeepForSdk
    @Nullable
    public Bundle performActionWithResponse(@NonNull Bundle bundle) {
        return this.zza.zzc(bundle, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.zza.zzC(onEventListener);
    }

    @KeepForSdk
    public void setConditionalUserProperty(@NonNull Bundle bundle) {
        this.zza.zzE(bundle);
    }

    @KeepForSdk
    public void setConsent(@NonNull Bundle bundle) {
        this.zza.zzF(bundle);
    }

    @KeepForSdk
    public void setCurrentScreen(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        this.zza.zzH(activity, str, str2);
    }

    @WorkerThread
    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(@NonNull EventInterceptor eventInterceptor) {
        this.zza.zzK(eventInterceptor);
    }

    @KeepForSdk
    public void setMeasurementEnabled(@Nullable Boolean bool) {
        this.zza.zzL(bool);
    }

    @KeepForSdk
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        this.zza.zzO(str, str2, obj, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.zza.zzP(onEventListener);
    }

    public final void zza(boolean z10) {
        this.zza.zzI(z10);
    }

    @KeepForSdk
    public void setMeasurementEnabled(boolean z10) {
        this.zza.zzL(Boolean.valueOf(z10));
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @NonNull
    @KeepForSdk
    public static AppMeasurementSdk getInstance(@NonNull Context context, @NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull Bundle bundle) {
        return zzef.zzg(context, str, str2, str3, bundle).zzd();
    }
}
