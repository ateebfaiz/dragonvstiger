package com.onesignal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.onesignal.b3;

public class SyncService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        b3.q().b(this, new b3.a(this));
        return 1;
    }
}
