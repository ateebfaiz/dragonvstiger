package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class y1 extends f2 {
    y1(int i10) {
        super(i10, (zzgt) null);
    }

    public final void a() {
        if (!j()) {
            for (int i10 = 0; i10 < b(); i10++) {
                Map.Entry g10 = g(i10);
                if (((zzeo) g10.getKey()).zzc()) {
                    g10.setValue(Collections.unmodifiableList((List) g10.getValue()));
                }
            }
            for (Map.Entry entry : c()) {
                if (((zzeo) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
