package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class NotificationOpenedActivityHMS extends Activity {
    private void a() {
        b(getIntent());
        finish();
    }

    private void b(Intent intent) {
        a1.b(this, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a();
    }
}
