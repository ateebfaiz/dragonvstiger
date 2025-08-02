package com.facebook.react.uimanager;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import e6.h;

class b1 {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray f3555a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    private final SparseBooleanArray f3556b = new SparseBooleanArray();

    /* renamed from: c  reason: collision with root package name */
    private final h f3557c = new h();

    public void a(t0 t0Var) {
        this.f3557c.a();
        this.f3555a.put(t0Var.q(), t0Var);
    }

    public void b(t0 t0Var) {
        this.f3557c.a();
        int q10 = t0Var.q();
        this.f3555a.put(q10, t0Var);
        this.f3556b.put(q10, true);
    }

    public t0 c(int i10) {
        this.f3557c.a();
        return (t0) this.f3555a.get(i10);
    }

    public int d() {
        this.f3557c.a();
        return this.f3556b.size();
    }

    public int e(int i10) {
        this.f3557c.a();
        return this.f3556b.keyAt(i10);
    }

    public boolean f(int i10) {
        this.f3557c.a();
        return this.f3556b.get(i10);
    }

    public void g(int i10) {
        this.f3557c.a();
        if (!this.f3556b.get(i10)) {
            this.f3555a.remove(i10);
            return;
        }
        throw new s("Trying to remove root node " + i10 + " without using removeRootNode!");
    }

    public void h(int i10) {
        this.f3557c.a();
        if (i10 != -1) {
            if (this.f3556b.get(i10)) {
                this.f3555a.remove(i10);
                this.f3556b.delete(i10);
                return;
            }
            throw new s("View with tag " + i10 + " is not registered as a root view");
        }
    }
}
