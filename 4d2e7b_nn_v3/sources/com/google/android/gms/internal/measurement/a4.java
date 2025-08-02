package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class a4 extends h4 {
    a4(int i10) {
        super(i10, (zzmj) null);
    }

    public final void a() {
        if (!j()) {
            for (int i10 = 0; i10 < b(); i10++) {
                Map.Entry g10 = g(i10);
                if (((zzjv) g10.getKey()).zzc()) {
                    g10.setValue(Collections.unmodifiableList((List) g10.getValue()));
                }
            }
            for (Map.Entry entry : c()) {
                if (((zzjv) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
