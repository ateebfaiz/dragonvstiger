package com.bugsnag.android;

import c.d;
import c1.l;
import c1.n;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class y {

    /* renamed from: f  reason: collision with root package name */
    public static final a f19133f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Collection f19134a;

    /* renamed from: b  reason: collision with root package name */
    private final Collection f19135b;

    /* renamed from: c  reason: collision with root package name */
    private final Collection f19136c;

    /* renamed from: d  reason: collision with root package name */
    private final List f19137d;

    /* renamed from: e  reason: collision with root package name */
    private l f19138e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public y(Collection collection, Collection collection2, Collection collection3, List list) {
        this.f19134a = collection;
        this.f19135b = collection2;
        this.f19136c = collection3;
        this.f19137d = list;
        this.f19138e = new n();
    }

    private final Map b() {
        HashMap hashMap = new HashMap();
        if (c().size() > 0) {
            hashMap.put("onBreadcrumb", Integer.valueOf(c().size()));
        }
        if (d().size() > 0) {
            hashMap.put("onError", Integer.valueOf(d().size()));
        }
        if (e().size() > 0) {
            hashMap.put("onSendError", Integer.valueOf(e().size()));
        }
        if (f().size() > 0) {
            hashMap.put("onSession", Integer.valueOf(f().size()));
        }
        return hashMap;
    }

    public void a(h3 h3Var) {
        if (this.f19134a.add(h3Var)) {
            this.f19138e.b("onError");
        }
    }

    public final Collection c() {
        return this.f19135b;
    }

    public final Collection d() {
        return this.f19134a;
    }

    public final List e() {
        return this.f19137d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return m.b(this.f19134a, yVar.f19134a) && m.b(this.f19135b, yVar.f19135b) && m.b(this.f19136c, yVar.f19136c) && m.b(this.f19137d, yVar.f19137d);
    }

    public final Collection f() {
        return this.f19136c;
    }

    public final boolean g(Breadcrumb breadcrumb, s2 s2Var) {
        if (this.f19135b.isEmpty()) {
            return true;
        }
        for (Object a10 : this.f19135b) {
            d.a(a10);
            try {
                throw null;
            } catch (Throwable th) {
                s2Var.c("OnBreadcrumbCallback threw an Exception", th);
            }
        }
        return true;
    }

    public final boolean h(o1 o1Var, s2 s2Var) {
        if (this.f19134a.isEmpty()) {
            return true;
        }
        for (h3 a10 : this.f19134a) {
            try {
                if (!a10.a(o1Var)) {
                    return false;
                }
            } catch (Throwable th) {
                s2Var.c("OnBreadcrumbCallback threw an Exception", th);
            }
        }
        return true;
    }

    public int hashCode() {
        return (((((this.f19134a.hashCode() * 31) + this.f19135b.hashCode()) * 31) + this.f19136c.hashCode()) * 31) + this.f19137d.hashCode();
    }

    public final boolean i(o1 o1Var, s2 s2Var) {
        for (Object a10 : this.f19137d) {
            d.a(a10);
            try {
                throw null;
            } catch (Throwable th) {
                s2Var.c("OnSendCallback threw an Exception", th);
            }
        }
        return true;
    }

    public final boolean j(Function0 function0, s2 s2Var) {
        if (this.f19137d.isEmpty()) {
            return true;
        }
        return i((o1) function0.invoke(), s2Var);
    }

    public final boolean k(l3 l3Var, s2 s2Var) {
        if (this.f19136c.isEmpty()) {
            return true;
        }
        for (Object a10 : this.f19136c) {
            d.a(a10);
            try {
                throw null;
            } catch (Throwable th) {
                s2Var.c("OnSessionCallback threw an Exception", th);
            }
        }
        return true;
    }

    public final void l(l lVar) {
        this.f19138e = lVar;
        lVar.e(b());
    }

    public String toString() {
        return "CallbackState(onErrorTasks=" + this.f19134a + ", onBreadcrumbTasks=" + this.f19135b + ", onSessionTasks=" + this.f19136c + ", onSendTasks=" + this.f19137d + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(Collection collection, Collection collection2, Collection collection3, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new CopyOnWriteArrayList() : collection, (i10 & 2) != 0 ? new CopyOnWriteArrayList() : collection2, (i10 & 4) != 0 ? new CopyOnWriteArrayList() : collection3, (i10 & 8) != 0 ? new CopyOnWriteArrayList() : list);
    }
}
