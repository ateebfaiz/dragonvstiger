package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;

final class x extends y0 {

    /* renamed from: w  reason: collision with root package name */
    static final Pair f7767w = new Pair("", 0L);

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f7768a;

    /* renamed from: b  reason: collision with root package name */
    public zzeu f7769b;

    /* renamed from: c  reason: collision with root package name */
    public final zzes f7770c = new zzes(this, "first_open_time", 0);

    /* renamed from: d  reason: collision with root package name */
    public final zzes f7771d = new zzes(this, "app_install_time", 0);

    /* renamed from: e  reason: collision with root package name */
    public final zzev f7772e = new zzev(this, "app_instance_id", (String) null);

    /* renamed from: f  reason: collision with root package name */
    private String f7773f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7774g;

    /* renamed from: h  reason: collision with root package name */
    private long f7775h;

    /* renamed from: i  reason: collision with root package name */
    public final zzes f7776i = new zzes(this, "session_timeout", 1800000);

    /* renamed from: j  reason: collision with root package name */
    public final zzeq f7777j = new zzeq(this, "start_new_session", true);

    /* renamed from: k  reason: collision with root package name */
    public final zzev f7778k = new zzev(this, "non_personalized_ads", (String) null);

    /* renamed from: l  reason: collision with root package name */
    public final zzeq f7779l = new zzeq(this, "allow_remote_dynamite", false);

    /* renamed from: m  reason: collision with root package name */
    public final zzes f7780m = new zzes(this, "last_pause_time", 0);

    /* renamed from: n  reason: collision with root package name */
    public final zzes f7781n = new zzes(this, "session_id", 0);

    /* renamed from: o  reason: collision with root package name */
    public boolean f7782o;

    /* renamed from: p  reason: collision with root package name */
    public final zzeq f7783p = new zzeq(this, "app_backgrounded", false);

    /* renamed from: q  reason: collision with root package name */
    public final zzeq f7784q = new zzeq(this, "deep_link_retrieval_complete", false);

    /* renamed from: r  reason: collision with root package name */
    public final zzes f7785r = new zzes(this, "deep_link_retrieval_attempts", 0);

    /* renamed from: s  reason: collision with root package name */
    public final zzev f7786s = new zzev(this, "firebase_feature_rollouts", (String) null);

    /* renamed from: t  reason: collision with root package name */
    public final zzev f7787t = new zzev(this, "deferred_attribution_cache", (String) null);

    /* renamed from: u  reason: collision with root package name */
    public final zzes f7788u = new zzes(this, "deferred_attribution_cache_timestamp", 0);

    /* renamed from: v  reason: collision with root package name */
    public final zzer f7789v = new zzer(this, "default_event_parameters", (Bundle) null);

    x(zzfr zzfr) {
        super(zzfr);
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences a() {
        zzg();
        zzu();
        Preconditions.checkNotNull(this.f7768a);
        return this.f7768a;
    }

    /* access modifiers changed from: package-private */
    public final Pair b(String str) {
        zzg();
        long elapsedRealtime = this.zzt.zzav().elapsedRealtime();
        String str2 = this.f7773f;
        if (str2 != null && elapsedRealtime < this.f7775h) {
            return new Pair(str2, Boolean.valueOf(this.f7774g));
        }
        this.f7775h = elapsedRealtime + this.zzt.zzf().zzi(str, zzdu.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzt.zzau());
            this.f7773f = "";
            String id2 = advertisingIdInfo.getId();
            if (id2 != null) {
                this.f7773f = id2;
            }
            this.f7774g = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e10) {
            this.zzt.zzay().zzc().zzb("Unable to get advertising id", e10);
            this.f7773f = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f7773f, Boolean.valueOf(this.f7774g));
    }

    /* access modifiers changed from: package-private */
    public final zzai c() {
        zzg();
        return zzai.zzb(a().getString("consent_settings", "G1"));
    }

    /* access modifiers changed from: package-private */
    public final Boolean d() {
        zzg();
        if (a().contains("measurement_enabled")) {
            return Boolean.valueOf(a().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void e(Boolean bool) {
        zzg();
        SharedPreferences.Editor edit = a().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void f(boolean z10) {
        zzg();
        this.zzt.zzay().zzj().zzb("App measurement setting deferred collection", Boolean.valueOf(z10));
        SharedPreferences.Editor edit = a().edit();
        edit.putBoolean("deferred_analytics_collection", z10);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        SharedPreferences sharedPreferences = this.f7768a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean h(long j10) {
        if (j10 - this.f7776i.zza() > this.f7780m.zza()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean i(int i10) {
        return zzai.zzj(i10, a().getInt("consent_source", 100));
    }

    /* access modifiers changed from: protected */
    public final void zzaA() {
        SharedPreferences sharedPreferences = this.zzt.zzau().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f7768a = sharedPreferences;
        boolean z10 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f7782o = z10;
        if (!z10) {
            SharedPreferences.Editor edit = this.f7768a.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzt.zzf();
        this.f7769b = new zzeu(this, "health_monitor", Math.max(0, ((Long) zzdu.zzb.zza((Object) null)).longValue()), (zzet) null);
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return true;
    }
}
