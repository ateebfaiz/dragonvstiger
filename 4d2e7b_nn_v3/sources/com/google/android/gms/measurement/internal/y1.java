package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;

final class y1 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzhx f7804a;

    /* synthetic */ y1(zzhx zzhx, zzhv zzhv) {
        this.f7804a = zzhx;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzfr zzfr;
        String str;
        boolean z10;
        try {
            this.f7804a.zzt.zzay().zzj().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzfr = this.f7804a.zzt;
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.f7804a.zzt.zzv();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) {
                            str = "gs";
                        } else {
                            str = "auto";
                        }
                        String str2 = str;
                        String queryParameter = data.getQueryParameter(Constants.REFERRER);
                        if (bundle == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        this.f7804a.zzt.zzaz().zzp(new x1(this, z10, data, str2, queryParameter));
                        zzfr = this.f7804a.zzt;
                    }
                }
                zzfr = this.f7804a.zzt;
            }
        } catch (RuntimeException e10) {
            this.f7804a.zzt.zzay().zzd().zzb("Throwable caught in onActivityCreated", e10);
            zzfr = this.f7804a.zzt;
        } catch (Throwable th) {
            this.f7804a.zzt.zzs().zzr(activity, bundle);
            throw th;
        }
        zzfr.zzs().zzr(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.f7804a.zzt.zzs().zzs(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.f7804a.zzt.zzs().zzt(activity);
        zzkc zzu = this.f7804a.zzt.zzu();
        zzu.zzt.zzaz().zzp(new k3(zzu, zzu.zzt.zzav().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzkc zzu = this.f7804a.zzt.zzu();
        zzu.zzt.zzaz().zzp(new j3(zzu, zzu.zzt.zzav().elapsedRealtime()));
        this.f7804a.zzt.zzs().zzu(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f7804a.zzt.zzs().zzv(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
