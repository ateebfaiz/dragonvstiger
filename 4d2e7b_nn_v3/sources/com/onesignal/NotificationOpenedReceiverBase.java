package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.m;

public abstract class NotificationOpenedReceiverBase extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z0.g(this, getIntent());
        finish();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        m.f(intent, "intent");
        super.onNewIntent(intent);
        z0.g(this, getIntent());
        finish();
    }
}
