package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.deser.e;
import com.fasterxml.jackson.databind.deser.f;
import com.fasterxml.jackson.databind.type.o;
import java.io.Serializable;
import l8.i;
import n8.a;

public abstract class h extends e implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected final e f5238a;

    /* renamed from: b  reason: collision with root package name */
    protected final f f5239b;

    /* renamed from: c  reason: collision with root package name */
    protected final g f5240c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f5241d;

    /* renamed from: e  reason: collision with root package name */
    protected final j8.h f5242e;

    /* renamed from: f  reason: collision with root package name */
    protected final Class f5243f;

    /* renamed from: g  reason: collision with root package name */
    protected transient i f5244g;

    protected h(f fVar, e eVar) {
        if (fVar != null) {
            this.f5239b = fVar;
            this.f5238a = eVar == null ? new e() : eVar;
            this.f5241d = 0;
            this.f5242e = null;
            this.f5240c = null;
            this.f5243f = null;
            this.f5244g = null;
            return;
        }
        throw new NullPointerException("Cannot pass null DeserializerFactory");
    }

    public final o h() {
        return this.f5240c.B();
    }

    public Object j(j jVar, String str) {
        throw a.u((com.fasterxml.jackson.core.h) null, str, jVar);
    }

    /* renamed from: l */
    public g f() {
        return this.f5240c;
    }
}
