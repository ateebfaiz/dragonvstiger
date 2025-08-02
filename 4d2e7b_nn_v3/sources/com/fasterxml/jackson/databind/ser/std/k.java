package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import java.text.DateFormat;
import java.util.Date;

public class k extends l {

    /* renamed from: f  reason: collision with root package name */
    public static final k f5556f = new k();

    public k() {
        this((Boolean) null, (DateFormat) null);
    }

    /* access modifiers changed from: protected */
    public long A(Date date) {
        if (date == null) {
            return 0;
        }
        return date.getTime();
    }

    /* renamed from: B */
    public void f(Date date, f fVar, b0 b0Var) {
        if (x(b0Var)) {
            fVar.Y(A(date));
        } else {
            y(date, fVar, b0Var);
        }
    }

    /* renamed from: C */
    public k z(Boolean bool, DateFormat dateFormat) {
        return new k(bool, dateFormat);
    }

    public k(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }
}
