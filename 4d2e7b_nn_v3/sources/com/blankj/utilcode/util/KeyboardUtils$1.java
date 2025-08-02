package com.blankj.utilcode.util;

import android.os.Bundle;
import android.os.ResultReceiver;

class KeyboardUtils$1 extends ResultReceiver {
    /* access modifiers changed from: protected */
    public void onReceiveResult(int i10, Bundle bundle) {
        if (i10 == 1 || i10 == 3) {
            d.c();
        }
    }
}
