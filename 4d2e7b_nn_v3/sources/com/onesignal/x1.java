package com.onesignal;

import com.adjust.sdk.Constants;
import com.onesignal.o3;

public class x1 extends v1 {
    /* access modifiers changed from: private */
    public static /* synthetic */ void f(o3.x xVar, boolean z10) {
        o3.z zVar;
        if (z10) {
            zVar = o3.z.PERMISSION_GRANTED;
        } else {
            zVar = o3.z.PERMISSION_DENIED;
        }
        xVar.a(zVar);
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return Constants.PUSH;
    }

    /* access modifiers changed from: package-private */
    public void b(o3.x xVar) {
        o3.h1(true, new w1(xVar));
    }
}
