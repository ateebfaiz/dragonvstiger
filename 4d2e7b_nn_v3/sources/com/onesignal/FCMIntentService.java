package com.onesignal;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.onesignal.l0;

public class FCMIntentService extends IntentService {

    class a implements l0.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Intent f10279a;

        a(Intent intent) {
            this.f10279a = intent;
        }

        public void a(l0.f fVar) {
            WakefulBroadcastReceiver.completeWakefulIntent(this.f10279a);
        }
    }

    public FCMIntentService() {
        super("FCMIntentService");
        setIntentRedelivery(true);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            o3.L0(this);
            l0.h(this, extras, new a(intent));
        }
    }
}
