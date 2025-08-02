package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.i;
import d.a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class l extends g0 implements i {

    /* renamed from: c  reason: collision with root package name */
    protected final Boolean f5557c;

    /* renamed from: d  reason: collision with root package name */
    protected final DateFormat f5558d;

    /* renamed from: e  reason: collision with root package name */
    protected final AtomicReference f5559e;

    protected l(Class cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        AtomicReference atomicReference;
        this.f5557c = bool;
        this.f5558d = dateFormat;
        if (dateFormat == null) {
            atomicReference = null;
        } else {
            atomicReference = new AtomicReference();
        }
        this.f5559e = atomicReference;
    }

    public o a(b0 b0Var, d dVar) {
        boolean z10;
        SimpleDateFormat simpleDateFormat;
        Locale locale;
        TimeZone timeZone;
        i.d q10 = q(b0Var, dVar, c());
        if (q10 == null) {
            return this;
        }
        i.c i10 = q10.i();
        if (i10.a()) {
            return z(Boolean.TRUE, (DateFormat) null);
        }
        if (q10.m()) {
            if (q10.l()) {
                locale = q10.f();
            } else {
                locale = b0Var.T();
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(q10.h(), locale);
            if (q10.o()) {
                timeZone = q10.j();
            } else {
                timeZone = b0Var.U();
            }
            simpleDateFormat2.setTimeZone(timeZone);
            return z(Boolean.FALSE, simpleDateFormat2);
        }
        boolean l10 = q10.l();
        boolean o10 = q10.o();
        if (i10 == i.c.STRING) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!l10 && !o10 && !z10) {
            return this;
        }
        DateFormat l11 = b0Var.f().l();
        if (l11 instanceof com.fasterxml.jackson.databind.util.o) {
            com.fasterxml.jackson.databind.util.o oVar = (com.fasterxml.jackson.databind.util.o) l11;
            if (q10.l()) {
                oVar = oVar.u(q10.f());
            }
            if (q10.o()) {
                oVar = oVar.v(q10.j());
            }
            return z(Boolean.FALSE, oVar);
        }
        if (!(l11 instanceof SimpleDateFormat)) {
            b0Var.k(c(), String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", new Object[]{l11.getClass().getName()}));
        }
        SimpleDateFormat simpleDateFormat3 = (SimpleDateFormat) l11;
        if (l10) {
            simpleDateFormat = new SimpleDateFormat(simpleDateFormat3.toPattern(), q10.f());
        } else {
            simpleDateFormat = (SimpleDateFormat) simpleDateFormat3.clone();
        }
        TimeZone j10 = q10.j();
        if (j10 != null && !j10.equals(simpleDateFormat.getTimeZone())) {
            simpleDateFormat.setTimeZone(j10);
        }
        return z(Boolean.FALSE, simpleDateFormat);
    }

    public boolean d(b0 b0Var, Object obj) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean x(b0 b0Var) {
        Boolean bool = this.f5557c;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.f5558d != null) {
            return false;
        }
        if (b0Var != null) {
            return b0Var.b0(a0.WRITE_DATES_AS_TIMESTAMPS);
        }
        throw new IllegalArgumentException("Null SerializerProvider passed for " + c().getName());
    }

    /* access modifiers changed from: protected */
    public void y(Date date, f fVar, b0 b0Var) {
        if (this.f5558d == null) {
            b0Var.w(date, fVar);
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f5559e.getAndSet((Object) null);
        if (dateFormat == null) {
            dateFormat = (DateFormat) this.f5558d.clone();
        }
        fVar.s0(dateFormat.format(date));
        a.a(this.f5559e, (Object) null, dateFormat);
    }

    public abstract l z(Boolean bool, DateFormat dateFormat);
}
