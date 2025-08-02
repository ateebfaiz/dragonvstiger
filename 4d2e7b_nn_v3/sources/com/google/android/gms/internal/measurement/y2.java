package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class y2 {

    /* renamed from: d  reason: collision with root package name */
    private static final y2 f7359d = new y2(true);

    /* renamed from: a  reason: collision with root package name */
    final h4 f7360a = new a4(16);

    /* renamed from: b  reason: collision with root package name */
    private boolean f7361b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7362c;

    private y2() {
    }

    public static y2 a() {
        throw null;
    }

    private static final void d(zzjv zzjv, Object obj) {
        boolean z10;
        zzne zzb = zzjv.zzb();
        zzkn.zze(obj);
        zzne zzne = zzne.DOUBLE;
        zznf zznf = zznf.INT;
        switch (zzb.zza().ordinal()) {
            case 0:
                z10 = obj instanceof Integer;
                break;
            case 1:
                z10 = obj instanceof Long;
                break;
            case 2:
                z10 = obj instanceof Float;
                break;
            case 3:
                z10 = obj instanceof Double;
                break;
            case 4:
                z10 = obj instanceof Boolean;
                break;
            case 5:
                z10 = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzje) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzkh)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzlm) || (obj instanceof zzkr)) {
                    return;
                }
        }
        if (z10) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzjv.zza()), zzjv.zzb().zza(), obj.getClass().getName()}));
    }

    public final void b() {
        if (!this.f7361b) {
            for (int i10 = 0; i10 < this.f7360a.b(); i10++) {
                Map.Entry g10 = this.f7360a.g(i10);
                if (g10.getValue() instanceof zzkf) {
                    ((zzkf) g10.getValue()).zzbJ();
                }
            }
            this.f7360a.a();
            this.f7361b = true;
        }
    }

    public final void c(zzjv zzjv, Object obj) {
        if (!zzjv.zzc()) {
            d(zzjv, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                d(zzjv, arrayList.get(i10));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzkr) {
            this.f7362c = true;
        }
        this.f7360a.put(zzjv, obj);
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        y2 y2Var = new y2();
        for (int i10 = 0; i10 < this.f7360a.b(); i10++) {
            Map.Entry g10 = this.f7360a.g(i10);
            y2Var.c((zzjv) g10.getKey(), g10.getValue());
        }
        for (Map.Entry entry : this.f7360a.c()) {
            y2Var.c((zzjv) entry.getKey(), entry.getValue());
        }
        y2Var.f7362c = this.f7362c;
        return y2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y2)) {
            return false;
        }
        return this.f7360a.equals(((y2) obj).f7360a);
    }

    public final int hashCode() {
        return this.f7360a.hashCode();
    }

    private y2(boolean z10) {
        b();
        b();
    }
}
