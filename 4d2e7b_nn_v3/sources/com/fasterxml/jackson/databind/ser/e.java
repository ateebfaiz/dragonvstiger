package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.c;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.q;
import com.fasterxml.jackson.databind.z;
import java.util.Collections;
import java.util.List;

public class e {

    /* renamed from: i  reason: collision with root package name */
    private static final c[] f5498i = new c[0];

    /* renamed from: a  reason: collision with root package name */
    protected final c f5499a;

    /* renamed from: b  reason: collision with root package name */
    protected z f5500b;

    /* renamed from: c  reason: collision with root package name */
    protected List f5501c = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    protected c[] f5502d;

    /* renamed from: e  reason: collision with root package name */
    protected a f5503e;

    /* renamed from: f  reason: collision with root package name */
    protected Object f5504f;

    /* renamed from: g  reason: collision with root package name */
    protected i f5505g;

    /* renamed from: h  reason: collision with root package name */
    protected t8.i f5506h;

    public e(c cVar) {
        this.f5499a = cVar;
    }

    public o a() {
        c[] cVarArr;
        if (this.f5505g != null && this.f5500b.F(q.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            this.f5505g.i(this.f5500b.F(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        a aVar = this.f5503e;
        if (aVar != null) {
            aVar.a(this.f5500b);
        }
        List list = this.f5501c;
        if (list != null && !list.isEmpty()) {
            List list2 = this.f5501c;
            cVarArr = (c[]) list2.toArray(new c[list2.size()]);
            if (this.f5500b.F(q.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (c k10 : cVarArr) {
                    k10.k(this.f5500b);
                }
            }
        } else if (this.f5503e == null && this.f5506h == null) {
            return null;
        } else {
            cVarArr = f5498i;
        }
        c[] cVarArr2 = this.f5502d;
        if (cVarArr2 == null || cVarArr2.length == this.f5501c.size()) {
            return new d(this.f5499a.m(), this, cVarArr, this.f5502d);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", new Object[]{Integer.valueOf(this.f5501c.size()), Integer.valueOf(this.f5502d.length)}));
    }

    public d b() {
        return d.K(this.f5499a.m(), this);
    }

    public a c() {
        return this.f5503e;
    }

    public c d() {
        return this.f5499a;
    }

    public Object e() {
        return this.f5504f;
    }

    public t8.i f() {
        return this.f5506h;
    }

    public List g() {
        return this.f5501c;
    }

    public i h() {
        return this.f5505g;
    }

    public void i(a aVar) {
        this.f5503e = aVar;
    }

    /* access modifiers changed from: protected */
    public void j(z zVar) {
        this.f5500b = zVar;
    }

    public void k(Object obj) {
        this.f5504f = obj;
    }

    public void l(c[] cVarArr) {
        if (cVarArr == null || cVarArr.length == this.f5501c.size()) {
            this.f5502d = cVarArr;
            return;
        }
        throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", new Object[]{Integer.valueOf(cVarArr.length), Integer.valueOf(this.f5501c.size())}));
    }

    public void m(t8.i iVar) {
        this.f5506h = iVar;
    }

    public void n(List list) {
        this.f5501c = list;
    }

    public void o(i iVar) {
        if (this.f5505g == null) {
            this.f5505g = iVar;
            return;
        }
        throw new IllegalArgumentException("Multiple type ids specified with " + this.f5505g + " and " + iVar);
    }
}
