package com.onesignal;

import org.json.JSONException;

class w4 extends t4 {
    w4(String str, boolean z10) {
        super(str, z10);
    }

    private int A() {
        int d10 = i().d("subscribableStatus", 1);
        if (d10 < -2) {
            return d10;
        }
        if (!i().c("androidPermission", true)) {
            return 0;
        }
        if (!i().c("userSubscribePref", true)) {
            return -2;
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public void a() {
        try {
            t("notification_types", Integer.valueOf(A()));
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public t4 p(String str) {
        return new w4(str, false);
    }
}
