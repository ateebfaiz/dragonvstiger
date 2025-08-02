package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;

final class n implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CharSequence f7041a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzx f7042b;

    n(zzx zzx, CharSequence charSequence) {
        this.f7042b = zzx;
        this.f7041a = charSequence;
    }

    public final Iterator iterator() {
        return this.f7042b.zzh(this.f7041a);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb2.append(zzq.zza(it.next(), ", "));
                while (it.hasNext()) {
                    sb2.append(", ");
                    sb2.append(zzq.zza(it.next(), ", "));
                }
            }
            sb2.append(']');
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
