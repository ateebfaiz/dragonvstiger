package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1dSDK;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;

final class AFb1fSDK implements Application.ActivityLifecycleCallbacks {
    private final AFa1tSDK AFInAppEventParameterName;
    /* access modifiers changed from: package-private */
    public boolean AFInAppEventType;
    final AFb1dSDK.AFa1wSDK AFKeystoreWrapper;
    private final Executor valueOf;
    /* access modifiers changed from: private */
    public boolean values;

    public static final class AFa1ySDK extends TimerTask {
        private /* synthetic */ Context AFInAppEventParameterName;
        private /* synthetic */ AFb1fSDK valueOf;

        AFa1ySDK(AFb1fSDK aFb1fSDK, Context context) {
            this.valueOf = aFb1fSDK;
            this.AFInAppEventParameterName = context;
        }

        public final void run() {
            if (this.valueOf.AFInAppEventType && this.valueOf.values) {
                AFb1fSDK aFb1fSDK = this.valueOf;
                aFb1fSDK.AFInAppEventType = false;
                try {
                    aFb1fSDK.AFKeystoreWrapper.AFKeystoreWrapper(this.AFInAppEventParameterName);
                } catch (Exception e10) {
                    AFLogger.afErrorLog("Listener threw exception! ", e10);
                }
            }
        }
    }

    public AFb1fSDK(Executor executor, AFa1tSDK aFa1tSDK, AFb1dSDK.AFa1wSDK aFa1wSDK) {
        m.f(executor, "");
        m.f(aFa1tSDK, "");
        m.f(aFa1wSDK, "");
        this.valueOf = executor;
        this.AFInAppEventParameterName = aFa1tSDK;
        this.AFKeystoreWrapper = aFa1wSDK;
    }

    /* access modifiers changed from: private */
    public static final void AFKeystoreWrapper(AFb1fSDK aFb1fSDK, Activity activity) {
        m.f(aFb1fSDK, "");
        m.f(activity, "");
        aFb1fSDK.values = true;
        Context applicationContext = activity.getApplicationContext();
        try {
            Timer timer = new Timer();
            AFa1ySDK aFa1ySDK = new AFa1ySDK(aFb1fSDK, applicationContext);
            AFb1dSDK.AFa1xSDK aFa1xSDK = AFb1dSDK.AFa1xSDK;
            timer.schedule(aFa1ySDK, AFb1dSDK.AFa1xSDK.AFKeystoreWrapper());
        } catch (Throwable th) {
            AFLogger.afErrorLog("Background task failed with a throwable: ", th);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m.f(activity, "");
        this.valueOf.execute(new d(this, activity));
    }

    public final void onActivityDestroyed(Activity activity) {
        m.f(activity, "");
    }

    public final void onActivityPaused(Activity activity) {
        m.f(activity, "");
        this.valueOf.execute(new e(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        m.f(activity, "");
        this.valueOf.execute(new c(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m.f(activity, "");
        m.f(bundle, "");
    }

    public final void onActivityStarted(Activity activity) {
        m.f(activity, "");
    }

    public final void onActivityStopped(Activity activity) {
        m.f(activity, "");
    }

    /* access modifiers changed from: private */
    public static final void AFInAppEventType(AFb1fSDK aFb1fSDK, Activity activity) {
        m.f(aFb1fSDK, "");
        m.f(activity, "");
        if (!aFb1fSDK.AFInAppEventType) {
            try {
                aFb1fSDK.AFKeystoreWrapper.valueOf(activity);
            } catch (Exception e10) {
                AFLogger.afErrorLog("Listener thrown an exception: ", e10, true);
            }
        }
        aFb1fSDK.values = false;
        aFb1fSDK.AFInAppEventType = true;
    }

    /* access modifiers changed from: private */
    public static final void values(AFb1fSDK aFb1fSDK, Activity activity) {
        m.f(aFb1fSDK, "");
        m.f(activity, "");
        AFa1tSDK aFa1tSDK = aFb1fSDK.AFInAppEventParameterName;
        AFa1tSDK.AFInAppEventParameterName(activity.getIntent());
    }
}
