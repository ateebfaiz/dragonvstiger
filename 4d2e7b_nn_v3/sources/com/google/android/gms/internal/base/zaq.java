package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

public class zaq extends Handler {
    public zaq() {
    }

    public zaq(Looper looper) {
        super(looper);
    }

    public zaq(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
