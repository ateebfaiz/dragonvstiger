package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.h;
import com.fasterxml.jackson.core.io.c;
import h8.b;
import j8.g;
import java.io.Serializable;
import java.io.Writer;

public class d extends p implements Serializable {
    protected static final int C = f.b.a();
    public static final n X = j8.d.f12406h;

    /* renamed from: j  reason: collision with root package name */
    protected static final int f5074j = a.c();

    /* renamed from: w  reason: collision with root package name */
    protected static final int f5075w = h.a.a();

    /* renamed from: a  reason: collision with root package name */
    protected final transient b f5076a = b.a();

    /* renamed from: b  reason: collision with root package name */
    protected final transient h8.a f5077b = h8.a.c();

    /* renamed from: c  reason: collision with root package name */
    protected int f5078c = f5074j;

    /* renamed from: d  reason: collision with root package name */
    protected int f5079d = f5075w;

    /* renamed from: e  reason: collision with root package name */
    protected int f5080e = C;

    /* renamed from: f  reason: collision with root package name */
    protected l f5081f;

    /* renamed from: g  reason: collision with root package name */
    protected n f5082g = X;

    /* renamed from: h  reason: collision with root package name */
    protected int f5083h;

    /* renamed from: i  reason: collision with root package name */
    protected final char f5084i;

    public enum a implements g {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);
        

        /* renamed from: a  reason: collision with root package name */
        private final boolean f5090a;

        private a(boolean z10) {
            this.f5090a = z10;
        }

        public static int c() {
            int i10 = 0;
            for (a aVar : values()) {
                if (aVar.a()) {
                    i10 |= aVar.b();
                }
            }
            return i10;
        }

        public boolean a() {
            return this.f5090a;
        }

        public int b() {
            return 1 << ordinal();
        }

        public boolean d(int i10) {
            if ((i10 & b()) != 0) {
                return true;
            }
            return false;
        }
    }

    public d(l lVar) {
        this.f5081f = lVar;
        this.f5084i = '\"';
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.core.io.b a(Object obj) {
        return com.fasterxml.jackson.core.io.b.a(!f(), obj);
    }

    /* access modifiers changed from: protected */
    public c b(com.fasterxml.jackson.core.io.b bVar, boolean z10) {
        if (bVar == null) {
            bVar = com.fasterxml.jackson.core.io.b.c();
        }
        return new c(e(), bVar, z10);
    }

    /* access modifiers changed from: protected */
    public f c(Writer writer, c cVar) {
        g8.d dVar = new g8.d(cVar, this.f5080e, this.f5081f, writer, this.f5084i);
        int i10 = this.f5083h;
        if (i10 > 0) {
            dVar.C(i10);
        }
        n nVar = this.f5082g;
        if (nVar != X) {
            dVar.D0(nVar);
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public final Writer d(Writer writer, c cVar) {
        return writer;
    }

    public j8.a e() {
        if (a.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.d(this.f5078c)) {
            return j8.b.a();
        }
        return new j8.a();
    }

    public boolean f() {
        return false;
    }

    public f h(Writer writer) {
        c b10 = b(a(writer), false);
        return c(d(writer, b10), b10);
    }

    public l i() {
        return this.f5081f;
    }

    public boolean j() {
        return false;
    }

    public d k(l lVar) {
        this.f5081f = lVar;
        return this;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return new d(this, this.f5081f);
    }

    protected d(d dVar, l lVar) {
        this.f5081f = lVar;
        this.f5078c = dVar.f5078c;
        this.f5079d = dVar.f5079d;
        this.f5080e = dVar.f5080e;
        this.f5082g = dVar.f5082g;
        this.f5083h = dVar.f5083h;
        this.f5084i = dVar.f5084i;
    }
}
