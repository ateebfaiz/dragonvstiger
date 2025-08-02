package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.databind.introspect.b0;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.util.a;
import com.fasterxml.jackson.databind.util.g;
import java.util.List;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected final j f5217a;

    protected c(j jVar) {
        this.f5217a = jVar;
    }

    public abstract i a();

    public abstract Class[] b();

    public abstract i.d c(i.d dVar);

    public abstract com.fasterxml.jackson.databind.introspect.i d();

    public abstract com.fasterxml.jackson.databind.introspect.i e();

    public abstract List f();

    public abstract p.b g(p.b bVar);

    public abstract g h();

    public Class i() {
        return this.f5217a.s();
    }

    public abstract a j();

    public abstract com.fasterxml.jackson.databind.introspect.c k();

    public abstract b0 l();

    public j m() {
        return this.f5217a;
    }

    public abstract boolean n();

    public abstract Object o(boolean z10);
}
