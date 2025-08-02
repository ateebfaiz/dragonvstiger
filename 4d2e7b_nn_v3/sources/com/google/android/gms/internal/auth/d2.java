package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.Map;

final class d2 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f6909a = -1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6910b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator f6911c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ f2 f6912d;

    /* synthetic */ d2(f2 f2Var, zzgp zzgp) {
        this.f6912d = f2Var;
    }

    private final Iterator a() {
        if (this.f6911c == null) {
            this.f6911c = this.f6912d.f6921c.entrySet().iterator();
        }
        return this.f6911c;
    }

    public final boolean hasNext() {
        if (this.f6909a + 1 < this.f6912d.f6920b.size()) {
            return true;
        }
        if (this.f6912d.f6921c.isEmpty()) {
            return false;
        }
        if (a().hasNext()) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.f6910b = true;
        int i10 = this.f6909a + 1;
        this.f6909a = i10;
        if (i10 < this.f6912d.f6920b.size()) {
            return (Map.Entry) this.f6912d.f6920b.get(this.f6909a);
        }
        return (Map.Entry) a().next();
    }

    public final void remove() {
        if (this.f6910b) {
            this.f6910b = false;
            this.f6912d.n();
            if (this.f6909a < this.f6912d.f6920b.size()) {
                f2 f2Var = this.f6912d;
                int i10 = this.f6909a;
                this.f6909a = i10 - 1;
                Object unused = f2Var.l(i10);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
