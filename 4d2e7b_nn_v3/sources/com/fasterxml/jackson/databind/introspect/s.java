package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.v;
import com.fasterxml.jackson.databind.w;

public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    protected static final p.b f5415a = p.b.c();

    public boolean a() {
        if (k() != null) {
            return true;
        }
        return false;
    }

    public abstract p.b b();

    public b.a c() {
        return null;
    }

    public Class[] d() {
        return null;
    }

    public i e() {
        j i10 = i();
        if (i10 == null) {
            return g();
        }
        return i10;
    }

    public abstract m f();

    public abstract g g();

    public abstract w h();

    public abstract j i();

    public abstract v j();

    public i k() {
        m f10 = f();
        if (f10 != null) {
            return f10;
        }
        j o10 = o();
        if (o10 == null) {
            return g();
        }
        return o10;
    }

    public abstract String l();

    public abstract i m();

    public abstract Class n();

    public abstract j o();

    public abstract w p();

    public abstract boolean q();

    public boolean r() {
        return false;
    }
}
