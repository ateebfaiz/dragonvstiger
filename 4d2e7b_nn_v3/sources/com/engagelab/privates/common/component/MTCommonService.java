package com.engagelab.privates.common.component;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import i1.a;

public class MTCommonService extends Service {
    private static final String TAG = "MTCommonService";

    public final IBinder onBind(Intent intent) {
        return a.b().a();
    }

    public final void onCreate() {
        s1.a.e(TAG, "onService create");
        a.b().f(getApplicationContext());
    }

    public final void onDestroy() {
        s1.a.e(TAG, "onService destroy");
    }

    public final int onStartCommand(Intent intent, int i10, int i11) {
        return 2;
    }

    public final boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
