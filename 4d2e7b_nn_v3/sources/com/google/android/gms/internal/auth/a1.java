package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class a1 {

    /* renamed from: d  reason: collision with root package name */
    private static final a1 f6890d = new a1(true);

    /* renamed from: a  reason: collision with root package name */
    final f2 f6891a = new y1(16);

    /* renamed from: b  reason: collision with root package name */
    private boolean f6892b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6893c;

    private a1() {
    }

    public static a1 a() {
        throw null;
    }

    private static final void d(zzeo zzeo, Object obj) {
        boolean z10;
        zzhn zzb = zzeo.zzb();
        zzez.zze(obj);
        zzhn zzhn = zzhn.DOUBLE;
        zzho zzho = zzho.INT;
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
                if ((obj instanceof zzee) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzew)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzfw) || (obj instanceof zzfb)) {
                    return;
                }
        }
        if (z10) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzeo.zza()), zzeo.zzb().zza(), obj.getClass().getName()}));
    }

    public final void b() {
        if (!this.f6892b) {
            this.f6891a.a();
            this.f6892b = true;
        }
    }

    public final void c(zzeo zzeo, Object obj) {
        if (!zzeo.zzc()) {
            d(zzeo, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                d(zzeo, arrayList.get(i10));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfb) {
            this.f6893c = true;
        }
        this.f6891a.put(zzeo, obj);
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        a1 a1Var = new a1();
        for (int i10 = 0; i10 < this.f6891a.b(); i10++) {
            Map.Entry g10 = this.f6891a.g(i10);
            a1Var.c((zzeo) g10.getKey(), g10.getValue());
        }
        for (Map.Entry entry : this.f6891a.c()) {
            a1Var.c((zzeo) entry.getKey(), entry.getValue());
        }
        a1Var.f6893c = this.f6893c;
        return a1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a1)) {
            return false;
        }
        return this.f6891a.equals(((a1) obj).f6891a);
    }

    public final int hashCode() {
        return this.f6891a.hashCode();
    }

    private a1(boolean z10) {
        b();
        b();
    }
}
