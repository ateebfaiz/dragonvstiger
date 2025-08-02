package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.Iterator;

public final class zzag {
    /* access modifiers changed from: private */
    public final String zza = ",\n  ";

    private zzag(String str) {
    }

    public static zzag zza(String str) {
        return new zzag(",\n  ");
    }

    static final CharSequence zzd(Object obj) {
        obj.getClass();
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public final Appendable zzb(Appendable appendable, Iterator it) throws IOException {
        if (it.hasNext()) {
            appendable.append(zzd(it.next()));
            while (it.hasNext()) {
                appendable.append(this.zza);
                appendable.append(zzd(it.next()));
            }
        }
        return appendable;
    }
}
