package com.google.firebase.messaging;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.firebase.messaging.Constants;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class k implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final Set f9245a = Collections.newSetFromMap(new WeakHashMap());

    k() {
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void b(Intent intent) {
        Bundle bundle = null;
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                bundle = extras.getBundle(Constants.MessageNotificationKeys.ANALYTICS_DATA);
            }
        } catch (RuntimeException e10) {
            Log.w(Constants.TAG, "Failed trying to get analytics data from Intent extras.", e10);
        }
        if (MessagingAnalytics.shouldUploadScionMetrics(bundle)) {
            MessagingAnalytics.logNotificationOpen(bundle);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intent intent = activity.getIntent();
        if (intent != null && this.f9245a.add(intent)) {
            if (Build.VERSION.SDK_INT <= 25) {
                new Handler(Looper.getMainLooper()).post(new j(this, intent));
            } else {
                b(intent);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        if (activity.isFinishing()) {
            this.f9245a.remove(activity.getIntent());
        }
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
