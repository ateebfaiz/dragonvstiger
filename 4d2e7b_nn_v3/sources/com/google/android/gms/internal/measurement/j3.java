package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class j3 {
    j3() {
    }

    public static final int a(int i10, Object obj, Object obj2) {
        zzlg zzlg = (zzlg) obj;
        zzlf zzlf = (zzlf) obj2;
        if (zzlg.isEmpty()) {
            return 0;
        }
        Iterator it = zzlg.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object b(Object obj, Object obj2) {
        zzlg zzlg = (zzlg) obj;
        zzlg zzlg2 = (zzlg) obj2;
        if (!zzlg2.isEmpty()) {
            if (!zzlg.zze()) {
                zzlg = zzlg.zzb();
            }
            zzlg.zzd(zzlg2);
        }
        return zzlg;
    }
}
