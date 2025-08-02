package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class f4 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f7170a = -1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7171b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator f7172c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ h4 f7173d;

    /* synthetic */ f4(h4 h4Var, zzmf zzmf) {
        this.f7173d = h4Var;
    }

    private final Iterator a() {
        if (this.f7172c == null) {
            this.f7172c = this.f7173d.f7188c.entrySet().iterator();
        }
        return this.f7172c;
    }

    public final boolean hasNext() {
        if (this.f7170a + 1 < this.f7173d.f7187b.size()) {
            return true;
        }
        if (this.f7173d.f7188c.isEmpty()) {
            return false;
        }
        if (a().hasNext()) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.f7171b = true;
        int i10 = this.f7170a + 1;
        this.f7170a = i10;
        if (i10 < this.f7173d.f7187b.size()) {
            return (Map.Entry) this.f7173d.f7187b.get(this.f7170a);
        }
        return (Map.Entry) a().next();
    }

    public final void remove() {
        if (this.f7171b) {
            this.f7171b = false;
            this.f7173d.n();
            if (this.f7170a < this.f7173d.f7187b.size()) {
                h4 h4Var = this.f7173d;
                int i10 = this.f7170a;
                this.f7170a = i10 - 1;
                Object unused = h4Var.l(i10);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
