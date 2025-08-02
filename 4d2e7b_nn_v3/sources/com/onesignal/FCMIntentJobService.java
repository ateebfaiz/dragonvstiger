package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.RequiresApi;
import com.onesignal.l0;

@RequiresApi(api = 21)
public class FCMIntentJobService extends JobIntentService {

    class a implements l0.e {
        a() {
        }

        public void a(l0.f fVar) {
        }
    }

    public static void j(Context context, Intent intent) {
        JobIntentService.d(context, FCMIntentJobService.class, 123890, intent, false);
    }

    /* access modifiers changed from: protected */
    public void g(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            o3.L0(this);
            l0.h(this, extras, new a());
        }
    }

    public /* bridge */ /* synthetic */ boolean h() {
        return super.h();
    }

    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    public /* bridge */ /* synthetic */ void onCreate() {
        super.onCreate();
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ int onStartCommand(Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }
}
